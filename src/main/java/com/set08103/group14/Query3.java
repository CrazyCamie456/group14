package com.set08103.group14;

import java.sql.*;
import java.util.Scanner;

/*
    Implements the third query.
    "All the countries in a region organised by largest population to smallest."
*/
public class Query3 {
	/*
		Runs a query and returns all countries within a user-given region sorted by population.
		Parameters: none
		Returns: none
	*/
	public static void run() {
		DatabaseLink db = DatabaseLink.Instance();
		Scanner in = new Scanner(System.in);
		ResultSet result = null;

		String inputRegion;
		System.out.println("Please enter a Region to display countries from.");

		boolean valid = false;
		while (!valid) {
			inputRegion = in.nextLine();
			String query = "SELECT Name, Population FROM country WHERE Region=`" + inputRegion + "` ORDER BY Population DESC;";
			result = db.runQuery(query);
			try {
				//Check if there is anything in the dataset.
				if (result.first()) {
					valid = true;
				}
			} catch (SQLException sqle) {
				/* Ignored */
			}

		}

		try {
			//Return to the start of the dataset.
			result.beforeFirst();
			//While there are more rows to read, read them.
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
