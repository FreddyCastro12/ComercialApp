package com.uniquindio.comercial_app.interfaceService;

import java.util.List;

import com.uniquindio.comercial_app.modelo.Service;

public interface IServiceService {
	public Service addService(Service service);

	public List<Service> listServices();

	public Service editService(Service service);

	public Service deleteService(Integer id);
}
