package com.example.demo.restcontroller;

import com.example.demo.modelo.Tmio1SitiosRuta;

public interface SitioRutaController {
public Tmio1SitiosRuta getSitioRuta(Integer id);
	
	public Iterable<Tmio1SitiosRuta> getSitiosRutas();
	
	public Tmio1SitiosRuta addSitioRuta(Tmio1SitiosRuta sitioruta);
	
	public Tmio1SitiosRuta delSitioRuta(Integer id);
}
