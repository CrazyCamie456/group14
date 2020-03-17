
package com.set08103.group14;

public class QueryContinentPopulation {
    public static void run() {
        //creates an instance link to the database
        DatabaseLink db = DatabaseLink.Instance();

        String districtName = new String("");

        //asks the user to enter the district they want to view
        System.out.println("Please enter a valid district");
        //reads in the district
        districtName = districtName.concat(scanner.nextLine());

        //creates the query
        String query = "SELECT Name, COUNT(Population) FROM city WHERE District = " + districtName +  " ORDER BY Population DESC;";
        //Gets the results from the database using the query just created
        ResultSet result = db.RunQuery(query);
        //if there another result get the next one
        while(result.next()) {
            System.out.println(result.getString("Name") + " | " + result.getInt("Population"));
        }
    }
}