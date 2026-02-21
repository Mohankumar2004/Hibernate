package oneToMany;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Bankss {
	@Id
	private int id;
	private String name;
	@OneToMany(cascade = CascadeType.ALL)
	
	private List<Accountss> account;
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
	public List<Accountss> getAccount() {
		return account;
	}
	public void setAccount(List<Accountss> account) {
		this.account = account;
	}
	
}