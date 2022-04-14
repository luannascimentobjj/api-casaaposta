package br.casaaposta.main.repository.consumer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.casaaposta.main.entity.consumer.OddsSuperCup;

public interface OddsSuperCupRepository extends JpaRepository<OddsSuperCup, Long> {

	OddsSuperCup findByTollTipAndMinutoAndHoraAndResultadoTipo(String toolTip, int minuto, int hora,
			String resultadoTipo);

	List<OddsSuperCup> findByDataOrderByResultadoTipoAsc(String data);

	List<OddsSuperCup> findByResultadoTipoOrderByResultadoTipoAsc(String resultadoTipo);

	List<OddsSuperCup> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante);

	List<OddsSuperCup> findByTimeCasaOrderByResultadoTipoAsc(String timeVisitante);

	List<OddsSuperCup> findByHoraOrderByResultadoTipoAsc(String hora);
	
	List<OddsSuperCup> findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(String timeCasa, String timeVisitante);
	
	List<OddsSuperCup> findByTollTipIsNotNull();
	
	@Query("SELECT DISTINCT timeVisitante FROM OddsSuperCup WHERE timeCasa IS NOT NULL")
	List<String> findDistinctTimeVisitanteByTimeVisitanteIsNotNull();
	
	@Query("SELECT DISTINCT hora FROM OddsSuperCup WHERE tollTip IS NOT NULL")
	List<String> findDistinctHora();
	

}
