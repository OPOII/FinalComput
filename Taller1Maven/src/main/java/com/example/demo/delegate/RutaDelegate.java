package com.example.demo.delegate;

import com.example.demo.modelo.Tmio1Ruta;

public interface RutaDelegate {
	
	public Iterable<Tmio1Ruta> getRutas();

	public Tmio1Ruta addRuta(Tmio1Ruta newbus);

	public void delRuta(Tmio1Ruta bus);

	public Tmio1Ruta getRuta(Integer i);
}
