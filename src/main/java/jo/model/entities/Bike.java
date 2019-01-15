/*
 * (c) 2019 ACME Inc.
 * Entity for the BIKES Oracle Table
 * 
 * @author Federico
 */

package jo.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BIKES")
public class Bike {
	@Id
	@Column(name = "BIKE_ID")
	private String id;

	@Column(name = "BIKEUSER_ID")
	private Integer bikeUserId;
	
	@Column(name = "STATION_ID")
	private Integer stationId;
	
	@Column(name = "CITY_ID")
	private Integer cityId;

	
	public Bike() {

	}

	public Bike(String id, Integer bikeUserId, Integer stationId, Integer cityId) {
		super();
		this.id = id;
		this.bikeUserId = bikeUserId;
		this.stationId = stationId;
		this.cityId = cityId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getBikeUserId() {
		return bikeUserId;
	}

	public void setBikeUserId(Integer bikeUserId) {
		this.bikeUserId = bikeUserId;
	}

	public Integer getStationId() {
		return stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	@Override
	public String toString() {
		return "Bike [id=" + id + ", bikeUserId=" + bikeUserId + ", stationId=" + stationId + ", cityId=" + cityId
				+ "]";
	}
	
}