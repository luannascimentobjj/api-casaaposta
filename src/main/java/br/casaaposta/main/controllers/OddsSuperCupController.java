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
import br.casaaposta.main.entity.consumer.OddsSuperCup;
import br.casaaposta.main.interfaces.OddsSuperCupDataInterface;
import br.casaaposta.main.repository.consumer.OddsSuperCupRepository;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/oddsSuperCup")
@Api(tags = "OddsSuperCup")
public class OddsSuperCupController {

	@Autowired
	private OddsSuperCupDataInterface oddsSuperCupData_;
	
	@GetMapping(value = "findOdds/")
	public ResponseEntity<List<OddsDTO>> findOddsSuperCup() {

		List<OddsSuperCup> resultados = oddsSuperCupData_.findAll();

		return new ResponseEntity<>(OddsDTO.converterToSuperCup(resultados), HttpStatus.OK);

	}
	
		
	@GetMapping(value = "findByDate/{date}")
	public ResponseEntity<List<OddsDTO>> findResultsByData(@PathVariable String date) {
		List<OddsSuperCup> results = oddsSuperCupData_.findByDataOrderByResultadoTipoAsc(date);

		return new ResponseEntity<>(OddsDTO.converterToSuperCup(results), HttpStatus.OK);

	}
	
	@GetMapping(value = "findByType/{type}")
	public ResponseEntity<List<OddsDTO>> findResultsByType(@PathVariable String type) {
		List<OddsSuperCup> results = oddsSuperCupData_.findByResultadoTipoOrderByResultadoTipoAsc(type);

		return new ResponseEntity<>(OddsDTO.converterToSuperCup(results), HttpStatus.OK);

	}
	
	@GetMapping(value = "findResultsByTimeCasa/{timeCasa}")
	public ResponseEntity<List<OddsDTO>> findResultsByTimeCasa(@PathVariable String timeCasa) {
		List<OddsSuperCup> results = oddsSuperCupData_.findByTimeCasaOrderByResultadoTipoAsc(timeCasa);

		return new ResponseEntity<>(OddsDTO.converterToSuperCup(results), HttpStatus.OK);

	}
	
	@GetMapping(value = "findResultsByTimeVisitante/{timeVisitante}")
	public ResponseEntity<List<OddsDTO>> findResultsByTimeVisitante(@PathVariable String timeVisitante) {
		List<OddsSuperCup> results = oddsSuperCupData_.findByTimeVisitanteOrderByResultadoTipoAsc(timeVisitante);

		return new ResponseEntity<>(OddsDTO.converterToSuperCup(results), HttpStatus.OK);

	}
	
	@GetMapping(value = "findResultsByHora/{hora}")
	public ResponseEntity<List<OddsDTO>> findResultsByHora(@PathVariable String hora) {
		List<OddsSuperCup > results = oddsSuperCupData_.findByHoraOrderByResultadoTipoAsc(hora);

		return new ResponseEntity<>(OddsDTO.converterToSuperCup(results), HttpStatus.OK);

	}
	
}
