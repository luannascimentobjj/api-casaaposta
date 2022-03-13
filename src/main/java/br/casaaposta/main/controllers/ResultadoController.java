package br.casaaposta.main.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.casaaposta.main.dto.ResultadoDTO;
import br.casaaposta.main.dto.TipoResultadoDTO;
import br.casaaposta.main.entity.consumer.Liga;
import br.casaaposta.main.entity.consumer.Resultado;
import br.casaaposta.main.entity.consumer.TipoResultado;
import br.casaaposta.main.repository.consumer.ResultadoRepository;
import br.casaaposta.main.repository.consumer.TipoResultadoRepository;

@RestController
@RequestMapping("/resultados")
public class ResultadoController {

	@Autowired
	private ResultadoRepository resultadoRepoRespository_;
	@Autowired 
	private TipoResultadoRepository tipoResultadoRepository_;

	@GetMapping(value = "findByCodLiga/{codLiga}")
	public ResponseEntity<List<ResultadoDTO>> findResultsByCodLiga(@PathVariable String codLiga) {

		List<Resultado> resultados = resultadoRepoRespository_.findByCodLigaOrderByResultadoTipoAsc(new Liga(codLiga));

		return new ResponseEntity<>(ResultadoDTO.converter(resultados), HttpStatus.OK);

	}

	@GetMapping(value = "findByDate/{date}")
	public ResponseEntity<List<ResultadoDTO>> findResultsByData(@PathVariable String data) {
		List<Resultado> resultados = resultadoRepoRespository_
				.findByDataOrderByResultadoTipoAsc(data.replace("-", "/"));

		return new ResponseEntity<>(ResultadoDTO.converter(resultados), HttpStatus.OK);

	}
	
	@GetMapping(value = "findByType/{type}")
	public ResponseEntity<List<ResultadoDTO>> findResultsByType(@PathVariable String type) {
		List<Resultado> resultados = resultadoRepoRespository_.findByResultadoTipoOrderByResultadoTipoAsc(type);

		return new ResponseEntity<>(ResultadoDTO.converter(resultados), HttpStatus.OK);

	}
	
	@GetMapping(value = "findAllResultsType/")
	public ResponseEntity<List<TipoResultadoDTO>> findAllResultsType() {

		List<TipoResultado> resultsTypes = tipoResultadoRepository_.findAll();

		return new ResponseEntity<>(TipoResultadoDTO.converter(resultsTypes), HttpStatus.OK);
		
	}

}
