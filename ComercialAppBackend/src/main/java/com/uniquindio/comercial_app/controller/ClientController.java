package com.uniquindio.comercial_app.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import com.uniquindio.comercial_app.interfaceService.IShoppingCartService;
import com.uniquindio.comercial_app.modelo.Client;
import com.uniquindio.comercial_app.modelo.Client_type;
import com.uniquindio.comercial_app.modelo.Menu;
import com.uniquindio.comercial_app.modelo.ShoppingCart;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ClientController {

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	@Autowired
	private IClientService serviceClient;

	@Autowired
	private IShoppingCartService serviceCarts;

	// Create client
	@PostMapping("/addClient")
	public Client addClient(@RequestBody Client client) {
		if (validateClient(client)) {
			if (validateEmail(client.getEmail())) {
				client.setAmount(0.0);
				Client_type client_type = new Client_type();
				client_type.setId(2);
				client.setClient_type_id(client_type);
				return serviceClient.addClient(client);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	// List clients
	@GetMapping("/listClients")
	public List<Client> listClients() {
		return serviceClient.listClients();
	}

	// Get Client by id
	@GetMapping("/getClient/{idClient}")
	public Client getClient(@PathVariable("idClient") Integer idClient) {
		return serviceClient.findById(idClient);
	}

	// Edit client
	@PutMapping(path = { "/editClient" })
	public Client editClient(@RequestBody Client client) {
		if (validateClient(client)) {
			if (validateEmail(client.getEmail())) {
				return serviceClient.editClient(client);
			} else {
				return null;
			}
		} else {
			return null;
		}
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

	// List menus
	@GetMapping("/getMenus/{idClient}")
	public List<Menu> getMenus(@PathVariable("idClient") Integer idClient) {
		return serviceClient.getMenus(idClient);
	}

	// Buy Shopping carts
	@PostMapping("/buyCart/{idClient}")
	public Client buyCart(@PathVariable("idClient") String idClient, @RequestBody ShoppingCart shoppingCart) {
		Client client = new Client();
		boolean centiinel = false;
		try {
			client = serviceClient.findById(Integer.parseInt(idClient));
			for (int i = 0; i <= client.getShoppingCarts().size() - 1 && centiinel == false; i++) {
				if (client.getShoppingCarts().get(i).getId() == shoppingCart.getId()) {
					client.getShoppingCarts().set(i, shoppingCart);
					centiinel = true;
				}
			}
			if (centiinel == false) {
				client.getShoppingCarts().add(shoppingCart);
			}
			client.setAmount(client.getAmount() - shoppingCart.getCost());
			shoppingCart.setState("Pagado");
			serviceCarts.addShoppingCart(shoppingCart);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("El cliente no cuenta con los recursos necesarios para finalizar la compra");
		}
		return serviceClient.addClient(client);
	}

	public boolean validateClient(Client client) {
		if (client.getAddress() == "" || client.getAmount() < 0 || client.getCellPhoneNumber() == ""
				|| client.getEmail() == "" || client.getName() == ""
				|| client.getPassword() == "" || client.getUser() == "") {
			return false;
		}
		return true;
	}

	public static boolean validateEmail(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}
}
