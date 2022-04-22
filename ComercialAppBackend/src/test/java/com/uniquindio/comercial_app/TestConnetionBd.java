package com.uniquindio.comercial_app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.uniquindio.comercial_app.interfaceService.IClientService;
import com.uniquindio.comercial_app.modelo.Client;

class TestConnetionBd {

	@Autowired
	private IClientService dataClient;
	
//	@Autowired
//	private BCryptPasswordEncoder encoder;

	@Test
	public void createUser() {
	
		Client client = new Client();
		client.setPassword("admin");
		client.setUser("admin");
		client.setAmount(new Double(500));
		client.setName("cliente1");
		client.setAddress("uniquindio");
		client.setCellPhoneNumber("3134566884");
		client.setEmail("correo@gmail.com");
		client.setId(1);
		Client clientReturn = dataClient.addClient(client);
		assertTrue(clientReturn.getPassword().equalsIgnoreCase(client.getPassword()));
	}
}
