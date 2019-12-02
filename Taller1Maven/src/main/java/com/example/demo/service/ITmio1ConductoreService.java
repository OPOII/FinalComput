package com.example.demo.service;

import com.example.demo.modelo.Tmio1Bus;
import com.example.demo.modelo.Tmio1Conductore;

public interface ITmio1ConductoreService {

	public Tmio1Conductore eliminar(String conductor);
	public Tmio1Conductore buscar(String conductor)throws Exception;
	public Tmio1Conductore agregar(Tmio1Conductore conductor)throws Exception;
	public void modificar(Tmio1Conductore conductor)throws Exception;
	public Iterable<Tmio1Conductore>findAll();
}
