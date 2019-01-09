/**
 * (c) 2019 ACME Inc.
 * Entity for the CITIES Oracle Table
 * 
 * @author Arturo
 */

package jo.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STATIONS")
public class Stations {
	@Id
	@Column(name = "STATIONS_ID")
	private Integer id;

	@Column(name = "STATIONS_NAME")
	private String name;
	
	@Column(name = "CITY_NAME")
	private String city_name;

public Stations () {
	
}

public Stations (Integer id, String name, String city_name) {

	super();
	this.id = id;
	this.name = name;
	this.city_name = city_name;
	
}

public Integer getId() {
	return id;
}
public String getCity_name() {
	return city_name;
}
public String getName() {
	return name;
}
public void setId(Integer id) {
	this.id = id;
}
public void setName(String name) {
	this.name = name;
}
public void setCity_name(String city_name) {
	this.city_name = city_name;
}


@Override
public String toString() {
	return "Station [id=" + id + ", name=" + name + ", city_name = "+ city_name +"]";
}

}
