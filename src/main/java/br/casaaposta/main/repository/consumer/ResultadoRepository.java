package br.casaaposta.main.repository.consumer;

import org.springframework.data.jpa.repository.JpaRepository;

import br.casaaposta.main.entity.consumer.Resultado;

public interface ResultadoRepository extends JpaRepository<Resultado, Long>{
	

	Resultado findByTollTipAndMinutoAndHoraAndResultadoTipo(String toolTip, int minuto, int hora, String resultadoTipo);
		
	}


