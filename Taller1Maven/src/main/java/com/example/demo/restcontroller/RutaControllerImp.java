package com.example.demo.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.delegate.RutaDelegate;
import com.example.demo.modelo.Tmio1Ruta;

@RestController
public class RutaControllerImp implements RutaController {

	@Autowired
	private RutaDelegate delegado;

	@GetMapping("/api/buses")
	public Iterable<Tmio1Ruta> getRutas() {
		return null;
	}

	@Override
	public Tmio1Ruta addRuta(Tmio1Ruta ruta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tmio1Ruta delRuta(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tmio1Ruta getRuta(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
