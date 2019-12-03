package com.example.demo.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.delegate.BusDelegateImp;
import com.example.demo.delegate.ConductoreDelegate;
import com.example.demo.delegate.ConductoreDelegateImp;
import com.example.demo.modelo.Tmio1Conductore;
import com.example.demo.service.ITmio1ConductoreService;

@RestController
public class ConductorControllerImp implements ConductorController {

	@Autowired
	private ITmio1ConductoreService servicio;

	@GetMapping("/api/conductores")
	public Iterable<Tmio1Conductore> getConductores() {
		return servicio.findAll();
	}

	@PostMapping("/api/conductores")
	public Tmio1Conductore addConductor(@RequestBody Tmio1Conductore conductor) {
		try {
			return servicio.agregar(conductor);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@DeleteMapping("/api/conductores/{id}")
	public Tmio1Conductore delConductor(@PathVariable String conductor) {
		Tmio1Conductore buscado = null;
		try {
			buscado = servicio.buscar(conductor);
			servicio.eliminar(buscado.getCedula());
			return buscado;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@GetMapping("/api/conductores/{id}")
	public Tmio1Conductore getConductor(@PathVariable String cedula) {
		try {
			return servicio.buscar(cedula);
		} catch (Exception e) {
			return null;
		}
	}

//	@GetMapping("/api/conductores")
//	public Iterable<Tmio1Conductore> getConductores() {
//		return service.findAll();
//	}
//
//	@PostMapping("/api/conductores")
//	public Tmio1Conductore addConductor(@RequestBody Tmio1Conductore conductor) {
//		try {
//			return service.agregar(conductor);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return null;
//	}
//	@DeleteMapping("/api/conductores({id}")
//	public Tmio1Conductore delConductor(@PathVariable String cedula) {
//		try {
//			Tmio1Conductore co=service.buscar(cedula);
//			service.eliminar(co.getCedula());
//			return co;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//	@GetMapping("/api/conductores/{id}")
//	public Tmio1Conductore getConductor(@PathVariable String cedula) {
//		try {
//			return service.buscar(cedula);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
}
