package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Tmio1Conductore;
import com.example.demo.repository.ConductoreRepositorio;

@Service
public class Tmio1ConductoreService implements ITmio1ConductoreService {
	
	private ConductoreRepositorio repositorio;
	@Autowired
	public Tmio1ConductoreService(ConductoreRepositorio servicio) {
		repositorio=servicio;
	}

	@Override
	public Tmio1Conductore eliminar(String conductor) {
			Tmio1Conductore co=repositorio.findById(conductor).get();
			repositorio.deleteById(conductor);
			return co;
	}

	@Override
	public Tmio1Conductore buscar(String conductor) throws Exception {
		if (!conductor.isEmpty()) {
			return repositorio.findById(conductor).get();
		} else {
			throw new Exception("No se puede buscar el conductor por que la cedula esta vacia");
		}
	}

	@Override
	public Tmio1Conductore agregar(Tmio1Conductore conductor) throws Exception {
		if (conductor != null &&conductor.getCedula() != "" && conductor.getNombre() != "" && conductor.getFechaNacimiento() != null
				&& conductor.getFechaContratacion().isAfter(conductor.getFechaNacimiento())==true) {
			return repositorio.save(conductor);
		} else {
			System.out.println("Entro");
			throw new Exception("El conductor que intenta agregar no cumple con los parametros establecidos");
		}
	}

	@Override
	public void modificar(Tmio1Conductore conductor) throws Exception {
		Tmio1Conductore viejo = buscar(conductor.getCedula());
		eliminar(viejo.getCedula());
		repositorio.save(conductor);
	}

	@Override
	public Iterable<Tmio1Conductore> findAll() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}
}
