package com.jpa.shop.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.jpa.shop.model.BaseProduct;
import com.jpa.shop.model.Product;
import com.jpa.shop.model.ProductImage;
import com.jpa.shop.model.TalkTimePackage;
import com.jpa.shop.util.JPAUtil;

public class ProductTest {
	private static EntityManager em;

	public static void main(String[] args) {
		//createData();
		  //getAllProducts();
		  //getAllTalkTimeProducts();
		//deleteCoupon();
		//createProduct();
		updateProduct();
		//createTalkTimePackage();
		//deleteProduct();
		//getProduct();

	}
	
	private static void updateProduct() {
		em = JPAUtil.getEntityManager(); // Application Managed entity manager
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			Product p = em.find(Product.class, 1);
			p.setDescription("Yantra to Establish peace in your home updated");
			
			
			
			
			tx.commit(); // Synchronizes/flushes persistent context
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
	
	private static void getAllProducts() {
		em = JPAUtil.getEntityManager(); // Application Managed entity manager
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			CriteriaBuilder builder = em
			        .getCriteriaBuilder();
			 
			    CriteriaQuery<BaseProduct> criteria = builder
			        .createQuery( BaseProduct.class );
			    criteria.from( BaseProduct.class );
			 
			    	List<BaseProduct> list =  em
			        .createQuery( criteria )
			        .getResultList();
			    	for (BaseProduct p: list) {
			    		System.out.println(p);
			    		System.out.println(p.getClass().getName());
			    		
			    	}
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
	
	private static void getAllTalkTimeProducts() {
		em = JPAUtil.getEntityManager(); // Application Managed entity manager
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			CriteriaBuilder builder = em
			        .getCriteriaBuilder();
			 
			    CriteriaQuery<TalkTimePackage> criteria = builder
			        .createQuery( TalkTimePackage.class );
			    criteria.from( TalkTimePackage.class );
			 
			    	List<TalkTimePackage> list =  em
			        .createQuery( criteria )
			        .getResultList();
			    	for (TalkTimePackage p: list) {
			    		System.out.println(p);
			    		System.out.println(p.getClass().getName());
			    		
			    	}
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
	
	private static void deleteProduct() {
		em = JPAUtil.getEntityManager(); // Application Managed entity manager
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			Product p = (Product) em.find(Product.class, 1);
			em.remove(p);
			
//			Product p = em.find(Product.class, 1);
//			System.out.println(p.getName());
//			System.out.println(p.getImages());
					
			tx.commit(); // Synchronizes/flushes persistent context
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

	private static void getProduct() {
		em = JPAUtil.getEntityManager(); // Application Managed entity manager
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			Product p = (Product) em.createQuery("select p from Product p join fetch p.images images where p.id =:id and images.active=true").setParameter("id", 4).getResultList().get(0);
//			Product p = (Product) em.createQuery("select p from Product p join fetch p.images images where p.id =:id").setParameter("id", 3).getResultList().get(0);
//			Product p = em.find(Product.class, 3);
			System.out.println(p.getName());
			System.out.println(p.getImages());
					
			tx.commit(); // Synchronizes/flushes persistent context
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
	
	private static void createProduct() {
		em = JPAUtil.getEntityManager(); // Application Managed entity manager
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			Product p = new Product();
			p.setName("Griha Shanti Yantra");
			p.setDescription("Yantra to Establish peace in your home");
			p.setManufacturer("BKS Systems");
			p.setModelNumber("GSY001");
			
			Set<ProductImage> images = new HashSet<ProductImage>();
			
			images.add(new ProductImage("http://abc.com/image1", true));
			images.add(new ProductImage("http://abc.com/image2", false));
			images.add(new ProductImage("http://abc.com/image3", true));
			
			p.setImages(images);
			
			em.persist(p);
			
			tx.commit(); // Synchronizes/flushes persistent context
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
	
	private static void createTalkTimePackage() {
		em = JPAUtil.getEntityManager(); // Application Managed entity manager
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			TalkTimePackage t = new TalkTimePackage();
			t.setName("5 minutes Package");
			t.setDescription("Talk Time for 5 minutes");
			t.setValidity(300);
			
				
			em.persist(t);
			
			tx.commit(); // Synchronizes/flushes persistent context
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
