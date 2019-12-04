package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Tmio1Sitio;
import com.example.demo.repository.SitioRepositorio;

@Service
public class Tmio1SitioService implements ITmio1SitioService{
	private SitioRepositorio repositorio;
	
	@Autowired
	public Tmio1SitioService(SitioRepositorio repositorio) {
		this.repositorio=repositorio;
	}
	@Transactional
	@Override
	public Tmio1Sitio eliminar(long sitio) {
		Tmio1Sitio eliminado=repositorio.findById(sitio).get();
		repositorio.deleteById(sitio);
		return eliminado;
	}
	@Transactional
	@Override
	public Tmio1Sitio buscar(long sitio) {
		return repositorio.findById(sitio).get();
	}
	@Transactional
	@Override
	public Tmio1Sitio agregar(Tmio1Sitio sitio) {
		return repositorio.save(sitio);
	}
	@Transactional
	@Override
	public void modificar(Tmio1Sitio sitio) {
		Tmio1Sitio viejo=buscar(sitio.getId());
		eliminar(viejo.getId());
		repositorio.save(sitio);
	}
	@Transactional
	@Override
	public Iterable<Tmio1Sitio> findAll() {
		return repositorio.findAll();
	}
	
}
