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
@CrossOrigin
public class ServiceController {
	@Autowired
	private IServiceService serviceService;

	// Create service
	@PostMapping("/addService")
	public Service addService(@RequestBody Service service) {
		if (validateService(service)) {
			return serviceService.addService(service);
		} else {
			return null;
		}
	}

	// List services
	@GetMapping("/listServices")
	public List<Service> listServices() {
		return serviceService.listServices();
	}

	// Edit service
	@PutMapping(path = { "/editService/{idService}" })
	public Service editService(@RequestBody Service service, @PathVariable("idService") Integer idService) {
		if (validateService(service)) {
			return serviceService.editService(service);
		} else {
			return null;
		}
	}

	// Delete service
	@DeleteMapping(path = { "/deleteService/{idService}" })
	public Service deleteService(@PathVariable("idService") Integer idService) {
		return serviceService.deleteService(idService);
	}

	public boolean validateService(Service service) {
		if (service.getCost() < 0 || service.getDateStart() == null || service.getDescription() == ""
				|| service.getName() == "") {
			return false;
		}
		return true;
	}
}
