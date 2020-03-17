package com.set08103.group14;

import java.sql.*;
import java.util.Scanner;

/*
    Implements the 24th query.
   The population of people, people living in cities, and people not living in cities in each region
*/
public class Query24 {

    /*
        The population of people, people living in cities, and people not living in cities in each region
    */
    public static void run() {
        DatabaseLink db = DatabaseLink.Instance();
        Scanner in = new Scanner(System.in);

        String query = "SELECT region AS Region, SUM( DISTINCT country.population) AS Population, SUM(city.population) AS City Population, (SUM(DISTINCT country.population) - SUM(city.population)) AS NotInCities FROM country JOIN city ON (city.countrycode = country.code) GROUP BY region;";
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