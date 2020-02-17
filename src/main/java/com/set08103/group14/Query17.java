package com.set08103.group14;

public class Query17 {
    public static void run() {
        //creates an instance link to the database
        DatabaseLink db = DatabaseLink.Instance();
        //defining variables
        ResultSet result;
        do{
            //creates the query
            String query = "SELECT Name, Population, District, (SELECT Name FROM country WHERE Code = CountryCode) FROM cities WHERE CountryCode = (SELECT capital From country);";
            //Gets the results from the database using the query just created
            result = db.RunQuery(query);
        }while(result.length() == 0 );
        //if there is more than one result get the next one

        while(result.next()) {
            System.out.println(result.getString("Name") + " | " + result.getInt("Population"));
        }
    }
}