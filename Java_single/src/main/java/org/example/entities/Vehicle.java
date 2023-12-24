package org.example.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Vehicle type cannot be blank!")
    @Column(name = "type", nullable = false)
    private String type;

    @Enumerated(EnumType.STRING)
    private UnitType unit;
    @NotBlank(message = "The plate of the vehicle cannot be blank!")
    @Size(max = 10, message = "The plate has to have a reasonable length")
    @Column(name = "plate", nullable = false)
    private String plate;


    @Positive
    @Column(name = "capacity", nullable = false)
    @Size(min = 1, max = 5000, message = "Capacity 1 to 100 for people, 100-2000 for special types like gas and 100-5000 for normal payloads")
    private double capacity ; // izmisli validaciq za razlichnite razmeri

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    private Set<Purchase> purchases;
    @ManyToOne
    private Company company;

    public Vehicle() {


    }

    public Vehicle(long id, String type, UnitType unit, String plate, double capacity, Set<Purchase> purchases, Company company) {
        this.id = id;
        this.type = type;
        this.unit = unit;
        this.plate = plate;
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

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }

    public UnitType getUnit() {
        return unit;
    }

    public void setUnit(UnitType unit) {
        this.unit = unit;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return id == vehicle.id && Objects.equals(type, vehicle.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }
}


