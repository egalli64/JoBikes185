/**
 * (c) 2019 ACME Inc.
 * Entity for the STATIONS Oracle Table
 * 
 * @author Arturo 
 * @author Susanna
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
		private Integer cityId;

		public Station() {
		}

		public Station(Integer id, String name, Integer cityId) {
			this.id = id;
			this.name = name;
			this.cityId = cityId;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getCityId() {
			return cityId;
		}

		public void setCityId(Integer cityId) {
			this.cityId = cityId;
		}

		@Override
		public String toString() {
			return "Station [id=" + id + ", name=" + name + ", cityId=" + cityId + "]";
		}

		
	}

