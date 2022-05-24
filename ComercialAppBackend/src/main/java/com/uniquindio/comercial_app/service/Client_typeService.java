package com.uniquindio.comercial_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniquindio.comercial_app.interfaceService.IClient_typeService;
import com.uniquindio.comercial_app.interfaces.IClient_type;
import com.uniquindio.comercial_app.modelo.Client_type;

@Service
public class Client_typeService implements IClient_typeService{
	
	@Autowired
	private IClient_type dataClient_type;

	@Override
	public Client_type findById(Integer client_type_id) {
		return dataClient_type.findById(client_type_id).get();
	}

	@Override
	public Client_type addClient_type(Client_type client_type) {
		return dataClient_type.save(client_type);
	}

}
