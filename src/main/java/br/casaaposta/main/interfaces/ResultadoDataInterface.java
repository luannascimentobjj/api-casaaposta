package br.casaaposta.main.interfaces;

import java.util.List;

import br.casaaposta.main.entity.consumer.Liga;
import br.casaaposta.main.entity.consumer.Resultado;

public interface ResultadoDataInterface {

		
	List<Resultado> findByCodLigaOrderByResultadoTipoAsc(Liga liga);
	
	List<Resultado> findByDataOrderByResultadoTipoAsc(String data);
	
	List<Resultado> findByResultadoTipoOrderByResultadoTipoAsc(String resultadoTipo);
	
	List<Resultado> findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(String timeCasa, String timeVisitante);
	
	List<Resultado> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante);
	
	List<Resultado> findByTimeCasaOrderByResultadoTipoAsc(String timeVisitante);
	
	List<Resultado> findByHoraOrderByResultadoTipoAsc(String hora);
	
	
	
}
