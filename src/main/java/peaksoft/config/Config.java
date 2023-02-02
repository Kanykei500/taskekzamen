package peaksoft.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.entity.Category;
import peaksoft.entity.Company;
import peaksoft.entity.Product;

import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.*;

public class Config {
    public static SessionFactory getSessionFactory() {
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "postgres");

        properties.put(Environment.HBM2DDL_AUTO, "update");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL, "true");

        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(Category.class);
        return configuration.buildSessionFactory();
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        final SessionFactory sessionFactory = getSessionFactory();
        return sessionFactory.unwrap(EntityManagerFactory.class);
    }
}
