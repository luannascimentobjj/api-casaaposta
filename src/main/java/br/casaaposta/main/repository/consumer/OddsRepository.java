package br.casaaposta.main.repository.consumer;

import org.springframework.data.jpa.repository.JpaRepository;

import br.casaaposta.main.entity.consumer.OddsEuroCup;

public interface OddsRepository extends JpaRepository<OddsEuroCup, Long> {

	OddsEuroCup findByTollTipAndMinutoAndHoraAndResultadoTipo(String toolTip, int minuto, int hora, String resultadoTipo);
		
	}
	

