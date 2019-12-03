package com.example.demo.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.delegate.RutaDelegate;
import com.example.demo.modelo.Tmio1Ruta;
import com.example.demo.service.ITmio1RutaService;

@RestController
public class RutaControllerImp implements RutaController {

	@Autowired
	private ITmio1RutaService servicio;

	@GetMapping("/api/rutas")
	public Iterable<Tmio1Ruta> getRutas() {
		try {
			return servicio.findAll();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PostMapping("/api/rutas")
	public Tmio1Ruta addRuta(@RequestBody Tmio1Ruta ruta) {
		try {
			servicio.agregar(ruta);
			return ruta;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@DeleteMapping("/api/rutas/{id}")
	public Tmio1Ruta delRuta(@PathVariable Integer id) {
		Tmio1Ruta ruta = null;
		try {
			ruta = servicio.buscar(id);
			servicio.eliminar(ruta.getId());
			return ruta;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/api/rutas/{id}")
	public Tmio1Ruta getRuta(@PathVariable Integer id) {
		try {
			return servicio.buscar(id);
		} catch (Exception e) {
			return null;
		}
	}

}
