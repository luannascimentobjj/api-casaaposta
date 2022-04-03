package br.casaaposta.main.interfaces;

import java.util.List;

import br.casaaposta.main.entity.consumer.OddsEuroCup;
import br.casaaposta.main.entity.consumer.OddsPremierCup;

public interface OddsPremierCupDataInterface {
	
	OddsEuroCup findByTollTipAndMinutoAndHoraAndResultadoTipo(String toolTip, int minuto, int hora, String resultadoTipo);
	
	List<OddsPremierCup> findByDataOrderByResultadoTipoAsc(String data);
	
	List<OddsPremierCup> findByResultadoTipoOrderByResultadoTipoAsc(String resultadoTipo);
	
	List<OddsPremierCup> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante);
	
	List<OddsPremierCup> findByTimeCasaOrderByResultadoTipoAsc(String timeVisitante);
	
	List<OddsPremierCup> findByHoraOrderByResultadoTipoAsc(String hora);
	

}
