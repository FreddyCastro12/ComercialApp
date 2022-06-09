package com.uniquindio.comercial_app.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SHOPPING_CARTS")
public class ShoppingCart {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "SHOPPING_CART_ID")
	private Integer id;
	@ManyToMany
	private List<Product> products;
	@OneToMany
	private List<Service> services;
	@Column(name = "SHOPPING_CART_COST")
	private Double cost;
	@Column(name = "SHOPPING_CART_STATE")
	private String state;
	
	public ShoppingCart(Integer id, List<Product> products, List<Service> services, Double cost, String state) {
		this.id = id;
		this.products = products;
		this.services = services;
		this.cost = cost;
		this.state = state;
	}
	
	public ShoppingCart() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", products=" + products + ", services=" + services + ", cost=" + cost
				+ ", state=" + state + "]";
	}
}
