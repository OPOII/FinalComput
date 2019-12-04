package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ITConductoresDao;
import com.example.demo.modelo.Tmio1Conductore;
import com.example.demo.repository.ConductoreRepositorio;

@Service
public class Tmio1ConductoreService implements ITmio1ConductoreService {

	private ITConductoresDao repositorio;
	@Autowired
	public Tmio1ConductoreService(ITConductoresDao servicio) {
		repositorio = servicio;
	}
	@Transactional
	@Override
	public Tmio1Conductore eliminar(String conductor) {
		Tmio1Conductore co = repositorio.findByCedula(conductor).get(0);
		repositorio.delete(co);
		return co;
	}
	@Transactional
	@Override
	public Tmio1Conductore buscar(String conductor) throws Exception {
		if (!conductor.isEmpty()) {
			Tmio1Conductore c=repositorio.findByCedula(conductor).get(0);
			return c;
		} else {
			throw new Exception("No se puede buscar el conductor por que la cedula esta vacia");
		}
	}
	@Transactional
	@Override
	public Tmio1Conductore agregar(Tmio1Conductore conductor) throws Exception {
		if (conductor != null && conductor.getCedula() != "" && conductor.getNombre() != ""
				&& conductor.getFechaNacimiento() != null
				&& conductor.getFechaContratacion().isAfter(conductor.getFechaNacimiento()) == true) {
			System.out.println("Entro a intentarGuardar");
			repositorio.save(conductor);
			repositorio.findByCedula(conductor.getCedula()+"Intenta buscar al conductor");
			return conductor;
		} else {
			System.out.println("Entro");
			throw new Exception("El conductor que intenta agregar no cumple con los parametros establecidos");
		}
	}
	@Transactional
	@Override
	public void modificar(Tmio1Conductore conductor) throws Exception {
		Tmio1Conductore viejo = buscar(conductor.getCedula());
		eliminar(viejo.getCedula());
		repositorio.save(conductor);
	}
	@Transactional
	@Override
	public Iterable<Tmio1Conductore> findAll() {
		return repositorio.findAll();
	}
}
