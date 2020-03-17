
package com.set08103.group14;

public class Query7 {
    public static void run() {
        //creates an instance link to the database
        DatabaseLink db = DatabaseLink.Instance();

        //creates the query
        String query = "SELECT city.name, city.population, country.name FROM city JOIN country ON (country.code = city.countrycode) ORDER BY Population DESC;";
        //Gets the results from the database using the query just created
        ResultSet result = db.RunQuery(query);
        //if there another result get the next one
        while(result.next()) {
            System.out.println(result.getString("city") + " | " + result.getInt("city.population")) + " | " + result.getString("country") + " | " + result.getString("district");
        }
    }
}