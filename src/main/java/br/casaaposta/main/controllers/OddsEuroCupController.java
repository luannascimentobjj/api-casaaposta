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
import br.casaaposta.main.entity.consumer.OddsEuroCup;
import br.casaaposta.main.interfaces.OddsEuroCupBusinessInterface;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/oddsEuroCup")
@Api(tags = "OddsEuroCup")
public class OddsEuroCupController {

	@Autowired
	private OddsEuroCupBusinessInterface oddsEuroCupBusiness_;
	
	@Autowired 
	LogBusiness logger_;
	
	Log log = new Log();	
	
	@GetMapping(value = "findAllOdds/")
	public ResponseEntity<List<OddsDTO>> findAllOddsEuroCup() {
		
		try {
			
			List<OddsEuroCup> resultados = oddsEuroCupBusiness_.findByTollTipIsNotNull();

			return new ResponseEntity<>(OddsDTO.converterToEuroCup(resultados), HttpStatus.OK);
			
		} catch (Exception e) {
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsEuroCupController.findOddsEuroCup");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}

	

	}
	
	
	@GetMapping(value = "findByDate/{date}")
	public ResponseEntity<List<OddsDTO>> findByDate(@PathVariable String date) {
		
		try {
			
			List<OddsEuroCup> results = oddsEuroCupBusiness_.findByDataOrderByResultadoTipoAsc(date);
			return new ResponseEntity<>(OddsDTO.converterToEuroCup(results), HttpStatus.OK);
			
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
			
			List<OddsEuroCup> results = oddsEuroCupBusiness_.findByResultadoTipoOrderByResultadoTipoAsc(type);
			return new ResponseEntity<>(OddsDTO.converterToEuroCup(results), HttpStatus.OK);
			
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
			
			List<OddsEuroCup> results = oddsEuroCupBusiness_.findByTimeCasaOrderByResultadoTipoAsc(homeTeam);
			return new ResponseEntity<>(OddsDTO.converterToEuroCup(results), HttpStatus.OK);
			
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
			
			List<OddsEuroCup> results = oddsEuroCupBusiness_.findByTimeVisitanteOrderByResultadoTipoAsc(visitingTeam);
			return new ResponseEntity<>(OddsDTO.converterToEuroCup(results), HttpStatus.OK);
		
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
			
			List<OddsEuroCup> results = oddsEuroCupBusiness_.findByHoraOrderByResultadoTipoAsc(hour);
			return new ResponseEntity<>(OddsDTO.converterToEuroCup(results), HttpStatus.OK);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsEuroCupController.findResultsByHour");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
			
		}
		


	}
	
	@GetMapping(value = "findMatch/{homeTeam}/{visitingTeam}")
	public ResponseEntity<List<OddsDTO>> findMatch(@PathVariable String homeTeam, String visitingTeam) {
		
		try {
			
			List<OddsEuroCup> results = oddsEuroCupBusiness_.findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(homeTeam, visitingTeam);
			return new ResponseEntity<>(OddsDTO.converterToEuroCup(results), HttpStatus.OK);

		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsEuroCupController.findMatch");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
			
		}
		
		

	}
}
