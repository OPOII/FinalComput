package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ITServiciosDao;
import com.example.demo.modelo.Tmio1Servicio;
import com.example.demo.modelo.Tmio1ServicioPK;
import com.example.demo.repository.ServicioRepositorio;

@Service
public class Tmio1ServicioService implements ITmio1ServicioService {
	@Autowired
	private ITServiciosDao repositorio;

	public Tmio1ServicioService(ITServiciosDao serv) {
		repositorio = serv;
	}
	@Transactional
	@Override
	public void eliminar(Tmio1ServicioPK servicio) {
		Tmio1Servicio s=repositorio.buscar(servicio);
		repositorio.delete(s);
	}
	@Transactional
	@Override
	public Tmio1Servicio buscar(Tmio1ServicioPK servicio) throws Exception {
		if (servicio != null) {
			return repositorio.buscar(servicio);
		} else {
			throw new Exception("No se puede encontrar la ruta que busca por que el parametro de busqueda es nulo");
		}
	}
	@Transactional
	@Override
	public void agregar(Tmio1Servicio servicio) throws Exception {
		if (servicio.getId() != null && servicio.getTmio1Bus() != null && servicio.getTmio1Conductore() != null
				&& servicio.getTmio1Ruta() != null) {
			repositorio.save(servicio);
		} else {
			throw new Exception("El servicio no cuenta con los parametros necesarios para ser agregado");
		}
	}
	@Transactional
	@Override
	public void modificar(Tmio1Servicio servicio) throws Exception {
		
	}
	@Transactional
	@Override
	public Iterable<Tmio1Servicio> findAll() {
		return repositorio.findAll();
	}

}
