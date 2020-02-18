package com.set08103.group14;

import java.sql.*;

/*
    Implements the first query.
    "All the countries in the world organised by largest population to smallest."
*/
public class Query1 {

    /*
        Runs a query and returns all countries sorted by population.
        Parameters: none
        Returns: none
    */
    public static void run() {
        DatabaseLink db = DatabaseLink.Instance();

        String query = "SELECT Name, Population FROM country ORDER BY Population DESC;";

        ResultSet result = db.runQuery(query);
        try {
            //While there are more rows to read, read them.
            while (result.next()) {
                System.out.println(result.getInt("Code")  + " | " +
                        result.getString("Name") + " | " +
                        result.getString("Continent") + " | " +
                        result.getString("Region") + " | " +
                        result.getInt("Population") + " | " +
                        result.getString("Capital")
                );
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}