package br.com.marce.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer {
	
	 private EntityManagerFactory factory;

	    public EntityManagerProducer() {
	        this.factory = Persistence.createEntityManagerFactory("JsfPrimefaces");
	    }

	    @Produces
	    @RequestScoped
	    public EntityManager createEntityManager() {
	        return this.factory.createEntityManager();
	    }

	    public void closeEntityManager(@Disposes EntityManager manager) {
	        manager.close();
	    }

}
