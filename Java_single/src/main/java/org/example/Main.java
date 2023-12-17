package org.example;

import org.example.configuration.SessionUtil;
import org.hibernate.Session;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        System.out.printf("Hello and welcome!");


        Session session = SessionUtil.getSessionFactory().openSession();

    }
}