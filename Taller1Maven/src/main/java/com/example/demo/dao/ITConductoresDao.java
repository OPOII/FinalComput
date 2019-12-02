package com.example.demo.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.example.demo.modelo.Tmio1Conductore;

public interface ITConductoresDao {

	public void save(Tmio1Conductore entity);
	public void update(Tmio1Conductore entity);
	public void delete(Tmio1Conductore entity);
	public List<Tmio1Conductore> findByCedula(String cedula);
	public List<Tmio1Conductore> findByNombre(String nombre);
	public List<Tmio1Conductore> findByApellidos(String apellidos);
	public Iterable<Object[]> findByFecha(LocalDate fecha);
}
