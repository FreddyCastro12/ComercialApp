package com.uniquindio.comercial_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniquindio.comercial_app.interfaceService.ILocalService;
import com.uniquindio.comercial_app.interfaces.ILocal;
import com.uniquindio.comercial_app.modelo.Local;

@Service
public class LocalService implements ILocalService{
	
	@Autowired
	private ILocal dataLocal;

	@Override
	public Local addLocal(Local local) {
		return dataLocal.save(local);
	}

	@Override
	public List<Local> listLocal() {
		return (List<Local>) dataLocal.findAll();
	}

	@Override
	public Local editLocal(Local local) {
		return dataLocal.save(local);
	}

	@Override
	public Local deleteLocal(Integer id) {
		Local local = dataLocal.findById(id).get();
		if (local!=null) {
			dataLocal.delete(local);
		}
		return local;
	}

	@Override
	public Local getLocal(Integer idLocal) {
		return dataLocal.findById(idLocal).get();
	}

}
