package org.example.entities;


import jakarta.persistence.*;

import java.util.Objects;

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

    @OneToOne
    private Purchase purchases;


    public Payload() {
    }

    public Payload(long id, String type, double weight, Purchase purchases) {
        this.id = id;
        this.type = type;
        this.weight = weight;
        this.purchases = purchases;
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

    public Purchase getPurchases() {
        return purchases;
    }

    public void setPurchases(Purchase purchases) {
        this.purchases = purchases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payload payload = (Payload) o;
        return id == payload.id && Double.compare(weight, payload.weight) == 0 && Objects.equals(type, payload.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, weight);
    }
}
