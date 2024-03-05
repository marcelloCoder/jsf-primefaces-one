package br.com.marce.jdbc;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            Map<String, String> properties = new HashMap<>();
            properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            properties.put("hibernate.connection.url", "jdbc:postgresql://localhost:5433/cursojsfprimefaces");
            properties.put("hibernate.connection.username", "postgres");
            properties.put("hibernate.connection.password", "admin");

            try {
                entityManagerFactory = Persistence.createEntityManagerFactory("JsfPrimefaces", properties);
            } catch (Exception e) {
                System.err.println("Erro ao criar o EntityManagerFactory: " + e.getMessage());
                e.printStackTrace();
            }
        }

        return entityManagerFactory;
    }

    public static void closeEntityManagerFactory() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
            entityManagerFactory = null;
        }
    }
}