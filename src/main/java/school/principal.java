package school;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class principal {
	@Id
    private int id;   // MANUAL ID

    private String name;

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

	public school getSchool() {
		return school;
	}

	public void setSchool(school school) {
		this.school = school;
	}

	// One Principal → One School
    @OneToOne
    @JoinColumn(name = "school_id")
    private school school;
	
}
