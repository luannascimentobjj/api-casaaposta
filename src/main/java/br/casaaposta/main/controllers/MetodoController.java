package br.casaaposta.main.controllers;

import br.casaaposta.main.dto.MetodoDTO;
import br.casaaposta.main.entity.api.Log;
import br.casaaposta.main.entity.api.Metodo;
import br.casaaposta.main.form.AtualizaMetodoForm;
import br.casaaposta.main.form.MetodoForm;
import br.casaaposta.main.repository.api.MetodoRespository;
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

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/metodos")
public class MetodoController {

	@Autowired
	private MetodoRespository metodoRepository_;
	private Log logger_ = new Log();

	@PostMapping
	@Transactional
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
	@Transactional
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
	@Transactional
	public ResponseEntity<MetodoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizaMetodoForm form) {
		Optional<Metodo> optional = metodoRepository_.findById(id);
		if (optional.isPresent()) {
			Metodo metodo = form.atualizar(id, metodoRepository_);
			return ResponseEntity.ok(new MetodoDTO(metodo));
		}
		
		return ResponseEntity.notFound().build();
	}
	

	@GetMapping()
	public List<MetodoDTO> buscarMetodos(MetodoDTO metodoDTO) {
		 Optional<Metodo> metodos = metodoRepository_.findBy(metodoDTO);
			if (metodos.isPresent()) {
				
				return MetodoDTO.converter(metodos);
			}
			return null;

	}

}
