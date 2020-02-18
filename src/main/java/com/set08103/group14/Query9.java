
package com.set08103.group14;
import java.util.Scanner;

public class Query9 {
    public static void run() {
        //creates an instance link to the database

        DatabaseLink db = DatabaseLink.Instance();
        //defining variables
        String regionName = "";
        ResultSet result;

        do{
            //asks the user to enter the region they want to view

            System.out.println("Please enter a valid region");
            //Creating a scanner to read in the user input
            Scanner scanner = new Scanner(System. in);
            //reads in the region
            regionName = regionName.concat(scanner.nextLine());
            //creates the query using user inputs
            String query = "SELECT Name, Population, District, (SELECT Name FROM country WHERE Code = CountryCode)  FROM cities WHERE (SELECT Name FROM Country WHERE " + regionName + "ORDER BY Population DESC;";
            //Gets the results from the database using the query just created
            result = db.RunQuery(query);
        }while(result.length() == 0 );
        //if there another result get the next one
        while(result.next()) {
            System.out.println(result.getString("Name") + " | " + result.getInt("Population"));
        }
    }
}