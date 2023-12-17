package org.example.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "type", nullable = false)
    private String type;


    @Column(name = "capacity", nullable = false)
    private double capacity ;

    @OneToMany(mappedBy = "vehicle")
    private Set<Order> orders;
    @ManyToOne

    private Company company;

    public Vehicle() {


    }

    public Vehicle(long id, String type, double capacity, Set<Order> orders, Company company) {
        this.id = id;
        this.type = type;
        this.capacity = capacity;
        this.orders = orders;
        this.company = company;
    }

    public long getId() {    //getters and setters
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public Company getCompany() {
        return company;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}


