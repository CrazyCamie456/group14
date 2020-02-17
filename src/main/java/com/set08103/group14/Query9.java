
package com.set08103.group14;

public class Query9 {
    public static void run() {
        DatabaseLink db = DatabaseLink.Instance();
        ResultSet result;

        do{
            String regionName = "";
            System.out.println("Please enter a valid region");
            System.in.readline(regionName);

            String query = "SELECT Name, Population FROM cities WHERE (SELECT Name FROM Country WHERE " + regionName + "ORDER BY Population DESC;";


            result = db.RunQuery(query);



        }while(result.length() == 0 );
        while(result.next()) {
            System.out.println(result.getString("Name") + " | " + result.getInt("Population"));
        }
    }
}