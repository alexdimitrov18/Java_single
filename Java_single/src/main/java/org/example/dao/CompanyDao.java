package org.example.dao;


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.configuration.SessionUtil;
import org.example.configuration.SessionUtil;
import org.example.dto.CompanyProfitDTO;
import org.example.dto.EmployeeDto;
import org.example.entities.Company;
import org.example.entities.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class CompanyDao {

    public static void createCompany(Company company) {  // C from CRUD
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
           Transaction transaction = session.beginTransaction();
            session.save(company);
            transaction.commit();
        }
    }

    public static Company getCompanyById(long id) {  // R from CRUD (by id)
        Company company;
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            company = session.get(Company.class, id);
            transaction.commit();
        }
        return company;
    }

    public static List<Company> getCompanies() { // R from CRUD
        List<Company> companies;
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            companies = session.createQuery("Select c From Company c", Company.class)
                    .getResultList();
            transaction.commit();
        }
        return companies;
    }

    public static void updateCompany(Company company) {  // U from CRUD
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(company);
            transaction.commit();
        }
    }

    public static void deleteCompany(Company company) { // D from CRUD
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(company);
            transaction.commit();
        }
    }


    public static List<Company> companiesWithNameEqualTo(String name) {   // Check by name
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Company> cr = cb.createQuery(Company.class);
            Root<Company> root = cr.from(Company.class);
            cr.select(root).where(cb.equal(root.get("name"), name));

            Query<Company> query = session.createQuery(cr);
            List<Company> companies = query.getResultList();
            return companies;
        }
    }

    public static List<Company> companiesWithNameNotEqualTo(String name) {  //
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Company> cr = cb.createQuery(Company.class);
            Root<Company> root = cr.from(Company.class);
            cr.select(root).where(cb.notEqual(root.get("name"), name));

            Query<Company> query = session.createQuery(cr);
            List<Company> companies = query.getResultList();
            return companies;
        }
    }

    public static List<Company> companiesWithNameLike(String name) {   //check by similar name
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Company> cr = cb.createQuery(Company.class);
            Root<Company> root = cr.from(Company.class);
            cr.select(root).where(cb.like(root.get("name"), "%" + name + "%"));

            Query<Company> query = session.createQuery(cr);
            List<Company> companies = query.getResultList();
            return companies;
        }
    }

    public static List<Company> companiesWithNameNotLike(String name) {   //
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Company> cr = cb.createQuery(Company.class);
            Root<Company> root = cr.from(Company.class);
            cr.select(root).where(cb.notLike(root.get("name"), "%" + name + "%"));

            Query<Company> query = session.createQuery(cr);
            List<Company> companies = query.getResultList();
            return companies;
        }
    }


    public static Set<Employee> getCompanyEmployees(long id) {  // Retrieve Company's employees
        Company company;
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            company = session.createQuery(
                            "select c from Company c" +
                                    " join fetch c.employees" +
                                    " where c.id = :id",
                            Company.class)
                    .setParameter("id", id)
                    .getSingleResult();
            transaction.commit();
        }
        return company.getEmployees();
    }
    //I was originally going to use DTOs but it made the code too hard to follow and made everything in the DAOs
    public static List<EmployeeDto> getCompanyEmployeesDTO(long id) {
        List<EmployeeDto> employees;
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employees = session.createQuery(
                            "select new org.example.dto.EmployeeDto(e.id, e.name) from Employee e" +
                                    " join e.company c " +
                                    "where c.id = :id",
                            EmployeeDto.class)
                    .setParameter("id", id)
                    .getResultList();
            transaction.commit();
        }
        return employees;
    }

    // This is one of the few cases where i couldnt do it without DTOs
    public static List<CompanyProfitDTO> getCompanyByProfit(long id ) {
        List<CompanyProfitDTO> companyProfitDTOS;
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            StringBuilder queryBuilder = new StringBuilder(" ");

            companyProfitDTOS = session.createQuery(" select new org.example.dto.CompanyProfitDTO(c.id, c.name, sum(p.price)) from Purchase p " +
                            " join p.company c " +
                            " join p.receipts r" +
                            " where r.id is not null and c.id = :id" , CompanyProfitDTO.class)
                    .setParameter("id", id)
                    .getResultList();
            transaction.commit();
        }
        return companyProfitDTOS;
    }




}
