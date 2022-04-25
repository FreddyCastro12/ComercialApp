package com.uniquindio.comercial_app.interfaceService;

import java.util.List;

import com.uniquindio.comercial_app.modelo.Client;

public interface IClientService {
	
	public Client addClient(Client client);

	public List<Client> listClients();

	public Client editClient(Client client);

	public Client deleteClient(Integer id);
	
	public Client loginClient(String email, String password);

	public Client findById(Integer idClient);
}
