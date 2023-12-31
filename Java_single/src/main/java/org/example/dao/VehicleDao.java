package org.example.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.configuration.SessionUtil;
import org.example.entities.Company;
import org.example.entities.Employee;
import org.example.entities.Vehicle;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class VehicleDao {

    public static void createVehicle(Vehicle vehicle ) {  // c from crud
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(vehicle);
            transaction.commit();
        }
    }

    public static Vehicle getVehicleByPlate(long plate) {  // get vehicle by plate
        Vehicle vehicle;
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            vehicle = session.get(Vehicle.class, plate);
            transaction.commit();
        }
        return vehicle;
    }

    public static List<Vehicle> getVehicles() { //  r from crud
        List<Vehicle> vehicle;
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            vehicle  = session.createQuery("Select c From Vehicle c", Vehicle.class)
                    .getResultList();
            transaction.commit();
        }
        return  vehicle;
    }

    public static void updateVehicle(Vehicle vehicle) {  // u from crud
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(vehicle);
            transaction.commit();
        }
    }

    public static void deleteVehicle(Vehicle vehicle) { //  d from crud
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(vehicle);
            transaction.commit();
        }
    }
//a string match worked just as good, didnt use this
    public static List<Vehicle> VehiclesWithPlateEqualTo(String plate) {
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Vehicle> cr = cb.createQuery(Vehicle.class);
            Root<Vehicle> root = cr.from(Vehicle.class);
            cr.select(root).where(cb.equal(root.get("plate"), plate));

            Query<Vehicle> query = session.createQuery(cr);
            List<Vehicle> vehicles = query.getResultList();
            return vehicles;
        }
    }

    public static List<Vehicle> VehiclesWithPlateNotEqualTo(String plate) {   //
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Vehicle> cr = cb.createQuery(Vehicle.class);
            Root<Vehicle> root = cr.from(Vehicle.class);
            cr.select(root).where(cb.notEqual(root.get("plate"), plate));

            Query<Vehicle> query = session.createQuery(cr);
            List<Vehicle> vehicles = query.getResultList();
            return vehicles;
        }
    }
    // planned to use it if there were typos in the plate, bad idea - unnecessary complexity
    public static List<Vehicle> VehiclesWithPlateLike(String plate) {   //ok
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Vehicle> cr = cb.createQuery(Vehicle.class);
            Root<Vehicle> root = cr.from(Vehicle.class);
            cr.select(root).where(cb.like(root.get("plate"), "%" + plate + "%"));

            Query<Vehicle> query = session.createQuery(cr);
            List<Vehicle> vehicles = query.getResultList();
            return vehicles;
        }
    }

    public static List<Vehicle> VehiclesWithPlateNotLike(String plate) {   //ok
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Vehicle> cr = cb.createQuery(Vehicle.class);
            Root<Vehicle> root = cr.from(Vehicle.class);
            cr.select(root).where(cb.notLike(root.get("plate"), "%" + plate + "%"));

            Query<Vehicle> query = session.createQuery(cr);
            List<Vehicle> vehicles = query.getResultList();
            return vehicles;
        }
    }
    public static Company getVehiclesCompany(long id ) {  // Vehicle X is owned by company Y
        Vehicle vehicle;
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            vehicle = session.createQuery(
                            "select c from Vehicle c" +
                                    " join fetch c.company" +
                                    " where c.id = :id",
                            Vehicle.class)
                    .setParameter("id", id)
                    .getSingleResult();
            transaction.commit();
        }
        return  vehicle.getCompany();
    }
}
