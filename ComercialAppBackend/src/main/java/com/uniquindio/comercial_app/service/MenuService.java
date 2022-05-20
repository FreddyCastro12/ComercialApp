package com.uniquindio.comercial_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniquindio.comercial_app.interfaceService.IMenuService;
import com.uniquindio.comercial_app.interfaces.IMenu;
import com.uniquindio.comercial_app.modelo.Menu;

@Service
public class MenuService implements IMenuService{
	@Autowired
	private IMenu dataMenu;
	
	@Override
	public Menu addMenu(Menu menu) {
		return dataMenu.save(menu);
	}

	@Override
	public List<Menu> listMenu() {
		return (List<Menu>) dataMenu.findAll();
	}

	@Override
	public Menu editMenu(Menu menu) {
		return dataMenu.save(menu);
	}

	@Override
	public Menu deleteMenu(Integer id) {
		Menu menu = dataMenu.findById(id).get();
		if (menu!=null) {
			dataMenu.delete(menu);
		}
		return menu;
	}

}
