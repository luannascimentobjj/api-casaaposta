package br.casaaposta.main.interfaces;

import java.util.List;

import br.casaaposta.main.entity.consumer.OddsWorldCup;

public interface OddsWorldCupBusinessInterface {
	
	List<OddsWorldCup> findByDataOrderByResultadoTipoAsc(String data) throws Exception;

	List<OddsWorldCup> findByResultadoTipoOrderByResultadoTipoAsc(String resultadoTipo) throws Exception;

	List<OddsWorldCup> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante) throws Exception;

	List<OddsWorldCup> findByTimeCasaOrderByResultadoTipoAsc(String timeVisitante) throws Exception;

	List<OddsWorldCup> findByHoraOrderByResultadoTipoAsc(String hora) throws Exception;
	
	List<OddsWorldCup> findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(String timeCasa, String timeVisitante) throws Exception;
	
	List<OddsWorldCup> findAll() throws Exception;

}
