package com.example.demo.restcontroller;

import com.example.demo.modelo.Tmio1Bus;
import com.example.demo.modelo.Tmio1Conductore;

public interface ConductorController {
	
	public Iterable<Tmio1Conductore> getConductores();

	public Tmio1Conductore addConductor(Tmio1Conductore conductor);

	public Tmio1Conductore delConductor(String conductor);
	
	public Tmio1Conductore getConductor(String cedula);
	
}
