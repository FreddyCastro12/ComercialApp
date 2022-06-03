package com.uniquindio.comercial_app;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uniquindio.comercial_app.controller.LocalController;
import com.uniquindio.comercial_app.interfaces.ILocal;
import com.uniquindio.comercial_app.modelo.Local;
import com.uniquindio.comercial_app.service.LocalService;

@SpringBootTest
@AutoConfigureMockMvc
@Import(LocalController.class)
class ControllerTest {
	
	@Mock
	private LocalService localService;
	
	@Mock
	private ILocal localRepository;
	
	@Mock
	private LocalController localController;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private Local local;
	
	ObjectMapper objectMapper;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		local = new Local();
		local.setId(10);
		local.setName("local testing");
		local.setSite("Sin confirmar");
		local.setStatus(0);
		local.setDateStart(new Date());
		local.setDateEnd(new Date());
		
		objectMapper = new ObjectMapper();

	}
	
	@Test
    void createLocalTest() throws Exception {
		when(localController.addLocal(local)).thenReturn(local);
        mockMvc.perform(post("/local/addLocal").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(local)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        verify(localController).addLocal(local);
    }

}
