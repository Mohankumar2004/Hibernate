package BD_OneToOne;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import oneToOne.car;

public class VehicalDriver {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mohankumar");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void insert() {

		Bike bike = new Bike();
		bike.setId(101);
		bike.setName("Pulsar");
		bike.setPrice(150000);

		Engine engine = new Engine();
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

	public void display() {

		Bike bike = em.find(Bike.class, 101);
		if (bike != null) {
			System.out.println(bike.getName() + "has" + bike.getEngine().getType());
		}
	}

	public void displayengin() {

		Engine engin = em.find(Engine.class, 101);
		if (engin != null) {
			System.out.println(engin.getBike().getName() + "has" + engin.getType());
		}
	}
	
	public void update() {
		Engine en = em.find(Engine.class, 101);
		if(en!=null)
		{
			en.getBike().setPrice(150000);
			en.setCc(200);
			en.setBike(en.getBike());
			en.getBike().setEngine(en);
			em.merge(en);
			em.merge(en.getBike());
			et.commit();
			
		}
	}
	
	public void updateusingcascade() {
		Bike bike=em.find(Bike.class, 1);
		if(bike!=null && bike.getEngine()!=null)
		{
			et.begin();
			bike.setPrice(245678);
			bike.getEngine().setCc(220);
			em.merge(bike);
			et.commit();
		}
	}
	
	public void deleteusingcascade() {
		Bike bike = new Bike();
		if(bike!=null && bike.getEngine()!=null)
		{
			em.remove(bike);
			et.commit();
		}
	}
	
	
	
	public static void main(String[] args) {
		VehicalDriver vd = new VehicalDriver();
		vd.insert();
	}
}
