package jo.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name = "USERS")
	public class Bicycle {
		@Id
		@Column(name = "BICYCLE_ID")
		private Integer id;
		
		@Column(name = "TARGET")
		private String target;
		
		@Column(name = "TYPE_ID")
		private Integer typeId;
		
		@Column(name = "BRAND")
		private String brand;
		
		@Column(name = "MODEL")
		private String model;
		
		@Column(name = "PRICE")
		private Double price;
		
		@Column(name = "STOCK")
		private Integer stock;

		public Bicycle(Integer id, String target, Integer typeId, String brand, String model, Double price,
				Integer stock) {
			super();
			this.id = id;
			this.target = target;
			this.typeId = typeId;
			this.brand = brand;
			this.model = model;
			this.price = price;
			this.stock = stock;
		}

		public Bicycle() {
			super();
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getTarget() {
			return target;
		}

		public void setTarget(String target) {
			this.target = target;
		}

		public Integer getTypeId() {
			return typeId;
		}

		public void setTypeId(Integer typeId) {
			this.typeId = typeId;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public Integer getStock() {
			return stock;
		}

		public void setStock(Integer stock) {
			this.stock = stock;
		}

		@Override
		public String toString() {
			return "Bicycle [id=" + id + ", target=" + target + ", typeId=" + typeId + ", brand=" + brand + ", model="
					+ model + ", price=" + price + ", stock=" + stock + "]";
		}
}