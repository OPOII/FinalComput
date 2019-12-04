package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ITSitiosRutasDao;
import com.example.demo.modelo.Tmio1SitiosRuta;
import com.example.demo.modelo.Tmio1SitiosRutaPK;
@Service
public class SitioRutaService implements InterfazSitioRuta {

	private ITSitiosRutasDao sitiosRepository;
	@Autowired
	public SitioRutaService(ITSitiosRutasDao repo) {
		sitiosRepository=repo;
	}
	@Transactional
	public void save(Tmio1SitiosRuta sitioruta) {
		sitiosRepository.save(sitioruta);
	}

	@Transactional
	@Override
	public Tmio1SitiosRuta findById(Tmio1SitiosRutaPK id) {
		return sitiosRepository.findById(id);
	}

	@Transactional
	@Override
	public Iterable<Tmio1SitiosRuta> findAll() {
		return sitiosRepository.findAll();
	}
	@Transactional
	@Override
	public void delete(Tmio1SitiosRuta sitioruta) {
		sitiosRepository.delete(sitioruta);
	}
	@Transactional
	@Override
	public Tmio1SitiosRuta buscarPorId(Integer id) {
		Iterable<Tmio1SitiosRuta> todos = findAll();
		for (Tmio1SitiosRuta sitioruta : todos) {
			if (sitioruta.getHash().equals(id)) {
				return sitioruta;
			}
		}
		return null;
	}

}
