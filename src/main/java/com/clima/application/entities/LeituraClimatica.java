package com.clima.application.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_leitura_climatica")
public class LeituraClimatica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_leitura_climatica")
	private Long id;

	@Column(nullable = false, unique = true)
	private double temperatura;

	@Column(nullable = false, unique = true)
	private double umidade;

	@Column(name = "data_hora_leitura", nullable = false, unique = true)
	private LocalDateTime dataHoraLeitura;

	public LeituraClimatica() {
	}

	public LeituraClimatica(double temperatura, double umidade, LocalDateTime dataHoraLeitura) {
		this.temperatura = temperatura;
		this.umidade = umidade;
		this.dataHoraLeitura = dataHoraLeitura;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public double getUmidade() {
		return umidade;
	}

	public void setUmidade(double umidade) {
		this.umidade = umidade;
	}

	public LocalDateTime getDataHoraLeitura() {
		return dataHoraLeitura;
	}

	public void setDataHoraLeitura(LocalDateTime dataHoraLeitura) {
		this.dataHoraLeitura = dataHoraLeitura;
	}

}