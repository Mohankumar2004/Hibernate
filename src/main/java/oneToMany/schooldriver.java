package oneToMany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class schooldriver {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mohankumar");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void insert() {
		try {
			et.begin();

			schools s = new schools();
			// do not set id when using @GeneratedValue
			s.setName("SVVB");

			students st1 = new students();
			// do not set id when using @GeneratedValue
			st1.setName("Ai");
			st1.setAge(14);
			st1.setSchool(s);

			students st2 = new students();
			// do not set id when using @GeneratedValue
			st2.setName("Bo");
			st2.setAge(13);
			st2.setSchool(s);

			s.getStudents().add(st1);
			s.getStudents().add(st2);

			em.persist(s); // cascade will persist students
			et.commit();
			System.out.println("Persisted school and students.");
		} catch (Exception e) {
			if (et.isActive())
				et.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}

	public static void main(String[] args) {

		schooldriver driver = new schooldriver();
		driver.insert();
	}
}