package com.example.demo.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.example.demo.validation.Step1;
import com.example.demo.validation.Update;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
public class BusApp {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
//	@NotNull
//	@Positive
//	private BigDecimal capacidad;
//	@NotBlank(groups = { Step1.class, Update.class })
//	@NonNull
//	private String marca;
//	@NotNull
//	@Positive
//	private BigDecimal modelo;
//	@NotBlank
//	@NonNull
//	private String placa;
//	@NotBlank
//	@NonNull
//	private String tipo;
//	@NotBlank
//	@NonNull
//	private String input;
}
