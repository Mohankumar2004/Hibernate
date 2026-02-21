package oneToMany;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class BankDriver {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mohankumar");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	
	public void save() {
		Accountss account=new Accountss();
		account.setId(1);
		account.setName("Mohankumar");
		account.setBalance(10000);
		Accountss account1=new Accountss();
		account1.setId(2);
		account1.setName("Mmk");
		account1.setBalance(20000);
		
		List<Accountss> list=new ArrayList<Accountss>();
		list.add(account);
		list.add(account1);
		
		Bankss bank=new Bankss();
		bank.setId(1);
		bank.setName("SBI");
		bank.setAccount(list);
		
		et.begin();
		em.persist(bank);
		et.commit();
		
		
	}
	
	
	public void display() {
		Bankss bank=em.find(Bankss.class, 1);
		if(bank!=null && bank.getAccount()!=null)
		{
			for (Accountss account : bank.getAccount()) {
				System.out.println(account.getName()+" has account in "+bank.getName());
			}
			
		}
	}
	
	
	public void update() {
		Bankss bank=em.find(Bankss.class, 1);
		if(bank!=null && bank.getAccount()!=null)
		{
			et.begin();
			for(Accountss account : bank.getAccount())
			{
				account.setBalance(account.getBalance()-50);
			}
			em.merge(bank);
			et.commit();
		}
	}
	
	
	public void delete() {
		et.begin();
		Bankss bank=em.find(Bankss.class, 1);
		Accountss account=em.find(Accountss.class, 101);
		if(bank!=null && account!=null)
		{
			bank.getAccount().remove(account);
			em.remove(account);
			et.commit();
		}
	}
	
	//add account in the existing bank
	public void addaccount() {
		Accountss ac=new Accountss();

		et.begin();
		Bankss bank=em.find(Bankss.class, 1);
		
		if(bank!=null)
		{
			ac.setId(103);
			ac.setName("Mmk");
			ac.setBalance(50000);
			bank.getAccount().add(ac);
			em.merge(bank);
			et.commit();
		}
		
		
	}
	
	
	public void updateaccountwithoutcascade() {
		et.begin();
		Bankss bank=em.find(Bankss.class, 1);
		Accountss accountupdate=null;
		Accountss account= em.find(Accountss.class, 101);
		if(bank!=null && account!=null)
		{
			List<Accountss> list =bank.getAccount();
			for (Accountss account2 : list) {
				if(account.getId()==account2.getId()) {
					account2.setName("mmm");
					accountupdate=account2;
					break;
				}
				
			}
			em.merge(accountupdate);
			et.commit();
		}
	}
	
	
	public void updateaccountwithcascade() {
		et.begin();
		Bankss bank=em.find(Bankss.class, 1);
		
		Accountss account= em.find(Accountss.class, 101);
		if(bank!=null && account!=null)
		{
			List<Accountss> list =bank.getAccount();
			for (Accountss account2 : list) {
				if(account.getId()==account2.getId()) {
					account2.setBalance(100000);
					break;
				}
			}
			em.merge(bank);
			et.commit();
		}
	}
	
	public void updatebank(){
		et.begin();
		Bankss bank=em.find(Bankss.class, 1);
		if(bank!=null)
		{
			bank.setName("SBIYono");
			em.merge(bank);
			et.commit();
			
		}
		
	}
	
	public void deletebank() {
		Bankss bank=em.find(Bankss.class, 1);
		if(bank!=null)
		{
			em.remove(bank);
			et.commit();
		}
	}
	
	public static void main(String args[])
	{
		
		BankDriver bankDriver=new BankDriver();
		bankDriver.updatebank();
		
	}
	
	
}
