package com.wail.wail.model;

public class CovidInformation {

    private String provinceName;
    private String regionName;
    private int numberOfCasesLastDay;

    public CovidInformation(String provinceName, String regionName, int numberOfCasesLastDay) {
        this.provinceName = provinceName;
        this.regionName = regionName;
        this.numberOfCasesLastDay = numberOfCasesLastDay;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public int getNumberOfCasesLastDay() {
        return numberOfCasesLastDay;
    }

    public void setNumberOfCasesLastDay(int numberOfCasesLastDay) {
        this.numberOfCasesLastDay = numberOfCasesLastDay;
    }

    @Override
    public String toString() {
        return "CovidInformation{" +
                "provinceName='" + provinceName + '\'' +
                ", regionName='" + regionName + '\'' +
                ", numberOfCasesLastDay=" + numberOfCasesLastDay +
                '}';
    }
}
