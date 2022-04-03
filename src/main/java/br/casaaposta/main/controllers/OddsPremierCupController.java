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
import br.casaaposta.main.entity.consumer.OddsPremierCup;
import br.casaaposta.main.interfaces.OddsPremierCupDataInterface;
import br.casaaposta.main.repository.consumer.OddsPremierCupRepository;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/oddsPremierCup")
@Api(tags = "OddsPremierCup")
public class OddsPremierCupController {

	

	@Autowired
	private OddsPremierCupDataInterface oddsPremierCupData_;
	
	@GetMapping(value = "findOdds/")
	public ResponseEntity<List<OddsDTO>> findOddsPremierCup() {

		List<OddsPremierCup> resultados = oddsPremierCupData_.findAll();

		return new ResponseEntity<>(OddsDTO.converterToPremierCup(resultados), HttpStatus.OK);

	}
	
	
	@GetMapping(value = "findByDate/{date}")
	public ResponseEntity<List<OddsDTO>> findResultsByData(@PathVariable String date) {
		
		List<OddsPremierCup> results = oddsPremierCupData_.findByDataOrderByResultadoTipoAsc(date);

		return new ResponseEntity<>(OddsDTO.converterToPremierCup(results), HttpStatus.OK);

	}
	
	@GetMapping(value = "findByType/{type}")
	public ResponseEntity<List<OddsDTO>> findResultsByType(@PathVariable String type) {
		
		List<OddsPremierCup> results = oddsPremierCupData_.findByResultadoTipoOrderByResultadoTipoAsc(type);
		
		return new ResponseEntity<>(OddsDTO.converterToPremierCup(results), HttpStatus.OK);

	}
	
	@GetMapping(value = "findResultsByTimeCasa/{timeCasa}")
	public ResponseEntity<List<OddsDTO>> findResultsByTimeCasa(@PathVariable String timeCasa) {
		
		List<OddsPremierCup> results = oddsPremierCupData_.findByTimeCasaOrderByResultadoTipoAsc(timeCasa);

		return new ResponseEntity<>(OddsDTO.converterToPremierCup(results), HttpStatus.OK);

	}
	
	@GetMapping(value = "findResultsByTimeVisitante/{timeVisitante}")
	public ResponseEntity<List<OddsDTO>> findResultsByTimeVisitante(@PathVariable String timeVisitante) {
		
		List<OddsPremierCup> results = oddsPremierCupData_.findByTimeVisitanteOrderByResultadoTipoAsc(timeVisitante);

		return new ResponseEntity<>(OddsDTO.converterToPremierCup(results), HttpStatus.OK);

	}
	
	@GetMapping(value = "findResultsByHora/{hora}")
	public ResponseEntity<List<OddsDTO>> findResultsByHora(@PathVariable String hora) {
		List<OddsPremierCup> results = oddsPremierCupData_.findByHoraOrderByResultadoTipoAsc(hora);

		return new ResponseEntity<>(OddsDTO.converterToPremierCup(results), HttpStatus.OK);

	}
}
