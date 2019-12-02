package com.example.demo.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Tmio1Bus;

@Repository
@Scope("singleton")
public class BusesDao implements ITBusesDao{
	@PersistenceContext
	private EntityManager manager;
	@Override
	public void save(Tmio1Bus entity) {
		manager.persist(entity);
	}

	@Override
	public void update(Tmio1Bus entity) {
		manager.merge(entity);
	}

	@Override
	public void delete(Tmio1Bus entity) {
		manager.remove(entity);
	}

	@Override
	public Tmio1Bus findById(Integer codigo) {
		return manager.find(Tmio1Bus.class, codigo);
	}

	@Override
	public List<Tmio1Bus> finAll() {
		String jpql="Select a FROM Tmio1Bus a";
		return manager.createQuery(jpql).getResultList();
	}

	@Override
	public List<Tmio1Bus> findByPlaca(String placa) {
		String jpql="Select a from Tmio1Bus a where a.placa='"+placa+"'";
		return manager.createQuery(jpql).getResultList();
	}

	@Override
	public List<Tmio1Bus> findByMarca(String marca) {
		String jpql="Select a from Tmio1Bus a where a.marca ='"+marca+"'";
		return manager.createQuery(jpql).getResultList();
	}

	@Override
	public List<Tmio1Bus> findByModelo(String modelo) {
		String jpql="Select a from Tmio1Bus a where a.modelo='"+modelo+"'";
		return manager.createQuery(jpql).getResultList();
	}

	@Override
	public List<Tmio1Bus> findByFecha(LocalDate date) {
		List<Tmio1Bus>retorno=new ArrayList<Tmio1Bus>();
		String q = "Select s.tmio1Bus.id , Count(s) from Tmio1Servicio s where :date between s.id.fechaInicio and s.id.fechaFin GROUP BY s.tmio1Bus.id ";
		Query query = manager.createQuery(q);
		
		query.setParameter("date", date);
		List<Object[]> results= query.getResultList();

		for (Object[] result: results) {
			Tmio1Bus n= (Tmio1Bus) result[0];
			int count= ((Number) result[1]).intValue();
			if( count>1) retorno.add(n);
		}
	
		return retorno;
	}

}
