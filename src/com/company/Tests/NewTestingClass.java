package com.company.Tests;

import com.company.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by kasdi on 01.03.2016.
 */
public class NewTestingClass {
    @Test //#1
    public void testDBinsertionActivity()
    {
        ModelClass modelClass = new ModelClass();


        ArrayList<Activity> list = modelClass.getDBactivities();

        modelClass.writeToDBActivity("testActivity", 12, 25, "sdsd");

        assertEquals(list.size()+1, modelClass.getDBactivities().size());
    }
    @Test //#2
    public void testDBupdateActivity()
    {
        ModelClass modelClass = new ModelClass();
        ArrayList<Activity> list = modelClass.getDBactivities();

        modelClass.writeToDBActivity("testActivity", 12, 25, "sdsd");
        //
        modelClass.updateDBActivity("testActivity", 15, 20, "This is an description", list.get(list.size() - 1).getIdActivity());

        list = modelClass.getDBactivities();
        assertEquals("testActivity", list.get(list.size() - 1).getName());
    }
    @Test //#4
    public void testDBdeleteActivity()
    {
        ModelClass modelClass = new ModelClass();
        //System.out.println(modelClass.getDBactivities2("2").toString());
        ArrayList<Activity> list = modelClass.getDBactivities();

        modelClass.deleteDBActivity(list.get(list.size() - 1).getIdActivity());
        // modelClass.writeToDB("DD", 12, 25, "sdsd");
        assertEquals(modelClass.getDBactivities().size(), list.size() - 1);
    }
    @Test //#5
    public void testDBretrieveActivity()
    {
        ModelClass modelClass = new ModelClass();

        assertNotNull(modelClass.getDBactivities2("5").getName());
    }
    @Test //#6
    public void testDBretrieveReservationsOnDay()
    {
        ModelClass modelClass = new ModelClass();
        ArrayList<Reservation2> list = modelClass.getDBReservationsOnDay("12/12/2014");

        for (Reservation2 r: list)
        {
            System.out.println(r.toString());
        }
        //modelClass.writeToDBReservation(2, 1, 12, "12/12/2014", "John", "+12345678", 7, "This is a very long comment");
        //modelClass.writeToDBReservation();
        assertEquals(list.size(), modelClass.getDBReservationsOnDay("12/12/2014").size());
    }
    @Test //#7
    public void testDBinsertReservation()
    {
        ModelClass modelClass = new ModelClass();
        ArrayList<Reservation2> listReservation = new ArrayList<>();
        listReservation = modelClass.getDBReservationsOnDay("12/12/2014");

        ArrayList<ActivitiesInReservation> list = new ArrayList<>();
        list.add(new ActivitiesInReservation(4, 29, 3, 11, 23));
        list.add(new ActivitiesInReservation(4, 29, 5, 11, 23));
        list.add(new ActivitiesInReservation(4, 29, 74, 11, 23));

        modelClass.writeToDBReservation(list, 2, "12/12/2014", "Blablabla2", "lalalala2", 2, "rororo2");


        assertEquals(listReservation.size() + 1, modelClass.getDBReservationsOnDay("12/12/2014").size());

        // System.out.println(modelClass.getLastReservationID());
    }

    @Test //#7
    public void testDBinstructors()
    {
        ModelClass modelClass = new ModelClass();
        int something = modelClass.getDBInstructors().size();
        assertEquals(1, something);
        System.out.println(modelClass.getDBInstructors().get(0).getName());
    }
    @Test //#7
    public void testDBAddKioskItem()
    {
        ModelClass modelClass = new ModelClass();
        modelClass.addDBKioskItem(new KioskItem(1, "Pink t-shirt", 299));

    }
    @Test //#8
    public void testGetKioskItems()
    {
        ModelClass modelClass = new ModelClass();
        
        assertNotEquals(0, modelClass.getDBKioskItems().size());
    }


    @Before
    public void setUp() throws Exception {
    }


}
