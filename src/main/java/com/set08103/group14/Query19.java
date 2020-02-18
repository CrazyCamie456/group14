package com.set08103.group14;
import java.util.Scanner;
public class Query19 {
    public static void run() {
        DatabaseLink db = DatabaseLink.Instance();
        ResultSet result;
        do{
            String regionName = "";
            System.out.println("Please enter the region you want to see the capital cities of");
            Scanner scanner = new Scanner(System. in);
            regionName = regionName.concat(scanner.nextLine());

            String query = "SELECT Name, Population, (SELECT Name FROM Country WHERE Code = CountryCode) FROM city WHERE ID = (SELECT Capital FROM country WHERE REGION = " + regionName + ") ORDER BY Population DESC";


            result = db.RunQuery(query);



        }while(result.length() == 0 );
        while(result.next()) {
            System.out.println(result.getString("Name") + " | " + result.getInt("Population"));
        }
    }
}