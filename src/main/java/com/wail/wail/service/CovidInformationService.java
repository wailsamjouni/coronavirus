package com.wail.wail.service;

import com.wail.wail.model.CovidInformation;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

@Service
public class CovidInformationService {

    private ArrayList<CovidInformation> updateList = new ArrayList<>();
    private String linkCsvFile = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

    public ArrayList<CovidInformation> getUpdateList() {
        return updateList;
    }

    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void BringInformationFromURL() throws IOException, InterruptedException {
        ArrayList<CovidInformation> currentList = new ArrayList<>();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder(URI.create(linkCsvFile)).build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        StringReader responseAsString = new StringReader(httpResponse.body());
        Iterable<CSVRecord> csvRecords = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(responseAsString);
        for (CSVRecord record : csvRecords) {
            String provinceName = record.get("Province/State");
            String regionName = record.get("Country/Region");
            int numberOfCasesLastDay = Integer.parseInt(record.get(record.size() - 1));
            //if (!provinceName.equals(""))
            currentList.add(new CovidInformation(provinceName, regionName, numberOfCasesLastDay));
        }
        this.updateList = currentList;
    }
}
