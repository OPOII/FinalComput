package com.example.demo.delegate;

import com.example.demo.modelo.Tmio1SitiosRuta;
import com.example.demo.modelo.Tmio1SitiosRutaPK;

public interface SitioRutaDelegate {

	public Iterable<Tmio1SitiosRuta> getRutas();
	
	public Tmio1SitiosRuta addRuta(Tmio1SitiosRuta newSitios);
	
	public void delRuta(Tmio1SitiosRuta sitio);
	
	public Tmio1SitiosRuta getSitiosRuta(Tmio1SitiosRutaPK id);
	
}
