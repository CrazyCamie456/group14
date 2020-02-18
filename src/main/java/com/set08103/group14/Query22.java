package com.set08103.group14;
import java.util.Scanner;
public class Query22 {
    public static void run() {
        DatabaseLink db = DatabaseLink.Instance();
        ResultSet result;
        do{
            String N = "";
            String reg = "";
            System.out.println("Please enter the region you wish to view the top N populated capital cities of")
            Scanner scanner = new Scanner(System. in);
            reg = reg.concat(scanner.nextLine());
            System.out.println("To see the top N populated capital cities in the region, please enter N as a number");

            N = N.concat(scanner.nextLine());
            int resultNumber = Integer.parseInt(N);

            String query = "SELECT Name, Population, (SELECT Name FROM Country WHERE Code = CountryCode) FROM city WHERE ID = (SELECT Capital FROM country WHERE Region =" + reg + ") ORDER BY Population DESC LIMIT" + resultNumber + ")";

            result = db.RunQuery(query);



        }while(result.length() == 0 );
        while(result.next()) {
            System.out.println(result.getString("Name") + " | " + result.getInt("Population"));
        }
    }
}