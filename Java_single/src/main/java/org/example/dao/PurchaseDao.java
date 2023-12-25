package org.example.dao;

import org.example.configuration.SessionUtil;
import org.example.entities.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Set;

public class PurchaseDao {

    public static void createPurchase(Purchase purchase) {  // ok
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(purchase);
            transaction.commit();
        }
    }

    public static Purchase getPurchaseById(long id) {  // ok
        Purchase purchase;
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            purchase = session.get(Purchase.class, id);
            transaction.commit();
        }
        return purchase;
    }

    public static List<Purchase> getPurchases() { // ok
        List<Purchase> purchases;
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            purchases = session.createQuery("Select c From Purchase c", Purchase.class)
                    .getResultList();
            transaction.commit();
        }
        return purchases;
    }

    public static void updatePurchase(Purchase purchase) {  // ok
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(purchase);
            transaction.commit();
        }
    }

    public static void deletePurchase(Purchase purchase) { // delete mojem da go smenim s remove  --- ok
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(purchase);
            transaction.commit();
        }
    }

    public static Company getPurchaseCompany(long id) {  // ok
        Purchase purchase;
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            purchase = session.createQuery(
                            "select c from Purchase c" +
                                    " join fetch c.company" +
                                    " where c.id = :id",
                            Purchase.class)
                    .setParameter("id", id)
                    .getSingleResult();
            transaction.commit();
        }
        return purchase.getCompany();
    }

    public static Employee getPurchaseEmployee(long id) {  // ok
        Purchase purchase;
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            purchase = session.createQuery(
                            "select c from Purchase c" +
                                    " join fetch c.employee" +
                                    " where c.id = :id",
                            Purchase.class)
                    .setParameter("id", id)
                    .getSingleResult();
            transaction.commit();
        }
        return purchase.getEmployee();
    }

    public static Vehicle getPurchaseVehicle(long id) {  // ok
        Purchase purchase;
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            purchase = session.createQuery(
                            "select c from Purchase c" +
                                    " join fetch c.vehicle" +
                                    " where c.id = :id",
                            Purchase.class)
                    .setParameter("id", id)
                    .getSingleResult();
            transaction.commit();
        }
        return purchase.getVehicle();
    }

    public static Payload getPurchasePayload(long id) {  // ok
        Purchase purchase;
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            purchase = session.createQuery(
                            "select c from Purchase c" +
                                    " join fetch c.payload" +
                                    " where c.id = :id",
                            Purchase.class)
                    .setParameter("id", id)
                    .getSingleResult();
            transaction.commit();
        }
        return purchase.getPayload();
    }

    public static Set<Client> getPurchaseClient(long id) {  // ok
        Purchase purchase;
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            purchase = session.createQuery(
                            "select c from Purchase c" +
                                    " join fetch c.clients" +
                                    " where c.id = :id",
                            Purchase.class)
                    .setParameter("id", id)
                    .getSingleResult();
            transaction.commit();
        }
        return purchase.getClients();
    }

}
