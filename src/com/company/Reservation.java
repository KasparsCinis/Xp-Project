package com.company;

/**
 * Created by Kuba on 2016-03-01.
 */
public class Reservation {
    int time;
    String activityName;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Reservation(int time, String activityName) {

        this.time = time;
        this.activityName = activityName;
    }
}
