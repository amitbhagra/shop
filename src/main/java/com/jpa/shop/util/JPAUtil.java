package com.jpa.shop.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.criteria.CriteriaBuilder;

public class JPAUtil {
	private static final String PERSISTENCE_UNIT_NAME = "JPA_Shop";
	private static EntityManagerFactory factory;

	private static EntityManagerFactory getEntityManagerFactory() {
		if (factory == null) {
			factory = Persistence
					.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		return factory;
	}
	
	public static EntityManager getEntityManager() {
		return getEntityManagerFactory().createEntityManager();
	}
	
	public static CriteriaBuilder getCriteriaBuilder(){
		CriteriaBuilder builder = getEntityManagerFactory().getCriteriaBuilder();
		return  builder;
	}
	
	public static PersistenceUnitUtil getPersistenceUtil() {
		return getEntityManagerFactory().getPersistenceUnitUtil();
	}

	public static void shutdown() {
		if (factory != null) {
			factory.close();
		}
	}
}
