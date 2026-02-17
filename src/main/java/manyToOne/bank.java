package manyToOne;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class bank {
	@Id
	private int id;
	private String name;
	@OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
	private List<accounts> account = new ArrayList<>();
	
	
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
	public List<accounts> getAccount() {
		return account;
	}
	public void setAccount(List<accounts> account) {
		this.account = account;
	}
	
}