package org.example;

import org.example.configuration.SessionUtil;
import org.example.dao.ClientDao;
import org.example.dao.CompanyDao;
import org.example.dao.EmployeeDAO;
import org.example.dao.VehicleDao;
import org.example.entities.*;
import org.hibernate.Session;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");
        Session session = SessionUtil.getSessionFactory().openSession();


        Company company = new Company();
        company.setName("DHL");

        ;
        //  Create company
        CompanyDao.createCompany(company);

        Employee employee = new Employee();
        employee.setName("Ivan");
        employee.setFamily_name("Petrov");
        employee.setEGN("1234567890");
        employee.setSalary(1000);
        employee.setCompany(company);
        EmployeeDAO.createEmployee(employee);

        Vehicle vehicle = new Vehicle();
        vehicle.setCompany(company);
        vehicle.setPlate("AB1234BA");
        vehicle.setCapacity(2000);
        vehicle.setType("Cisterna");
        vehicle.setUnit(UnitType.Litre);
        VehicleDao.createVehicle(vehicle);

        Client client = new Client();
        client.setName("Klient");
        client.setFamily_name("Klientov");
        client.setCompany(new HashSet<>(Arrays.asList(company)));
        ClientDao.createClient(client);


        // Get companies
        CompanyDao.getCompanies().stream().forEach(System.out::println);
        EmployeeDAO.getEmoplyees().stream().forEach(System.out::println);
        VehicleDao.getVehicles().stream().forEach(System.out::println);
        ClientDao.getClients().stream().forEach(System.out::println);
    }
}