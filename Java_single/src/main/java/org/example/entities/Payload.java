package org.example.entities;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "payload")
public class Payload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "weight", nullable = false)
    private double  weight;

    @OneToMany (mappedBy = "payload")
    private Set<Order> orders;


    public Payload() {
    }

    public Payload(long id, String type, double weight, Set<Order> orders) {
        this.id = id;
        this.type = type;
        this.weight = weight;
        this.orders = orders;
    }

    public long getId() {
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

}
