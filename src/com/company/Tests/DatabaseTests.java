package com.company.Tests;

import com.company.Activity;
import com.company.ModelClass;
import com.company.Reservation2;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by kasdi on 01.03.2016.
 */
public class DatabaseTests {
    @Test //#1
    public void testDBinsertionActivity()
    {
        ModelClass modelClass = new ModelClass();


        ArrayList<Activity> list = modelClass.getDBactivities();

        modelClass.writeToDBActivity("DD", 12, 25, "sdsd");

        assertEquals(list.size()+1, modelClass.getDBactivities().size());
    }
    @Test //#2
    public void testDBupdateActivity()
    {
        ModelClass modelClass = new ModelClass();
        ArrayList<Activity> list = new ArrayList<>();
        list = modelClass.getDBactivities();


        modelClass.writeToDBActivity("DD", 12, 25, "sdsd");
        //

        modelClass.updateDBActivity("testActivity", 15, 20, "This is an description", list.get(list.size() - 1).getIdActivity());
        assertEquals("testActivity", list.get(list.size() - 1).getName());
    }
    @Test //#4
    public void testDBdeleteActivity()
    {
        ModelClass modelClass = new ModelClass();
        //System.out.println(modelClass.getDBactivities2("2").toString());
        ArrayList<Activity> list = new ArrayList<>();
        list = modelClass.getDBactivities();


        modelClass.deleteDBActivity(list.get(list.size() - 1).getIdActivity());
        // modelClass.writeToDB("DD", 12, 25, "sdsd");
        assertEquals(modelClass.getDBactivities().size(), list.size()-1);
    }
    @Test //#5
    public void testDBretrieveActivity()
    {
        ModelClass modelClass = new ModelClass();

        assertNotNull(modelClass.getDBactivities2("4").getName());
    }
    @Test //#6
    public void testDBinsertionReservation()
    {
        ModelClass modelClass = new ModelClass();
        ArrayList<Reservation2> list = modelClass.getDBReservationsOnDay("12/12/2014");

        modelClass.writeToDBReservation(2, 1, 12, "12/12/2014", "John", "+12345678", 7, "This is a very long comment");
        //modelClass.writeToDBReservation();
        assertEquals(list.size()+1, modelClass.getDBReservationsOnDay("12/12/2014").size());
    }
    

    @Before
    public void setUp() throws Exception {
    }


}
