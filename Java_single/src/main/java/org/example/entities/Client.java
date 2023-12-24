package org.example.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "name", nullable = false)
    @Size(max = 30, message = "Max length is 30 characters")
    private String name;

    @Column(name = "family_name", nullable = false)
    @Size(max = 30, message = "Max length is 30 characters")
    private String family_name;

    @ManyToMany
    private Set<Company> company  ;

    @ManyToMany
    private Set<Purchase> purchases;

    public Client() {
    }

    public Client(long id, String name, String family_name, Set<Company> company, Set<Purchase> purchases) {
        this.id = id;
        this.name = name;
        this.family_name = family_name;
        this.company = company;
        this.purchases = purchases;
    }

    public long getId() {
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

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public Set<Company> getCompany() {
        return company;
    }

    public void setCompany(Set<Company> company) {
        this.company = company;
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
        Client client = (Client) o;
        return id == client.id && Objects.equals(name, client.name) && Objects.equals(family_name, client.family_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, family_name);
    }
}
