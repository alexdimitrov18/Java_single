package org.example.entities;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "family_name", nullable = false)
    private String family_name;

    @ManyToMany
    private Set<Company> company  ;

    public Client() {
    }

    public Client(long id, String name, String family_name, Set<Company> company) {
        this.id = id;
        this.name = name;
        this.family_name = family_name;
        this.company = company;
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
}
