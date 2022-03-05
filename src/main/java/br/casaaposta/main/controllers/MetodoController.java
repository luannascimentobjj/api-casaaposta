package br.casaaposta.main.controllers;

import br.casaaposta.main.entity.Log;
import br.casaaposta.main.entity.MetodoEntity;
import br.casaaposta.main.form.MetodoForm;
import br.casaaposta.main.models.MetodoModel;
import br.casaaposta.main.repository.MetodoRespository;
import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.controller.form.AtualizacaoTopicoForm;
import br.com.alura.forum.modelo.Topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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
	public ResponseEntity<MetodoModel> cadastrar(@RequestBody @Valid MetodoForm form, UriComponentsBuilder uriBuilder) {

		try {

			MetodoEntity metodoEntity = form.converter(form);
			metodoRepository_.save(metodoEntity);
			URI uri = uriBuilder.path("/metodos/{id}").buildAndExpand(metodoEntity.getId()).toUri();
			return ResponseEntity.created(uri).body(new MetodoModel(metodoEntity));

		} catch (Exception e) {
			return null;
		}

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {

		try {

			Optional<MetodoEntity> optional = metodoRepository_.findById(id);
			if (optional.isPresent()) {
				metodoRepository_.deleteById(id);
				return ResponseEntity.ok().build();
			}

			return ResponseEntity.notFound().build();

		} catch (Exception e) {
			return null;
		}

	}

}
