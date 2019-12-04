package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Tmio1Ruta;
import com.example.demo.modelo.Tmio1SitiosRuta;
import com.example.demo.modelo.Tmio1SitiosRutaPK;

@Repository
@Scope("singleton")
public class SitiosRutasDao implements ITSitiosRutasDao {
	@PersistenceContext
	private EntityManager manager;
	@Override
	public void save(Tmio1SitiosRuta entity) {
manager.persist(entity);		
	}

	@Override
	public void update(Tmio1SitiosRuta entity) {
		manager.merge(entity);
		
	}

	@Override
	public void delete(Tmio1SitiosRuta entity) {
		manager.remove(entity);		
	}

	@Override
	public Tmio1SitiosRuta findById(Tmio1SitiosRutaPK id) {
		return manager.find(Tmio1SitiosRuta.class, id);
	}

	@Override
	public List<Tmio1SitiosRuta> findAll() {
		String jpql = "Select a from Tmio1SitiosRuta a";
		return manager.createQuery(jpql).getResultList();
	}

}
