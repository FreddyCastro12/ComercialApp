package com.uniquindio.comercial_app.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uniquindio.comercial_app.modelo.Local;

@Repository
public interface ILocal extends CrudRepository<Local, Integer>{

}

