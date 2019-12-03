package com.example.demo.delegate;

import com.example.demo.modelo.Tmio1Sitio;

public interface SitioDelegate {

	public Iterable<Tmio1Sitio> getSitios();
	
	public Tmio1Sitio addSitio(Tmio1Sitio sitio);
	
	public void delSitio(Tmio1Sitio sitio);
	
	public Tmio1Sitio getSitio(long id);
}
