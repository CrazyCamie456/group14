package com.set08103.group14;

import java.sql.*;

public class Query1 {
    public static void run() {
        DatabaseLink db = DatabaseLink.Instance();

        String query = "SELECT Name, Population FROM country ORDER BY Population DESC;";

        ResultSet result = db.runQuery(query);
        try {
            while (result.next()) {
                System.out.println(result.getInt("Code")  + " | " +
                        result.getString("Name") + " | " +
                        result.getString("Continent") + " | " +
                        result.getString("Region") + " | " +
                        result.getInt("Population") + " | " +
                        result.getString("Capital")
                );
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}