package com.example.demo.delegate;

import com.example.demo.modelo.Tmio1Bus;

public interface BusDelegate {

	public Iterable<Tmio1Bus> getBuses();
	
	public Tmio1Bus addBus(Tmio1Bus newbus);
	
	public void delBus(Tmio1Bus bus);
	
	public Tmio1Bus getBus(Integer i);
}