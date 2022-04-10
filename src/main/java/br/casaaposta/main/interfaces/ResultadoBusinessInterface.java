package br.casaaposta.main.interfaces;

import java.util.List;

import br.casaaposta.main.entity.consumer.Liga;
import br.casaaposta.main.entity.consumer.Resultado;

public interface ResultadoBusinessInterface {

		
	List<Resultado> findByCodLigaOrderByResultadoTipoAsc(Liga liga) throws Exception;
	
	List<Resultado> findByDataOrderByResultadoTipoAsc(String data) throws Exception;
	
	List<Resultado> findByResultadoTipoOrderByResultadoTipoAsc(String resultadoTipo) throws Exception;
	
	List<Resultado> findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(String timeCasa, String timeVisitante) throws Exception;
	
	List<Resultado> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante) throws Exception;
	
	List<Resultado> findByTimeCasaOrderByResultadoTipoAsc(String timeVisitante) throws Exception;
	
	List<Resultado> findByHoraOrderByResultadoTipoAsc(String hora) throws Exception;
	
	
	
}
