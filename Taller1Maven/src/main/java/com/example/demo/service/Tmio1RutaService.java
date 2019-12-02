package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Tmio1Ruta;
import com.example.demo.repository.RutaRepositorio;

@Service
public class Tmio1RutaService implements ITmio1RutaService {
	private RutaRepositorio repositorio;

	@Autowired
	public Tmio1RutaService(RutaRepositorio serv) {
		repositorio = serv;
	}

	@Override
	public void eliminar(Integer ruta) {
		repositorio.deleteById(ruta);
	}

	@Override
	public Tmio1Ruta buscar(Integer ruta) throws Exception {
		if (ruta != null) {
			return repositorio.findById(ruta).get();
		} else {
			throw new Exception("No se puede buscar la ruta por que el parametro esta vacio");
		}
	}

	@Override
	public void agregar(Tmio1Ruta ruta) throws Exception {
		if (ruta != null && ruta.getHoraInicio().doubleValue() < ruta.getHoraFin().doubleValue()
				&& ruta.getDiaInicio().doubleValue() < ruta.getDiaFin().doubleValue()) {
			repositorio.save(ruta);
		} else {
			throw new Exception("Los campos para agregar la ruta no cuemplen con los parametros");
		}
//			repositorio.agregar(ruta);
//		}else {
//			throw new Exception("Los campos para agregar la ruta no cumplen con los parametros");
//		}
	}

	@Override
	public void modificar(Tmio1Ruta ruta) throws Exception {
//		Tmio1Ruta ru=buscar(ruta.getId());
//		eliminar(ru.getId());
//		repositorio.Modificar(ruta);
	}

	@Override
	public Iterable<Tmio1Ruta> findAll() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

}
