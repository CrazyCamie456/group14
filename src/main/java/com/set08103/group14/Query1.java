package com.set08103.group14;

public class Query1 {
    public static void run() {
        DatabaseLink db = DatabaseLink.Instance();
        // @TODO Change class name to match actual class.

        String query = "SELECT Name, Population FROM country ORDER BY Population DESC;";

        ResultSet result = db.RunQuery(query);
        while(result.next()) {
            console.WriteLine(result.getString("Name") + " | " + result.getInt("Population"));
        }
    }
}