package BD_OneToMany_ManyToOne;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Bank1 {
	@Id
	private int id;
	private String name;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Account1> account;
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
	public List<Account1> getAccount() {
		return account;
	}
	public void setAccount(List<Account1> account) {
		this.account = account;
	}
}
