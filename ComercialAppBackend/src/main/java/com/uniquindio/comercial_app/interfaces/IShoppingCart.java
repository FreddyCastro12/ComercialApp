package com.uniquindio.comercial_app.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uniquindio.comercial_app.modelo.Client;
import com.uniquindio.comercial_app.modelo.ShoppingCart;

@Repository
public interface IShoppingCart extends CrudRepository<ShoppingCart, Integer>{

}
