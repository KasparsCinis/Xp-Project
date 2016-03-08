package com.company;

/**
 * Created by kasdi on 01.03.2016.
 */
public class Instructor {




    private int idActivity;
    private String name;
    private int idInstructor;

    public Instructor()
    {
        idActivity = 0;
        name = "";
        idInstructor = 0;
    }
    public Instructor(int idInstructor, int idActivity, String name) {
        this.idInstructor = idInstructor;
        this.idActivity = idActivity;
        this.name = name;
    }


    public int getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(int idInstructor) {
        this.idInstructor = idInstructor;
    }

    public int getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(int idActivity) {
        this.idActivity = idActivity;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
