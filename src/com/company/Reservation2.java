package com.company;

import java.util.ArrayList;

/**
<<<<<<< HEAD
 * Created by kasdi on 01.03.2016.
 */
public class Reservation2 {

    ArrayList<ActivitiesInReservation> activitiesInReservations = new ArrayList<>();

    private int idReservation;
    private int idActivity;
    private int idInstructor;
    private String date;
    private String customerName;
    private String customerMobilePhone;
    private int numberOfPeple;
    private String comment;

    public Reservation2(ArrayList<ActivitiesInReservation> activitiesInReservations, int idReservation, int idActivity, int idInstructor, String date, String customerName, String customerMobilePhone, int numberOfPeple, String comment) {
        this.activitiesInReservations = activitiesInReservations;
        this.idReservation = idReservation;
        this.idActivity = idActivity;
        this.idInstructor = idInstructor;
        this.date = date;
        this.customerName = customerName;
        this.customerMobilePhone = customerMobilePhone;
        this.numberOfPeple = numberOfPeple;
        this.comment = comment;
    }

    public Reservation2()
    {

    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }
    public int getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(int idActivity) {
        this.idActivity = idActivity;
    }

    public int getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(int idInstructor) {
        this.idInstructor = idInstructor;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerMobilePhone() {
        return customerMobilePhone;
    }

    public void setCustomerMobilePhone(String customerMobilePhone) {
        this.customerMobilePhone = customerMobilePhone;
    }

    public int getNumberOfPeple() {
        return numberOfPeple;
    }

    public void setNumberOfPeple(int numberOfPeple) {
        this.numberOfPeple = numberOfPeple;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String toString()
    {
        String toReturn = idReservation + " " + idActivity + " " + idInstructor + " " + date;

        for (int i = 0; i <activitiesInReservations.size(); i++ )
        {
           toReturn += activitiesInReservations.get(i).getIdActivity();
        }

        return toReturn ;
    }

    public int getStartTime(int activityId)
    {
        for (ActivitiesInReservation a : activitiesInReservations)
        {
            if (a.getIdActivity() == activityId)
            {
                return a.getStartTime();
            }
        }
        return 0;
    }

    public int getEndTime(int activityId)
    {
        for (ActivitiesInReservation a : activitiesInReservations)
        {
            if (a.getIdActivity() == activityId)
            {
                return a.getEndTime();
            }
        }
        return 0;
    }
}
