package com.example.demo.delegate;

import com.example.demo.modelo.Tmio1Conductore;

public interface ConductoreDelegate {

	public Iterable<Tmio1Conductore> getConductores();
	
	public Tmio1Conductore addConductor(Tmio1Conductore newconductor);
	
	public void delConductore(Tmio1Conductore conductor);
	
	public Tmio1Conductore getConductore(String cedula);
}
