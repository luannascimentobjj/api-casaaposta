package br.casaaposta.main.repository.consumer;
import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import br.casaaposta.main.entity.consumer.OddsEuroCup;
import org.springframework.data.jpa.repository.Query;

public interface OddsEuroCupRepository extends JpaRepository<OddsEuroCup, Long> {

	OddsEuroCup findByTollTipAndMinutoAndHoraAndResultadoTipo(String toolTip, int minuto, int hora, String resultadoTipo);
			
	List<OddsEuroCup> findByDataOrderByResultadoTipoAsc(String data);
	
	List<OddsEuroCup> findByResultadoTipoOrderByResultadoTipoAsc(String resultadoTipo);
	
	List<OddsEuroCup> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante);
	
	List<OddsEuroCup> findByTimeCasaOrderByResultadoTipoAsc(String timeVisitante);
	
	List<OddsEuroCup> findByHoraOrderByResultadoTipoAsc(int hora);
	
	List<OddsEuroCup> findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(String timeCasa, String timeVisitante);
	
	Page<OddsEuroCup> findByTollTipIsNotNull(Pageable pageable);
	
	@Query("SELECT DISTINCT timeVisitante FROM OddsEuroCup WHERE timeCasa IS NOT NULL")
	List<String> findDistinctTimeVisitanteByTimeVisitanteIsNotNull();
	
	@Query("SELECT DISTINCT hora FROM OddsEuroCup WHERE tollTip IS NOT NULL")
	List<String> findDistinctHora();
	
	

	}
	

