package com.example.demo.restcontroller;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.modelo.Tmio1Bus;

public interface BusController {

	public Iterable<Tmio1Bus> getBuses();

	public Tmio1Bus addBus(Tmio1Bus bus);

	public Tmio1Bus delBus(Integer id);
	
	public Tmio1Bus getBus(Integer bus);
	
}
