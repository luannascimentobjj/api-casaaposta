package br.casaaposta.main.interfaces;

import java.util.List;

import br.casaaposta.main.entity.consumer.OddsWorldCup;

public interface OddsWorldCupDataInterface {
	
	List<OddsWorldCup> findByDataOrderByResultadoTipoAsc(String data);

	List<OddsWorldCup> findByResultadoTipoOrderByResultadoTipoAsc(String resultadoTipo);

	List<OddsWorldCup> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante);

	List<OddsWorldCup> findByTimeCasaOrderByResultadoTipoAsc(String timeVisitante);

	List<OddsWorldCup> findByHoraOrderByResultadoTipoAsc(String hora);

}
