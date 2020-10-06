package com.example.blood.Model;

public class DoctorModel {
    String name;
    String number;
    String profession;


    public DoctorModel(String name, String number, String profession) {
        this.name = name;
        this.number = number;
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
