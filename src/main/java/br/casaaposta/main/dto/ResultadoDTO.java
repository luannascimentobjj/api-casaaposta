package br.casaaposta.main.dto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.casaaposta.main.entity.consumer.Resultado;
import lombok.Data;

@Data
public class ResultadoDTO {

	private int Id;
	
	private int idLiga;
	
	private String resultado;
	
	private String data;
	
	private String jogo;
	
	private String resultadoTipo;
	
	private String timeVisitante;
	
	private String timeCasa;
	
	private Double percentual;
	
	private int hora;
	
	private int minuto;
	
	private String ano;
	
	private String dataCompleta;
	
	
	public ResultadoDTO(Resultado resultado){
		
		this.Id = resultado.getId();
		this.timeCasa = resultado.getTimeCasa();
		this.timeVisitante = resultado.getTimeVisitante();
		this.jogo = resultado.getTimeCasa().trim() + " vs " + resultado.getTimeVisitante().trim();
 		this.resultado = resultado.getResultado();
		this.data = resultado.getData();
		this.percentual = resultado.getPercentual();
		this.data = resultado.getData();
		this.ano = resultado.getAno();
		this.minuto = resultado.getMinuto();
		this.hora = resultado.getHora();
		this.dataCompleta = resultado.getData() + "/" + resultado.getAno();
		this.resultadoTipo = resultado.getResultadoTipo();
		
	}
	
	public static List<ResultadoDTO> converter(List<Resultado> resultados) {
		return resultados.stream().map(ResultadoDTO::new).collect(Collectors.toList());
	}
	
}
