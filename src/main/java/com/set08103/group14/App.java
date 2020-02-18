package com.set08103.group14;

public class App {

    public static void main(String[] args) {

        System.out.println("Query 1");
        Query1.run();

        //System.out.println("Query 2");
        //Query2.run();

       // System.out.println("Query 3");
        //Query3.run();

        DatabaseLink.disconnect();
    }
}