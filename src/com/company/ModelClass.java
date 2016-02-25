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

    public void writeToDB(String name, int ageLimit, double price, String description)
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

    public void updateDB(String name, int ageLimit, double price, String description, int idActivity)
    {
        String sql="UPDATE activities SET name = ?, ageLimit = ?, price = ?, description = ?WHERE idActivity = ?";

                try {

                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, name);
                    preparedStatement.setInt(2, ageLimit);
                    preparedStatement.setDouble(3, price);
                    preparedStatement.setString(4, description);
                    preparedStatement.setInt(5, idActivity);

                    int numberOfRows = preparedStatement.executeUpdate();
                    System.out.println("Completed insert. Number of rows affected:" + numberOfRows);

                }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

   public void deleteDB(int idActivity)
   {
       String sql = "DELETE FROM activities WHERE idActivity = ?";

       try {
           PreparedStatement preparedStatement = conn.prepareStatement(sql);
           preparedStatement.setInt(1, idActivity);
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
   }



