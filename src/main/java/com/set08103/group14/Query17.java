package com.set08103.group14;

public class Query17 {
    public static void run() {
        //creates an instance link to the database
        DatabaseLink db = DatabaseLink.Instance();
        //defining variables
        ResultSet result;
        do{
            //creates the query
            String query = "SELECT city.name, city.population, , country.name  FROM City JOIN country ON (country.code = city.countrycode) WHERE city.id = country.capital ORDER BY population DESC;";
            //Gets the results from the database using the query just created
            result = db.RunQuery(query);
        }while(result.length() == 0 );
        //if there is more than one result get the next one

        while(result.next()) {
            System.out.println(result.getString("city.name") + " | " + result.getInt("city.population") + " | " + result.getInt("country.name"));
        }
    }
}