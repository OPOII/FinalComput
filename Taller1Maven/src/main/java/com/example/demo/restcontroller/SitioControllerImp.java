package com.example.demo.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.modelo.Tmio1Sitio;
import com.example.demo.service.ITmio1SitioService;

public class SitioControllerImp implements SitioController{

	@Autowired
	private ITmio1SitioService servicio;
	
	
	@GetMapping("/api/sitios")
	public Iterable<Tmio1Sitio> getSitios() {
		return servicio.findAll();
	}

	@PostMapping("/api/sitios")
	public Tmio1Sitio addSitio(@RequestBody Tmio1Sitio sitio) {
		try {
			return servicio.agregar(sitio);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@DeleteMapping("/api/sitios/{id}")
	public Tmio1Sitio delSitio(long id) {
		Tmio1Sitio buscado=null;
		try {
			buscado=servicio.buscar(id);
			servicio.eliminar(buscado.getId());
			return buscado;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/api/sitios/{id}")
	public Tmio1Sitio getSitio(long id) {
		try {
			return servicio.buscar(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
}
