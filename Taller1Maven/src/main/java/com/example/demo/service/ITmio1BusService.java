package com.example.demo.service;

import com.example.demo.modelo.Tmio1Bus;

public interface ITmio1BusService {

	public Tmio1Bus eliminar(Integer bus);
	public Tmio1Bus buscar(Integer bus);
	public Tmio1Bus agregar(Tmio1Bus bus);
	public void modificar(Tmio1Bus bus);
	public Iterable<Tmio1Bus>findAll();
}
