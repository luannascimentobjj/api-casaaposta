package br.casaaposta.main.interfaces;

import java.util.List;

import br.casaaposta.main.entity.consumer.OddsEuroCup;

public interface OddsEuroCupDataInterface {

	OddsEuroCup findByTollTipAndMinutoAndHoraAndResultadoTipo(String toolTip, int minuto, int hora, String resultadoTipo);
	
	List<OddsEuroCup> findByDataOrderByResultadoTipoAsc(String data);
	
	List<OddsEuroCup> findByResultadoTipoOrderByResultadoTipoAsc(String resultadoTipo);
	
	List<OddsEuroCup> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante);
	
	List<OddsEuroCup> findByTimeCasaOrderByResultadoTipoAsc(String timeVisitante);
	
	List<OddsEuroCup> findByHoraOrderByResultadoTipoAsc(String hora);
	
	List<OddsEuroCup> findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(String timeCasa, String timeVisitante);
	
}
