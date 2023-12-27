package org.example.entities;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "type", nullable = false)
    private String type;
    @ManyToMany(mappedBy = "skills")
    private Set<Employee> employee ;


    public Skill() {
    }

    public Skill(long id, String type, Set<Employee> employee) {
        this.id = id;
        this.type = type;
        this.employee = employee;
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

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }
}
