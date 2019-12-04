package com.example.demo.dao;

import java.util.List;

import com.example.demo.modelo.Tmio1SitiosRuta;
import com.example.demo.modelo.Tmio1SitiosRutaPK;

public interface ITSitiosRutas {
	public void save(Tmio1SitiosRuta entity);
	public void update(Tmio1SitiosRuta entity);
	public void delete(Tmio1SitiosRuta entity);
	public Tmio1SitiosRuta findById(Tmio1SitiosRutaPK id);
	public List<Tmio1SitiosRuta> findAll();
}
