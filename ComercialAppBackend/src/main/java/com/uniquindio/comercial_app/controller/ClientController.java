package com.uniquindio.comercial_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniquindio.comercial_app.interfaceService.IClientService;
import com.uniquindio.comercial_app.modelo.Client;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ClientController {

	@Autowired
	private IClientService serviceClient;

	// Create client
	@PostMapping("/addClient")
	public Client addClient(@RequestBody Client client) {
		client.setAmount(0.0);
		return serviceClient.addClient(client);
	}

	// List clients
	@GetMapping("/listClients")
	public List<Client> listClients() {
		return serviceClient.listClients();
	}

	// Edit client
	@PutMapping(path = { "/editClient" })
	public Client editClient(@RequestBody Client client) {
		return serviceClient.editClient(client);
	}

	// Delete client
	@DeleteMapping(path = { "/deleteClient/{idClient}" })
	public Client deleteClient(@PathVariable("idClient") Integer idClient) {
		return serviceClient.deleteClient(idClient);
	}

	// login client
	@GetMapping(path = { "/loginClient/{email}/{password}" })
	public Client loginClient(@PathVariable("email") String email, @PathVariable("password") String password) {
		return serviceClient.loginClient(email, password);
	}

}
