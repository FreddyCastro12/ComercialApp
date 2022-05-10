package com.uniquindio.comercial_app.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MENU")
public class Menu {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "MENU_ID")
	private Integer id;
	
	@Column(name = "PATH")
	private String path;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "ICON")
	private String icon;
	
	@Column(name = "CLASS")
	private String clase;

	public Menu(Integer id, String path, String title, String icon, String clase) {
		super();
		this.id = id;
		this.path = path;
		this.title = title;
		this.icon = icon;
		this.clase = clase;
	}
	
	public Menu() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}
}
