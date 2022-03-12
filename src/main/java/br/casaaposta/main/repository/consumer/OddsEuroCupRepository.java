package br.casaaposta.main.repository.consumer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.casaaposta.main.entity.consumer.OddsEuroCup;

public interface OddsEuroCupRepository extends JpaRepository<OddsEuroCup, Long> {

	OddsEuroCup findByTollTipAndMinutoAndHoraAndResultadoTipo(String toolTip, int minuto, int hora, String resultadoTipo);
			
	List<OddsEuroCup> findByDataOrderByResultadoTipoAsc(String data);
	
	List<OddsEuroCup> findByResultadoTipoOrderByResultadoTipoAsc(String resultadoTipo);
	
	List<OddsEuroCup> findAll();
	
	}
	

