package com.example.demo.restcontroller;

import com.example.demo.modelo.Tmio1Sitio;

public interface SitioController {
	public Iterable<Tmio1Sitio> getSitios();

	public Tmio1Sitio addSitio(Tmio1Sitio sitio);
	
	public Tmio1Sitio delSitio(long id);
	
	public Tmio1Sitio getSitio(long id);
}
