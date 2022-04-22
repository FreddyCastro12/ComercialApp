package com.uniquindio.comercial_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uniquindio.comercial_app.interfaceService.IServiceService;
import com.uniquindio.comercial_app.interfaces.IService;
import com.uniquindio.comercial_app.modelo.Service;

public class ServiceService implements IServiceService{
	
	@Autowired
	private IService dataService;

	@Override
	public Service addService(Service service) {
		return dataService.save(service);
	}

	@Override
	public List<Service> listServices() {
		return (List<Service>) dataService.findAll();
	}

	@Override
	public Service editService(Service service) {
		return dataService.save(service);
	}

	@Override
	public Service deleteService(Integer id) {
		Service service = dataService.findById(id).get();
		if (service!=null) {
			dataService.delete(service);
		}
		return service;
	}

}
