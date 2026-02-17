package oneToOne;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class vehicalDriver {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mohankumar");
	car car=new car();
	engin engin=new engin();
	public void save() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			engin.setId(1);
			engin.setEngine(4);
			engin.setCc(2000);
			
			car.setId(1);
			car.setName("BMW");
			car.setEngine(engin);
			
			em.persist(car);
			et.commit();
			System.out.println("Persisted car and engine.");
		
		} catch (Exception e) {
			if (et.isActive()) et.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}
	public void find() {
		EntityManager em = emf.createEntityManager();
		try {
			car findcar = em.find(car.class, 1);
			if (findcar == null) {
				System.out.println("Car not found.");
				return;
			}
			engin findengin = findcar.getEngine();
			if(findengin!=null) {
				System.out.println("Car Name: " + findcar.getName());
				System.out.println("Engine CC: " + findengin.getCc());
			} else {
				System.out.println("Engine not found for car.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	public void update() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			car findcar = em.find(car.class, 1);
			if (findcar != null) {
				findcar.setName("Audi");
				engin findengin = findcar.getEngine();
				if(findengin!=null) {
					findengin.setCc(2500);
				}
				em.merge(findcar);
				System.out.println("Updated car and engine.");
			} else {
				System.out.println("Car not found for update.");
			}
			et.commit();
		} catch (Exception e) {
			if (et.isActive()) et.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	public void delete() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			car findcar = em.find(car.class, 1);
			if (findcar != null) {
				em.remove(findcar);
				System.out.println("Deleted car and its engine.");
			} else {
				System.out.println("Car not found for deletion.");
			}
			et.commit();
		} catch (Exception e) {
			if (et.isActive()) et.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	public void deleteengine() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			engin findengin = em.find(engin.class, 1);
			car findcar = em.find(car.class, 1);
			if(findcar.getEngine() != null ) {
				findcar.setEngine(null);
				em.merge(findcar);
				System.out.println("Unlinked engine from car.");
			}
			if (findengin != null) {
				em.remove(findengin);
				System.out.println("Deleted engine.");
			} else {
				System.out.println("Engine not found for deletion.");
			}
			et.commit();
		} catch (Exception e) {
			if (et.isActive()) et.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	public static void main(String[] args) {
		vehicalDriver driver = new vehicalDriver();
		//driver.save();
		driver.deleteengine();
		emf.close();
	}
}