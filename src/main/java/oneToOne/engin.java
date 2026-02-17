package oneToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class engin {
	@Id
	int id;
	int engine;
	int cc;
	public int getId() {
		return id;
	}
	
	public int getEngine() {
		return engine;
	}
	public void setEngine(int engine) {
		this.engine = engine;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}

	public void setId(int i) {
		this.id = i;
		
	}
	
}