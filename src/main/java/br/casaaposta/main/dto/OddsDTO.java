package br.casaaposta.main.dto;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import br.casaaposta.main.entity.consumer.Liga;
import br.casaaposta.main.entity.consumer.OddsEuroCup;
import br.casaaposta.main.entity.consumer.OddsPremierCup;
import br.casaaposta.main.entity.consumer.OddsSuperCup;
import br.casaaposta.main.entity.consumer.OddsWorldCup;
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
		this.jogo = oddsEuroCup.getTimeCasa() + " vs " + oddsEuroCup.getTimeVisitante();
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
	
		
	public OddsDTO(OddsSuperCup oddsSuperCup){
		
		this.Id = oddsSuperCup.getId();
		this.timeCasa = oddsSuperCup.getTimeCasa();
		this.timeVisitante = oddsSuperCup.getTimeVisitante();
		this.jogo = oddsSuperCup.getTimeCasa() + " vs " + oddsSuperCup.getTimeVisitante();
 		this.resultado = oddsSuperCup.getResultado();
		this.data = oddsSuperCup.getData();
		this.percentual = oddsSuperCup.getPercentual();
		this.data = oddsSuperCup.getData();
		this.ano = oddsSuperCup.getAno();
		this.minuto = oddsSuperCup.getMinuto();
		this.hora = oddsSuperCup.getHora();
		this.dataCompleta = oddsSuperCup.getData() + "/" + oddsSuperCup.getAno();
		this.resultadoTipo = oddsSuperCup.getResultadoTipo();
		
	}
	
	
	public OddsDTO(OddsPremierCup oddsPremierCup){
		
		this.Id = oddsPremierCup.getId();
		this.timeCasa = oddsPremierCup.getTimeCasa();
		this.timeVisitante = oddsPremierCup.getTimeVisitante();
		this.jogo = oddsPremierCup.getTimeCasa() + " vs " + oddsPremierCup.getTimeVisitante();
 		this.resultado = oddsPremierCup.getResultado();
		this.data = oddsPremierCup.getData();
		this.percentual = oddsPremierCup.getPercentual();
		this.data = oddsPremierCup.getData();
		this.ano = oddsPremierCup.getAno();
		this.minuto = oddsPremierCup.getMinuto();
		this.hora = oddsPremierCup.getHora();
		this.dataCompleta = oddsPremierCup.getData() + "/" + oddsPremierCup.getAno();
		this.resultadoTipo = oddsPremierCup.getResultadoTipo();
		
	}
	
	
public OddsDTO(OddsWorldCup oddsWorldCup){
		
		this.Id = oddsWorldCup.getId();
		this.timeCasa = oddsWorldCup.getTimeCasa();
		this.timeVisitante = oddsWorldCup.getTimeVisitante();
		this.jogo = oddsWorldCup.getTimeCasa() + " vs " + oddsWorldCup.getTimeVisitante();
 		this.resultado = oddsWorldCup.getResultado();
		this.data = oddsWorldCup.getData();
		this.percentual = oddsWorldCup.getPercentual();
		this.data = oddsWorldCup.getData();
		this.ano = oddsWorldCup.getAno();
		this.minuto = oddsWorldCup.getMinuto();
		this.hora = oddsWorldCup.getHora();
		this.dataCompleta = oddsWorldCup.getData() + "/" + oddsWorldCup.getAno();
		this.resultadoTipo = oddsWorldCup.getResultadoTipo();
		
	}
	

	public static List<OddsDTO> converterPageableEuroCup(Page<OddsEuroCup> resultados) {
		return resultados.stream().map(OddsDTO::new).collect(Collectors.toList());
	}	

	public static List<OddsDTO> converterToEuroCup(List<OddsEuroCup> resultados) {
			return resultados.stream().map(OddsDTO::new).collect(Collectors.toList());
	}
	
	public static List<OddsDTO> converterToSuperCup(List<OddsSuperCup> resultados) {
		return resultados.stream().map(OddsDTO::new).collect(Collectors.toList());
	}

	public static List<OddsDTO> converterToPremierCup(List<OddsPremierCup> resultados) {
		return resultados.stream().map(OddsDTO::new).collect(Collectors.toList());
	}
	
	public static List<OddsDTO> converterToWorldCup(List<OddsWorldCup> resultados) {
		return resultados.stream().map(OddsDTO::new).collect(Collectors.toList());
	}
}
