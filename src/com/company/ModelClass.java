package com.company;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Dom on 2016-02-25.
 */
public class ModelClass {

    private Connection conn=null;

    public ModelClass(){

        try
        {
            String DB_URL = "jdbc:mysql://85.10.205.173:3306/xpproject";
            String USER = "keauser";
            String PASS = "Passwordpass";
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("conn obj created "+conn + " message: ");


        } catch (SQLException e)
        {
            System.out.println("db error" + e.getMessage());
        }}

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
    public void writeToDBReservation(int idActivity, int idInstructor, int time, String date, String customerName, String customerMobilePhone, int numberOfPeple, String comment)
    {
        String sql="INSERT INTO reservations VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)\n";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, idActivity);
            preparedStatement.setInt(2, idInstructor);
            preparedStatement.setInt(3, time);
            preparedStatement.setString(4, date);
            preparedStatement.setString(5, customerName);
            preparedStatement.setString(6, customerMobilePhone);
            preparedStatement.setInt(7, numberOfPeple);
            preparedStatement.setString(8, comment);

            int numberOfRows= preparedStatement.executeUpdate();
            System.out.println("Completed insert. Number of rows affected:" + numberOfRows);

        }
        catch (SQLException e)
        {
            e.printStackTrace();
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
                reserv = new Reservation2(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getInt(8),
                        resultSet.getString(9));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reserv;
    }
    public ArrayList<Reservation2> getDBReservationsOnDay(String date)
    {
        ArrayList<Reservation2> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM reservations WHERE date = '" + date  + "'";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Reservation2 reserv = new Reservation2(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getInt(8),
                        resultSet.getString(9));
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
            String sql = "SELECT * FROM activities";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Reservation2 reserv = new Reservation2(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getInt(8),
                        resultSet.getString(9));
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
        String sql = "DELETE FROM instructor’ WHERE idInstructor = ?";

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
   }



