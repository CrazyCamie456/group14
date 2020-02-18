package com.set08103.group14;

import java.sql.*;
import java.util.Scanner;

/*
    Implements the fourth query.
    "The top N populated countries in the world where N is provided by the user."
*/
public class Query4 {

    /*
        Runs a query and prints a certain amount of countries sorted by population.
        Parameters: none
        Returns: none
    */
    public static void run() {
        DatabaseLink db = DatabaseLink.Instance();
        Scanner in = new Scanner(System.in);

        System.out.println("How many results would you like displayed?");
        int limit = in.nextInt();

        String query = "SELECT Name, Population FROM country ORDER BY Population DESC;";

        ResultSet result = db.runQuery(query);
        int i = 0;
        try {
            //While there are more rows to read, read them.
            while (result.next() && i < limit) {
                System.out.println(result.getInt("Code")  + " | " +
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
