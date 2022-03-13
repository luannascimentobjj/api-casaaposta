package br.casaaposta.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.casaaposta.main.dto.OddsDTO;
import br.casaaposta.main.entity.consumer.OddsSuperCup;
import br.casaaposta.main.repository.consumer.OddsSuperCupRepository;

@Controller
@RequestMapping("/oddsSuperCup")
public class OddsSuperCupController {

	@Autowired
	private OddsSuperCupRepository oddsSuperCupRepository_;
	
	@GetMapping(value = "findOdds/")
	public ResponseEntity<List<OddsDTO>> findOddsSuperCup() {

		List<OddsSuperCup> resultados = oddsSuperCupRepository_.findAll();

		return new ResponseEntity<>(OddsDTO.converterToSuperCup(resultados), HttpStatus.OK);

	}
	
	
	
	@GetMapping(value = "findByDate/{date}")
	public ResponseEntity<List<OddsDTO>> findResultsByData(@PathVariable String date) {
		List<OddsSuperCup> results = oddsSuperCupRepository_.findByDataOrderByResultadoTipoAsc(date.replace("-", "/"));

		return new ResponseEntity<>(OddsDTO.converterToSuperCup(results), HttpStatus.OK);

	}
	
	@GetMapping(value = "findByType/{type}")
	public ResponseEntity<List<OddsDTO>> findResultsByType(@PathVariable String type) {
		List<OddsSuperCup> results = oddsSuperCupRepository_.findByResultadoTipoOrderByResultadoTipoAsc(type);

		return new ResponseEntity<>(OddsDTO.converterToSuperCup(results), HttpStatus.OK);

	}
	
	@GetMapping(value = "findResultsByTimeCasa/{timeCasa}")
	public ResponseEntity<List<OddsDTO>> findResultsByTimeCasa(@PathVariable String timeCasa) {
		List<OddsSuperCup> results = oddsSuperCupRepository_.findByTimeCasaOrderByResultadoTipoAsc(timeCasa);

		return new ResponseEntity<>(OddsDTO.converterToSuperCup(results), HttpStatus.OK);

	}
	
	@GetMapping(value = "findResultsByTimeVisitante/{timeVisitante}")
	public ResponseEntity<List<OddsDTO>> findResultsByTimeVisitante(@PathVariable String timeVisitante) {
		List<OddsSuperCup> results = oddsSuperCupRepository_.findByTimeVisitanteOrderByResultadoTipoAsc(timeVisitante);

		return new ResponseEntity<>(OddsDTO.converterToSuperCup(results), HttpStatus.OK);

	}
	
	@GetMapping(value = "findResultsByHora/{hora}")
	public ResponseEntity<List<OddsDTO>> findResultsByHora(@PathVariable String hora) {
		List<OddsSuperCup > results = oddsSuperCupRepository_.findByHoraOrderByResultadoTipoAsc(hora);

		return new ResponseEntity<>(OddsDTO.converterToSuperCup(results), HttpStatus.OK);

	}
	
}
