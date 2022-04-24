package com.uniquindio.comercial_app.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICES")
public class Service {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "SERVICE_ID")
	private Integer id;
	@Column(name = "SERVICE_NAME")
	private String name;
	@Column(name = "SERVICE_COST")
	private Double cost;
	@Column(name = "SERVICE_DESCRIPTION")
	private String description;
	@Column(name = "SERVICE_DATE_START")
	private Date dateStart;
	@Column(name = "SERVICE_DATE_END")
	private Date dateEnd;
	
	public Service(Integer id, String name, Double cost, String description, Date dateStart, Date dateEnd) {
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.description = description;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
	}
	
	public Service() {

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

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
