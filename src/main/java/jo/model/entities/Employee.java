package jo.model.entities;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEES")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EmpGen")
	@SequenceGenerator(sequenceName = "EMPLOYEES_SEQ", allocationSize = 1, name = "EmpGen")
	@Column(name = "EMPLOYEE_ID")
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private Date hireDate;
	private String jobId;

	protected Employee() {
	}

	public Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = firstName.charAt(0) + lastName.substring(0, Math.min(7, lastName.length())).toUpperCase();
		this.hireDate = Date.valueOf(LocalDate.now());
		this.jobId = "IT_PROG";
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return String.format("[%s %s, %s, %s, %s]", firstName, lastName, email, hireDate, jobId);
	}
}