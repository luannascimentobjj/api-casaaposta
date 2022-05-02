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
import br.casaaposta.main.interfaces.OddsEuroCupBusinessInterface;
import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@RequestMapping("/oddsEuroCup")
@Api(tags = "OddsEuroCup")
public class OddsEuroCupController {

	@Autowired
	private OddsEuroCupBusinessInterface oddsEuroCupBusiness_;
	
	@Autowired 
	LogBusiness logger_;
	
	Log log = new Log();	
	
	@GetMapping(value = "findAllOdds/{page}/{size}")
	public ResponseEntity<PageDTO> findAllOddsEuroCup(@PathVariable int page, @PathVariable int size) {
		
		try {
			
			PageDTO resultados = oddsEuroCupBusiness_.findByTollTipIsNotNull(PageRequest.of(page, size));
			return new ResponseEntity<>(resultados, HttpStatus.OK);
			
		} catch (Exception e) {
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsEuroCupController.findOddsEuroCup");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}

	}
	
	
	@GetMapping(value = "findAllTeams/")
	public ResponseEntity<List<String>> findAllTeamsEuroCup() {
		
		try {
			
			List<String> resultados = oddsEuroCupBusiness_.findDistinctTimeVisitanteByTimeVisitanteIsNotNull();
			return new ResponseEntity<>(resultados, HttpStatus.OK);
			
		} catch (Exception e) {
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsEuroCupController.findOddsEuroCup");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}

	}
	
	@GetMapping(value = "findAllHours/")
	public ResponseEntity<List<String>> findAllHoursEuroCup() {
		
		try {
			
			List<String> resultados = oddsEuroCupBusiness_.findDistinctHora();

			return new ResponseEntity<>(resultados, HttpStatus.OK);
			
		} catch (Exception e) {
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsEuroCupController.findAllHoursEuroCup");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}

	}
	
	
	@GetMapping(value = "findByDate/{date}")
	public ResponseEntity<List<OddsDTO>> findByDate(@PathVariable String date) {
		
		try {
			
			List<OddsDTO> results = oddsEuroCupBusiness_.findByDataOrderByResultadoTipoAsc(date);
			return new ResponseEntity<>(results, HttpStatus.OK);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsEuroCupController.findByDate");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
			
		}
		
	

	}
	
	@GetMapping(value = "findByType/{type}")
	public ResponseEntity<List<OddsDTO>> findResultsByType(@PathVariable String type) {
		
		try {
			
			List<OddsDTO> results = oddsEuroCupBusiness_.findByResultadoTipoOrderByResultadoTipoAsc(type);
			return new ResponseEntity<>(results, HttpStatus.OK);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsEuroCupController.findResultsByType");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
			
		}
		


	}
	
	@GetMapping(value = "findResultsByHomeTeam/{homeTeam}")
	public ResponseEntity<List<OddsDTO>> findResultsByHomeTeam(@PathVariable String homeTeam) {
		
		try {
			
			List<OddsDTO> results = oddsEuroCupBusiness_.findByTimeCasaOrderByResultadoTipoAsc(homeTeam);
			return new ResponseEntity<>(results, HttpStatus.OK);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsEuroCupController.findResultsByHomeTeam");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
			
		}
		


	}
	
	@GetMapping(value = "findResultsByVisitingTeam/{visitingTeam}")
	public ResponseEntity<List<OddsDTO>> findResultsByVisitingTeam(@PathVariable String visitingTeam) {
		
		try {
			
			List<OddsDTO> results = oddsEuroCupBusiness_.findByTimeVisitanteOrderByResultadoTipoAsc(visitingTeam);
			return new ResponseEntity<>(results, HttpStatus.OK);
		
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsEuroCupController.findResultsByVisitingTeam");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}
		
	

	}
	
	@GetMapping(value = "findResultsByHour/{hour}")
	public ResponseEntity<List<OddsDTO>> findResultsByHour(@PathVariable String hour) {
		
		try {
			
			List<OddsDTO> results = oddsEuroCupBusiness_.findByHoraOrderByResultadoTipoAsc(hour);
			return new ResponseEntity<>(results, HttpStatus.OK);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsEuroCupController.findResultsByHour");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
			
		}
		


	}
	
	@GetMapping(value = "findMatch/{homeTeam}/{visitingTeam}")
	public ResponseEntity<List<OddsDTO>> findMatch(@PathVariable String homeTeam, @PathVariable String visitingTeam) {
		
		try {
			
			List<OddsDTO> results = oddsEuroCupBusiness_.findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(homeTeam, visitingTeam);
			return new ResponseEntity<>(results, HttpStatus.OK);

		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsEuroCupController.findMatch");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
			
		}
		
		

	}
}
