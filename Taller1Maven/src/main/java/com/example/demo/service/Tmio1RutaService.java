package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ITRutasDao;
import com.example.demo.dao.ITServiciosDao;
import com.example.demo.modelo.Tmio1Ruta;
import com.example.demo.repository.RutaRepositorio;

@Service
public class Tmio1RutaService implements ITmio1RutaService {
	private ITRutasDao repositorio;

	@Autowired
	public Tmio1RutaService(ITRutasDao serv) {
		repositorio = serv;
	}
	@Transactional
	@Override
	public Tmio1Ruta eliminar(Integer ruta) {
		Tmio1Ruta r = repositorio.findById(ruta);
		repositorio.delete(r);
		return r;
	}
	@Transactional
	@Override
	public Tmio1Ruta buscar(Integer ruta) throws Exception {
		if (ruta != null) {
			return repositorio.findById(ruta);
		} else {
			throw new Exception("No se puede buscar la ruta por que el parametro esta vacio");
		}
	}
	@Transactional
	@Override
	public Tmio1Ruta agregar(Tmio1Ruta ruta) throws Exception {
		if (ruta != null && ruta.getHoraInicio().doubleValue() < ruta.getHoraFin().doubleValue()
				&& ruta.getDiaInicio().doubleValue() < ruta.getDiaFin().doubleValue()) {
			repositorio.save(ruta);
			return ruta;
		} else {
			throw new Exception("Los campos para agregar la ruta no cuemplen con los parametros");
		}
//			repositorio.agregar(ruta);
//		}else {
//			throw new Exception("Los campos para agregar la ruta no cumplen con los parametros");
//		}
	}
	@Transactional
	@Override
	public void modificar(Tmio1Ruta ruta) throws Exception {
//		Tmio1Ruta ru=buscar(ruta.getId());
//		eliminar(ru.getId());
//		repositorio.Modificar(ruta);
	}
	@Transactional
	@Override
	public Iterable<Tmio1Ruta> findAll() {
		return repositorio.findAll();
	}

}
