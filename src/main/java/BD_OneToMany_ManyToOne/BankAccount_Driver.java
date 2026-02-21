package BD_OneToMany_ManyToOne;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class BankAccount_Driver {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mohankumar");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public void insert() {
		Bank1 bank =new Bank1();
		bank.setId(1);
		bank.setName("SBI");
		
		Account1 account =new Account1();
		account.setId(101);
		account.setName("Mohankumar");
		account.setBalance(10000);
		
		List<Account1> list=new ArrayList<Account1>();
		list.add(account);
		
		et.begin();
		bank.setAccount(list);
		account.setBank(bank);
		em.persist(bank);
		et.commit();
		
	}
	
	public void fetchbybank() {
		Bank1 bank = em.find(Bank1.class, 1);
		if(bank!=null) {
			for ( Account1 account : bank.getAccount()) {
				System.out.println("Bank Name: "+bank.getName());
				System.out.println("Account Name: "+account.getName());
				System.out.println("Account Balance: "+account.getBalance());
				System.out.println("====================================");
				
			}
		}
	}
	
	public void fetchbyaccount() {
		Account1 account = em.find(Account1.class, 101);
		if(account!=null) {
			System.out.println("Account Name: "+account.getName());
			System.out.println("Account Balance: "+account.getBalance());
			System.out.println("Bank Name: "+account.getBank().getName());
		}
	}
	
	public void fetchall() {
		Bank1 bank = em.find(Bank1.class, 1);
		if(bank!=null) {
			for ( Account1 account : bank.getAccount()) {
				System.out.println("Bank Name: "+bank.getName());
				System.out.println("Account Name: "+account.getName());
				System.out.println("Account Balance: "+account.getBalance());
				System.out.println("====================================");
				
			}
		}
	}
	
	public void delete() {
		Bank1 bank = em.find(Bank1.class, 1);
		if(bank!=null) {
			et.begin();
			em.remove(bank);
			et.commit();
		}
	}
	
	public void deletebyaccount() {
		Account1 account = em.find(Account1.class, 101);
		if(account!=null) {
			et.begin();
			em.remove(account);
			et.commit();
		}
	}
	
	public void deletebybank() {
		Bank1 bank = em.find(Bank1.class, 1);
		if(bank!=null) {
			et.begin();
			for ( Account1 account : bank.getAccount()) {
				account.setBank(null);
				em.merge(account);
			}
		}
	}
	
	public void addaccounttoexistingbank() {
		Bank1 bank = em.find(Bank1.class, 1);
		if(bank!=null) {
			Account1 account =new Account1();
			account.setId(102);
			account.setName("Kumar");
			account.setBalance(20000);
			
			et.begin();
			bank.getAccount().add(account);
			account.setBank(bank);
			em.persist(account);
			et.commit();
		}
	}
	
	
	public static void main(String[] args) {
		
		BankAccount_Driver driver = new BankAccount_Driver();
//		driver.fetchbybank();
//		driver.fetchbyaccount();
		driver.addaccounttoexistingbank();
	
	}
}


