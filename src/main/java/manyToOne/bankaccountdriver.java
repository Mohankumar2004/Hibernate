package manyToOne;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class bankaccountdriver {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mohankumar");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void insert() {
		banks bank1 = new banks();
		bank1.setId(101);
		bank1.setName("SBI");

		accounts account = new accounts();
		account.setId(101);
		account.setName("mmk");
		account.setAge(22);

		account.setBank(bank1);
		bank1.getAccount().add(account);
		et.begin();
		em.persist(bank1);
		em.persist(account);
		et.commit();

	}

	public static void main(String[] args) {

		bankaccountdriver bankaccountdriver = new bankaccountdriver();
		bankaccountdriver.insert();
		
		
	}
}