package com.set08103.group14;

import java.util.Scanner;

public class Query13 {
    public static void run(String args[]) {
        DatabaseLink db = DatabaseLink.Instance();
        ResultSet result;
        do{
            String continentName = "";
            String resultNumberText = "";
            System.out.println("Please enter the number of cities you want to see");
            Scanner scanner = new Scanner(System. in);
            resultNumberText = resultNumberText.concat(scanner.nextLine());
            int resultNumber =Integer.parseInt(resultNumberText);

            System.out.println("Please enter a valid country");
            continentName = continentName.concat(scanner.nextLine());
            String query = "SELECT TOP"+resultNumber+" Name, Population FROM citiesWHERE " + continentName + " ORDER BY Population DESC;";


            result = db.RunQuery(query);



        }while(result.length() == 0 );
        while(result.next()) {
            System.out.println(result.getString("Name") + " | " + result.getInt("Population"));
        }
    }
}