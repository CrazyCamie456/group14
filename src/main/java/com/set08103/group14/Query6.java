package com.set08103.group14;

import java.sql.*;
import java.util.Scanner;

/*
    Implements the sixth query.
    "The top N populated countries in a region where N is provided by the user."
*/
public class Query6 {
    /*
        Runs a query and prints a limited number of countries within a user-given region sorted by population.
        Parameters: none
        Returns: none
    */
    public static void run() {

        DatabaseLink db = DatabaseLink.Instance();
        Scanner in = new Scanner(System.in);
        ResultSet result = null;

        String inputRegion;
        System.out.println("Please enter a Region to display countries from.");

        boolean valid = false;
        while (!valid) {
            inputRegion = in.nextLine();
            String query = "SELECT Name, Population FROM country WHERE Region=`" + inputRegion + "` ORDER BY Population DESC;";
            result = db.runQuery(query);
            try {
                //Check if there is anything in the dataset.
                if (result.first()) {
                    valid = true;
                }
            } catch (SQLException sqle) {
                /* Ignored */
            }

        }
        System.out.println("How many results would you like displayed?");
        int limit = in.nextInt();
        int i = 0;

        try {
            //Return to the start of the dataset.
            result.beforeFirst();
            //While there are more rows to read, read them.
            while (result.next() && i < limit) {
                System.out.println(result.getInt("Code") + " | " +
                        result.getString("Name") + " | " +
                        result.getString("Continent") + " | " +
                        result.getString("Region") + " | " +
                        result.getInt("Population") + " | " +
                        result.getString("Capital")
                );
                i++;
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
