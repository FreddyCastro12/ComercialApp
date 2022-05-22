package com.uniquindio.comercial_app.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTS")
public class Product {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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
	
	@Column(name = "PRODUCT_AMOUNT")
	private Integer amount;
	
	public Product() {

	}

	public Product(Integer id, String name, Double cost, String description, String imagen, Integer amount) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.description = description;
		this.imagen = imagen;
		this.amount = amount;
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

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", cost=" + cost + ", description=" + description + ", imagen="
				+ imagen + ", amount=" + amount + "]";
	}
	
}
