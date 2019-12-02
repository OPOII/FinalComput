package com.example.demo.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
public class RutaApp {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
//	@NonNull
//	@NotBlank
//	private String activa;
//	@NonNull
//	@NotBlank
//	private String descripcion;
//	@NotNull
//	@Positive
//	private BigDecimal diaInicio;
//	@NotNull
//	@Positive
//	private BigDecimal diaFin;
//	@NotNull
//	@Positive
//	private BigDecimal horaInicio;
//	@NotNull
//	@Positive
//	private BigDecimal horaFin;
//	@NonNull
//	@NotBlank
//	private String numero;

}
