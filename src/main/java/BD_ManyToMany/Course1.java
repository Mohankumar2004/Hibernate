package BD_ManyToMany;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course1 {
	@Id
	private int id;
	private String course;
	private String duration;
	@ManyToMany
	private List<Student1> student;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public List<Student1> getStudent() {
		return student;
	}
	public void setStudent(List<Student1> student) {
		this.student = student;
	}
}
