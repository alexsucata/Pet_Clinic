package com.alexsucata;

import com.alexsucata.consults.ConsultEntity;
import com.alexsucata.invoices.InvoiceEntity;
import com.alexsucata.owners.OwnerEntity;
import com.alexsucata.pets.PetEntity;
import com.alexsucata.veterinarians.VeterinarianEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;


public class Connection {

    private static Connection instance;
    private SessionFactory sessionFactory;

    private Connection() {

    }

    public static Connection getInstance() {
        if (instance == null) {
            instance = new Connection();
        }
        return instance;
    }

    private SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Properties properties = new Properties();
                properties.put(Environment.URL, "jdbc:mysql:localhost:3306/pet_vet");
                properties.put(Environment.USER, "root");
                properties.put(Environment.PASS, "Sucata1977!");
                properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                properties.put(Environment.HBM2DDL_AUTO, "update");

                Configuration configuration = new Configuration();
                configuration.setProperties(properties);
                configuration.addAnnotatedClass(ConsultEntity.class);
                configuration.addAnnotatedClass(InvoiceEntity.class);
                configuration.addAnnotatedClass(OwnerEntity.class);
                configuration.addAnnotatedClass(PetEntity.class);
                configuration.addAnnotatedClass(VeterinarianEntity.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                this.sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Exception exception) {
                System.out.println(exception);
            }
        }
        return sessionFactory;
    }

    public Session getSession() {
        return getSessionFactory().openSession();
    }
}
