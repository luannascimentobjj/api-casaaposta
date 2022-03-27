package br.casaaposta.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.casaaposta.main.dto.OddsDTO;
import br.casaaposta.main.entity.consumer.OddsWorldCup;
import br.casaaposta.main.repository.consumer.OddsWorldCupRepository;
import io.swagger.annotations.Api;



@RestController
@RequestMapping("/oddsWorldCup")
@Api(tags = "OddsWorldCup")
public class OddsWorldCupController {
	
	@Autowired
	private OddsWorldCupRepository oddsWorldCupRepository_;
	

	
	@GetMapping(value = "findOdds")
	public ResponseEntity<List<OddsDTO>> findOddsWorldCup() {

		List<OddsWorldCup> resultados = oddsWorldCupRepository_.findAll();

		return new ResponseEntity<>(OddsDTO.converterToWorldCup(resultados), HttpStatus.OK);

	}
	
	@GetMapping(value = "findByDate/{date}")
	public ResponseEntity<List<OddsDTO>> findResultsByData(@PathVariable String date) {
		List<OddsWorldCup> results = oddsWorldCupRepository_.findByDataOrderByResultadoTipoAsc(date.replace("-", "/"));

		return new ResponseEntity<>(OddsDTO.converterToWorldCup(results), HttpStatus.OK);

	}
	
	@GetMapping(value = "findByType/{type}")
	public ResponseEntity<List<OddsDTO>> findResultsByType(@PathVariable String type) {
		List<OddsWorldCup> results = oddsWorldCupRepository_.findByResultadoTipoOrderByResultadoTipoAsc(type);

		return new ResponseEntity<>(OddsDTO.converterToWorldCup(results), HttpStatus.OK);

	}
	
	@GetMapping(value = "findResultsByTimeCasa/{timeCasa}")
	public ResponseEntity<List<OddsDTO>> findResultsByTimeCasa(@PathVariable String timeCasa) {
		List<OddsWorldCup> results = oddsWorldCupRepository_.findByTimeCasaOrderByResultadoTipoAsc(timeCasa);

		return new ResponseEntity<>(OddsDTO.converterToWorldCup(results), HttpStatus.OK);

	}
	
	@GetMapping(value = "findResultsByTimeVisitante/{timeVisitante}")
	public ResponseEntity<List<OddsDTO>> findResultsByTimeVisitante(@PathVariable String timeVisitante) {
		List<OddsWorldCup> results = oddsWorldCupRepository_.findByTimeVisitanteOrderByResultadoTipoAsc(timeVisitante);

		return new ResponseEntity<>(OddsDTO.converterToWorldCup(results), HttpStatus.OK);

	}
	
	@GetMapping(value = "findResultsByHora/{hora}")
	public ResponseEntity<List<OddsDTO>> findResultsByHora(@PathVariable String hora) {
		List<OddsWorldCup > results = oddsWorldCupRepository_.findByHoraOrderByResultadoTipoAsc(hora);

		return new ResponseEntity<>(OddsDTO.converterToWorldCup(results), HttpStatus.OK);

	}

}
