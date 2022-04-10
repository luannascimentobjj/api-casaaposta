package br.casaaposta.main.repository.consumer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.casaaposta.main.entity.consumer.OddsEuroCup;
import br.casaaposta.main.entity.consumer.OddsWorldCup;

public interface OddsWorldCupRepository extends JpaRepository<OddsWorldCup, Long> {

	OddsEuroCup findByTollTipAndMinutoAndHoraAndResultadoTipo(String toolTip, int minuto, int hora, String resultadoTipo);
		
	
	List<OddsWorldCup> findByDataOrderByResultadoTipoAsc(String data);

	List<OddsWorldCup> findByResultadoTipoOrderByResultadoTipoAsc(String resultadoTipo);

	List<OddsWorldCup> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante);

	List<OddsWorldCup> findByTimeCasaOrderByResultadoTipoAsc(String timeVisitante);

	List<OddsWorldCup> findByHoraOrderByResultadoTipoAsc(String hora);
	
	List<OddsWorldCup> findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(String timeCasa, String timeVisitante);
	}
	

