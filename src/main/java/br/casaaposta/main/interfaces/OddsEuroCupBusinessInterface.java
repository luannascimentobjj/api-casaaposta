package br.casaaposta.main.interfaces;
import java.util.List;
import org.springframework.data.domain.Pageable;

import br.casaaposta.main.dto.OddsDTO;
import br.casaaposta.main.dto.PageDTO;
import br.casaaposta.main.entity.consumer.OddsEuroCup;

public interface OddsEuroCupBusinessInterface {


	List<OddsDTO> findByDataOrderByResultadoTipoAsc(String data) throws Exception;
	
	List<OddsDTO> findByResultadoTipoOrderByResultadoTipoAsc(String resultadoTipo) throws Exception;
	
	List<OddsDTO> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante) throws Exception;
	
	List<OddsDTO> findByTimeCasaOrderByResultadoTipoAsc(String timeVisitante) throws Exception;
	
	List<OddsDTO> findByHoraOrderByResultadoTipoAsc(int hora) throws Exception;
	
	List<OddsDTO> findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(String timeCasa, String timeVisitante) throws Exception;
	
	List<OddsEuroCup> findAll() throws Exception;
	
	PageDTO findByTollTipIsNotNull(Pageable pageable) throws Exception;
	
	List<String> findDistinctTimeVisitanteByTimeVisitanteIsNotNull() throws Exception;
	
	List<String> findDistinctHora() throws Exception;
}
