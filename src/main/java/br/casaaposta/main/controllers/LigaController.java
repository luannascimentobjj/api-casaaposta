package br.casaaposta.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.casaaposta.main.dto.LigaDTO;
import br.casaaposta.main.interfaces.LigaDataInterface;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/ligas")
@Api(tags = "Liga")

public class LigaController {

	
	@Autowired
	LigaDataInterface ligaData_;
	
	@GetMapping()
	public List<LigaDTO> findLigas() {
				 
		return LigaDTO.converter(ligaData_.findAll());
			

	}
	

}
