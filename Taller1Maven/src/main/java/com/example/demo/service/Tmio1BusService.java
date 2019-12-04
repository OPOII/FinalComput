package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ITBusesDao;
import com.example.demo.modelo.Tmio1Bus;
import com.example.demo.repository.BusRepositorio;

@Service
public class Tmio1BusService implements ITmio1BusService {
//	private BusRepositorio repositorio;
	@Autowired
	private ITBusesDao repositorio;
	// Service hace la logica
	@Autowired
	public Tmio1BusService(ITBusesDao repositorio) {
		this.repositorio=repositorio;
	}

	@Override
	public Tmio1Bus eliminar(Integer bus) {
		Tmio1Bus eliminado=repositorio.findById(bus);
		repositorio.delete(eliminado);
		return eliminado;
	}

	@Override
	public Tmio1Bus buscar(Integer bus) throws Exception {
//		if(bus!=null) {
			return repositorio.findById(bus);
//		}else {
//			throw new Exception("No se puede buscar el bus por que el parametro esta vacio");
//		}
	}

	@Override
	public Tmio1Bus agregar(Tmio1Bus bus) throws Exception {
		if (bus.getCapacidad().doubleValue() > 0 && bus != null
				&& (bus.getTipo().equals("A") || bus.getTipo().equals("T")) || bus.getTipo().equals("P")) {
			repositorio.save(bus);
			return bus;
		} else {
			throw new Exception("El bus que intenta agregar no cumple con los parametros exigidos");
		}
	}

	@Override
	public void modificar(Tmio1Bus bus) throws Exception {
		Tmio1Bus viejo = buscar(bus.getId());
		eliminar(viejo.getId());
		repositorio.save(bus);
		}

	@Override
	public Iterable<Tmio1Bus> findAll() {
		return repositorio.finAll();
	}
	
}