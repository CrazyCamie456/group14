package com.set08103.group14;

import java.sql.*;
import java.util.Scanner;

/*
    Implements the 20th query.
   The top N populated capital cities in the world WHERE N is provided by the user.
*/
public class Query20 {

    /*
        Runs a query and prints the top N capital cities sorted by population.
    */
    public static void run() {
        DatabaseLink db = DatabaseLink.Instance();
        Scanner in = new Scanner(System.in);

        String query = "SELECT city.name AS city, city.population, country.name AS country, continent FROM city JOIN country ON (country.code = city.countrycode) WHERE city.ID = country.capital ORDER BY population;";

        int limit = in.nextInt();
        int i = 0;

        ResultSet result = db.runQuery(query);
        try {
            //While there are more rows to read, read them.
            while (result.next() && i < limit) {
                System.out.println(result.getInt("Code")  + "\t\t| " +
                        result.getString("Name") + "\t\t| " +
                        result.getString("Continent") + "\t\t| " +
                        result.getString("Region") + "\t\t| " +
                        result.getInt("Population") + "\t\t | " +
                        result.getString("City")
                );
                i++;
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}