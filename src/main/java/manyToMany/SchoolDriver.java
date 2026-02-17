package manyToMany;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


public class SchoolDriver {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Mohankumar");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public void insert() {
		Students student1=new Students();
		student1.setId(101);
		student1.setName("Mohankumar");
		student1.setAge(21);
		
		Subjects subject1 =new Subjects();
		subject1.setId(1);
		subject1.setName("JAVA");
		
		Subjects subject2 =new Subjects();
		subject2.setId(2);
		subject2.setName("SPRING BOOT");
		
		List<Subjects> subject=new ArrayList<Subjects>();
		subject.add(subject1);
		subject.add(subject2);
		
		et.begin();
		student1.setSubjects(subject);
		
		em.persist(subject1);
		em.persist(subject2);
		em.persist(student1);
		
		et.commit();
		
	}
	
	public void displaystudentsubject() {
		
		Subjects subject = em.find(Subjects.class, 1);
		Students student = em.find(Students.class, 101);
		if(subject!=null)
		{
			for (Subjects sub : student.getSubjects()) {
				System.out.println(sub.getName());
			}
		}
	}
	public void displaysubject() {
		
	}
	
	public void updatestudent() {
		et.begin();
		Students student = em.find(Students.class, 101);
		if(student!=null)
		{
			student.setName("Mohan");
			em.merge(student);
			et.commit();
		}
		
	}
	public void updatesubject() {
		et.begin();
		Subjects subject = em.find(Subjects.class, 1);
		if(subject!=null)
		{
			subject.setName("CORE_JAVA");
			em.merge(subject);
			et.commit();
		}
			
	}
	
	public void deletestudent() {
		et.begin();
		Students student = em.find(Students.class, 101);
		if(student!=null)
		{
			em.remove(student);
			et.commit();
		}
	}
	private void deletesubject() {
		et.begin();
		Subjects subject = em.find(Subjects.class, 1);
		Students std1 = em.find(Students.class, 101);
//		Students std2 = em.find(Students.class, 102);
		
		if(subject!=null && std1!=null)
		{
			std1.getSubjects().remove(subject);
			em.remove(subject);
			et.commit();
		}
		
	}
	
	
	public static void main(String[] args) {
		SchoolDriver sd=new SchoolDriver();
//		sd.insert();
//		sd.displaystudentsubject();
//		sd.updatestudent();
//		sd.updatesubject();
//		sd.deletestudent();
		sd.deletesubject();
		
	}
}
