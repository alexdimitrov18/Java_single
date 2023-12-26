package org.example.dao;

import org.example.configuration.SessionUtil;
import org.example.entities.Client;
import org.example.entities.Company;
import org.example.entities.Employee;
import org.example.entities.Skill;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Set;

public class SkillDao {

    public static void createSkill(Skill skill   ) {  // ok
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(skill);
            transaction.commit();
        }
    }

    public static Skill getSkillById(long id) {  // ok
        Skill skill;
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            skill = session.get(Skill.class, id);
            transaction.commit();
        }
        return skill;
    }

    public static List<Skill> getSkills() { // ok
        List<Skill> skills;
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            skills = session.createQuery("Select c From Skill c", Skill.class)
                    .getResultList();
            transaction.commit();
        }
        return skills;
    }

    public static void updateSkills(Skill skill) {  // ok
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(skill);
            transaction.commit();
        }
    }

    public static void deleteSkill(Skill skill) { // delete mojem da go smenim s remove  --- ok
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(skill);
            transaction.commit();
        }
    }

    public static Set<Skill> getEmployeesSkill(long id) {  // ok
        Employee employee;
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employee = session.createQuery(
                            "select c from Employee c" +
                                    " join fetch c.skills" +
                                    " where c.id = :id",
                            Employee.class)
                    .setParameter("id", id)
                    .getSingleResult();
            transaction.commit();
        }
        return employee.getSkills();
    }
}
