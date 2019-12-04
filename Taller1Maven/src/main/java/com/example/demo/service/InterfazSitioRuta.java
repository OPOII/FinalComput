package com.example.demo.service;

import com.example.demo.modelo.Tmio1SitiosRuta;
import com.example.demo.modelo.Tmio1SitiosRutaPK;

public interface InterfazSitioRuta {
	public void save(Tmio1SitiosRuta sitioruta);

	public Tmio1SitiosRuta findById(Tmio1SitiosRutaPK id);

	public Iterable<Tmio1SitiosRuta> findAll();

	public void delete(Tmio1SitiosRuta sitioruta);
	
	public Tmio1SitiosRuta buscarPorId(Integer id);
}
