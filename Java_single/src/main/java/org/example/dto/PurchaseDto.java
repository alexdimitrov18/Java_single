package org.example.dto;

import jakarta.persistence.*;
import org.example.entities.*;

import java.time.LocalDateTime;
import java.util.Set;

public class PurchaseDto {

    private long id;
    private LocalDateTime start_time;

    private LocalDateTime end_time;

    private String arrival_point;

    private double  price;

    private String departure_point;

    private Employee employee;   // ????? pitai ivo  - tova e vuv purchase klasa

    private Vehicle vehicle;

    private Company company;

    private Payload payload;

    private Set<Client> clients;

    public PurchaseDto(long id, LocalDateTime start_time, LocalDateTime end_time, String arrival_point, double price, String departure_point, Employee employee, Vehicle vehicle, Company company, Payload payload, Set<Client> clients) {
        this.id = id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.arrival_point = arrival_point;
        this.price = price;
        this.departure_point = departure_point;
        this.employee = employee;
        this.vehicle = vehicle;
        this.company = company;
        this.payload = payload;
        this.clients = clients;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public LocalDateTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalDateTime end_time) {
        this.end_time = end_time;
    }

    public String getArrival_point() {
        return arrival_point;
    }

    public void setArrival_point(String arrival_point) {
        this.arrival_point = arrival_point;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDeparture_point() {
        return departure_point;
    }

    public void setDeparture_point(String departure_point) {
        this.departure_point = departure_point;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
}
