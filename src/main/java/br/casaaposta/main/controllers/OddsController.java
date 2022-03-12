package br.casaaposta.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.casaaposta.main.dto.OddsDTO;
import br.casaaposta.main.entity.consumer.OddsEuroCup;
import br.casaaposta.main.repository.consumer.OddsEuroCupRepository;

@RestController
@RequestMapping("/odds")
public class OddsController {
	
	
	@Autowired 
	private OddsEuroCupRepository oddsEuroCupRepository_;
	
	
	
	@GetMapping(value = "findAllResultsType/")
	public ResponseEntity<List<String>> findAllResultsType() {

		List<OddsEuroCup> odds = oddsEuroCupRepository_.findAll();

		return new ResponseEntity<>(OddsDTO.converterToReturnAllResultsType(odds), HttpStatus.OK);

	}

}
