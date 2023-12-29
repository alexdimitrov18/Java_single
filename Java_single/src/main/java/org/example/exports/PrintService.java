package org.example.exports;

import com.itextpdf.layout.element.ListItem;
import org.example.dao.CompanyDao;
import org.example.dao.EmployeeDAO;
import org.example.dao.PurchaseDao;
import org.example.entities.*;


import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;


import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class PrintService {

    private  EmployeeDAO employeeDAO;
    private  PurchaseDao purchaseDao;
    private  CompanyDao companyDao;


   public PrintService(){

       employeeDAO = new EmployeeDAO();
       purchaseDao = new PurchaseDao();
       companyDao = new CompanyDao();

   }

    public void printPurchaseToPdf(Purchase purchase, PurchaseDao purchaseDao) {
        String filePath = "C:\\Users\\Alex\\Desktop\\Uni\\java\\Java_single_repo\\Java_single\\src\\main\\resources\\purchases.pdf";
        try (PdfWriter writer = new PdfWriter(filePath)) {
            try (PdfDocument pdf = new PdfDocument(writer)) {
                try (Document document = new Document(pdf)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    Paragraph title = new Paragraph("Purchase #" + purchase.getId())
                            .setFontSize(18)
                            .setBold()
                            .setTextAlignment(TextAlignment.CENTER);
                    document.add(title);
                    document.add(new Paragraph("Arrival point: " + purchase.getArrival_point()));
                    document.add(new Paragraph("Departure point: " + purchase.getDeparture_point()));
                    document.add(new Paragraph("Start time: " + purchase.getStart_time().format(formatter)));
                    document.add(new Paragraph("End time: " + purchase.getEnd_time().format(formatter)));
                    document.add(new Paragraph("Price: " + purchase.getPrice()));
                    document.add(new Paragraph("Driver: " + purchase.getEmployee().getName() + " " + purchase.getEmployee().getFamily_name()));
                    document.add(new Paragraph("Company: " + purchase.getCompany().getName()));
//                    for (Client client : orderDao.) {
//                        document.add(new Paragraph("Clients: ").setFirstLineIndent(1));
//                        //document.add(new)
//                    }
                }
            }
            System.out.println("PDF created successfully at: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printCompanyToPdf(Company company, CompanyDao companyDao) {
        String filePath = "C:\\Users\\Alex\\Desktop\\Uni\\java\\Java_single_repo\\Java_single\\src\\main\\resources\\company.pdf";
        try (PdfWriter writer = new PdfWriter(filePath)) {
            try (PdfDocument pdf = new PdfDocument(writer)) {
                try (Document document = new Document(pdf)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    Paragraph title = new Paragraph("Company #" + company.getId())
                            .setFontSize(18)
                            .setBold()
                            .setTextAlignment(TextAlignment.CENTER);
                    document.add(title);
                    document.add(new Paragraph("Name: " + company.getName()));
                    document.add(new Paragraph("Employees: "));
                    for (Employee employee : company.getEmployees()) {
                        document.add(new Paragraph("Name: " + employee.getName()));
                        document.add(new Paragraph("Family name: " + employee.getFamily_name()));
                    }
                    document.add(new Paragraph("Vehicles: "));
                    for (Vehicle vehicle : company.getVehicles()) {
                        document.add(new Paragraph("Vehicle plate: " + vehicle.getPlate()));
                        document.add(new Paragraph("Vehicle type: " + vehicle.getType()));
                    }
                    document.add(new Paragraph("Clients: "));
                    for (Client client : company.getClients()) {
                        document.add(new Paragraph("Name: " + client.getName()));
                        document.add(new Paragraph("Family Name: " + client.getFamily_name()));
                    }
//                    for (Client client : orderDao.) {
//                        document.add(new Paragraph("Clients: ").setFirstLineIndent(1));
//                        //document.add(new)
//                    }
                }
            }
            System.out.println("PDF created successfully at: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printEmployeeToPdf(Employee employee, EmployeeDAO employeeDAO) {
        String filePath = "C:\\Users\\Alex\\Desktop\\Uni\\java\\Java_single_repo\\Java_single\\src\\main\\resources\\employee.pdf";
        try (PdfWriter writer = new PdfWriter(filePath)) {
            try (PdfDocument pdf = new PdfDocument(writer)) {
                try (Document document = new Document(pdf)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    Paragraph title = new Paragraph("Employee #" + employee.getId())
                            .setFontSize(18)
                            .setBold()
                            .setTextAlignment(TextAlignment.CENTER);
                    document.add(title);
                    document.add(new Paragraph("First name : " + employee.getName()));
                    document.add(new Paragraph("Family name : " + employee.getFamily_name()));
                    document.add(new Paragraph("EGN : " + employee.getEGN()));
                    for (Skill skill : employee.getSkills()) {
                        document.add(new Paragraph("Skill: " + skill.getType()));
                    }
                    document.add(new Paragraph("Salary: " + employee.getSalary()));

//                    for (Client client : orderDao.) {
//                        document.add(new Paragraph("Clients: ").setFirstLineIndent(1));
//                        //document.add(new)
//                    }
                }
            }
            System.out.println("PDF created successfully at: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
