package com.example.demo.dao;

import com.example.demo.modelo.Tmio1Servicio;
import com.example.demo.modelo.Tmio1ServicioPK;

public interface ITServiciosDao {
	public void save(Tmio1Servicio servicio);
	public void delete(Tmio1Servicio servicio);
	public void update(Tmio1Servicio servicio);
	public Tmio1Servicio buscar(Tmio1ServicioPK id);
	public Iterable<Tmio1Servicio> findAll();
}
