package com.uniquindio.comercial_app.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uniquindio.comercial_app.modelo.Client_type;

@Repository
public interface IClient_type extends CrudRepository<Client_type, Integer>{
	
	@Query(value = "INSERT INTO client_type_menus(client_type_client_type_id, menus_menu_id) VALUES(:client_type_id, :idMenu)", nativeQuery = true)
	void saveMenu(@Param(value = "client_type_id") Integer client_type_id, @Param(value = "idMenu") Integer idMenu);
}
