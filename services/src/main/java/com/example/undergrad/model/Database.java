package com.example.undergrad.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public class Database {

   public static void createNewDatabase(String fileName) {

        Connection connection = null;
        Statement statement = null;

        try {
            // SQLite database file location
            // JDBC URL for SQLite
            String url = "jdbc:sqlite:" + fileName;

            // Establish a connection to the database
            connection = DriverManager.getConnection(url);
            // Create a Statement object
            statement = connection.createStatement();


            // Create the 'keys' table
            String  createTableSQL = "CREATE TABLE IF NOT EXISTS events("
                    + "    id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "    eventName TEXT NOT NULL,"
                    + "    start TIMESTAMP,"
                    + "    end TIMESTAMP"
                    + ")";

            // Execute the SQL statement to create the table
            statement.execute(createTableSQL);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static Connection connect(String dbFile) {
        // SQLite connection string
        String url = "jdbc:sqlite:" + dbFile;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }



    //https://www.sqlitetutorial.net/sqlite-java/select/
    public static void loadEvents(String dbfile) {
        String sql = "SELECT id, eventName, start, end FROM events";
        Connection conn = connect(dbfile);

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("eventName");
                Date start = new Date(rs.getTimestamp("start").getTime());
                Date end = new Date(rs.getTimestamp("end").getTime());
                Events event = new Events(start,end, name);
                event.setEventid(id);
                Events.eventList.add(event);
            }

            Collections.sort(Events.eventList);
            stmt.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            if(conn != null){

                try{
                    conn.close();
                }catch (Exception e){
                }
            }
        }

    }


    public static void updateEvents(String dbfile, Events event) {
        System.out.println("Called");
        String insertQuery = "INSERT OR REPLACE INTO events (id,eventName, start, end) VALUES (?,?, ?, ?)";
        Connection conn = connect(dbfile);
        try {

            PreparedStatement statement = conn.prepareStatement(insertQuery);
            // Set the values for the 'kid' and 'keypair_blob' columns
            statement.setInt(1, event.getEventid()); // Replace 1 with your 'kid' value
            statement.setString(2, event.geteventName());
            statement.setTimestamp(3, new Timestamp(event.getStartDateandTime().getTime()));
            statement.setTimestamp(4, new Timestamp(event.getEndDateandTime().getTime()));
            statement.executeUpdate();
            System.out.println("Updated");
            statement.close();
        } catch (Exception e) {

        }finally {
            if(conn != null){
                try{
                    conn.close();
                }catch (Exception e){
                }
            }
        }
    }


}