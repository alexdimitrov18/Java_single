package org.example.entities;


import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "payload")
public class Payload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

  //  @JoinColumn(name = "type", nullable = false)
    @ManyToOne( fetch = FetchType.LAZY)
    private Skill skills;

    @Column(name = "weight", nullable = false)
    private double  weight;

    @OneToOne
    private Purchase purchases;


    public Payload() {
    }

    public Payload(long id, Skill skill, double weight, Purchase purchases) {
        this.id = id;
        this.skills = skills;
        this.weight = weight;
        this.purchases = purchases;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Skill getSkills() {
        return skills;
    }

    public void setSkills(Skill skill) {
        this.skills = skills;
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
        return id == payload.id && Double.compare(weight, payload.weight) == 0 && Objects.equals(skills, payload.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, skills, weight);
    }
}
