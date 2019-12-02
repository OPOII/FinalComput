package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.example.demo.modelo.Tmio1Bus;
import com.example.demo.modelo.Tmio1Conductore;
import com.example.demo.modelo.Tmio1Ruta;
import com.example.demo.modelo.Tmio1ServicioPK;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class ServicioApp {

	@EmbeddedId
	private Tmio1ServicioPK id;
	@ManyToOne
	private Tmio1Bus tmio1Bus;
	@ManyToOne
	private Tmio1Conductore tmio1Conductore;
	@ManyToOne
	private Tmio1Ruta tmio1Ruta;
	@NonNull
	@NotBlank
	private Date fechaContratacion;
}

