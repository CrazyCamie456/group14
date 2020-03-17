package com.set08103.group14;

import java.util.Scanner;

public class Query16 {
    public static void run() {
        //creates an instance link to the database
        DatabaseLink db = DatabaseLink.Instance();
        //defining variables
        ResultSet result;
        String districtName = new String("");
        String resultNumberText = new String("");
        do{
            //Ask user for the number of cities they want
            System.out.println("Please enter the number of cities you want to see");
            //Creating a scanner to read in the user input
            Scanner scanner = new Scanner(System. in);
            //reads the input and adds it to the query
            resultNumberText = resultNumberText.concat(scanner.nextLine());
            //casts the result into an int
            int resultNumber =Integer.parseInt(resultNumberText);
            //asks the user to enter the district they want to view
            System.out.println("Please enter a valid district");
            //reads in the district
            districtName = districtName.concat(scanner.nextLine());
            //creates the query using user inputs
            String query ="SELECT city.name AS city, city.population, country.name AS country, district FROM city JOIN country ON (country.code = city.countrycode) WHERE district = " + districtName + "  ORDER BY population DESC LIMIT" +  resultNumber + ";";
            //Gets the results from the database using the query just created
            result = db.RunQuery(query);
        }while(result.length() == 0 );
        //if there another result get the next one
        while(result.next()) {
            System.out.println(result.getString("city") + " | " + result.getInt("city.population")) + " | " + result.getString("country") + " | " + result.getString("district");
        }
    }
}