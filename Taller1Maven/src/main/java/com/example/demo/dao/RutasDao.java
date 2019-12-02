package com.example.demo.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Tmio1Ruta;

@Repository
@Scope("singleton")
public class RutasDao implements ITRutasDao{
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void save(Tmio1Ruta entity) {
		manager.persist(entity);
	}

	@Override
	public void update(Tmio1Ruta entity) {
		manager.merge(entity);
	}

	@Override
	public void delete(Tmio1Ruta entity) {
		manager.remove(entity);
	}

	@Override
	public Tmio1Ruta findById(Integer ruta) {
		return manager.find(Tmio1Ruta.class, ruta);
	}
	@Override
	public List<Tmio1Ruta> findByHoras(BigDecimal inicio, BigDecimal fin) {
//		String jpql="Select a from Tmio1Ruta a where"+inicio+" between a.horaInicio and a.horaFin and"+fin+"between a.horaInicio and a.horaFin";
		String jpql="Select a from Tmio1Ruta a where a.horaInicio<="+inicio+" and a.horaFin>="+fin+"";
//		String jpql="Select a from Tmio1Ruta a where "+inicio+">= a.horaInicio and"+fin+"<=a.horaFin";
		return manager.createQuery(jpql).getResultList();
	}

	@Override
	public List<Tmio1Ruta> findByFecha(BigDecimal diaInicio, BigDecimal diaFIn) {
		String jpql="Select a from Tmio1Ruta a where a.diaInicio<="+diaInicio+" and a.diaFin>="+diaFIn+"";
		return manager.createQuery(jpql).getResultList();
	}

	@Override
	public List<Tmio1Ruta> findByFecha(LocalDate date) {
		String q = "select s.tmio1Ruta from Tmio1Servicio s where :date between s.id.fechaInicio and s.id.fechaFin group by s.tmio1Ruta having count(s) < 10";
		Query query = manager.createQuery(q);
		query.setParameter("date", date);
		return query.getResultList();
	}
	
}
