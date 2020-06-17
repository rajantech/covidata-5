package com.example.covidata.pojo;

public class pojoIndiaStates {


    public String stateName;
    public String stateTotalCases;
    public String stateTodayCases;

    public pojoIndiaStates(String stateName, String stateTotalCases, String stateTodayCases) {
        this.stateName = stateName;
        this.stateTotalCases = stateTotalCases;
        this.stateTodayCases = stateTodayCases;
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

    public String getStateTodayCases() {
        return stateTodayCases;
    }

    public void setStateTodayCases(String stateTodayCases) {
        this.stateTodayCases = stateTodayCases;
    }
}
