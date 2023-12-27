package org.example;

import org.example.dao.*;

public class Filtered_data {
    private EmployeeDAO employeeDAO;
    private VehicleDao vehicleDao;
    private ClientDao clientDao;
    private PayloadDao payloadDao;
    private CompanyDao companyDao;
    private PurchaseDao purchaseDao;
    public Filtered_data() {
        employeeDAO = new EmployeeDAO();
        vehicleDao = new VehicleDao();
        clientDao = new ClientDao();
        payloadDao = new PayloadDao();
        companyDao = new CompanyDao();
        purchaseDao = new PurchaseDao();
    }

    //slujitel po skill i zaplata


}
