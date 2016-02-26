package com.company;

/**
 * Created by Dom on 2016-02-25.
 */
public class Activity {

    public Activity(String idActivity, String name, int ageLimit, double price, String description)
    {
        this.idActivity = idActivity;
        this.name = name;
        this.ageLimit = ageLimit;
        this.price = price;
        this.description = description;
    }

    public Activity( String name, int ageLimit, double price, String description)
    {
        this.name = name;
        this.ageLimit = ageLimit;
        this.price = price;
        this.description = description;
    }


    private String idActivity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(String idActivity) {
        this.idActivity = idActivity;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String name;
    private int ageLimit;
    private double price;
    private String description;



    public String toString()
    {
        return idActivity + " " + name + " " + ageLimit + " " + price + " " + description;
    }



}
