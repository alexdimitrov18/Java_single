package org.example;

import org.example.configuration.SessionUtil;
import org.example.dao.*;
import org.example.entities.*;
import org.hibernate.Session;

import java.time.LocalDateTime;
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

        Payload payload = new Payload();
        payload.setWeight(200);
        payload.setType("Cisterna");


        // Get companies
        CompanyDao.getCompanies().stream().forEach(System.out::println);
        EmployeeDAO.getEmoplyees().stream().forEach(System.out::println);
        VehicleDao.getVehicles().stream().forEach(System.out::println);
        ClientDao.getClients().stream().forEach(System.out::println);

        Purchase purchase = new Purchase();

        purchase.setStart_time(LocalDateTime.now());
        purchase.setEnd_time(LocalDateTime.now().plusDays(1));
        purchase.setDeparture_point("Belene");
        purchase.setArrival_point("Lovech");
        purchase.setPrice(100);

        purchase.setCompany(company);
        purchase.setClients(new HashSet<>(Arrays.asList(client)));
        purchase.setEmployee(employee);
       // purchase.setPayload(payload);
        purchase.setVehicle(vehicle);
        PurchaseDao.createPurchase(purchase);
        PurchaseDao.getPurchases().stream().forEach(System.out::println);



    }
}