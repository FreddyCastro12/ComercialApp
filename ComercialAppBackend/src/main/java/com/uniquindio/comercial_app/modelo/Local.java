package com.uniquindio.comercial_app.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOCAL")
public class Local {
	@Id
	@Column(name = "LOCAL_ID")
	private Integer id;
	@Column(name = "LOCAL_NAME")
	private String name;
	@Column(name = "LOCAL_SITE")
	private String site;
	@Column(name = "LOCAL_STATUS")
	private Integer status;
	@Column(name = "LOCAL_DATE_START")
	private Date dateStart;
	@Column(name = "LOCAL_DATE_END")
	private Date dateEnd;
	
	public Local(Integer id, String name, String site, Integer status, Date dateStart, Date dateEnd) {
		this.id = id;
		this.name = name;
		this.site = site;
		this.status = status;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
	}
	
	public Local() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
}