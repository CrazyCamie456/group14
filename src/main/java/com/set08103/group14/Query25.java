package com.set08103.group14;

import java.sql.*;
import java.util.Scanner;

/*
    Implements the 25th query.
   The population of people, people living in cities, and people not living in cities in each country
*/
public class Query25 {

    /*
        The population of people, people living in cities, and people not living in cities in each country
    */
    public static void run() {
        DatabaseLink db = DatabaseLink.Instance();
        Scanner in = new Scanner(System.in);

        String query = "SELECT country.name AS Country, country.population AS Population, SUM(city.population) AS City Population, country.population - SUM(city.population) AS NotInCities FROM country JOIN city ON (city.countrycode = country.code) GROUP BY country.name;";
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