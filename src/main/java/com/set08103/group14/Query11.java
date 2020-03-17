
package com.set08103.group14;
import java.util.Scanner;
public class Query11 {
    public static void run() {
        //creates an instance link to the database
        DatabaseLink db = DatabaseLink.Instance();
        //defining variables
        ResultSet result;
        String districtName = new String("");
        do{

          //asks the user to enter the district they want to view
            System.out.println("Please enter a valid district");
            //Creating a scanner to read in the user input
            Scanner scanner = new Scanner(System. in);
            //reads in the district
            districtName = districtName.concat(scanner.nextLine());
            //creates the query using user inputs
            String query = "SELECT city.name, city.Population, country.name, District FROM City JOIN country ON (country.code = city.countrycode) WHERE district =  " + districtName + "ORDER BY Population DESC;";
            //Gets the results from the database using the query just created
            result = db.RunQuery(query);
        }while(result.length() == 0 );
        //if there another result get the next one
        while(result.next()) {
            System.out.println(result.getString("city") + " | " + result.getInt("city.population")) + " | " + result.getString("country.name") + " | " + result.getString("city.district");
        }
    }
}