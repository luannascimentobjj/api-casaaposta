package br.casaaposta.main.dto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.casaaposta.main.entity.consumer.Liga;
import br.casaaposta.main.entity.consumer.OddsEuroCup;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class OddsDTO implements Serializable { 
	
	private static final long serialVersionUID = 2709912232043849993L;

	private Integer Id;

	private String resultado;

	private int hora;
	
	private int minuto;

	private double percentual;
	
	private String jogo;
	
	private String tollTip;
	
	private String resultadoTipo;
	
	private boolean isContable;
	
	private int sumScore;
	
	private String timeCasa;
	
	private String timeVisitante;
	
	private String data;
	
	private String ano;
	
	private Liga codLiga;
	
	private String dataCompleta;


	
	
	public OddsDTO(OddsEuroCup oddsEuroCup){
		
		this.Id = oddsEuroCup.getId();
		this.timeCasa = oddsEuroCup.getTimeCasa();
		this.timeVisitante = oddsEuroCup.getTimeVisitante();
		this.jogo = oddsEuroCup.getTimeCasa().trim() + " vs " + oddsEuroCup.getTimeVisitante().trim();
 		this.resultado = oddsEuroCup.getResultado();
		this.data = oddsEuroCup.getData();
		this.percentual = oddsEuroCup.getPercentual();
		this.data = oddsEuroCup.getData();
		this.ano = oddsEuroCup.getAno();
		this.minuto = oddsEuroCup.getMinuto();
		this.hora = oddsEuroCup.getHora();
		this.dataCompleta = oddsEuroCup.getData() + "/" + oddsEuroCup.getAno();
		this.resultadoTipo = oddsEuroCup.getResultadoTipo();
		
	}
	
	public static List<String> converterToReturnAllResultsType(List<OddsEuroCup> oddsEuroCup) {
		List<String> listToReturn = new ArrayList<>();
		oddsEuroCup.stream().map(OddsDTO::new).collect(Collectors.toList()).forEach(list -> {
			if(!listToReturn.contains(list.getResultadoTipo())) {
				listToReturn.add(list.getResultadoTipo());
			}
		});
		return listToReturn;
	}

}
