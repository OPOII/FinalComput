package com.example.demo.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Tmio1Conductore;
@Repository
@Scope("singleton")
public class ConductoreDao implements ITConductoresDao{
	@PersistenceContext
	private EntityManager manager;
	@Override
	public void save(Tmio1Conductore entity) {
		System.out.println("Entro al Dao e intenta salvarlo");
		manager.persist(entity);
	}

	@Override
	public void update(Tmio1Conductore entity) {
		manager.merge(entity);
	}

	@Override
	public void delete(Tmio1Conductore entity) {
	manager.remove(entity);	
	}

	@Override
	public List<Tmio1Conductore> findByCedula(String cedula) {
		String jpql="Select a from Tmio1Conductore a where a.cedula='"+cedula+"'";
//		return manager.createQuery(jpql).getResultList();
		return manager.createQuery(jpql).getResultList();
	}

	@Override
	public List<Tmio1Conductore> findByNombre(String nombre) {
		String jpql="Select a from Tmio1Conductore a where a.nombre='"+nombre+"'";
		return manager.createQuery(jpql).getResultList();
	}

	@Override
	public List<Tmio1Conductore> findByApellidos(String apellidos) {
		String jpql="Select a from Tmio1Conductore a where a.apellidos='"+apellidos+"'";
		return manager.createQuery(jpql).getResultList();
	}

	@Override
	public Iterable<Object[]> findByFecha(LocalDate fecha) {
		String jpql="Select c.tmio1Conductore.cedula,Count(c) from Tmio1Servicio c "+
				"where :theDate Between c.id.fechaInicio and c.id.fechaFin GROUP BY c.tmio1Conductore.cedula";
//		Query query=manager.createQuery(jpql);
//		query.setParameter("date", fecha);
		TypedQuery<Object[]>lista=manager.createQuery(jpql,Object[].class);
		return lista.setParameter("theDate", fecha).getResultList();
	}

	@Override
	public List<Tmio1Conductore> findAll() {
		String jpql="Select a FROM Tmio1Bus a";
		return manager.createQuery(jpql).getResultList();
	}
	
}