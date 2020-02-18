
package com.set08103.group14;
import java.util.Scanner;
public class Query10 {
    public static void run() {
        //creates an instance link to the database

        DatabaseLink db = DatabaseLink.Instance();
        //defining variables
        String countryName = "";
        ResultSet result;
        do{

            //asks the user to enter the country they want to view

            System.out.println("Please enter a valid country");
            //Creating a scanner to read in the user input
            Scanner scanner = new Scanner(System. in);

            String query = "SELECT Name, Population, District, (SELECT Name FROM country WHERE Code = CountryCode)  FROM cities WHERE (SELECT Name FROM Country WHERE " + countryName + "ORDER BY Population DESC;";


            result = db.RunQuery(query);



        }while(result.length() == 0 );
        while(result.next()) {
            System.out.println(result.getString("Name") + " | " + result.getInt("Population"));
        }
    }
}