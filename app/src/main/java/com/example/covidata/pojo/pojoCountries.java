package com.example.covidata.pojo;

public class pojoCountries {


    public String countries;
    public String cases;
    public  String newCases;

    public pojoCountries() {
    }

    public pojoCountries(String countries, String cases, String newCases) {
        this.countries = countries;
        this.cases = cases;
        this.newCases = newCases;
    }

    public String getNewCases() {
        return newCases;
    }

    public void setNewCases(String newCases) {
        this.newCases = newCases;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }
}
