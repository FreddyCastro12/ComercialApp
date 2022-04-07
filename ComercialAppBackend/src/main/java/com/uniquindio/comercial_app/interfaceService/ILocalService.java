package com.uniquindio.comercial_app.interfaceService;

import java.util.List;

import com.uniquindio.comercial_app.modelo.Local;

public interface ILocalService {
	public Local addLocal(Local local);

	public List<Local> listLocal();

	public Local editLocal(Local local);

	public Local deleteLocal(Integer id);
}
