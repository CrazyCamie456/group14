package com.set08103.group14;

public class DatabaseLink {

    private static DatabaseLink instance;
    private Connection con;

    public static DatabaseLink Instance() {
        if (instance == null) {
            instance = new DatabaseLink();
            // @TODO Add connection to database here.
        }
        return instance;

    }

    private DatabaseLink() {
        // @TODO Create a DatabaseLink and assign con.
    }

    public rset runQuery(String query) {
        try {
            Statement stmt = con.createStatement();
            return stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get employee details");
            return null;
        }
    }
}