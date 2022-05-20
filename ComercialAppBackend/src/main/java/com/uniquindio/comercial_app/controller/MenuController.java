package com.uniquindio.comercial_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniquindio.comercial_app.interfaceService.IMenuService;
import com.uniquindio.comercial_app.modelo.Menu;

@RestController
@RequestMapping("/menu")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class MenuController {
	@Autowired
	private IMenuService serviceMenu;
	
	// Create menu
	@PostMapping("/addMenu")
	public Menu addMenu(@RequestBody Menu menu) {
		return serviceMenu.addMenu(menu);
	}

	// List menus
	@GetMapping("/listMenus")
	public List<Menu> listMenu() {
		return serviceMenu.listMenu();
	}

	// Edit menu
	@PutMapping(path = { "/editMenu" })
	public Menu editMenu(@RequestBody Menu menu) {
		return serviceMenu.editMenu(menu);
	}

	// Delete menu
	@DeleteMapping(path = { "/deleteMenu/{idMenu}" })
	public Menu deleteMenu(@PathVariable("idMenu") Integer idMenu) {
		return serviceMenu.deleteMenu(idMenu);
	}
}
