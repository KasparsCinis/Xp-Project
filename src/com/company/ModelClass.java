package com.company;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Dom on 2016-02-25.
 */
public class ModelClass {

    private Connection conn = null;

    public ModelClass() {

        try {
            String DB_URL = "jdbc:mysql://85.10.205.173:3306/xpproject";
            String USER = "keauser";
            String PASS = "Passwordpass";
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("conn obj created " + conn + " message: ");


        } catch (SQLException e) {
            System.out.println("db error" + e.getMessage());
        }
    }



    public void writeToDBActivity(String name, int ageLimit, double price, String description)
    {
        String sql="INSERT INTO activities VALUES (null, ?, ?, ?, ?)\n";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, ageLimit);
            preparedStatement.setDouble(3, price);
            preparedStatement.setString(4, description);

            int numberOfRows= preparedStatement.executeUpdate();
            System.out.println("Completed insert. Number of rows affected:" + numberOfRows);

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    //Later
    public void updateDBReservation(ArrayList<ActivitiesInReservation> list,
                                    int idInstructor,
                                    int reservationID,
                                    String date,
                                    String customerName,
                                    String customerMobilePhone,
                                    int numberOfPeople,
                                    String comment)
    {
        String sql="UPDATE reservations SET idInstructor = ?, date = ?, customerName = ?, customerMobilePhone = ?, numberOfPeople = ?, comment = ? WHERE idReservation = ?";

        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, idInstructor);
            preparedStatement.setString(2, date);
            preparedStatement.setString(3, customerName);
            preparedStatement.setString(4, customerMobilePhone);
            preparedStatement.setInt(5, numberOfPeople);
            preparedStatement.setString(6, comment);
            preparedStatement.setInt(7, reservationID);

