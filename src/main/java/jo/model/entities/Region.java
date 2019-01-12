package jo.model.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "REGIONS")
public class Region {
	@Id
	@Column(name = "REGION_ID")
	private int id;

	@Column(name = "REGION_NAME")
	private String name;

	@OneToMany(mappedBy="region", cascade = CascadeType.ALL)
	@ElementCollection(targetClass=Country.class)
	private Set<Country> countries;
	
	public Region() {
	}

	public Region(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("id=%d, name=%s", id, name);
	}

	public Set<Country> getCountries() {
		return countries;
	}
}
