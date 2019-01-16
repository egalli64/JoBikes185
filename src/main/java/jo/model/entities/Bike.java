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
	private Integer id;
	
	@Column(name = "CITY_ID")
	private Integer cityId;
	
	@Column(name = "STATION_ID")
	private Integer stationId;
	
	@Column(name = "BU_ID")
	private Integer bikeUserId;

	@Column(name = "TYPE")
	private String  type;
	
	public Bike() {

	}

	public Bike(Integer id, Integer cityId, Integer stationId, Integer bikeUserId, String type) {
		super();
		this.id = id;
		this.cityId = cityId;
		this.stationId = stationId;
		this.bikeUserId = bikeUserId;
		this.type = type;
	}

	public Bike(Integer id, Integer cityId, Integer stationId, String type) {
		super();
		this.id = id;
		this.cityId = cityId;
		this.stationId = stationId;
		this.type = type;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getStationId() {
		return stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	public Integer getBikeUserId() {
		return bikeUserId;
	}

	public void setBikeUserId(Integer bikeUserId) {
		this.bikeUserId = bikeUserId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Bike [id=" + id + ", cityId=" + cityId + ", stationId=" + stationId + ", bikeUserId=" + bikeUserId
				+ ", type=" + type + "]";
	}
	
}