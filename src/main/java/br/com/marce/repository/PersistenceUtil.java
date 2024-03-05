package br.com.marce.repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
	 private static EntityManagerFactory entityManagerFactory;

	    public static EntityManagerFactory getEntityManagerFactory() {
	        if (entityManagerFactory == null) {
	            entityManagerFactory = Persistence.createEntityManagerFactory("JsfPrimefaces");
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
