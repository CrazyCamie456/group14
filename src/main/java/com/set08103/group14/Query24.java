package com.set08103.group14;
import java.util.Scanner;
public class Query24 {
    public static void run() {
        DatabaseLink db = DatabaseLink.Instance();
        ResultSet result;
        do{
            String reg = "";
            System.out.println("Please enter the region you wish to view the populations of")
            Scanner scanner = new Scanner(System. in);
            reg = reg.concat(scanner.nextLine());

            String query = "SELECT COUNT (Population), (SELECT COUNT (Population) FROM city WHERE CountryCode = Code), (SELECT(SELECT COUNT (Population) FROM COUNTRY WHERE Region =" + reg + ") - (SELECT COUNT (Population) FROM city WHERE CountryCode = Code) as OutOfCity) FROM Country WHERE Region =" + reg + ")";

            result = db.RunQuery(query);



        }while(result.length() == 0 );
        while(result.next()) {
            System.out.println(result.getString("Name") + " | " + result.getInt("Population"));
        }
    }
}