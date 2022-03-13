package br.casaaposta.main.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.casaaposta.main.entity.consumer.TipoResultado;
import lombok.Data;

@Data
public class TipoResultadoDTO {

	public int id;

	private String resultadoTipo;

	private boolean isOdds;

	public TipoResultadoDTO(TipoResultado tiposResultados) {

		this.id = tiposResultados.getId();
		this.resultadoTipo = tiposResultados.getResultadoTipo();
		this.isOdds = tiposResultados.isOdds();

	}

	public static List<TipoResultadoDTO> converter(List<TipoResultado> tiposResultados) {
		return tiposResultados.stream().map(TipoResultadoDTO::new).collect(Collectors.toList());
	}
}
