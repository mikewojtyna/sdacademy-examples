package pl.sdacademy.db.jpa.employee;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Department {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String location;
	// also persist employees
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_dep")
	private Collection<Employee> employees;

	public Collection<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Collection<Employee> employees) {
		this.employees = employees;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
