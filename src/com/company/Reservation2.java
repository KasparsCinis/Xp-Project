package com.company;

/**
<<<<<<< HEAD
 * Created by kasdi on 01.03.2016.
 */
public class Reservation2 {




    private int idReservation;
    private int idActivity;
    private int idInstructor;
    private int time;
    private String date;
    private String customerName;
    private String customerMobilePhone;
    private int numberOfPeple;
    private String comment;

    public Reservation2()
    {

    }
    public Reservation2(int idReservation, int idActivity, int idInstructor, int time, String date, String customerName, String customerMobilePhone, int numberOfPeple, String comment) {
        this.idReservation = idReservation;
        this.idActivity = idActivity;
        this.idInstructor = idInstructor;
        this.time = time;
        this.date = date;
        this.customerName = customerName;
        this.customerMobilePhone = customerMobilePhone;
        this.numberOfPeple = numberOfPeple;
        this.comment = comment;
    }
    public Reservation2(int idReservation, int idActivity, int idInstructor, int time, String date, String customerName, String customerMobilePhone, int numberOfPeple) {
        this.idReservation = idReservation;
        this.idActivity = idActivity;
        this.idInstructor = idInstructor;
        this.time = time;
        this.date = date;
        this.customerName = customerName;
        this.customerMobilePhone = customerMobilePhone;
        this.numberOfPeple = numberOfPeple;
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

}
