package org.example.entities;


import jakarta.persistence.*;

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
    private Set<Purchase> purchases;
    @ManyToOne

    private Company company;

    public Vehicle() {


    }

    public Vehicle(long id, String type, double capacity, Set<Purchase> purchases, Company company) {
        this.id = id;
        this.type = type;
        this.capacity = capacity;
        this.purchases = purchases;
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

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}


