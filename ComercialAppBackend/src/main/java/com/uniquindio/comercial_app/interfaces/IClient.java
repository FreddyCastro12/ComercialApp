package com.uniquindio.comercial_app.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uniquindio.comercial_app.modelo.Client;

@Repository
public interface IClient extends CrudRepository<Client, Integer>{
	Client findByEmail(String email);
}
