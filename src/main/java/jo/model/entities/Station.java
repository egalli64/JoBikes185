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

public class Station {

	@Entity
	@Table(name = "STATIONS")
	public class City {
		@Id
		@Column(name = "STATION_ID")
		private Integer stationId;

		@Column(name = "STATION_NAME")
		private String stationName;

		@Column(name = "CITY_ID")
		private Integer cityId;

		public City() {
			super();
		}

		public City(Integer stationId, String stationName, Integer cityId) {
			super();
			this.stationId = stationId;
			this.stationName = stationName;
			this.cityId = cityId;
		}

		public Integer getStationId() {
			return stationId;
		}

		public void setStationId(Integer stationId) {
			this.stationId = stationId;
		}

		public String getStationName() {
			return stationName;
		}

		public void setStationName(String stationName) {
			this.stationName = stationName;
		}

		public Integer getCityId() {
			return cityId;
		}

		public void setCityId(Integer cityId) {
			this.cityId = cityId;
		}
	}
}
