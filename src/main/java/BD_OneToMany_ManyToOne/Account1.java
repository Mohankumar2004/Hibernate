package BD_OneToMany_ManyToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Account1 {
	@Id
	private int id;
	private String name;
	private int balance;
	@ManyToOne
	private Bank1 bank;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Bank1 getBank() {
		return bank;
	}
	public void setBank(Bank1 bank) {
		this.bank = bank;
	}
	
}
