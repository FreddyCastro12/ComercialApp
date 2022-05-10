package com.uniquindio.comercial_app.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uniquindio.comercial_app.modelo.Menu;

public interface IMenu extends CrudRepository<Menu, Integer> {
	@Query(value = "SELECT M.* "
			+ "FROM client C "
			+ "JOIN client_type CT ON CT.client_type_id = C.client_type_id "
			+ "JOIN client_type_menus CTM ON CTM.client_type_client_type_id = CT.client_type_id "
			+ "JOIN menu M ON M.menu_id = CTM.menus_menu_id "
			+ "WHERE C.client_id = :id", nativeQuery = true)
	List<Menu> getMenus(@Param(value = "id") Integer id);
}
