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
import br.casaaposta.main.entity.consumer.OddsPremierCup;
import br.casaaposta.main.interfaces.OddsPremierCupBusinessInterface;
import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@RequestMapping("/oddsPremierCup")
@Api(tags = "OddsPremierCup")
public class OddsPremierCupController {

	@Autowired 
	LogBusiness logger_;
	
	Log log = new Log();	

	@Autowired
	private OddsPremierCupBusinessInterface oddsPremierCupBusiness_;
	
	@GetMapping(value = "findAllOdds/{page}/{size}")
	public ResponseEntity<PageDTO> findAllOddsPremierCup(@PathVariable int page, @PathVariable int size) {
		
		try {
			
			PageDTO resultados = oddsPremierCupBusiness_.findByTollTipIsNotNull(PageRequest.of(page, size));
			return new ResponseEntity<>(resultados, HttpStatus.OK);			
			

		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsPremierCupController.findAllOddsPremierCup");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}

		

	}
	
	@GetMapping(value = "findAllTeams/")
	public ResponseEntity<List<String>> findAllTeamsPremierCup() {
		
		try {
			
			List<String> resultados = oddsPremierCupBusiness_.findDistinctTimeVisitanteByTimeVisitanteIsNotNull();

			return new ResponseEntity<>(resultados, HttpStatus.OK);
			
		} catch (Exception e) {
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsPremierCupController.findAllTeamsPremierCup");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}

	}
	
	
	@GetMapping(value = "findAllHours/")
	public ResponseEntity<List<String>> findAllHoursPremierCup() {
		
		try {
			
			List<String> resultados = oddsPremierCupBusiness_.findDistinctHora();

			return new ResponseEntity<>(resultados, HttpStatus.OK);
			
		} catch (Exception e) {
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsPremierCupController.findAllHoursPremierCup");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}

	}
	
	@GetMapping(value = "findByDate/{date}")
	public ResponseEntity<List<OddsDTO>> findResultsByDate(@PathVariable String date) {
		
		try {
			
			List<OddsPremierCup> results = oddsPremierCupBusiness_.findByDataOrderByResultadoTipoAsc(date);
			return new ResponseEntity<>(OddsDTO.converterToPremierCup(results), HttpStatus.OK);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsPremierCupController.findResultsByDate");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}


	}
	
	@GetMapping(value = "findByType/{type}")
	public ResponseEntity<List<OddsDTO>> findResultsByType(@PathVariable String type) {
		
		try {
			
			List<OddsPremierCup> results = oddsPremierCupBusiness_.findByResultadoTipoOrderByResultadoTipoAsc(type);
			return new ResponseEntity<>(OddsDTO.converterToPremierCup(results), HttpStatus.OK);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsPremierCupController.findByType");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
			
		}
		
	

	}
	
	@GetMapping(value = "findResultsByHomeTeam/{homeTeam}")
	public ResponseEntity<List<OddsDTO>> findResultsByHomeTeam(@PathVariable String homeTeam) {
		
		try {
			
			List<OddsPremierCup> results = oddsPremierCupBusiness_.findByTimeCasaOrderByResultadoTipoAsc(homeTeam);
			return new ResponseEntity<>(OddsDTO.converterToPremierCup(results), HttpStatus.OK);

		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsPremierCupController.findResultsByHomeTeam");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}
		


	}
	
	@GetMapping(value = "findResultsByVisitingTeam/{visitingTeam}")
	public ResponseEntity<List<OddsDTO>> findResultsByVisitingTeam(@PathVariable String visitingTeam) {
		
		try {
			
			List<OddsPremierCup> results = oddsPremierCupBusiness_.findByTimeVisitanteOrderByResultadoTipoAsc(visitingTeam);
			return new ResponseEntity<>(OddsDTO.converterToPremierCup(results), HttpStatus.OK);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsPremierCupController.findResultsByVisitingTeam");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}
	
	}
	
	@GetMapping(value = "findResultsByHour/{hour}")
	public ResponseEntity<List<OddsDTO>> findResultsByHour(@PathVariable int hour) {
		
		try {
			
			List<OddsPremierCup> results = oddsPremierCupBusiness_.findByHoraOrderByResultadoTipoAsc(hour);
			return new ResponseEntity<>(OddsDTO.converterToPremierCup(results), HttpStatus.OK);

		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsPremierCupController.findResultsByHour");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
			
		}
	
	}
	
	
	@GetMapping(value = "findMatch/{homeTeam}/{visitingTeam}")
	public ResponseEntity<List<OddsDTO>> findMatch(@PathVariable String homeTeam, @PathVariable String visitingTeam) {
		
		try {
			
			List<OddsPremierCup> results = oddsPremierCupBusiness_.findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(homeTeam, visitingTeam);
			return new ResponseEntity<>(OddsDTO.converterToPremierCup(results), HttpStatus.OK);

		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsPremierCupController.findMatch");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
			
		}

	}
}
