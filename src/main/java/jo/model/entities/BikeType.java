package jo.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TYPES")
public class BikeType {
	@Id
	@Column(name = "TYPE_ID")
	private Integer id;

	@Column(name = "TYPE_NAME")
	private String typeName;

	@Column(name = "TYPE_IMAGINE")
	private String typeImg;

	public BikeType() {

	}

	public BikeType(Integer id, String type, String typeImg) {
		super();
		this.id = id;
		this.typeName = type;
		this.typeImg = typeImg;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeImg() {
		return typeImg;
	}

	public void setTypeImg(String typeImg) {
		this.typeImg = typeImg;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "BikeType [id=" + id + ", typeName=" + typeName + ", typeImg=" + typeImg + "]";
	}
 
}
