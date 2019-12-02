package com.example.demo.restcontroller;

import com.example.demo.modelo.Tmio1Ruta;

public interface RutaController {

	public Iterable<Tmio1Ruta> getRutas();
	
	public Tmio1Ruta addRuta(Tmio1Ruta ruta);
	
	public Tmio1Ruta delRuta(Integer id);
	
	public Tmio1Ruta getRuta(Integer id);
}
