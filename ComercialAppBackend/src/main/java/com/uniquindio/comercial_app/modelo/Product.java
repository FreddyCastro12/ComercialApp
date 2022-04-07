package com.uniquindio.comercial_app.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTS")
public class Product {
	
	@Id
	@Column(name = "PRODUCT_ID")
	private Integer id;
	@Column(name = "PRODUCT_NAME")
	private String name;
	@Column(name = "PRODUCT_COST")
	private Double cost;
	@Column(name = "PRODUCT_DESCRIPTION")
	private String description;
	@Column(name = "PRODUCT_IMAGE")
	private String imagen;
	
	public Product() {

	}

	public Product(Integer id, String name, Double cost, String description, String imagen) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.description = description;
		this.imagen = imagen;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
}
