package br.casaaposta.main.interfaces;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import br.casaaposta.main.entity.consumer.OddsEuroCup;

public interface OddsEuroCupBusinessInterface {


	List<OddsEuroCup> findByDataOrderByResultadoTipoAsc(String data) throws Exception;
	
	List<OddsEuroCup> findByResultadoTipoOrderByResultadoTipoAsc(String resultadoTipo) throws Exception;
	
	List<OddsEuroCup> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante) throws Exception;
	
	List<OddsEuroCup> findByTimeCasaOrderByResultadoTipoAsc(String timeVisitante) throws Exception;
	
	List<OddsEuroCup> findByHoraOrderByResultadoTipoAsc(String hora) throws Exception;
	
	List<OddsEuroCup> findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(String timeCasa, String timeVisitante) throws Exception;
	
	List<OddsEuroCup> findAll() throws Exception;
	
	Page<OddsEuroCup> findByTollTipIsNotNull(Pageable pageable) throws Exception;
	
	List<String> findDistinctTimeVisitanteByTimeVisitanteIsNotNull() throws Exception;
	
	List<String> findDistinctHora() throws Exception;
}
