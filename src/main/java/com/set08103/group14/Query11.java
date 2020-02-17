
package com.set08103.group14;

public class Query9 {
    public static void run() {
        DatabaseLink db = DatabaseLink.Instance();
        ResultSet result;
        do{
            String districtName = "";
            System.out.println("Please enter a valid district");
            System.in.read(districtName);

            String query = "SELECT Name, Population FROM cities WHERE (SELECT Name FROM cities WHERE " + districtName + "ORDER BY Population DESC;";


            result = db.RunQuery(query);



        }while(result.length() == 0 );
        while(result.next()) {
            System.out.println(result.getString("Name") + " | " + result.getInt("Population"));
        }
    }
}