package br.casaaposta.main.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.casaaposta.main.business.LogBusiness;
import br.casaaposta.main.dto.OddsDTO;
import br.casaaposta.main.entity.api.Log;
import br.casaaposta.main.entity.consumer.OddsWorldCup;
import br.casaaposta.main.interfaces.OddsWorldCupBusinessInterface;
import io.swagger.annotations.Api;



@RestController
@RequestMapping("/oddsWorldCup")
@Api(tags = "OddsWorldCup")
public class OddsWorldCupController {
	
	@Autowired
	private OddsWorldCupBusinessInterface oddsWorldCupBusiness_;
	
	@Autowired 
	LogBusiness logger_;
	
	Log log = new Log();
	
	@GetMapping(value = "findAllOdds")
	public ResponseEntity<List<OddsDTO>> findAllOddsWorldCup() {
		
		try {

			List<OddsWorldCup> resultados = oddsWorldCupBusiness_.findByTollTipIsNotNull();
			return new ResponseEntity<>(OddsDTO.converterToWorldCup(resultados), HttpStatus.OK);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsWorldCupController.findAllOddsWorldCup");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
			
		}


	}
	
	@GetMapping(value = "findAllTeams/")
	public ResponseEntity<List<String>> findAllTeamsWorldCup() {
		
		try {
			
			List<String> resultados = oddsWorldCupBusiness_.findDistinctTimeVisitanteByTimeVisitanteIsNotNull();

			return new ResponseEntity<>(resultados, HttpStatus.OK);
			
		} catch (Exception e) {
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsWorldCupController.findAllTeamsWorldCup");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}

	}
	
	@GetMapping(value = "findAllHours/")
	public ResponseEntity<List<String>> findAllHoursWorldCup() {
		
		try {
			
			List<String> resultados = oddsWorldCupBusiness_.findDistinctHora();

			return new ResponseEntity<>(resultados, HttpStatus.OK);
			
		} catch (Exception e) {
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsWorldCupController.findAllHoursWorldCup");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}

	}
	
	@GetMapping(value = "findByDate/{date}")
	public ResponseEntity<List<OddsDTO>> findByDate(@PathVariable String date) {
		
		try {
			
			List<OddsWorldCup> results = oddsWorldCupBusiness_.findByDataOrderByResultadoTipoAsc(date);
			return new ResponseEntity<>(OddsDTO.converterToWorldCup(results), HttpStatus.OK);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsWorldCupController.findByDate");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}
		


	}
	
	@GetMapping(value = "findByType/{type}")
	public ResponseEntity<List<OddsDTO>> findResultsByType(@PathVariable String type) {
		
		try {

			List<OddsWorldCup> results = oddsWorldCupBusiness_.findByResultadoTipoOrderByResultadoTipoAsc(type);
			return new ResponseEntity<>(OddsDTO.converterToWorldCup(results), HttpStatus.OK);
		
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsWorldCupController.findByType");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}
		
	

	}
	
	@GetMapping(value = "findResultsByHomeTeam/{homeTeam}")
	public ResponseEntity<List<OddsDTO>> findResultsByHomeTeam(@PathVariable String homeTeam) {
		
		try {

			List<OddsWorldCup> results = oddsWorldCupBusiness_.findByTimeCasaOrderByResultadoTipoAsc(homeTeam);
			return new ResponseEntity<>(OddsDTO.converterToWorldCup(results), HttpStatus.OK);

		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsWorldCupController.findResultsByHomeTeam");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}
		
	
	}
	
	@GetMapping(value = "findResultsByVisitingTeam/{visitingTeam}")
	public ResponseEntity<List<OddsDTO>> findResultsByVisitingTeam(@PathVariable String visitingTeam) {
		
		try {

			List<OddsWorldCup> results = oddsWorldCupBusiness_.findByTimeVisitanteOrderByResultadoTipoAsc(visitingTeam);
			return new ResponseEntity<>(OddsDTO.converterToWorldCup(results), HttpStatus.OK);

		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsWorldCupController.findResultsByVisitingTeam");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}
		
		
	}
	
	@GetMapping(value = "findResultsByHour/{hour}")
	public ResponseEntity<List<OddsDTO>> findResultsByHour(@PathVariable String hour) {
		
		try {

			List<OddsWorldCup> results = oddsWorldCupBusiness_.findByHoraOrderByResultadoTipoAsc(hour);
			return new ResponseEntity<>(OddsDTO.converterToWorldCup(results), HttpStatus.OK);

		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsWorldCupController.findResultsByHour");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
			
		}
		
	}
	
	@GetMapping(value = "findMatch/{homeTeam}/{visitingTeam}")
	public ResponseEntity<List<OddsDTO>> findMatch(@PathVariable String homeTeam, String visitingTeam) {
		
		try {
			
			List<OddsWorldCup> results = oddsWorldCupBusiness_.findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(homeTeam, visitingTeam);
			return new ResponseEntity<>(OddsDTO.converterToWorldCup(results), HttpStatus.OK);

		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsWorldCupController.findMatch");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
			
		}

	}

}
