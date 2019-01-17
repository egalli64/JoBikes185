package jo.model.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ORGS")
public class Org {
	@Id
	@Column(name = "ORG_ID")
	private Integer id;

	@Column(name = "ORG_NAME")
	private String name;

	@ManyToMany
	@JoinTable(name = "ORG_COUNTRY", //
			joinColumns = @JoinColumn(name = "ORG_ID"), //
			inverseJoinColumns = @JoinColumn(name = "COUNTRY_ID"))
	Set<Country> countries;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<Country> getCountries() {
		return countries;
	}

	@Override
	public String toString() {
		return "Org [id=" + id + ", name=" + name + ", countries=" + countries + "]";
	}
}
