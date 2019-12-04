package com.example.demo.service;

import com.example.demo.modelo.Tmio1Conductore;
import com.example.demo.modelo.Tmio1Ruta;

public interface ITmio1RutaService {
	public Tmio1Ruta eliminar(Integer ruta);
	public Tmio1Ruta buscar(Integer ruta)throws Exception;
	public Tmio1Ruta agregar(Tmio1Ruta ruta)throws Exception;
	public void modificar(Tmio1Ruta ruta)throws Exception;
	public Iterable<Tmio1Ruta> findAll();
}
