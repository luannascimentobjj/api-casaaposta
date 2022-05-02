package br.casaaposta.main.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.casaaposta.main.business.LogBusiness;
import br.casaaposta.main.dto.OddsDTO;
import br.casaaposta.main.dto.PageDTO;
import br.casaaposta.main.entity.api.Log;
import br.casaaposta.main.entity.consumer.OddsSuperCup;
import br.casaaposta.main.interfaces.OddsSuperCupBusinessInterface;
import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@RequestMapping("/oddsSuperCup")
@Api(tags = "OddsSuperCup")
public class OddsSuperCupController {

	@Autowired 
	LogBusiness logger_;
	
	Log log = new Log();	
	
	@Autowired
	private OddsSuperCupBusinessInterface oddsSuperCupBusiness_;
	
	@GetMapping(value = "findAllOdds/{page}/{size}")
	public ResponseEntity<PageDTO> findAllOddsSuperCup(@PathVariable int page, @PathVariable int size) {

		try {
			
			PageDTO resultados = oddsSuperCupBusiness_.findByTollTipIsNotNull(PageRequest.of(page, size));
			return new ResponseEntity<>(resultados, HttpStatus.OK);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsSuperCupController.findAllOddsSuperCup");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}


	}
	
	@GetMapping(value = "findAllTeams/")
	public ResponseEntity<List<String>> findAllTeamsSuperCup() {
		
		try {
			
			List<String> resultados = oddsSuperCupBusiness_.findDistinctTimeVisitanteByTimeVisitanteIsNotNull();

			return new ResponseEntity<>(resultados, HttpStatus.OK);
			
		} catch (Exception e) {
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsSuperCupController.findAllTeams");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}

	}
	
	
	@GetMapping(value = "findAllHours/")
	public ResponseEntity<List<String>> findAllHoursSuperCup() {
		
		try {
			
			List<String> resultados = oddsSuperCupBusiness_.findDistinctHora();

			return new ResponseEntity<>(resultados, HttpStatus.OK);
			
		} catch (Exception e) {
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsSuperCupController.findAllHoursSuperCup");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}

	}
	
		
	@GetMapping(value = "findByDate/{date}")
	public ResponseEntity<List<OddsDTO>> findByDate(@PathVariable String date) {
		
		try {
		
			List<OddsSuperCup> results = oddsSuperCupBusiness_.findByDataOrderByResultadoTipoAsc(date);
			return new ResponseEntity<>(OddsDTO.converterToSuperCup(results), HttpStatus.OK);

		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsSuperCupController.findByDate");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
			
		}
		


	}
	
	@GetMapping(value = "findByType/{type}")
	public ResponseEntity<List<OddsDTO>> findResultsByType(@PathVariable String type) {
		
		try {

			List<OddsSuperCup> results = oddsSuperCupBusiness_.findByResultadoTipoOrderByResultadoTipoAsc(type);
			return new ResponseEntity<>(OddsDTO.converterToSuperCup(results), HttpStatus.OK);
		
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsSuperCupController.findByType");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
			
		}
		
	

	}
	
	@GetMapping(value = "findResultsByHomeTeam/{homeTeam}")
	public ResponseEntity<List<OddsDTO>> findResultsByTimeCasa(@PathVariable String homeTeam) {
		
		try {
			
			List<OddsSuperCup> results = oddsSuperCupBusiness_.findByTimeCasaOrderByResultadoTipoAsc(homeTeam);
			return new ResponseEntity<>(OddsDTO.converterToSuperCup(results), HttpStatus.OK);

		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsSuperCupController.findResultsByHomeTeam");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}
		
		

	}
	
	@GetMapping(value = "findResultsByVisitingTeam/{visitingTeam}")
	public ResponseEntity<List<OddsDTO>> findResultsByTimeVisitante(@PathVariable String timeVisitante) {
		
		try {
			
			List<OddsSuperCup> results = oddsSuperCupBusiness_.findByTimeVisitanteOrderByResultadoTipoAsc(timeVisitante);
			return new ResponseEntity<>(OddsDTO.converterToSuperCup(results), HttpStatus.OK);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsSuperCupController.findResultsByVisitingTeam");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
			
		}
		
	

	}
	
	@GetMapping(value = "findResultsByHour/{hour}")
	public ResponseEntity<List<OddsDTO>> findResultsByHour(@PathVariable String hour) {
		
		try {
			
			List<OddsSuperCup > results = oddsSuperCupBusiness_.findByHoraOrderByResultadoTipoAsc(hour);
			return new ResponseEntity<>(OddsDTO.converterToSuperCup(results), HttpStatus.OK);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsSuperCupController.findResultsByHour");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
			
		}
		
	}
	
	@GetMapping(value = "findMatch/{homeTeam}/{visitingTeam}")
	public ResponseEntity<List<OddsDTO>> findMatch(@PathVariable String homeTeam, @PathVariable String visitingTeam) {
		
		try {
			
			List<OddsSuperCup> results = oddsSuperCupBusiness_.findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(homeTeam, visitingTeam);
			return new ResponseEntity<>(OddsDTO.converterToSuperCup(results), HttpStatus.OK);

		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsSuperCupController.findMatch");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
			
		}

	}
	
}
