package jo.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRIES")
public class Country {
	@Id
	@Column(name = "COUNTRY_ID")
	private String id;

	@Column(name = "COUNTRY_NAME")
	private String name;

	@Column(name = "REGION_ID")
	private Integer regId;

	public Country() {
	}

	public Country(String id, String name, Integer regId) {
		this.id = id;
		this.name = name;
		this.regId = regId;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getRegId() {
		return regId;
	}

	@Override
	public String toString() {
		return String.format("id=%s, name=%s, region=%d", id, name, regId);
	}
}
