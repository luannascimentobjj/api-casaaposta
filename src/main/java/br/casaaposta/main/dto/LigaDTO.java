package br.casaaposta.main.dto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.casaaposta.main.entity.consumer.Liga;
import lombok.Data;

@Data
public class LigaDTO {

	private String codLiga;
	
	private String nomeLiga;
	
	
	
	public LigaDTO(Liga liga){
		this.codLiga = liga.getCodLiga();
		this.nomeLiga = liga.getNomeLiga();

	}
	
	
	
	public static List<LigaDTO> converter(List<Liga> liga) {
		return liga.stream().map(LigaDTO::new).collect(Collectors.toList());
	}
}
