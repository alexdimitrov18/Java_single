package org.example.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.configuration.SessionUtil;
import org.example.entities.Client;
import org.example.entities.Payload;
import org.example.entities.Purchase;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Set;

public class PayloadDao {

    public static void createPayload(Payload payload   ) {  // ok
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(payload);
            transaction.commit();
        }
    }

    public static Payload getPayloadById(long id) {  // ok
        Payload payload;
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            payload = session.get(Payload.class, id);
            transaction.commit();
        }
        return payload;
    }

    public static List<Payload> getPayloads() { // ok
        List<Payload> payloads;
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            payloads = session.createQuery("Select c From Payload c", Payload.class)
                    .getResultList();
            transaction.commit();
        }
        return payloads;
    }

    public static void updatePayload(Payload payload) {  // ok
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(payload);
            transaction.commit();
        }
    }

    public static void deletePayload(Payload payload) { // delete mojem da go smenim s remove  --- ok
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(payload);
            transaction.commit();
        }
    }

    public static List<Payload> PayloadWithTypeEqualTo(String type) {   // ok
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Payload> cr = cb.createQuery(Payload.class);
            Root<Payload> root = cr.from(Payload.class);
            cr.select(root).where(cb.equal(root.get("type"), type));

            Query<Payload> query = session.createQuery(cr);
            List<Payload> payloads = query.getResultList();
            return payloads;
        }
    }

    public static List<Payload> PayloadByWeightBetween(double bottom, double top) {  // filtrirane po kriterii
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Payload> cr = cb.createQuery(Payload.class);
            Root<Payload> root = cr.from(Payload.class);

            cr.select(root).where(cb.between(root.get("weight"), bottom, top));

            Query<Payload> query = session.createQuery(cr);
            List<Payload> payloads = query.getResultList();
            return payloads;
        }
    }

    public static Purchase getPayloadsPurchase(long id) {  // ok
        Payload payload;
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            payload = session.createQuery(
                            "select c from Payload c" +
                                    " join fetch c.purchases" +
                                    " where c.id = :id",
                            Payload.class)
                    .setParameter("id", id)
                    .getSingleResult();
            transaction.commit();
        }
        return payload.getPurchases();
    }

}
