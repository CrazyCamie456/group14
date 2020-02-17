package com.set08103.group14;
import java.util.Scanner;
public class Query12 {
    public static void run() {
        DatabaseLink db = DatabaseLink.Instance();
        ResultSet result;
        do{
            String resultNumberText = "";
            System.out.println("Please enter the number of cities you want to see");
            Scanner scanner = new Scanner(System. in);
            resultNumberText = resultNumberText.concat(scanner.nextLine());
            int resultNumber = Integer.parseInt(resultNumberText);
            String query = "SELECT TOP"+resultNumber+" Name, Population FROM cities ORDER BY Population DESC;";


            result = db.RunQuery(query);



        }while(result.length() == 0 );
        while(result.next()) {
            System.out.println(result.getString("Name") + " | " + result.getInt("Population"));
        }
    }
}