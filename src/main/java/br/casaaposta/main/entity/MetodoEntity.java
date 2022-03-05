package br.casaaposta.main.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.persistence.Entity;

import br.casaaposta.main.form.MetodoForm;
import br.casaaposta.main.models.MetodoModel;
import lombok.Data;

@Entity
@Data
public class MetodoEntity {

	public MetodoEntity(MetodoForm metodoForm) {
		this.metodo = metodoForm.getMercado();
		this.equipeCasa = metodoForm.getEquipeCasa();
		this.equipeVisitante = metodoForm.getEquipeVisitante();
		this.mercado = metodoForm.getMercado();
		this.odds = metodoForm.getOdds();
		this.liga = metodoForm.getLiga();
		this.entradas = metodoForm.getEntradas();
		this.resultados = metodoForm.getResultados();
		this.hora = metodoForm.getHora();
		
	}
	private Integer id;
	private String metodo;
	private String equipeCasa;
	private String equipeVisitante;
	private String mercado;
	private String odds;
	private String liga;
	private String entradas;
	private String resultados;
	private String hora;
	private String data;
	private LocalDateTime dataInclusaoRegistro;
	
}
