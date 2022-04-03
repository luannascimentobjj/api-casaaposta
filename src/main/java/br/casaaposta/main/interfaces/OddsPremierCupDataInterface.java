package br.casaaposta.main.interfaces;

import java.util.List;

import br.casaaposta.main.entity.consumer.OddsPremierCup;

public interface OddsPremierCupDataInterface {
	
		
	List<OddsPremierCup> findByDataOrderByResultadoTipoAsc(String data);
	
	List<OddsPremierCup> findByResultadoTipoOrderByResultadoTipoAsc(String resultadoTipo);
	
	List<OddsPremierCup> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante);
	
	List<OddsPremierCup> findByTimeCasaOrderByResultadoTipoAsc(String timeCasa);
	
	List<OddsPremierCup> findByHoraOrderByResultadoTipoAsc(String hora);
	
	List<OddsPremierCup> findAll();
}
