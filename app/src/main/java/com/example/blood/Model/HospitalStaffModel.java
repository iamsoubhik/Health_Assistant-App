package com.example.blood.Model;

public class HospitalStaffModel {

    String hospitalName;
    String receptionistName;
    String helplinenumber;

    public HospitalStaffModel(String hospitalName, String receptionistName, String helplinenumber) {
        this.hospitalName = hospitalName;
        this.receptionistName = receptionistName;
        this.helplinenumber = helplinenumber;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getReceptionistName() {
        return receptionistName;
    }

    public String getHelplinenumber() {
        return helplinenumber;
    }
}
