package BD_OneToOne;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class VehicalDriver {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Mohankumar");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	public void insert() {
		
		Bike bike=new Bike();
		bike.setId(101);
		bike.setName("Pulsar");
		bike.setPrice(150000);
		
		Engine engine=new Engine();
		engine.setId(201);
		engine.setType("Petrol");
		engine.setCc(150);
		
		et.begin();
		bike.setEngine(engine);
		engine.setBike(bike);
		
		em.persist(bike);
		em.persist(engine);
		et.commit();
		
	}
	public static void main(String[] args) {
		VehicalDriver vd=new VehicalDriver();
		vd.insert();
	}
}
