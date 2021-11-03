package com.wail.wail.controller;

import com.wail.wail.model.CovidInformation;
import com.wail.wail.service.CovidInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class CovidInformationController {

    @Autowired
    private CovidInformationService covidInformationService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String getHomePage(Model item){
        ArrayList<CovidInformation> covidInformation = covidInformationService.getUpdateList();
        int numberOfAllCases = covidInformation.stream().mapToInt(info -> info.getNumberOfCasesLastDay()).sum();
        item.addAttribute("listOfCovidInformation", covidInformation);
        item.addAttribute("numberOfAllCases",numberOfAllCases);
        return "homepage";
    }
}
