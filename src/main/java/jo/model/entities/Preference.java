/**
 * (c) 2019 ACME Inc.
 * Preference Entity
 *  @author SuperCoolMegaFicoJavaTeam(SusiAriaPpe)
 */

package jo.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PREFERENCES")
public class Preference {

	@Id
	@Column(name = "NAME")
	private String name;

	@Column(name = "SQL")
	private Integer sql;

	@Column(name = "JAVA")
	private Integer java;

	@Column(name = "HTML")
	private Integer html;

	public Preference() {

	}

	public Preference(String name, Integer sql, Integer java, Integer html) {
		this.name = name;
		this.sql = sql;
		this.java = java;
		this.html = html;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSql() {
		return sql;
	}

	public void setSql(Integer sql) {
		this.sql = sql;
	}

	public Integer getJava() {
		return java;
	}

	public void setJava(Integer java) {
		this.java = java;
	}

	public Integer getHtml() {
		return html;
	}

	public void setHtml(Integer html) {
		this.html = html;
	}

	@Override
	public String toString() {
		return "Preference [name=" + name + ", sql=" + sql + ", java=" + java + ", html=" + html + "]";
	}

}
