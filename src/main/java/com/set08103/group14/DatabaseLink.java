package com.set08103.group14;

import java.sql.*;

public class DatabaseLink {

    private static DatabaseLink instance;
    private Connection con;

    public static DatabaseLink Instance() {
        if (instance == null) {
            instance = new DatabaseLink();
        }
        return instance;

    }

    public static void disconnect() {
        if (instance.con != null)
        {
            try
            {
                // Close connection
                instance.con.close();
                instance = null;
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    private DatabaseLink() {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        // Connection to the database
        //con = null;
        int retries = 100;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                // Wait a bit
                Thread.sleep(10000);
                // Exit for loop
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    public ResultSet runQuery(String query) {
        try {
            Statement stmt = con.createStatement();
            return stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get employee details");
            return null;
        }
    }
}