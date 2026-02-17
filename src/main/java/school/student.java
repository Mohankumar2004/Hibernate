 package school;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class student {
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


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public school getSchool() {
		return school;
	}


	public void setSchool(school school) {
		this.school = school;
	}


	private int age;
    

    // Many Students → One School
    @ManyToOne
    @JoinColumn(name = "school_id")
    private school school;
}