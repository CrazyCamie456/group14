package com.set08103.group14;

import java.util.Scanner;

public class Query18 {
    public static void run() {
        //creates an instance link to the database
        DatabaseLink db = DatabaseLink.Instance();
        //defining variables
        ResultSet result;
        String districtName = "";
        String resultNumberText = "";
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
            System.out.println("Please enter a valid country");
            //reads in the district
            districtName = districtName.concat(scanner.nextLine());
            //creates the query using user inputs
            String query = "SELECT  Name, Population, (SELECT Name FROM country WHERE Code = CountryCode) FROM cities WHERE CountryCode = (SELECT Code FROM country WHERE LocalName =  " + districtName + ");";
            //Gets the results from the database using the query just created
            result = db.RunQuery(query);
        }while(districtName == "" && resultNumber == 0);
        //if there is another result get the next one
        while(result.next()) {
            System.out.println(result.getString("Name") + " | " + result.getInt("Population"));
        }
    }
}