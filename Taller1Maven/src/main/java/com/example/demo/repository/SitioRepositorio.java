package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modelo.Tmio1Servicio;
import com.example.demo.modelo.Tmio1Sitio;

public interface SitioRepositorio extends CrudRepository<Tmio1Sitio, Long>{

}
