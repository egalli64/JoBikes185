/**
 * (c) 2019 ACME Inc.
 * Entity for the STATIONS Oracle Table
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
public class Station {
	@Id
	@Column(name = "STATION_ID")
	private Integer id;

	@Column(name = "STATION_NAME")
	private String name;

	@Column(name = "CITY_ID")
	private String cityId;

	public Station() {

	}

	public Station(Integer id, String name, String cityId) {

		super();
		this.id = id;
		this.name = name;
		this.cityId = cityId;

	}

	public Integer getId() {
		return id;
	}

	public String getCity_name() {
		return cityId;
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

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	@Override
	public String toString() {
		return "Station [id=" + id + ", name=" + name + ", cityId = " + cityId + "]";
	}

}
