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

import com.uniquindio.comercial_app.interfaceService.ILocalService;
import com.uniquindio.comercial_app.modelo.Local;

@RestController
@RequestMapping("/local")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class LocalController {

	@Autowired
	private ILocalService serviceLocal;

	// Create local
	@PostMapping("/addLocal")
	public Local addLocal(@RequestBody Local local) {
		if(validateLocal(local)) {
			return serviceLocal.addLocal(local);
		} else {
			return null;
		}
	}

	// List local
	@GetMapping("/listLocal")
	public List<Local> listLocal() {
		return serviceLocal.listLocal();
	}

	@GetMapping("/prueba")
	public String prueba() {
		return "entra";
	}

	// Edit local
	@PutMapping(path = { "/editLocal/{idLocal}" })
	public Local editLocal(@RequestBody Local local, @PathVariable("idLocal") Integer idLocal) {
		if (validateLocal(local)) {
			return serviceLocal.editLocal(local);
		} else {
			return null;
		}
	}

	// Delete local
	@DeleteMapping(path = { "/deleteLocal/{idLocal}" })
	public Local deleteLocal(@PathVariable("idLocal") Integer idLocal) {
		return serviceLocal.deleteLocal(idLocal);
	}

	// List local
	@GetMapping("/getLocal/{idLocal}")
	public Local getLocal(@PathVariable("idLocal") Integer idLocal) {
		return serviceLocal.getLocal(idLocal);
	}

	public boolean validateLocal(Local local) {
		if (local.getDateStart() == null || local.getName() == "" || local.getSite() == "" || local.getStatus() < 0) {
			return false;
		}
		return true;
	}
}
