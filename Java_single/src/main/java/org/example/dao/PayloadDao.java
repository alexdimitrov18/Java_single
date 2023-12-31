package org.example.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.configuration.SessionUtil;
import org.example.entities.Client;
import org.example.entities.Payload;
import org.example.entities.Purchase;
import org.example.entities.Skill;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Set;

public class PayloadDao {

    public static void createPayload(Payload payload   ) {  //  C from CRUD
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

    public static List<Payload> getPayloads() { //
        List<Payload> payloads;
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            payloads = session.createQuery("Select c From Payload c", Payload.class)
                    .getResultList();
            transaction.commit();
        }
        return payloads;
    }

    public static void updatePayload(Payload payload) {  // U FROM CRUD
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(payload);
            transaction.commit();
        }
    }

    public static void deletePayload(Payload payload) { // D FROM CRUD
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(payload);
            transaction.commit();
        }
    }
    // Originally i had the idea to match the payload's type and the employee's skill by Strint type = string skill
    // But it was a bad idea so i just linked the two (as shown in the diagram)
    public static List<Payload> PayloadWithSkillEqualTo(Skill skill ) {
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Payload> cr = cb.createQuery(Payload.class);
            Root<Payload> root = cr.from(Payload.class);
            cr.select(root).where(cb.equal(root.get("skill"), skill));

            Query<Payload> query = session.createQuery(cr);
            List<Payload> payloads = query.getResultList();
            return payloads;
        }
    }
    // Payload by weight range
    public static List<Payload> PayloadByWeightBetween(double bottom, double top) {
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
    // Get the order of a certain payload
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
