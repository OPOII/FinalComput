package com.example.demo.dao;

import java.util.List;

import com.example.demo.modelo.Tmio1Sitio;

public interface ITSitioDao {

	public void save(Tmio1Sitio ruta);
	public Tmio1Sitio findById(Long id);
	public void delete(Tmio1Sitio ruta);
	public List<Tmio1Sitio>findAll();
	public Tmio1Sitio update(Tmio1Sitio entity);
}
