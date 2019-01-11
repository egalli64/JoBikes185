/*
 * (c) 2019 ACME Inc.
 * Entity for the CITIES Oracle Table
 * 
 * @author Alessio
 */

package jo.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BIKE_USERS")
public class BikeUser {
	@Id
	@Column(name = "BU_ID")
	private Integer id;

	@Column(name = "FIRSTNAME")
	private String firstName;
	
	@Column(name = "LASTNAME")
	private String lastName;

	public BikeUser() {

	}

	public BikeUser(Integer id, String firstName, String lastName) {
		this.id = id;
		this.firstName=firstName;
		this.lastName=lastName;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "BikeUser [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}



}
