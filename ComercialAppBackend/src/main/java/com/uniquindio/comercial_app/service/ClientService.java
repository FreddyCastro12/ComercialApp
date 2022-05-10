package com.uniquindio.comercial_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniquindio.comercial_app.interfaceService.IClientService;
import com.uniquindio.comercial_app.interfaces.IClient;
import com.uniquindio.comercial_app.interfaces.IMenu;
import com.uniquindio.comercial_app.modelo.Client;
import com.uniquindio.comercial_app.modelo.Menu;

@Service
public class ClientService implements IClientService{
	
	@Autowired
	private IClient dataClient;
	
	@Autowired
	private IMenu dataMenu;
	
	@Override
	public Client addClient(Client client) {
		return dataClient.save(client);
	}

	@Override
	public List<Client> listClients() {
		return (List<Client>) dataClient.findAll();
	}

	@Override
	public Client editClient(Client client) {
		return dataClient.save(client);
	}

	@Override
	public Client deleteClient(Integer id) {
		Client client = dataClient.findById(id).get();
		if (client!=null) {
			dataClient.delete(client);
		}
		return client;
	}

	@Override
	public Client loginClient(String email, String password) {
		Client client = dataClient.findByEmail(email);
		if (client!=null) {
			String passwordClient = client.getPassword();
			if(passwordClient.equals(password)) {
				return client;
			}else {
				return null;
			}
		}
		return null;
	}

	@Override
	public Client findById(Integer idClient) {
		return dataClient.findById(idClient).get();
	}

	@Override
	public List<Menu> getMenus(Integer id) {
		return dataMenu.getMenus(id);
	}

}
