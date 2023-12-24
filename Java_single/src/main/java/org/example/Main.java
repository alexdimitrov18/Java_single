package org.example;

import org.example.configuration.SessionUtil;
import org.example.dao.CompanyDao;
import org.example.dao.EmployeeDAO;
import org.example.dao.VehicleDao;
import org.example.entities.Company;
import org.example.entities.Employee;
import org.example.entities.UnitType;
import org.example.entities.Vehicle;
import org.hibernate.Session;


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

        // Get companies
        CompanyDao.getCompanies().stream().forEach(System.out::println);
        EmployeeDAO.getEmoplyees().stream().forEach(System.out::println);
        VehicleDao.getVehicles().stream().forEach(System.out::println);
    }
}