package com.example.demo.service;

import com.example.demo.modelo.Tmio1Bus;

public interface ITmio1BusService {

	public Tmio1Bus eliminar(Integer bus);
	public Tmio1Bus buscar(Integer bus)throws Exception;
	public Tmio1Bus agregar(Tmio1Bus bus)throws Exception;
	public void modificar(Tmio1Bus bus)throws Exception;
	public Iterable<Tmio1Bus>findAll();
}
