package com.example.covidata.pojo;

public class pojoDistrict {

    public String districtname;
    public String confirmedcases;
    public String deceased;

    public pojoDistrict(String districtname, String confirmedcases, String deceased) {
        this.districtname = districtname;
        this.confirmedcases = confirmedcases;
        this.deceased = deceased;
    }

    public String getDistrictname() {
        return districtname;
    }

    public void setDistrictname(String districtname) {
        this.districtname = districtname;
    }

    public String getConfirmedcases() {
        return confirmedcases;
    }

    public void setConfirmedcases(String confirmedcases) {
        this.confirmedcases = confirmedcases;
    }

    public String getDeceased() {
        return deceased;
    }

    public void setDeceased(String deceased) {
        this.deceased = deceased;
    }
}

