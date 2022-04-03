package br.casaaposta.main.interfaces;

import java.util.List;

import br.casaaposta.main.entity.consumer.OddsSuperCup;

public interface OddsSuperCupDataInterface {

	List<OddsSuperCup> findByDataOrderByResultadoTipoAsc(String data);

	List<OddsSuperCup> findByResultadoTipoOrderByResultadoTipoAsc(String resultadoTipo);

	List<OddsSuperCup> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante);

	List<OddsSuperCup> findByTimeCasaOrderByResultadoTipoAsc(String timeVisitante);

	List<OddsSuperCup> findByHoraOrderByResultadoTipoAsc(String hora);
	
	List<OddsSuperCup> findAll();
	
}
