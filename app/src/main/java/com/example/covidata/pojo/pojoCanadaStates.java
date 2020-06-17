package com.example.covidata.pojo;

public class pojoCanadaStates {

    public String stateName;
    public String stateTotalCases;
    public String stateTotalDeaths;

    public pojoCanadaStates(String stateName, String stateTotalCases, String stateTotalDeaths) {
        this.stateName = stateName;
        this.stateTotalCases = stateTotalCases;
        this.stateTotalDeaths = stateTotalDeaths;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateTotalCases() {
        return stateTotalCases;
    }

    public void setStateTotalCases(String stateTotalCases) {
        this.stateTotalCases = stateTotalCases;
    }

    public String getStateTotalDeaths() {
        return stateTotalDeaths;
    }

    public void setStateTotalDeaths(String stateTotalDeaths) {
        this.stateTotalDeaths = stateTotalDeaths;
    }
}
