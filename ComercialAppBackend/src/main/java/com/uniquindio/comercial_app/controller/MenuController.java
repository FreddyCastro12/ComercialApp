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

import com.uniquindio.comercial_app.interfaceService.IClient_typeService;
import com.uniquindio.comercial_app.interfaceService.IMenuService;
import com.uniquindio.comercial_app.modelo.Client_type;
import com.uniquindio.comercial_app.modelo.Menu;

@RestController
@RequestMapping("/menu")
@CrossOrigin
public class MenuController {
	@Autowired
	private IMenuService serviceMenu;
	
	@Autowired
	private IClient_typeService serviceClient_type;
	
	// Create menu
	@PostMapping("/addMenu/{client}/{admin}")
	public Menu addMenu(@RequestBody Menu menu, @PathVariable("client") Integer client, @PathVariable("admin") Integer admin) {
		Menu m = serviceMenu.addMenu(menu);
		if(client == 2) {
			Client_type client_type = serviceClient_type.findById(client);
			List<Menu> listMenus = client_type.getMenus();
			
			if(!listMenus.contains(m)) {
				listMenus.add(m);
				client_type.setMenus(listMenus);
				serviceClient_type.addClient_type(client_type);
			}
		}
		
		if (admin == 1) {
			Client_type client_type = serviceClient_type.findById(admin);
			List<Menu> listMenus = client_type.getMenus();
			
			if(!listMenus.contains(m)) {
				listMenus.add(m);
				client_type.setMenus(listMenus);
				serviceClient_type.addClient_type(client_type);
			}
		}
		return m;
	}

	// List menus
	@GetMapping("/listMenus")
	public List<Menu> listMenu() {
		return serviceMenu.listMenu();
	}
	
	// List menus
	@GetMapping("/listClientTypeMenus/{idMenu}")
	public List<Integer> listClientTypeMenus(@PathVariable("idMenu") Integer idMenu) {
		return serviceMenu.listClientTypeMenus(idMenu);
	}

	// Edit menu
	@PutMapping(path = { "/editMenu/{client}/{admin}"})
	public Menu editMenu(@RequestBody Menu menu, @PathVariable("client") Integer client, @PathVariable("admin") Integer admin) {
		Menu m = serviceMenu.editMenu(menu);
		
		if(client == 0) {
			Client_type client_type = serviceClient_type.findById(2);
			List<Menu> listMenus = client_type.getMenus();
			
			if(listMenus.contains(m)) {
				listMenus.remove(m);
				client_type.setMenus(listMenus);
				serviceClient_type.addClient_type(client_type);
			}
		}else {
			Client_type client_type = serviceClient_type.findById(client);
			List<Menu> listMenus = client_type.getMenus();
			
			if(!listMenus.contains(m)) {
				listMenus.add(m);
				client_type.setMenus(listMenus);
				serviceClient_type.addClient_type(client_type);
			}
		}
		
		if(admin == 0) {
			Client_type client_type = serviceClient_type.findById(1);
			List<Menu> listMenus = client_type.getMenus();
			
			if(listMenus.contains(m)) {
				listMenus.remove(m);
				client_type.setMenus(listMenus);
				serviceClient_type.addClient_type(client_type);
			}
		}else {
			Client_type client_type = serviceClient_type.findById(admin);
			List<Menu> listMenus = client_type.getMenus();
			
			if(!listMenus.contains(m)) {
				listMenus.add(m);
				client_type.setMenus(listMenus);
				serviceClient_type.addClient_type(client_type);
			}
		}
		
		return m;
	}

	// Delete menu
	@DeleteMapping(path = { "/deleteMenu/{idMenu}" })
	public Menu deleteMenu(@PathVariable("idMenu") Integer idMenu) {
		return serviceMenu.deleteMenu(idMenu);
	}
}
