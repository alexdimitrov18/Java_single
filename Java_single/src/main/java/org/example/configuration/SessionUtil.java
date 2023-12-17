package org.example.configuration;

//import org.example.entity.Company;
//import org.example.entity.CompanyEvent;
//import org.example.entity.Employee;
//import org.example.entity.IdentityCard;

import org.example.entities.Company;
import org.example.entities.Employee;
import org.example.entities.Skill;
import org.example.entities.Vehicle;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Company.class); //dobavqme novi
            configuration.addAnnotatedClass(Vehicle.class);
            configuration.addAnnotatedClass(Employee.class);
            configuration.addAnnotatedClass(Skill.class);
            ServiceRegistry serviceRegistry
                    = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }

        return sessionFactory;
    }
}
