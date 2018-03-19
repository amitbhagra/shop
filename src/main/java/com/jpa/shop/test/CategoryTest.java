package com.jpa.shop.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.jpa.shop.model.Category;
import com.jpa.shop.util.JPAUtil;

public class CategoryTest {
	private static EntityManager em;

	public static void main(String[] args) {
		createCategory();
		  //getAllProducts();
		 // getAllTalkTimeProducts();
		//deleteCoupon();
		//createProduct();
		//createTalkTimePackage();
		//deleteProduct();
		//getProduct();

	}
	
	private static void createCategory() {
		em = JPAUtil.getEntityManager(); // Application Managed entity manager
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Category category = new Category();
			category.setName("Yantra");
			
			em.persist(category);
			Category category2 = new Category();
			category2.setName("Gemstones");
			
			em.persist(category2);
			tx.commit();
			System.out.println("Transaction commited ");
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
		} finally {
			if (em != null && em.isOpen())
				em.close();
			//System.out.println("Person is now in detached state " + p.getId());
			JPAUtil.shutdown();
		}
	}
	
	
}
