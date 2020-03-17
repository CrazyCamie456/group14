package com.set08103.group14;

import java.sql.*;
import java.util.Scanner;

/*
    Implements the 23rd query.
   The population of people, people living in cities, and people not living in cities in each continent
*/
public class Query23 {

    /*
        The population of people, people living in cities, and people not living in cities in each continent
    */
    public static void run() {
        DatabaseLink db = DatabaseLink.Instance();
        Scanner in = new Scanner(System.in);

       String query = "SELECT continent AS Continent, SUM(DISTINCT country.population) AS Population, SUM(city.population) AS City Population, (SUM(DISTINCT country.population) - SUM(city.population)) AS NotInCities FROM country JOIN city ON (city.countrycode = country.code) GROUP BY continent;";

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