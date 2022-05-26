package com.uniquindio.comercial_app;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.uniquindio.comercial_app.controller.LocalController;
import com.uniquindio.comercial_app.interfaceService.IClientService;
import com.uniquindio.comercial_app.interfaces.ILocal;
import com.uniquindio.comercial_app.modelo.Local;
import com.uniquindio.comercial_app.service.LocalService;

@RunWith(MockitoJUnitRunner.class)
class Testing {

	@Mock
	private LocalService localService;

	@Mock
	private ILocal localRepository;

	@InjectMocks
	private LocalController localController;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

//	@Autowired
//	private BCryptPasswordEncoder encoder;

	@Test
	public void createLocal() {
		try {
			Local local = new Local();
			local.setId(10);
			local.setName("local testing");
			local.setSite("Sin confirmar");
			local.setStatus(0);
			local.setDateStart(new Date());
			local.setDateEnd(new Date());
			System.out.println(local.toString());
			when(localController.addLocal(local)).thenReturn(local);
			assertNotNull(localController.addLocal(local));
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
