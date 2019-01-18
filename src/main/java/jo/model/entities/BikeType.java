package jo.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TYPES")
public class BikeType {
	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "TYPE_IMAGINE")
	private String pic;

	public BikeType() {

	}

	public BikeType(Integer id, String type, String pic) {
		super();
		this.id = id;
		this.type = type;
		this.pic = pic;
	}

	public Integer getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@Override
	public String toString() {
		return "BikeType [id=" + id + ", type=" + type + ", pic=" + pic + "]";
	}
}
