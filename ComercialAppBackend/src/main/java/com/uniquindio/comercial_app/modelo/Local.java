package com.uniquindio.comercial_app.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "local")
public class Local {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "local_id")
	private Integer id;
	@Column(name = "local_name")
	private String name;
	@Column(name = "local_site")
	private String site;
	@Column(name = "local_status")
	private Integer status;
	@Column(name = "local_date_start")
	private Date dateStart;
	@Column(name = "local_date_end")
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