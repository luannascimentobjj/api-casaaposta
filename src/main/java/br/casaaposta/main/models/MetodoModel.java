package br.casaaposta.main.models;

import br.casaaposta.main.entity.MetodoEntity;
import lombok.Data;

@Data
public class MetodoModel {

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

	public MetodoModel(MetodoEntity metodo){
		this.id = metodo.getId();
		this.metodo = metodo.getMetodo();
		this.equipeCasa = metodo.getEquipeCasa();
		this.mercado = metodo.getMercado();
		this.odds = metodo.getOdds();
		this.liga = metodo.getLiga();
		this.hora = metodo.getHora();
		this.data = metodo.getData();
		this.equipeVisitante = metodo.getEquipeVisitante();
	}


}
