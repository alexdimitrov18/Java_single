package org.example.dto;


import jakarta.persistence.*;
import org.example.entities.Employee;
import org.example.entities.Skill;

import java.util.Objects;

@Entity
@Table(name = "EmployeeSkillsDTO")
public class EmployeeSkillsDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill ;

    public EmployeeSkillsDto() {
    }

    public EmployeeSkillsDto(long id, Employee employee, Skill skill) {
        this.id = id;
        this.employee = employee;
        this.skill = skill;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeSkillsDto that = (EmployeeSkillsDto) o;
        return id == that.id && Objects.equals(employee, that.employee) && Objects.equals(skill, that.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employee, skill);
    }



}
