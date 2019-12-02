package com.example.demo.service;

import com.example.demo.modelo.Tmio1Conductore;
import com.example.demo.modelo.Tmio1Servicio;
import com.example.demo.modelo.Tmio1ServicioPK;

public interface ITmio1ServicioService {
	public void eliminar(Tmio1ServicioPK servicio);
	public Tmio1Servicio buscar(Tmio1ServicioPK servicio)throws Exception;
	public void agregar(Tmio1Servicio servicio)throws Exception;
	public void modificar(Tmio1Servicio servicio)throws Exception;
	public Iterable<Tmio1Servicio>findAll();
}
