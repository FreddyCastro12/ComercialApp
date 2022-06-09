package com.uniquindio.comercial_app.interfaceService;

import java.util.List;

import com.uniquindio.comercial_app.modelo.Menu;

public interface IMenuService {
	public Menu addMenu(Menu menu);

	public List<Menu> listMenu();

	public Menu editMenu(Menu menu);

	public Menu deleteMenu(Integer id);

	public List<Integer> listClientTypeMenus(Integer idMenu);
}
