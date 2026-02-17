package manyToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class accounts {
	@Id
	private int id;
	private String name;
	private int age;
	@ManyToOne
	@JoinColumn(name = "bank_id")
	private bank bank;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public bank getBank() {
		return bank;
	}
	public void setBank(bank bank) {
		this.bank=bank;
	}
	
}
