package br.casaaposta.main.repository.consumer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.casaaposta.main.entity.consumer.OddsPremierCup;

public interface OddsPremierCupRepository extends JpaRepository<OddsPremierCup, Long> {

	OddsPremierCup findByTollTipAndMinutoAndHoraAndResultadoTipo(String toolTip, int minuto, int hora, String resultadoTipo);
	
	List<OddsPremierCup> findByDataOrderByResultadoTipoAsc(String data);
	
	List<OddsPremierCup> findByResultadoTipoOrderByResultadoTipoAsc(String resultadoTipo);
	
	List<OddsPremierCup> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante);
	
	List<OddsPremierCup> findByTimeCasaOrderByResultadoTipoAsc(String timeVisitante);
	
	List<OddsPremierCup> findByHoraOrderByResultadoTipoAsc(String hora);
	
	List<OddsPremierCup> findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(String timeCasa, String timeVisitante);
	
	List<OddsPremierCup> findByTollTipIsNotNull();
	
	@Query("SELECT DISTINCT timeVisitante FROM OddsPremierCup WHERE timeCasa IS NOT NULL")
	List<String> findDistinctTimeVisitanteByTimeVisitanteIsNotNull();
	
	@Query("SELECT DISTINCT hora FROM OddsPremierCup WHERE tollTip IS NOT NULL")
	List<String> findDistinctHora();
	
	
	
	}
	

