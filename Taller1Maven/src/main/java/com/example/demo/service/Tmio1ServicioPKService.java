//package com.example.demo.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.repository.ServicioPKRepository;
//import com.example.demo.modelo.Tmio1ServicioPK;;
//@Service
//public class Tmio1ServicioPKService implements ITmio1ServicioPK {
//	private ServicioPKRepository repositorio;
//	@Autowired
//	public Tmio1ServicioPKService(ServicioPKRepository repos) {
//		repositorio=repos;
//	}
//	@Override
//	public void eliminar(Integer ruta) {
//		repositorio.deleteById(ruta);
//		
//	}
//
//	@Override
//	public Tmio1ServicioPK buscar(Integer ruta) throws Exception {
//		
//		return repositorio.findById(ruta).get();
//	}
//
//	@Override
//	public void agregar(Tmio1ServicioPK ruta) throws Exception {
//
//		repositorio.save(ruta);
//	}
//
//	@Override
//	public void modificar(Tmio1ServicioPK ruta) throws Exception {
//		
//	}
//
//	@Override
//	public Iterable<Tmio1ServicioPK> findAll() {
//		return repositorio.findAll();
//	}
//
//}
