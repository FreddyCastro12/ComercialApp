package com.uniquindio.comercial_app;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uniquindio.comercial_app.controller.ClientController;
import com.uniquindio.comercial_app.controller.LocalController;
import com.uniquindio.comercial_app.controller.ProductController;
import com.uniquindio.comercial_app.controller.ServiceController;
import com.uniquindio.comercial_app.interfaces.IClient;
import com.uniquindio.comercial_app.interfaces.ILocal;
import com.uniquindio.comercial_app.interfaces.IProduct;
import com.uniquindio.comercial_app.interfaces.IService;
import com.uniquindio.comercial_app.modelo.Client;
import com.uniquindio.comercial_app.modelo.Local;
import com.uniquindio.comercial_app.modelo.Product;
import com.uniquindio.comercial_app.modelo.Service;
import com.uniquindio.comercial_app.service.ClientService;
import com.uniquindio.comercial_app.service.LocalService;
import com.uniquindio.comercial_app.service.ProductService;
import com.uniquindio.comercial_app.service.ServiceService;

//@RunWith(MockitoJUnitRunner.class)
class Testing {
	@Mock
	private LocalService localService;

	@Mock
	private ILocal localRepository;

	@Mock
	private ProductService productService;

	@Mock
	private IProduct productRepository;

	@Mock
	private ClientService clientService;

	@Mock
	private IClient clientRepository;

	@Mock
	private ServiceService serviceService;

	@Mock
	private IService serviceRepository;

	@InjectMocks
	private LocalController localController;

	@InjectMocks
	private ProductController productController;

	@InjectMocks
	private ClientController clientController;

	@InjectMocks
	private ServiceController serviceController;

	ObjectMapper objectMapper;

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private Local local;
	
	@Mock
	private Product product;
	
	@Mock
	private Client client;
	
	@Mock
	private Service service;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		local = new Local();
		local.setId(10);
		local.setName("local testing");
		local.setSite("Sin confirmar");
		local.setStatus(0);
		local.setDateStart(new Date());
		local.setDateEnd(new Date());

		product = new Product();
		product.setAmount(100);
		product.setCost(10000.0);
		product.setDescription("Producto prueba unitaria");
		product.setId(12);
		product.setImagen("Ruta imagen");
		product.setLocal(local);
		product.setName("Producto prueba");

		client = new Client();
		client.setAddress("Direccion");
		client.setAmount(1000000.0);
		client.setCellPhoneNumber("3158742658");
		client.setEmail("correo@gmail.com");
		client.setId(5);
		client.setName("Nombre");
		client.setPassword("contraseña123");
		client.setUser("Usuario");

		service = new Service();
		service.setCost(1500.0);
		service.setDateEnd(new Date());
		service.setDateStart(new Date());
		service.setDescription("Descripcion servicio prueba");
		service.setId(8);
		service.setName("Servicio pruebas");

		objectMapper = new ObjectMapper();
	}

	// Pruebas Unitarias Locales

	@Test
	public void createLocal() {
		System.out.println(local.toString());
		when(localController.addLocal(local)).thenReturn(local);
		assertNotNull(localController.addLocal(local));
	}

	@Test
	public void updateLocal() {

		when(localController.getLocal(10)).thenReturn(local);
		Local l = localController.getLocal(10);
		assertNotNull(l);
		if (l != null) {
			System.out.println("Local antes: " + local.toString());
			l.setName("Pruebas unitarias");
			l.setSite("407");
			when(localController.editLocal(l, l.getId())).thenReturn(l);
			assertNotNull(localController.editLocal(l, l.getId()));
			System.out.println("Local despues: " + l.toString());
		}

	}

	@Test
	public void deleteLocal() {
		try {
			when(localController.deleteLocal(local.getId())).thenReturn(local);
			assertNotNull(localController.deleteLocal(local.getId()));
			System.out.println("Local eliminado");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Pruebas Unitarias Producto

	@Test
	public void createProduct() {
		System.out.println(product.toString());
		when(productController.addProduct(product)).thenReturn(product);
		assertNotNull(productController.addProduct(product));
	}

	@Test
	public void updateProduct() {
		System.out.println("Producto antes: " + product.toString());
		product.setName("Prueba");
		product.setCost(4000.0);
		when(productController.editProduct(product)).thenReturn(product);
		assertNotNull(productController.editProduct(product));
		System.out.println("Producto despues: " + product.toString());
	}

	@Test
	public void deleteProduct() {
		when(productController.deleteProduct(product.getId())).thenReturn(product);
		assertNotNull(productController.deleteProduct(product.getId()));
		System.out.println("Producto eliminado");
	}

	// Pruebas Unitarias Cliente

	@Test
	public void createClient() {
		System.out.println(client.toString());
		when(clientController.addClient(client)).thenReturn(client);
		assertNotNull(clientController.addClient(client));
	}

	@Test
	public void updateClient() {
		System.out.println("Cliente antes: " + client.toString());
		client.setName("Pruebas unitarias");
		client.setAmount(4000.0);
		when(clientController.editClient(client)).thenReturn(client);
		assertNotNull(clientController.editClient(client));
		System.out.println("Cliente despues: " + client.toString());
	}

	@Test
	public void deleteClient() {
		when(clientController.deleteClient(client.getId())).thenReturn(client);
		assertNotNull(clientController.deleteClient(client.getId()));
		System.out.println("Cliente eliminado");
	}

	// Pruebas Unitarias Servicios

	@Test
	public void createService() {
		System.out.println(service.toString());
		when(serviceController.addService(service)).thenReturn(service);
		assertNotNull(serviceController.addService(service));
	}

	@Test
	public void updateService() {
		System.out.println("Servicio antes: " + service.toString());
		service.setName("Pruebas unitarias");
		service.setCost(4000.0);
		when(serviceController.editService(service, service.getId())).thenReturn(service);
		assertNotNull(serviceController.editService(service, service.getId()));
		System.out.println("Servicio despues: " + service.toString());
	}

	@Test
	public void deleteService() {
		when(serviceController.deleteService(service.getId())).thenReturn(service);
		assertNotNull(serviceController.deleteService(service.getId()));
		System.out.println("Servicio eliminado");
	}
}
