package br.casaaposta.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.casaaposta.main.data.OddsEuroCupData;
import br.casaaposta.main.dto.OddsDTO;
import br.casaaposta.main.entity.consumer.OddsEuroCup;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/oddsEuroCup")
@Api(tags = "OddsEuroCup")
public class OddsEuroCupController {

	@Autowired
	private OddsEuroCupData oddsEuroCupData_;
		
	
	@GetMapping(value = "findOdds/")
	public ResponseEntity<List<OddsDTO>> findOddsEuroCup() {

		List<OddsEuroCup> resultados = oddsEuroCupData_.findAll();

		return new ResponseEntity<>(OddsDTO.converterToEuroCup(resultados), HttpStatus.OK);

	}
	
	
	@GetMapping(value = "findByDate/{date}")
	public ResponseEntity<List<OddsDTO>> findResultsByData(@PathVariable String date) {
		List<OddsEuroCup> results = oddsEuroCupData_.findByDataOrderByResultadoTipoAsc(date.replace("-", "/"));

		return new ResponseEntity<>(OddsDTO.converterToEuroCup(results), HttpStatus.OK);

	}
	
	@GetMapping(value = "findByType/{type}")
	public ResponseEntity<List<OddsDTO>> findResultsByType(@PathVariable String type) {
		List<OddsEuroCup> results = oddsEuroCupData_.findByResultadoTipoOrderByResultadoTipoAsc(type);

		return new ResponseEntity<>(OddsDTO.converterToEuroCup(results), HttpStatus.OK);

	}
	
	@GetMapping(value = "findResultsByTimeCasa/{timeCasa}")
	public ResponseEntity<List<OddsDTO>> findResultsByTimeCasa(@PathVariable String timeCasa) {
		List<OddsEuroCup> results = oddsEuroCupData_.findByTimeCasaOrderByResultadoTipoAsc(timeCasa);

		return new ResponseEntity<>(OddsDTO.converterToEuroCup(results), HttpStatus.OK);

	}
	
	@GetMapping(value = "findResultsByTimeVisitante/{timeVisitante}")
	public ResponseEntity<List<OddsDTO>> findResultsByTimeVisitante(@PathVariable String timeVisitante) {
		List<OddsEuroCup> results = oddsEuroCupData_.findByTimeVisitanteOrderByResultadoTipoAsc(timeVisitante);

		return new ResponseEntity<>(OddsDTO.converterToEuroCup(results), HttpStatus.OK);

	}
	
	@GetMapping(value = "findResultsByHora/{hora}")
	public ResponseEntity<List<OddsDTO>> findResultsByHora(@PathVariable String hora) {
		List<OddsEuroCup> results = oddsEuroCupData_.findByHoraOrderByResultadoTipoAsc(hora);

		return new ResponseEntity<>(OddsDTO.converterToEuroCup(results), HttpStatus.OK);

	}
	
	@GetMapping(value = "findJogo/{timeCasa}/{timeVisitante}")
	public ResponseEntity<List<OddsDTO>> findJogo(@PathVariable String timeCasa, String timeVisitante) {
		List<OddsEuroCup> results = oddsEuroCupData_.findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(timeCasa, timeVisitante);

		return new ResponseEntity<>(OddsDTO.converterToEuroCup(results), HttpStatus.OK);

	}
}
