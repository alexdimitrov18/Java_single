package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime start_time;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime end_time;

    @Column(name = "arrival_point", nullable = false)
    private String arrival_point;

    @Column(name = "price", nullable = false)
    private double  price;

    @Column(name = "departure_point", nullable = false)
    private String departure_point;

    @ManyToOne
    private Employee employee;   // ????? pitai ivo  - tova e vuv purchase klasa

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private Company company;

    @OneToOne
    private Payload payload;

    @ManyToMany(mappedBy = "purchases")
    private Set<Client> clients;

    public Purchase() {
    }

    public Purchase(long id, LocalDateTime start_time, LocalDateTime end_time, String arrival_point, double price, String departure_point, Employee employee, Vehicle vehicle, Company company, Payload payload, Set<Client> clients) {
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

    public void setEmployee(Employee employees) {
        this.employee = employees;
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

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }
}
