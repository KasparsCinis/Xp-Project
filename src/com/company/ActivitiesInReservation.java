package com.company;

/**
 * Created by kasdi on 03.03.2016.
 */
public class ActivitiesInReservation {

    private int activitiesInReservationID;
    private int idReservation;
    private int idActivity;
    private int startTime;
    private int endTime;

    public ActivitiesInReservation() {
    }

    public ActivitiesInReservation(int idActivity, int startTime) {
        this.idActivity = idActivity;
        this.startTime = startTime;
    }

    public ActivitiesInReservation(int idActivity, int startTime, int endTime) {

        this.idActivity = idActivity;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getActivitiesInReservationID() {
        return activitiesInReservationID;
    }

    public void setActivitiesInReservationID(int activitiesInReservationID) {
        this.activitiesInReservationID = activitiesInReservationID;
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

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime +1;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public ActivitiesInReservation(int activitiesInReservationID, int idReservation, int idActivity, int startTime, int endTime) {
        this.activitiesInReservationID = activitiesInReservationID;
        this.idReservation = idReservation;
        this.idActivity = idActivity;
        this.startTime = startTime;
        this.endTime = endTime;
    }


}