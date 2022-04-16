package br.casaaposta.main.interfaces;

import java.util.List;

import org.springframework.data.domain.Pageable;

import br.casaaposta.main.dto.PageDTO;
import br.casaaposta.main.entity.consumer.OddsSuperCup;

public interface OddsSuperCupBusinessInterface {

	List<OddsSuperCup> findByDataOrderByResultadoTipoAsc(String data) throws Exception;

	List<OddsSuperCup> findByResultadoTipoOrderByResultadoTipoAsc(String resultadoTipo) throws Exception;

	List<OddsSuperCup> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante) throws Exception;

	List<OddsSuperCup> findByTimeCasaOrderByResultadoTipoAsc(String timeVisitante) throws Exception;

	List<OddsSuperCup> findByHoraOrderByResultadoTipoAsc(String hora) throws Exception;
	
	List<OddsSuperCup> findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(String timeCasa, String timeVisitante) throws Exception;
	
	List<OddsSuperCup> findAll() throws Exception;
	
	PageDTO findByTollTipIsNotNull(Pageable pageable) throws Exception;
	
	List<String> findDistinctTimeVisitanteByTimeVisitanteIsNotNull() throws Exception;
	
	List<String> findDistinctHora() throws Exception;
	
}
