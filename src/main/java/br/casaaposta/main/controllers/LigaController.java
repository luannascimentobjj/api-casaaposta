package br.casaaposta.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.casaaposta.main.dto.LigaDTO;
import br.casaaposta.main.repository.consumer.LigaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/ligas")
@Api(value ="Liga")
@ApiOperation(value ="Busca todas as ligas.")
public class LigaController {
	
	@Autowired
	private LigaRepository ligaRepoRespository_;
	
	
	@GetMapping()
	public List<LigaDTO> findLigas() {
		
		 
		return LigaDTO.converter(ligaRepoRespository_.findAll());
			

	}
	

}
