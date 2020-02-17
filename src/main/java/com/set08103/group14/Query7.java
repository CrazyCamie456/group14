
package com.set08103.group14;

public class Query7 {
    public static void run() {
        DatabaseLink db = DatabaseLink.Instance();


        String query = "SELECT Name, Population FROM cities ORDER BY Population DESC;";

        ResultSet result = db.RunQuery(query);
        while(result.next()) {
            System.out.println(result.getString("Name") + " | " + result.getInt("Population"));
        }
    }
}