            int numberOfRows = preparedStatement.executeUpdate();
            System.out.println("Completed insert. Number of rows affected:" + numberOfRows);

        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        for (ActivitiesInReservation air : list)
        {
            sql="UPDATE activitiesInReservation SET idActivity = ?, startTime = ?, endTime = ? WHERE idReservation = ?";
            try {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(2, air.getIdActivity());
                preparedStatement.setInt(3, air.getStartTime());
                preparedStatement.setInt(4, air.getEndTime());

                int numberOfRows= preparedStatement.executeUpdate();
                System.out.println("Completed insert. Number of rows affected:" + numberOfRows);

            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

    }

    public ArrayList<Instructor> getDBInstructors()
    {
        ArrayList<Instructor> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM instructor";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Instructor instructor = new Instructor(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3));

                list.add(instructor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public void writeToDBReservation(ArrayList<ActivitiesInReservation> list, int idInstructor,  String date, String customerName, String customerMobilePhone, int numberOfPeple, String comment)
    {
        String sql="INSERT INTO reservations VALUES (null, ?, ?, ?, ?, ?, ?, ?)\n";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, idInstructor);
            preparedStatement.setString(3, date);
            preparedStatement.setString(4, customerName);
            preparedStatement.setString(5, customerMobilePhone);
            preparedStatement.setInt(6, numberOfPeple);
            preparedStatement.setString(7, comment);

            int numberOfRows= preparedStatement.executeUpdate();
            System.out.println("Completed insert. Number of rows affected:" + numberOfRows);

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        //Add the ActivitiesInReservation in the database
        for (ActivitiesInReservation air : list)
        {
            sql="INSERT INTO activitiesInReservation VALUES (null, ?, ?, ?, ?)\n";
            try {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, getLastReservationID());
                preparedStatement.setInt(2, air.getIdActivity());
                preparedStatement.setInt(3, air.getStartTime());
                preparedStatement.setInt(4, air.getEndTime());

                int numberOfRows= preparedStatement.executeUpdate();
                System.out.println("Completed insert. Number of rows affected:" + numberOfRows);

            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
    public void writeToDBInstructor(int idActivity, String name)
    {
        String sql="INSERT INTO instructor VALUES (null, ?, ?)\n";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, idActivity);
            preparedStatement.setString(2, name);

            int numberOfRows= preparedStatement.executeUpdate();
            System.out.println("Completed insert. Number of rows affected:" + numberOfRows);

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public Reservation2 getDBReservationByID(int ID)
    {
        Reservation2 reserv = new Reservation2();
        try {
            String sql = "SELECT * FROM reservations WHERE idReservation  = '" + ID + "'";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //Get the ActivitiesInReservation
                ArrayList<ActivitiesInReservation> activitiesInReservations = new ArrayList<>();

                reserv = new Reservation2(activitiesInReservations,
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getInt(7),
                        resultSet.getString(8));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reserv;
    }

    public ArrayList<ActivitiesInReservation> getDBActivitiesInReservation(int reservationID)
    {
        ArrayList<ActivitiesInReservation> activitiesInReservations = new ArrayList<>();

        ActivitiesInReservation reserv = new ActivitiesInReservation();
        try {
            String sql = "SELECT * FROM activitiesInReservation WHERE idReservation  = '" + reservationID + "'";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                reserv = new ActivitiesInReservation(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5));

                activitiesInReservations.add(reserv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return activitiesInReservations;
    }
    public int getLastReservationID()
    {
        int lastId = 0;
        try {
            String sql = "SELECT * FROM reservations";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                ArrayList<ActivitiesInReservation> activitiesInReservations = new ArrayList<>();

                lastId = resultSet.getInt(1);
                Reservation2 reserv = new Reservation2(activitiesInReservations,
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getInt(7),
                        resultSet.getString(8));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lastId;
    }
    public int getLastActivityID()
    {
        int lastId = 0;
        try {
            String sql = "SELECT * FROM activities";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                lastId = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lastId;
    }



    public ArrayList<Reservation2> getDBReservationsOnDay(String date)
    {
        ArrayList<Reservation2> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM reservations WHERE date = '" + date  + "'";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ArrayList<ActivitiesInReservation> activitiesInReservations = new ArrayList<>();

                Reservation2 reserv = new Reservation2(activitiesInReservations,
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getInt(7),
                        resultSet.getString(8));

                list.add(reserv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<Reservation2> getDBReservations()
    {
        ArrayList<Reservation2> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM reservations";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ArrayList<ActivitiesInReservation> activitiesInReservations = new ArrayList<>();
                Reservation2 reserv = new Reservation2(activitiesInReservations,
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getInt(7),
                        resultSet.getString(8));
                list.add(reserv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public Instructor getDBInstructorByID(int ID)
    {
        Instructor instructor = new Instructor();
        try {
            String sql = "SELECT * FROM instructor WHERE idInstructor  = '" + ID + "'";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                instructor = new Instructor (resultSet.getInt(1),resultSet.getInt(2), resultSet.getString(3));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return instructor;
    }
    public Instructor getDBInstructorByActivityID(String ID)
    {
        Instructor instructor = new Instructor();
        try {
            String sql = "SELECT * FROM instructor WHERE idActivity  = '" + ID + "'";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                instructor = new Instructor (resultSet.getInt(1),resultSet.getInt(2), resultSet.getString(3));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return instructor;
    }
    public ArrayList<Instructor> getDBInstructorsByActivity(ArrayList<Integer> list)
    {
        ArrayList<Instructor> instructorList = new ArrayList<>();
        for (Integer i : list) {
            try {
                String sql = "SELECT * FROM instructor WHERE idActivity = '" + i + "'";

                PreparedStatement preparedStatement = conn.prepareStatement(sql);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Instructor instructor = new Instructor(resultSet.getInt(1),
                            resultSet.getInt(2),
                            resultSet.getString(3));

                    instructorList.add(instructor);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instructorList;
    }
    public void deleteDBReservation(int ID)
    {
        String sql = "DELETE FROM reservations WHERE idReservation  = ?";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, ID);
            int numberOfRows= preparedStatement.executeUpdate();
            System.out.println("Completed delete. Number of rows affected:"+numberOfRows);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void deleteDBInstructor(int ID)
    {
        String sql = "DELETE FROM instructor WHERE idInstructor = ?";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, ID);
            int numberOfRows= preparedStatement.executeUpdate();
            System.out.println("Completed delete. Number of rows affected:"+numberOfRows);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }




    public void updateDBActivity(String name, int ageLimit, double price, String description, String idActivity)
    {
        String sql="UPDATE activities SET name = ?, ageLimit = ?, price = ?, description = ?WHERE idActivity = ?";

                try {

                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, name);
                    preparedStatement.setInt(2, ageLimit);
                    preparedStatement.setDouble(3, price);
                    preparedStatement.setString(4, description);
                    preparedStatement.setString(5, idActivity);

                    int numberOfRows = preparedStatement.executeUpdate();
                    System.out.println("Completed insert. Number of rows affected:" + numberOfRows);

                }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

   public void deleteDBActivity(String idActivity)
   {
       String sql = "DELETE FROM activities WHERE idActivity = ?";

       try {
           PreparedStatement preparedStatement = conn.prepareStatement(sql);
           preparedStatement.setString(1, idActivity);
           int numberOfRows= preparedStatement.executeUpdate();
           System.out.println("Completed delete. Number of rows affected:"+numberOfRows);
       } catch (SQLException e)
       {
           e.printStackTrace();
       }
   }
    public void deleteDBKioskItems(int idKioskItem)
    {
        String sql = "DELETE FROM kioskItems WHERE idKioskItem = ?";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, idKioskItem);
            int numberOfRows= preparedStatement.executeUpdate();
            System.out.println("Completed delete. Number of rows affected:"+numberOfRows);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void updateDBKioskItems(int idKioskItem, String name, int price)
    {
        String sql="UPDATE kioskItems SET name = ?, price = ? WHERE idKioskItem = ?";

        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, price);
            preparedStatement.setInt(3, idKioskItem);

            int numberOfRows = preparedStatement.executeUpdate();
            System.out.println("Completed insert. Number of rows affected:" + numberOfRows);

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void updateDBInstructor(String name, String intID)
    {
        String sql="UPDATE instructor SET name = ? WHERE idActivity = ?";

        try {
            System.out.println(name + " " + intID);
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, Integer.parseInt(intID));

            int numberOfRows = preparedStatement.executeUpdate();
            System.out.println("Completed insert. Number of rows affected:" + numberOfRows);
            if (numberOfRows == 0)
            {
                //Create a new instructor
                writeToDBInstructor( Integer.parseInt(intID), name);
            }

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


    public ArrayList<Activity> getDBactivities() {
        ArrayList<Activity> activitiesList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM activities";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Activity activity = new Activity (resultSet.getString(1),resultSet.getString(2), resultSet.getInt(3), resultSet.getDouble(4), resultSet.getString(5) );
                activitiesList.add(activity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activitiesList;
    }

    public Activity getDBactivities2(String idActivity) {
       // ArrayList<Activity> activitiesList = new ArrayList<>();
        Activity activity = new Activity();
        try {
            String sql = "SELECT * FROM activities WHERE idActivity = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, idActivity);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                 activity = new Activity (resultSet.getString(1),resultSet.getString(2), resultSet.getInt(3), resultSet.getDouble(4), resultSet.getString(5) );

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activity;
    }


    /**
    *methods dealing with the kiosk stuff
    */
    public ArrayList<KioskItem> getDBKioskItems()
    {
        ArrayList<KioskItem> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM kioskItems";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                KioskItem item = new KioskItem(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3));
                list.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public void addDBKioskItem(KioskItem item)
    {
        String sql="INSERT INTO kioskItems VALUES (null, ?, ?)\n";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, item.getName());
            preparedStatement.setInt(2, item.getPrice());


            int numberOfRows= preparedStatement.executeUpdate();
            System.out.println("Completed insert. Number of rows affected:" + numberOfRows);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }





   }



