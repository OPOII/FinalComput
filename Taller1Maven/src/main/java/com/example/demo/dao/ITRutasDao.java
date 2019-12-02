package com.example.demo.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.example.demo.modelo.Tmio1Ruta;

public interface ITRutasDao {

	public void save(Tmio1Ruta entity);
	public void update(Tmio1Ruta entity);
	public void delete(Tmio1Ruta entity);
	public Tmio1Ruta findById(Integer ruta);
	public List<Tmio1Ruta> findByFecha(BigDecimal diaInicio, BigDecimal diaFIn);
	public List<Tmio1Ruta>findByHoras(BigDecimal inicio, BigDecimal fin);
	public List<Tmio1Ruta>findByFecha(LocalDate date);
}
