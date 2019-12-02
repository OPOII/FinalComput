package com.example.demo.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.delegate.ServiceDelegate;
import com.example.demo.modelo.Tmio1Servicio;
import com.example.demo.modelo.Tmio1ServicioPK;

@RestController
public class ServiceControllerImp implements ServiceController {
	@Autowired
	private ServiceDelegate delegado;

	@GetMapping("/api/servicios/")
	public Iterable<Tmio1Servicio> getServicios() {
		return delegado.getServicios();
	}

	@PostMapping("/api/servicios/")
	public Tmio1Servicio addServicio(@RequestBody Tmio1Servicio servicio) {
		return delegado.addServicio(servicio);
	}

	@DeleteMapping("/api/servicios/{id}")
	public Tmio1Servicio delServicio(@PathVariable Tmio1ServicioPK id) {
		Tmio1Servicio service = delegado.getServicio(id);
		delegado.delServicio(service);
		return service;
	}

	@GetMapping("/api/servicios/{id}")
	public Tmio1Servicio getServicio(@PathVariable Tmio1ServicioPK id) {
		return delegado.getServicio(id);
	}

}
