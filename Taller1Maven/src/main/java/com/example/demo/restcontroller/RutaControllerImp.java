package com.example.demo.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.delegate.RutaDelegate;
import com.example.demo.modelo.Tmio1Ruta;

@RestController
public class RutaControllerImp implements RutaController {

	@Autowired
	private RutaDelegate delegado;

	@GetMapping("/api/rutas/")
	public Iterable<Tmio1Ruta> getRutas() {
		return delegado.getRutas();
	}

	@PostMapping("/api/rutas/")
	public Tmio1Ruta addRuta(Tmio1Ruta ruta) {
		return delegado.addRuta(ruta);
	}

	@DeleteMapping("/api/rutas/{id}")
	public Tmio1Ruta delRuta(Integer id) {
		Tmio1Ruta ruta = delegado.getRuta(id);
		delegado.delRuta(ruta);
		return ruta;
	}

	@GetMapping("/api/rutas/{id}")
	public Tmio1Ruta getRuta(Integer id) {
		return delegado.getRuta(id);
	}

}
