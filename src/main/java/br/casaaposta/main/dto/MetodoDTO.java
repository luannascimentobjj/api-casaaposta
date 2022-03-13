package br.casaaposta.main.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.casaaposta.main.entity.api.Metodo;
import lombok.Data;

@Data
public class MetodoDTO {

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

	public MetodoDTO(Metodo metodo){
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



	

	public static List<MetodoDTO> converter(List<Metodo> metodos) {
		return metodos.stream().map(MetodoDTO::new).collect(Collectors.toList());
	}
	
}
