package br.casaaposta.main.controllers;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.casaaposta.main.business.LogBusiness;
import br.casaaposta.main.dto.MetodoDTO;
import br.casaaposta.main.entity.api.Log;
import br.casaaposta.main.entity.api.Metodo;
import br.casaaposta.main.form.AtualizaMetodoForm;
import br.casaaposta.main.form.MetodoForm;
import br.casaaposta.main.interfaces.MetodoBusinessInterface;
import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@RequestMapping("/methods")
@Api(tags = "Method")
public class MethodController {

	@Autowired
	private MetodoBusinessInterface metodoBusiness_;
	
	@Autowired 
	LogBusiness logger_;
	
	Log log = new Log();

	@PostMapping
	public ResponseEntity<MetodoDTO> save(@RequestBody @Valid MetodoForm form, UriComponentsBuilder uriBuilder){

		try {

			Metodo metodo = form.converter(form);
			metodoBusiness_.save(metodo);
			URI uri = uriBuilder.path("/metodos/{id}").buildAndExpand(metodo.getId()).toUri();
			return ResponseEntity.created(uri).body(new MetodoDTO(metodo));

		} catch (Exception e) {
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, MethodController.save");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		try {

			Optional<Metodo> optional = metodoBusiness_.findById(id);
			if (optional.isPresent()) {
				metodoBusiness_.deleteById(id);
				return ResponseEntity.ok().build();
			}

			return ResponseEntity.notFound().build();

		} catch (Exception e) {
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, MethodController.delete");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<MetodoDTO> update(@PathVariable Long id, @RequestBody @Valid AtualizaMetodoForm form) {
		
		try {
			
			Optional<Metodo> optMetodo = metodoBusiness_.findById(id);
			if (optMetodo.isPresent()) {
				Metodo metodo = form.atualizar(optMetodo, form);
				metodoBusiness_.save(metodo);
				return ResponseEntity.ok(new MetodoDTO(metodo));
			}

			return ResponseEntity.notFound().build();
			
		} catch (Exception e) {
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, MethodController.update");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}
		

	}

	@GetMapping()
	public ResponseEntity<List<MetodoDTO>> findAllMethods() {

		try {
			
			List<Metodo> metodos = metodoBusiness_.findAll();
			return ResponseEntity.ok(MetodoDTO.converter(metodos));
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, MethodController.findAllMethods");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}
		
		

	}

}
