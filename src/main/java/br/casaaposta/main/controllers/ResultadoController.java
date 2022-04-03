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
import br.casaaposta.main.interfaces.TipoResultadoDataInterface;
import br.casaaposta.main.repository.consumer.ResultadoRepository;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/resultados")
@Api(tags = "Resultado")
public class ResultadoController {

	@Autowired
	private ResultadoRepository resultadoData_;
	@Autowired 
	private TipoResultadoDataInterface tipoResultadoData_;

	@GetMapping(value = "findByCodLiga/{codLiga}")
	public ResponseEntity<List<ResultadoDTO>> findResultsByCodLiga(@PathVariable String codLiga) {

		List<Resultado> resultados = resultadoData_.findByCodLigaOrderByResultadoTipoAsc(new Liga(codLiga));

		return new ResponseEntity<>(ResultadoDTO.converter(resultados), HttpStatus.OK);

	}

	@GetMapping(value = "findByDate/{date}")
	public ResponseEntity<List<ResultadoDTO>> findResultsByData(@PathVariable String data) {
		List<Resultado> resultados = resultadoData_.findByDataOrderByResultadoTipoAsc(data);

		return new ResponseEntity<>(ResultadoDTO.converter(resultados), HttpStatus.OK);

	}
	
	@GetMapping(value = "findByType/{type}")
	public ResponseEntity<List<ResultadoDTO>> findResultsByType(@PathVariable String type) {
		List<Resultado> resultados = resultadoData_.findByResultadoTipoOrderByResultadoTipoAsc(type);

		return new ResponseEntity<>(ResultadoDTO.converter(resultados), HttpStatus.OK);

	}
	
	@GetMapping(value = "findAllResultsType/")
	public ResponseEntity<List<TipoResultadoDTO>> findAllResultsType() {

		List<TipoResultado> resultsTypes = tipoResultadoData_.findAll();

		return new ResponseEntity<>(TipoResultadoDTO.converter(resultsTypes), HttpStatus.OK);
		
	}
	
	@GetMapping(value = "findJogo/{timeCasa}/{timeVisitante}")
	public ResponseEntity<List<ResultadoDTO>> findJogo(@PathVariable String timeCasa, String timeVisitante) {
		List<Resultado> results = resultadoData_.findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(timeCasa, timeVisitante);

		return new ResponseEntity<>(ResultadoDTO.converter(results), HttpStatus.OK);

	}
	
	
	@GetMapping(value = "findResultsByTimeCasa/{timeCasa}")
	public ResponseEntity<List<ResultadoDTO>> findResultsByTimeCasa(@PathVariable String timeCasa) {
		List<Resultado> results = resultadoData_.findByTimeCasaOrderByResultadoTipoAsc(timeCasa);

		return new ResponseEntity<>(ResultadoDTO.converter(results), HttpStatus.OK);

	}
	
	@GetMapping(value = "findResultsByTimeVisitante/{timeVisitante}")
	public ResponseEntity<List<ResultadoDTO>> findResultsByTimeVisitante(@PathVariable String timeVisitante) {
		List<Resultado> results = resultadoData_.findByTimeVisitanteOrderByResultadoTipoAsc(timeVisitante);

		return new ResponseEntity<>(ResultadoDTO.converter(results), HttpStatus.OK);

	}
	
	@GetMapping(value = "findResultsByHora/{hora}")
	public ResponseEntity<List<ResultadoDTO>> findResultsByHora(@PathVariable String hora) {
		List<Resultado> results = resultadoData_.findByHoraOrderByResultadoTipoAsc(hora);

		return new ResponseEntity<>(ResultadoDTO.converter(results), HttpStatus.OK);

	}

}
