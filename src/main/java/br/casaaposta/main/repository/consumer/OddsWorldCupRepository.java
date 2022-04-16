package br.casaaposta.main.repository.consumer;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.casaaposta.main.entity.consumer.OddsWorldCup;

public interface OddsWorldCupRepository extends JpaRepository<OddsWorldCup, Long> {

	OddsWorldCup findByTollTipAndMinutoAndHoraAndResultadoTipo(String toolTip, int minuto, int hora, String resultadoTipo);
		
	List<OddsWorldCup> findByDataOrderByResultadoTipoAsc(String data);

	List<OddsWorldCup> findByResultadoTipoOrderByResultadoTipoAsc(String resultadoTipo);

	List<OddsWorldCup> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante);

	List<OddsWorldCup> findByTimeCasaOrderByResultadoTipoAsc(String timeVisitante);

	List<OddsWorldCup> findByHoraOrderByResultadoTipoAsc(String hora);
	
	List<OddsWorldCup> findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(String timeCasa, String timeVisitante);
	
	Page<OddsWorldCup> findByTollTipIsNotNull(Pageable pageable);
	
	@Query("SELECT DISTINCT timeVisitante FROM OddsSuperCup WHERE timeCasa IS NOT NULL")
	List<String> findDistinctTimeVisitanteByTimeVisitanteIsNotNull();
	
	@Query("SELECT DISTINCT hora FROM OddsSuperCup WHERE tollTip IS NOT NULL")
	List<String> findDistinctHora();
	
	
	}
	

