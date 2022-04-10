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
import br.casaaposta.main.dto.ResultadoDTO;
import br.casaaposta.main.dto.TipoResultadoDTO;
import br.casaaposta.main.entity.api.Log;
import br.casaaposta.main.entity.consumer.Liga;
import br.casaaposta.main.entity.consumer.Resultado;
import br.casaaposta.main.entity.consumer.TipoResultado;
import br.casaaposta.main.interfaces.TipoResultadoBusinessInterface;
import br.casaaposta.main.repository.consumer.ResultadoRepository;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/results")
@Api(tags = "Result")
public class ResultController {

	@Autowired
	private ResultadoRepository resultadoBusiness_;
	@Autowired 
	private TipoResultadoBusinessInterface tipoResultadoBusiness_;
	@Autowired 
	LogBusiness logger_;
	Log log = new Log();
	
	@GetMapping(value = "findByCodLeague/{codLeague}")
	public ResponseEntity<List<ResultadoDTO>> findResultsByCodLeague(@PathVariable String codLeague) {
		
		try {
			
			List<Resultado> resultados = resultadoBusiness_.findByCodLigaOrderByResultadoTipoAsc(new Liga(codLeague));
			return new ResponseEntity<>(ResultadoDTO.converter(resultados), HttpStatus.OK);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, ResultController.findResultsByCodLeague");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}

		

	}

	@GetMapping(value = "findByDate/{date}")
	public ResponseEntity<List<ResultadoDTO>> findResultsByDate(@PathVariable String date) {
		
		try {

			List<Resultado> resultados = resultadoBusiness_.findByDataOrderByResultadoTipoAsc(date);
			return new ResponseEntity<>(ResultadoDTO.converter(resultados), HttpStatus.OK);
		
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, ResultController.findResultsByDate");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}
		
	

	}
	
	@GetMapping(value = "findByType/{type}")
	public ResponseEntity<List<ResultadoDTO>> findResultsByType(@PathVariable String type) {
		
		try {

			List<Resultado> resultados = resultadoBusiness_.findByResultadoTipoOrderByResultadoTipoAsc(type);
			return new ResponseEntity<>(ResultadoDTO.converter(resultados), HttpStatus.OK);

		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, ResultController.findResultsByType");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}
		
		
	}
	
	@GetMapping(value = "findAllResultsType/")
	public ResponseEntity<List<TipoResultadoDTO>> findAllResultsType() {

		try {

			List<TipoResultado> resultsTypes = tipoResultadoBusiness_.findAll();
			return new ResponseEntity<>(TipoResultadoDTO.converter(resultsTypes), HttpStatus.OK);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, ResultController.findAllResultsType");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
			
		}
				
	}
	
	@GetMapping(value = "findMatch/{homeTeam}/{visitingTeam}")
	public ResponseEntity<List<ResultadoDTO>> findMatch(@PathVariable String homeTeam, String visitingTeam) {
		
		try {

			List<Resultado> results = resultadoBusiness_.findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(homeTeam, visitingTeam);
			return new ResponseEntity<>(ResultadoDTO.converter(results), HttpStatus.OK);

		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, ResultController.findMatch");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}
		
	
	}
	
	
	@GetMapping(value = "findResultsByHomeTeam/{homeTeam}")
	public ResponseEntity<List<ResultadoDTO>> findResultsByHomeTeam(@PathVariable String homeTeam) {
		
		try {

			List<Resultado> results = resultadoBusiness_.findByTimeCasaOrderByResultadoTipoAsc(homeTeam);
			return new ResponseEntity<>(ResultadoDTO.converter(results), HttpStatus.OK);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, ResultController.findResultsByHomeTeam");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
			
		}
		
		

	}
	
	@GetMapping(value = "findResultsByVisitingTeam/{visitingTeam}")
	public ResponseEntity<List<ResultadoDTO>> findResultsByVisitingTeam(@PathVariable String visitingTeam) {
		
		try {

			List<Resultado> results = resultadoBusiness_.findByTimeVisitanteOrderByResultadoTipoAsc(visitingTeam);
			return new ResponseEntity<>(ResultadoDTO.converter(results), HttpStatus.OK);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, ResultController.findResultsByVisitingTeam");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
			
		}
		
	

	}
	
	@GetMapping(value = "findResultsByHour/{hour}")
	public ResponseEntity<List<ResultadoDTO>> findResultsByHour(@PathVariable String hour) {
		
		try {

			List<Resultado> results = resultadoBusiness_.findByHoraOrderByResultadoTipoAsc(hour);
			return new ResponseEntity<>(ResultadoDTO.converter(results), HttpStatus.OK);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, ResultController.findResultsByHour");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
			
		}
		
	

	}

}
