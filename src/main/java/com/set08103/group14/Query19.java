package com.set08103.group14;

import java.sql.*;
import java.util.Scanner;

/*
    Implements the nineteenth query.
    "All the capital cities in a region organised by largest population to smallest."
*/
public class Query19 {

    /*
        Runs a query and prints all capital cities sorted by population.
    */
    public static void run() {
        DatabaseLink db = DatabaseLink.Instance();
        Scanner in = new Scanner(System.in);

        String inputRegion;
        System.out.println("Please enter a Region to display countries from.");
        inputRegion = in.nextLine();

        String query = "SELECT city.name, population FROM City JOIN country ON (country.code = city.countrycode) WHERE city.id = country.capital AND region = " + inputRegion + " ORDER BY population DESC;";

        ResultSet result = db.runQuery(query);
        try {
            //While there are more rows to read, read them.
            while (result.next()) {
                System.out.println(result.getInt("Code")  + "\t\t| " +
                        result.getString("Name") + "\t\t| " +
                        result.getString("Continent") + "\t\t| " +
                        result.getString("Region") + "\t\t| " +
                        result.getInt("Population") + "\t\t | " +
                        result.getString("City")
                );
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}