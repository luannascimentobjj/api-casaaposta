package br.casaaposta.main.repository.consumer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.casaaposta.main.entity.consumer.Liga;
import br.casaaposta.main.entity.consumer.Resultado;

public interface ResultadoRepository extends JpaRepository<Resultado, Long>{
	

	Resultado findByTollTipAndMinutoAndHoraAndResultadoTipo(String toolTip, int minuto, int hora, String resultadoTipo);
	
	List<Resultado> findByCodLigaOrderByResultadoTipoAsc(Liga liga);
	
	List<Resultado> findByDataOrderByResultadoTipoAsc(String data);
	
	List<Resultado> findByResultadoTipoOrderByResultadoTipoAsc(String resultadoTipo);
	
	List<Resultado> findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(String timeCasa, String timeVisitante);
	
	List<Resultado> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante);
	
	List<Resultado> findByTimeCasaOrderByResultadoTipoAsc(String timeVisitante);
	
	List<Resultado> findByHoraOrderByResultadoTipoAsc(String hora);
		
	}


