package com.example.demo.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Tmio1Bus;

public interface ITBusesDao{

	public void save(Tmio1Bus entity);
	public void update(Tmio1Bus entity);
	public void delete(Tmio1Bus entity);
	public Tmio1Bus findById(Integer codigo);
	public List<Tmio1Bus>finAll();
	public List<Tmio1Bus> findByPlaca(String placa);
	public List<Tmio1Bus> findByMarca(String marca);
	public List<Tmio1Bus> findByModelo(String modelo);
	public List<Tmio1Bus> findByFecha(LocalDate date);
}
