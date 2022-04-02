package br.casaaposta.main.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.casaaposta.main.dto.MetodoDTO;
import br.casaaposta.main.entity.api.Log;
import br.casaaposta.main.entity.api.Metodo;
import br.casaaposta.main.form.AtualizaMetodoForm;
import br.casaaposta.main.form.MetodoForm;
import br.casaaposta.main.repository.api.MetodoRespository;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/metodos")
@Api(tags = "Metodo")
public class MetodoController {

	@Autowired
	private MetodoRespository metodoRepository_;
	private Log logger_ = new Log();

	@PostMapping
	public ResponseEntity<MetodoDTO> cadastrar(@RequestBody @Valid MetodoForm form, UriComponentsBuilder uriBuilder) {

		try {

			Metodo metodo = form.converter(form);
			metodoRepository_.save(metodo);
			URI uri = uriBuilder.path("/metodos/{id}").buildAndExpand(metodo.getId()).toUri();
			return ResponseEntity.created(uri).body(new MetodoDTO(metodo));

		} catch (Exception e) {
			return null;
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {

		try {

			Optional<Metodo> optional = metodoRepository_.findById(id);
			if (optional.isPresent()) {
				metodoRepository_.deleteById(id);
				return ResponseEntity.ok().build();
			}

			return ResponseEntity.notFound().build();

		} catch (Exception e) {
			return null;
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<MetodoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizaMetodoForm form) {
		Optional<Metodo> optMetodo = metodoRepository_.findById(id);
		if (optMetodo.isPresent()) {
			Metodo metodo = form.atualizar(optMetodo, form);
			metodoRepository_.save(metodo);
			return ResponseEntity.ok(new MetodoDTO(metodo));
		}

		return ResponseEntity.notFound().build();
	}

	@GetMapping()
	public ResponseEntity<List<MetodoDTO>> buscarMetodos() {

		List<Metodo> metodos = metodoRepository_.findAll();
		return ResponseEntity.ok(MetodoDTO.converter(metodos));

	}

}
