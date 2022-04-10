package br.casaaposta.main.repository.consumer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.casaaposta.main.entity.consumer.OddsEuroCup;
import br.casaaposta.main.entity.consumer.OddsSuperCup;

public interface OddsSuperCupRepository extends JpaRepository<OddsSuperCup, Long> {

	OddsEuroCup findByTollTipAndMinutoAndHoraAndResultadoTipo(String toolTip, int minuto, int hora,
			String resultadoTipo);

	List<OddsSuperCup> findByDataOrderByResultadoTipoAsc(String data);

	List<OddsSuperCup> findByResultadoTipoOrderByResultadoTipoAsc(String resultadoTipo);

	List<OddsSuperCup> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante);

	List<OddsSuperCup> findByTimeCasaOrderByResultadoTipoAsc(String timeVisitante);

	List<OddsSuperCup> findByHoraOrderByResultadoTipoAsc(String hora);
	
	List<OddsSuperCup> findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(String timeCasa, String timeVisitante);

}
