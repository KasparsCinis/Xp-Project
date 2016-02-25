package com.company;





import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

import java.util.ArrayList;


public class Main {

  /*  @Test //#1
    public void testDBinsertion()
    {
    ModelClass modelClass = new ModelClass();
        modelClass.writeToDB("DD", 12, 25, "sdsd");
        assertEquals("DD", modelClass.toString());
    }

    @Test //#2
    public void testDBupdate()
    {
        ModelClass modelClass = new ModelClass();
        modelClass.writeToDB("DD", 12, 25, "sdsd");
        assertEquals("DD", modelClass.toString());

    }

    @Test //#4
    public void testDBdelete()
    {
        ModelClass modelClass = new ModelClass();
        modelClass.writeToDB("DD", 12, 25, "sdsd");
        assertEquals("DD", modelClass.toString());
    }

    @Test //#5
    public void testDBretrieve()
    {
        ModelClass modelClass = new ModelClass();
        modelClass.writeToDB("DD", 12, 25, "sdsd");
        assertEquals("DD", modelClass.toString());
    } */

    public static void main(String[] args) {
        ModelClass modelClass = new ModelClass();
        ArrayList<Activity> list = new ArrayList<>();

        list = modelClass.getDBactivities();

        for (Activity a: list)
        {
            System.out.println(a.toString());
        }

    }
}
