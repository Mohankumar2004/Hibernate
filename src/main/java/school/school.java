package school;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class school {
	@Id
    private int id;

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

	public principal getPrincipal() {
		return principal;
	}

	public void setPrincipal(principal principal) {
		this.principal = principal;
	}

	private String name;

    @OneToOne(mappedBy = "school", cascade = CascadeType.ALL)
    private principal principal;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private List<student> students;   // ✅ school.Student

    public List<student> getStudents() {
        return students;
    }

    public void setStudents(List<student> students) {
        this.students = students;
    }
}