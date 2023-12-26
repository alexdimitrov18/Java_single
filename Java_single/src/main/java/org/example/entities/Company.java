package org.example.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @NotBlank(message = "Company name cannot be blank!")
    @Size(max = 20, message = "Company name has to be with up to 20 characters!")
    @Pattern(regexp = "^([A-Z]).*", message = "Company name has to start with capital letter!")
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY) //vuv vehicle clasa kolonata se kazva company
    private Set<Vehicle> vehicles;
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Set<Employee> employees;   // ako sveti v cherveno, da si dobavq mapinga tip @OnetoMany / OnetoOne i t.n

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Set<Purchase> purchases;
    @ManyToMany
    private Set<Client> clients;

    public Company(long id, String name, Set<Vehicle> vehicles, Set<Employee> employees, Set<Purchase> purchases, Set<Client> clients) {
        this.id = id;
        this.name = name;
        this.vehicles = vehicles;
        this.employees = employees;
        this.purchases = purchases;
        this.clients = clients;
    }

    public Company() {


    } // prazen konstruktor (defaulten) - trqbva mu na hibernate

    public long getId() {  // generiran getter i setter
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Vehicle> getVehicles() {  //getter and setter for vehicles
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return id == company.id && Objects.equals(name, company.name) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
