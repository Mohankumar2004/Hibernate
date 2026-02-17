package oneToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;

@Entity
public class car {
	
	@Id
	int id;
	String name;
	
	@OneToOne
	@JoinColumn(name = "engine_id")
	engin engine;
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
	public engin getEngine() {
		return engine;
	}
	public void setEngine(engin engine) {
		this.engine = engine;
	}
	
	
}