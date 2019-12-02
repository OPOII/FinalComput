package com.example.demo.service;

import com.example.demo.modelo.Tmio1Sitio;

public interface ITmio1SitioService {

	public Tmio1Sitio eliminar(long sitio);
	public Tmio1Sitio buscar(long sitio);
	public Tmio1Sitio agregar(Tmio1Sitio sitio);
	public void modificar(Tmio1Sitio sitio);
	public Iterable<Tmio1Sitio>findAll();
}
