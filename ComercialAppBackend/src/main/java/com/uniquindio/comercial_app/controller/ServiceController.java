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

import com.uniquindio.comercial_app.interfaceService.IServiceService;
import com.uniquindio.comercial_app.modelo.Service;

@RestController
@RequestMapping("/service")
@CrossOrigin(origins = "http://localhost:4200")
public class ServiceController {
	@Autowired
	private IServiceService serviceService;

	// Create service
	@PostMapping("/addService")
	public Service addService(@RequestBody Service service) {
		return serviceService.addService(service);
	}

	// List services
	@GetMapping("/listServices")
	public List<Service> listServices() {
		return serviceService.listServices();
	}

	// Edit service
	@PutMapping(path = { "/editService/{idService}" })
	public Service editService(@RequestBody Service service, @PathVariable("idService") Integer idService) {
		return serviceService.editService(service);
	}

	// Delete service
	@DeleteMapping(path = { "/deleteService/{idService}" })
	public Service deleteService(@PathVariable("idService") Integer idService) {
		return serviceService.deleteService(idService);
	}
}
