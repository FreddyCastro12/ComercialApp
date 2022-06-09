package com.uniquindio.comercial_app.interfaceService;

import com.uniquindio.comercial_app.modelo.Client_type;

public interface IClient_typeService {
	public Client_type findById(Integer client_type_id);
	
	public Client_type addClient_type(Client_type client_type);
}
