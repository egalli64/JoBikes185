package jo.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
	
	@Entity
	@Table(name = "USERS")
	public class User {
		@Id
		@Column(name = "USER_ID")
		private Integer id;
		
		@Column(name = "USER_NAME")
		private String usr;
		
		@Column(name = "USER_PASSWORD")
		private String pwd;
		
		@Column(name = "USER_ROLE")
		private String rol;

		public User(Integer id, String usr, String pwd, String rol) {
			super();
			this.id = id;
			this.usr = usr;
			this.pwd = pwd;
			this.rol = rol;
		}

		public User() {
			super();
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getUsr() {
			return usr;
		}

		public void setUsr(String usr) {
			this.usr = usr;
		}

		public String getPwd() {
			return pwd;
		}

		public void setPwd(String pwd) {
			this.pwd = pwd;
		}

		public String getRol() {
			return rol;
		}

		public void setRol(String rol) {
			this.rol = rol;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", usr=" + usr + ", pwd=" + pwd + ", rol=" + rol + "]";
		}
	}