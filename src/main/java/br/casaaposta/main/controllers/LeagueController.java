package br.casaaposta.main.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.casaaposta.main.business.LogBusiness;
import br.casaaposta.main.dto.LigaDTO;
import br.casaaposta.main.entity.api.Log;
import br.casaaposta.main.entity.consumer.Liga;
import br.casaaposta.main.interfaces.LigaBusinessInterface;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/leagues")
@Api(tags = "Leagues")

public class LeagueController {

	
	@Autowired
	LigaBusinessInterface ligaBusiness_;
	
	
	@Autowired 
	LogBusiness logger_;
	
	Log log = new Log();
	
	@GetMapping()
	public ResponseEntity<List<LigaDTO>> findAllLeagues() {
		
		try {
		
			List<Liga> ligas = ligaBusiness_.findAll();
			return ResponseEntity.ok(LigaDTO.converter(ligas));
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, LeagueController.findAllLeagues");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}
				 
		
			

	}
	

}
