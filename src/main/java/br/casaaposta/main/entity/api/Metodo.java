package br.casaaposta.main.entity.api;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.casaaposta.main.form.AtualizaMetodoForm;
import br.casaaposta.main.form.MetodoForm;
import lombok.Data;

@Entity
@Table(name = "Metodos")
@Data
public class Metodo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
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

	public Metodo() {

	}

	public Metodo(MetodoForm metodoForm) {
		this.metodo = metodoForm.getMetodo();
		this.equipeCasa = metodoForm.getEquipeCasa();
		this.equipeVisitante = metodoForm.getEquipeVisitante();
		this.mercado = metodoForm.getMercado();
		this.odds = metodoForm.getOdds();
		this.liga = metodoForm.getLiga();
		this.entradas = metodoForm.getEntradas();
		this.resultados = metodoForm.getResultados();
		this.hora = metodoForm.getHora();
		this.data = metodoForm.getData();

	}

	public Metodo(AtualizaMetodoForm metodoForm) {
		this.metodo = metodoForm.getMetodo();
		this.equipeCasa = metodoForm.getEquipeCasa();
		this.equipeVisitante = metodoForm.getEquipeVisitante();
		this.mercado = metodoForm.getMercado();
		this.odds = metodoForm.getOdds();
		this.liga = metodoForm.getLiga();
		this.entradas = metodoForm.getEntradas();
		this.resultados = metodoForm.getResultados();
		this.hora = metodoForm.getHora();
		this.data = metodoForm.getData();

	}

}
