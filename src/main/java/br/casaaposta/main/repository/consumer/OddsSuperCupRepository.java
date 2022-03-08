package br.casaaposta.main.repository.consumer;

import org.springframework.data.jpa.repository.JpaRepository;

import br.casaaposta.main.entity.consumer.OddsEuroCup;
import br.casaaposta.main.entity.consumer.OddsSuperCup;

public interface OddsSuperCupRepository extends JpaRepository<OddsSuperCup, Long> {

	OddsEuroCup findByTollTipAndMinutoAndHoraAndResultadoTipo(String toolTip, int minuto, int hora, String resultadoTipo);
		
	}
	

