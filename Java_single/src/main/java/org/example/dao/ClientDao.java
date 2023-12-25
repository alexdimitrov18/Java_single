package org.example.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.configuration.SessionUtil;
import org.example.entities.Client;
import org.example.entities.Company;
import org.example.entities.Employee;
import org.example.entities.Purchase;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Set;

public class ClientDao {

    public static void createClient(Client client   ) {  // ok
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        }
    }

    public static Client getClientById(long id) {  // ok
        Client client;
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            client = session.get(Client.class, id);
            transaction.commit();
        }
        return client;
    }

    public static List<Client> getClients() { // ok
        List<Client> clients;
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            clients = session.createQuery("Select c From Client c", Client.class)
                    .getResultList();
            transaction.commit();
        }
        return clients;
    }

    public static void updateClients(Client client) {  // ok
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
        }
    }

    public static void deleteClient(Client client) { // delete mojem da go smenim s remove  --- ok
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(client);
            transaction.commit();
        }
    }
    public static List<Client> clientsWithNameEqualTo(String name) {   // ok
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Client> cr = cb.createQuery(Client.class);
            Root<Client> root = cr.from(Client.class);
            cr.select(root).where(cb.equal(root.get("name"), name));

            Query<Client> query = session.createQuery(cr);
            List<Client> clients = query.getResultList();
            return clients;
        }
    }

    public static List<Client> clientsWithNameNotEqualTo(String name) {   // ok
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Client> cr = cb.createQuery(Client.class);
            Root<Client> root = cr.from(Client.class);
            cr.select(root).where(cb.notEqual(root.get("name"), name));

            Query<Client> query = session.createQuery(cr);
            List<Client> clients = query.getResultList();
            return clients;
        }
    }

    public static List<Client> clientsWithNameLike(String name) {   //ok
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Client> cr = cb.createQuery(Client.class);
            Root<Client> root = cr.from(Client.class);
            cr.select(root).where(cb.like(root.get("name"), "%" + name + "%"));

            Query<Client> query = session.createQuery(cr);
            List<Client> clients = query.getResultList();
            return clients;
        }
    }

    public static List<Client> clientsWithNameNotLike(String name) {   //ok
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Client> cr = cb.createQuery(Client.class);
            Root<Client> root = cr.from(Client.class);
            cr.select(root).where(cb.notLike(root.get("name"), "%" + name + "%"));

            Query<Client> query = session.createQuery(cr);
            List<Client> clients = query.getResultList();
            return clients;
        }
    }

    public static Set<Company> getClientsCompany(long id) {  // ok
        Client client;
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            client = session.createQuery(
                            "select c from Client c" +
                                    " join fetch c.company" +
                                    " where c.id = :id",
                            Client.class)
                    .setParameter("id", id)
                    .getSingleResult();
            transaction.commit();
        }
        return client.getCompany();
    }

    public static Set<Purchase> getClientsPurchase(long id) {  // ok
        Client client;
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            client = session.createQuery(
                            "select c from Client c" +
                                    " join fetch c.purchases" +
                                    " where c.id = :id",
                            Client.class)
                    .setParameter("id", id)
                    .getSingleResult();
            transaction.commit();
        }
        return client.getPurchases();
    }


}
