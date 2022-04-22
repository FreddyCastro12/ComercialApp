package com.uniquindio.comercial_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	
	@GetMapping("/prueba")
	public String prueba() {
		System.out.println("entra");
		return "entra";
	}
}
