package br.casaaposta.main.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import br.casaaposta.main.form.AtualizaMetodoForm;
import br.casaaposta.main.form.MetodoForm;
import lombok.Data;

@Entity
@Data
public class Metodo {

	public Metodo(MetodoForm metodoForm) {
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
	
	public Metodo(AtualizaMetodoForm metodoForm) {
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
