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
		private String tar;
		
		@Column(name = "TYPE_ID")
		private Integer tId;
		
		@Column(name = "BRAND")
		private String bra;
		
		@Column(name = "MODEL")
		private String mod;
		
		@Column(name = "PRICE")
		private Double pri;
		
		@Column(name = "STOCK")
		private Integer sto;

		public Bicycle(Integer id, String tar, Integer tId, String bra, String mod, Double pri, Integer sto) {
			super();
			this.id = id;
			this.tar = tar;
			this.tId = tId;
			this.bra = bra;
			this.mod = mod;
			this.pri = pri;
			this.sto = sto;
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

		public String getTar() {
			return tar;
		}

		public void setTar(String tar) {
			this.tar = tar;
		}

		public Integer gettId() {
			return tId;
		}

		public void settId(Integer tId) {
			this.tId = tId;
		}

		public String getBra() {
			return bra;
		}

		public void setBra(String bra) {
			this.bra = bra;
		}

		public String getMod() {
			return mod;
		}

		public void setMod(String mod) {
			this.mod = mod;
		}

		public Double getPri() {
			return pri;
		}

		public void setPri(Double pri) {
			this.pri = pri;
		}

		public Integer getSto() {
			return sto;
		}

		public void setSto(Integer sto) {
			this.sto = sto;
		}

		@Override
		public String toString() {
			return "Bicycle [id=" + id + ", tar=" + tar + ", tId=" + tId + ", bra=" + bra + ", mod=" + mod + ", pri="
					+ pri + ", sto=" + sto + "]";
		}
}