package manyToOne;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Ecomdriver {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mohankumar");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public void Insert() {
		Product product = new Product();
		product.setId(1);
		product.setName("Samsung");
		product.setPrice(55000);
		
		Review r1=new Review();
		r1.setId(101);
		r1.setMsg("Good");
		
		Review r2=new Review();
		r2.setId(102);
		r2.setMsg("Bad");
		
		Review r3=new Review();
		r3.setId(103);
		r3.setMsg("Okay");
		
		et.begin();
		r1.setProduct(product);
		r2.setProduct(product);
		r3.setProduct(product);
		
		em.persist(product);
		em.persist(r1);
		em.persist(r2);
		em.persist(r3);
		et.commit();
		
	}
	public static void main(String[] args) {
		Ecomdriver d1=new Ecomdriver();
		d1.Insert();
	}
}
