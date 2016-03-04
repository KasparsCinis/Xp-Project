package com.company.Tests;

import com.company.*;
import org.junit.Before;
import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by kasdi on 01.03.2016.
 */
public class NewTestingClass {
    /**
    * DATABASE TESTS
     */


    @Test //#1 Tests if inserting new activity in the database works
    public void testDBinsertionActivity()
    {
        //Database connector object
        ModelClass modelClass = new ModelClass();

        //List of all activities from the database
        ArrayList<Activity> list = modelClass.getDBactivities();
        //Inserts new activity to the database
        modelClass.writeToDBActivity("insertedActivityName", 12, 25, "sdsd");

        //Checks if the total activity count has increased by one
        assertEquals(list.size()+1, modelClass.getDBactivities().size());
    }
    @Test //#2 Tests if updating activity works
    public void testDBupdateActivity()
    {
        ModelClass modelClass = new ModelClass();  //Database connector object
        ArrayList<Activity> list = modelClass.getDBactivities();

        //Updates the activity
        modelClass.updateDBActivity("testActivity", 15, 20, "This is an description", Integer.toString(modelClass.getLastActivityID()));

        list = modelClass.getDBactivities();

        //Check if the last activity is updated with the information we expect
        assertEquals("testActivity", list.get(list.size() - 1).getName());
    }
    @Test //#3 Tests if retrieving an activity works
    public void testDBretrieveActivity()
    {
        ModelClass modelClass = new ModelClass();
        //Checks if the Database actually returned any information
        assertNotNull(modelClass.getDBactivities2("5").getName());
    }
    @Test //#4 Tests if deleting an activity works
    public void testDBdeleteActivity()
    {
        ModelClass modelClass = new ModelClass();

        ArrayList<Activity> list = modelClass.getDBactivities();

        //Delete the last activity in the database
        modelClass.deleteDBActivity(list.get(list.size() - 1).getIdActivity());
        assertEquals(modelClass.getDBactivities().size(), list.size() - 1);
    }
    @Test //#5 Tests if inserting a reservation works
    public void testDBinsertReservation()
    {
        ModelClass modelClass = new ModelClass();
        ArrayList<Reservation2> listReservation = new ArrayList<>();
        listReservation = modelClass.getDBReservationsOnDay("12/12/2014");

        ArrayList<ActivitiesInReservation> list = new ArrayList<>();
        list.add(new ActivitiesInReservation(4, 29, 3, 11, 23));
        list.add(new ActivitiesInReservation(4, 29, 5, 11, 23));
        list.add(new ActivitiesInReservation(4, 29, 74, 11, 23));

        modelClass.writeToDBReservation(list, 2, "12/12/2014", "John Test", "+123 45748", 2, "This is a comment about how this reservation is awesome");


        assertEquals(listReservation.size() + 1, modelClass.getDBReservationsOnDay("12/12/2014").size());
    }
    @Test //#6 Tests if retrieving reservations on specific day works
    public void testDBretrieveReservationsOnDay()
    {
        ModelClass modelClass = new ModelClass();
        ArrayList<Reservation2> list = modelClass.getDBReservationsOnDay("12/12/2014"); //Retrieves all reservations on 12/12/2014

        for (Reservation2 r: list)
        {
            System.out.println(r.toString());
        }
        assertNotEquals(0, modelClass.getDBReservationsOnDay("12/12/2014").size());
    }
    @Test //#7
    public void testDBdeleteReservation()
    {
        ModelClass modelClass = new ModelClass();

        ArrayList<Reservation2> list = modelClass.getDBReservations();

        //Delete the last activity in the database
        modelClass.deleteDBActivity("36");
        assertEquals(modelClass.getDBReservations().size(), list.size() - 1);
    }
    @Test //#8
    public void testDBGetInstructors()
    {
        ModelClass modelClass = new ModelClass();
        int something = modelClass.getDBInstructors().size();
        assertEquals(1, something);
        System.out.println(modelClass.getDBInstructors().get(0).getName());
    }
    @Test //#9
    public void testDBAddKioskItem()
    {
        ModelClass modelClass = new ModelClass();
        modelClass.addDBKioskItem(new KioskItem(1, "Pink t-shirt", 299));

    }
    @Test //#10
    public void testGetKioskItems()
    {
        ModelClass modelClass = new ModelClass();
        ArrayList<kioskItem> listy = new ArrayList<>();
        listy = modelClass.getDBKioskItems();

        for (kioskItem k : listy)
        {
            System.out.println(k.getName());
        }
        System.out.println(modelClass.getDBKioskItems().get(0).getName());
        assertNotEquals(0, modelClass.getDBKioskItems().size());


    }





    @Before
    public void setUp() throws Exception {
    }


}
