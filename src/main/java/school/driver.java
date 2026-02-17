//package school;
//
//import java.util.ArrayList;
//import java.util.List;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.Persistence;
//
//public class driver {
//	static EntityManagerFactory emf =Persistence.createEntityManagerFactory("Mohankumar");
//    static EntityManager em = emf.createEntityManager();
//    static EntityTransaction et = em.getTransaction();
//    
//    public static void main(String[] args) {
//
//        
//        insert();
//
//        
//        findSchool(1);
//
//        
//        updateStudentName(1001, "Mohankumar");
//
//        
//        deleteStudent(1001);
//
//        em.close();
//        emf.close();
//    }
//    public static void insert() {
//        et.begin();
//
//        school school = new school();
//        school.setId(1);
//        school.setName("SVV School");
//
//        principal principal = new principal();
//        principal.setId(101);
//        principal.setName("Mr. Varun");
//        principal.setSchool(school);
//
//        school.setPrincipal(principal);
//
//        student s1 = new student();
//        s1.setId(1001);
//        s1.setName("MMK");
//        s1.setSchool(school);
//
//        student s2 = new student();
//        s2.setId(1002);
//        s2.setName("Kavi");
//        s2.setSchool(school);
//
//        List<student> students = new ArrayList<>();
//        students.add(s1);
//        students.add(s2);
//
//        school.setStudents(students);
//
//        em.persist(school);  
//
//        et.commit();
//        System.out.println("Data inserted successfully");
//    }
//    public static void findSchool(int schoolId) {
//        school school = em.find(school.class, schoolId);
//
//        if (school != null) {
//            System.out.println("School Name: " + school.getName());
//            System.out.println("Principal: " +
//                    school.getPrincipal().getName());
//
//            for (student s : school.getStudents()) {
//                System.out.println("Student: " + s.getName());
//            }
//        } else {
//            System.out.println("School not found");
//        }
//    }
//    public static void updateStudentName(int studentId, String newName) {
//        et.begin();
//
//        student student = em.find(student.class, studentId);
//        if (student != null) {
//            student.setName(newName);
//            System.out.println("Student name updated");
//        } else {
//            System.out.println("Student not found");
//        }
//
//        et.commit();
//    }
//    
//    public static void deleteStudent(int studentId) {
//        et.begin();
//
//        student student = em.find(student.class, studentId);
//        if (student != null) {
//            em.remove(student);
//            System.out.println("Student deleted");
//        } else {
//            System.out.println("Student not found");
//        }
//
//        et.commit();
//    }
//
//}
