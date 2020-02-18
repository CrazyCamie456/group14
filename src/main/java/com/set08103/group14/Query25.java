package com.set08103.group14;
import java.util.Scanner;
public class Query25 {
    public static void run() {
        DatabaseLink db = DatabaseLink.Instance();
        ResultSet result;
        do{
            String country = "";
            System.out.println("Please enter the country you wish to view the populations of")
            Scanner scanner = new Scanner(System. in);
            country = country.concat(scanner.nextLine());

            String query = "SELECT COUNT (Population), (SELECT COUNT (Population) FROM city WHERE CountryCode = Code), (SELECT(SELECT COUNT (Population) FROM COUNTRY WHERE Country =" + country + ") - (SELECT COUNT (Population) FROM city WHERE CountryCode = Code) as OutOfCity) FROM Country WHERE Country =" + country + ")";

            result = db.RunQuery(query);



        }while(result.length() == 0 );
        while(result.next()) {
            System.out.println(result.getString("Name") + " | " + result.getInt("Population"));
        }
    }
}