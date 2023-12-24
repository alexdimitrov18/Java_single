package org.example;

import org.example.configuration.SessionUtil;
import org.example.dao.CompanyDao;
import org.example.entities.Company;
import org.hibernate.Session;


public class Main {
    public static void main(String[] args) {

        System.out.printf("Hello and welcome!");


        Session session = SessionUtil.getSessionFactory().openSession();


        Company company = new Company();
        company.setName("DHL");

        Company company2 = new Company(); // ne mi dava SQL Error  ako imam 2 ednakvi imena
        company.setName("DHL");
        //  Create company
        CompanyDao.createCompany(company);



        // Get companies
        CompanyDao.getCompanies().stream().forEach(System.out::println);

    }
}