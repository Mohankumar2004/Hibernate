package BD_ManyToMany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class StudentCourseDriver {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Mohankumar");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
}
