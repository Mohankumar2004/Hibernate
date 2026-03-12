package BD_ManyToMany;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Student1 {
	@Id
	private int id;
	private String name;
	private int age;
	@ManyToMany
	private List<Course1> course;
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
	public List<Course1> getCourse() {
		return course;
	}
	public void setCourse(List<Course1> course) {
		this.course = course;
	}
}
