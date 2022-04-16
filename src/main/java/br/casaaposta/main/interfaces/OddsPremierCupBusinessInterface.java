package br.casaaposta.main.interfaces;

import java.util.List;

import org.springframework.data.domain.Pageable;

import br.casaaposta.main.dto.PageDTO;
import br.casaaposta.main.entity.consumer.OddsPremierCup;

public interface OddsPremierCupBusinessInterface {
	
		
	List<OddsPremierCup> findByDataOrderByResultadoTipoAsc(String data) throws Exception;
	
	List<OddsPremierCup> findByResultadoTipoOrderByResultadoTipoAsc(String resultadoTipo) throws Exception;
	
	List<OddsPremierCup> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante) throws Exception;
	
	List<OddsPremierCup> findByTimeCasaOrderByResultadoTipoAsc(String timeCasa) throws Exception;
	
	List<OddsPremierCup> findByHoraOrderByResultadoTipoAsc(String hora) throws Exception;
	
	List<OddsPremierCup> findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(String timeCasa, String timeVisitante) throws Exception;
	
	List<OddsPremierCup> findAll() throws Exception;
	
	PageDTO findByTollTipIsNotNull(Pageable pageable) throws Exception;
	
	List<String> findDistinctTimeVisitanteByTimeVisitanteIsNotNull() throws Exception;
	
	List<String> findDistinctHora() throws Exception;
}
