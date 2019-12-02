package com.example.demo.restcontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.delegate.BusDelegate;
import com.example.demo.modelo.Tmio1Bus;
import com.example.demo.repository.BusRepositorio;
import com.example.demo.service.ITmio1BusService;

@RestController
public class BusControllerImp implements BusController {
	@Autowired
	private BusDelegate delegado;
	//Esto usa el servicio, no el delegado

	@GetMapping("/api/buses")
	public Iterable<Tmio1Bus> getBuses() {
		return delegado.getBuses();
	}

	@PostMapping("/api/buses")
	public Tmio1Bus addBus(@RequestBody Tmio1Bus bus) {
		return delegado.addBus(bus);
	}

	@DeleteMapping("/api/buses/{id}")
	public Tmio1Bus delBus(@PathVariable Integer bus) {
		Tmio1Bus bu = delegado.getBus(bus);
		delegado.delBus(bu);
		return bu;
	}

	@GetMapping("/api/buses/{id}")
	public Tmio1Bus getBus(@PathVariable Integer bus) {
		return delegado.getBus(bus);
	}

}
