package com.example.demo.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Tmio1SitiosRuta;
import com.example.demo.service.InterfazSitioRuta;
@RestController
public class SitioRutaControllerImp implements SitioRutaController {
	
	@Autowired
	private  InterfazSitioRuta service;
	@Override
	@GetMapping("/api/sitiosrutas/{id}")
	public Tmio1SitiosRuta getSitioRuta(@PathVariable Integer id) {
		Tmio1SitiosRuta sitio=service.buscarPorId(id);
		return sitio;
	}
	@GetMapping("/api/sitiosrutas")
	public Iterable<Tmio1SitiosRuta> getSitiosRutas() {
		
		return service.findAll();
	}
	@PostMapping("/api/sitiosrutas")
	@Override
	public Tmio1SitiosRuta addSitioRuta(@RequestBody Tmio1SitiosRuta sitioruta) {
		service.save(sitioruta);
		return sitioruta;
	}
	@PostMapping("/api/sitiosrutas/{id}")
	@Override
	public Tmio1SitiosRuta delSitioRuta(@PathVariable Integer id) {
		Tmio1SitiosRuta sitioruta = service.buscarPorId(id);
		service.delete(sitioruta);
		return sitioruta;
	}

}
