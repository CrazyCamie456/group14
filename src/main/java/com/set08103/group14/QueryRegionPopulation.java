
package com.set08103.group14;

public class QueryWorldPopulation {
    public static void run() {
        //creates an instance link to the database
        DatabaseLink db = DatabaseLink.Instance();

        String input = new String;

        //creates the query
        String query = "SELECT Name, COUNT(Population) FROM country WHERE Region = " + input + " ORDER BY Population DESC;";
        //Gets the results from the database using the query just created
        ResultSet result = db.RunQuery(query);
        //if there another result get the next one
        while(result.next()) {
            System.out.println(result.getString("Name") + " | " result.getInt("Population"));
        }
    }
}