package com.uniquindio.comercial_app.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT_TYPE")
public class Client_type {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "CLIENT_TYPE_ID")
	private Integer id;
	
	@Column(name = "CLIENT_TYPE_NAME")
	private String name;
	
	@ManyToMany
	private List<Menu> menus;

	public Client_type(Integer id, List<Menu> menus) {
		super();
		this.id = id;
		this.menus = menus;
	}
	
	public Client_type() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
}
