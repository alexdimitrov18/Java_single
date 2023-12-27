package org.example;

import org.example.configuration.SessionUtil;
import org.example.dao.*;
import org.example.dto.VehicleDTO;
import org.example.entities.*;
import org.hibernate.Session;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Dummy_data {
private  EmployeeDAO employeeDAO;
private VehicleDao vehicleDao;
private ClientDao clientDao;
private PayloadDao payloadDao;
private CompanyDao companyDao;
private PurchaseDao purchaseDao;
    public Dummy_data() {
        employeeDAO = new EmployeeDAO();
        vehicleDao = new VehicleDao();
        clientDao = new ClientDao();
        payloadDao = new PayloadDao();
        companyDao = new CompanyDao();
        purchaseDao = new PurchaseDao();
    }


    public void dummy() {
        Session session = SessionUtil.getSessionFactory().openSession();
    Skill skill1 = new Skill(1,"Driver", null);
    Skill skill2 = new Skill(2,"Courier", null);
    Skill skill3 = new Skill(2,"Janitor",  null);
    Set<Skill> skills = new HashSet<>();
    skills.add(skill1);
    skills.add(skill2);
    skills.add(skill3);
    SkillDao.createSkill(skill1);
    SkillDao.createSkill(skill2);
    SkillDao.createSkill(skill3);


    Employee employee1 = new Employee(0,"Ivan", "Parvanov", "1234567890", 2000,null,skills,null);
    Employee employee2 = new Employee(0, "Petar", "Petrov","2233223322",2000, null, new HashSet<>(Arrays.asList(skill2)), null);
    Employee employee3 = new Employee(0, "Georgi", "Todorov", "7355608111", 2300, null, new HashSet<>(Arrays.asList(skill3)),null );
    Employee employee4 = new Employee(0, "Milen", "Atanasov", "3330003331", 2220, null, skills,null );
    Employee employee5 = new Employee(0, "Atanas", "Slavov", "1110001110", 5000, null, new HashSet<>(Arrays.asList(skill2)),null );
    Employee employee6 = new Employee(0, "Stefan", "Spasov", "0011223344", 1000, null,skills,null );
    Set<Employee> employeesSet1 = new HashSet<>();
    Set<Employee> employeesSet2 = new HashSet<>();
    Set<Employee> employeesSet3 = new HashSet<>();
        employeesSet1.add(employee1);
        employeesSet1.add(employee2);
        employeesSet2.add(employee3);
        employeesSet2.add(employee4);
        employeesSet3.add(employee5);
        employeesSet3.add(employee6);
    EmployeeDAO.createEmployee(employee1);
    EmployeeDAO.createEmployee(employee2);
    EmployeeDAO.createEmployee(employee3);
    EmployeeDAO.createEmployee(employee4);
    EmployeeDAO.createEmployee(employee5);
    EmployeeDAO.createEmployee(employee6);

    // suzdai gi s create Dao neshtoto

    Vehicle vehicle1 = new Vehicle(1,"Avtobus",UnitType.People,"AB1234BA",80,null,null);
    Vehicle vehicle2 = new Vehicle(21,"Cisterna",UnitType.Litre,"AB0011XX",2000,null,null);
    Vehicle vehicle3 = new Vehicle(33,"Kamion",UnitType.Kilograms,"XX9911XX",5000,null,null);
    Set<Vehicle> vehicleSet1 = new HashSet<>();
        vehicleSet1.add(vehicle1);
        vehicleSet1.add(vehicle2);
        vehicleSet1.add(vehicle3);
    Set<Vehicle> vehicleSet2 = new HashSet<>();
        vehicleSet2.add(vehicle1);
        vehicleSet2.add(vehicle2);
    Set <Vehicle> vehiclesSet3 = new HashSet<>();
        vehiclesSet3.add(vehicle1);
        vehiclesSet3.add(vehicle3);
    VehicleDao.createVehicle(vehicle1);
    VehicleDao.createVehicle(vehicle2);
    VehicleDao.createVehicle(vehicle3);


    Client client1 = new Client(1,"Klient", "Klientov", null, null );
    Client client2 = new Client(2,"Metodi", "Klientov", null, null );
    ClientDao.createClient(client1);
    ClientDao.createClient(client2);

    Company company1 = new Company(1,"DHL", vehicleSet1,employeesSet1,null,null);
    Company company2 = new Company(2,"Ekont", vehicleSet2,employeesSet1,null,null);
    Company company3 = new Company(3,"Speedy", vehiclesSet3,employeesSet1,null,null);
    Company company4 = new Company(4,"Express", new HashSet<>(Arrays.asList(vehicle1)),employeesSet1,null,null);
    CompanyDao.createCompany(company1);
    CompanyDao.createCompany(company2);
    CompanyDao.createCompany(company3);
    CompanyDao.createCompany(company4);


    Payload payload1 = new Payload(1,"People",100,null);
    Payload payload2 = new Payload(333,"Gas",2000,null);
    Payload payload3 = new Payload(555,"Regular",5000,null);
    PayloadDao.createPayload(payload1);
    PayloadDao.createPayload(payload2);
    PayloadDao.createPayload(payload3);


    Purchase purchase1 = new Purchase(1,LocalDateTime.now(),LocalDateTime.now().plusDays(1),"Belene",100,"Lovech",employee1,vehicle1,company1,payload1,new HashSet<>(Arrays.asList(client1)));
    Purchase purchase2 = new Purchase(2,LocalDateTime.now(),LocalDateTime.now().plusDays(1),"Pleven",140,"Ruse",employee2,vehicle2,company3,payload3,new HashSet<>(Arrays.asList(client2)));
    Purchase purchase3 = new Purchase(3,LocalDateTime.now(),LocalDateTime.now().plusDays(1),"Sliven",111,"Vratsa",employee5,vehicle3,company4,payload2,new HashSet<>(Arrays.asList(client2)));
    PurchaseDao.createPurchase(purchase1);
    PurchaseDao.createPurchase(purchase2);
    PurchaseDao.createPurchase(purchase3);

    Receipt receipt1 = new Receipt(1,client1, purchase1);
    Receipt receipt2 = new Receipt(3,client2, purchase3);
    ReceiptDao.createReceipt(receipt1);
    ReceiptDao.createReceipt(receipt2);




    CompanyDao.getCompanies().stream().forEach(System.out::println);
    EmployeeDAO.getEmoplyees().stream().forEach(System.out::println);
    VehicleDao.getVehicles().stream().forEach(System.out::println);
    ClientDao.getClients().stream().forEach(System.out::println);
    PayloadDao.getPayloads().stream().forEach(System.out::println);
    ReceiptDao.getReceipts().stream().forEach(System.out::println);
    PurchaseDao.getPurchases().stream().forEach(System.out::println);
    SkillDao.getSkills().stream().forEach(System.out::println);


    }

}
