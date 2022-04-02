package br.casaaposta.main.dto;

import java.util.List;
import java.util.Optional;
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
		this.resultados = metodo.getResultados();
		this.entradas = metodo.getEntradas();
		this.equipeVisitante = metodo.getEquipeVisitante();
	}

	public MetodoDTO(Optional<Metodo> metodo2){
		this.id = metodo2.get().getId();
		this.metodo = metodo2.get().getMetodo();
		this.equipeCasa = metodo2.get().getEquipeCasa();
		this.mercado = metodo2.get().getMercado();
		this.odds = metodo2.get().getOdds();
		this.liga = metodo2.get().getLiga();
		this.hora = metodo2.get().getHora();
		this.data = metodo2.get().getData();
		this.resultados = metodo2.get().getResultados();
		this.entradas = metodo2.get().getEntradas();
		this.equipeVisitante = metodo2.get().getEquipeVisitante();
	}


	

	public static List<MetodoDTO> converter(List<Metodo> metodos) {
		return metodos.stream().map(MetodoDTO::new).collect(Collectors.toList());
	}
	
	
	public static List<MetodoDTO> converterOptToEntity(List<Metodo> metodos) {
		return metodos.stream().map(MetodoDTO::new).collect(Collectors.toList());
	}
	
}
