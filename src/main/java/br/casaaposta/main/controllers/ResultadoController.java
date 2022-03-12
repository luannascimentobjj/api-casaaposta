package br.casaaposta.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.casaaposta.main.dto.ResultadoDTO;
import br.casaaposta.main.entity.consumer.Liga;	
import br.casaaposta.main.entity.consumer.Resultado;
import br.casaaposta.main.repository.consumer.ResultadoRepository;

@RestController
@RequestMapping("/resultados")
public class ResultadoController {
	
	@Autowired
	private ResultadoRepository resultadoRepoRespository_;
	
	@GetMapping("/{codLiga}")
	public List<ResultadoDTO> findResultsByCodLiga(@PathVariable String codLiga) {

		 List<Resultado> resultados = resultadoRepoRespository_.findByCodLigaOrderByResultadoTipoAsc(new Liga(codLiga));
	
				return ResultadoDTO.converter(resultados);
	
	}
	

	
	@GetMapping("/{data}")
	public List<ResultadoDTO> findResultsByData(@PathVariable String data) {

	//	 List<Resultado> resultados = resultadoRepoRespository_.findByCodLigaOrderByResultadoTipoAsc(new Liga(codLiga));
	
		//		return ResultadoDTO.converter(resultados);
		return null;
	
	}
	
}
