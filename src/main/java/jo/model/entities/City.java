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
@Table(name = "CITIES")
public class City {
	@Id
	@Column(name = "CITY_ID")
	private Integer id;

	@Column(name = "CITY_NAME")
	private String name;

	public City() {

	}

	public City(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

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

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + "]";
	}

}
