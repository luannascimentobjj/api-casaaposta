package br.casaaposta.main.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.casaaposta.main.dto.UsuarioDTO;
import br.casaaposta.main.entity.api.Usuario;
import br.casaaposta.main.form.UsuarioForm;
import br.casaaposta.main.repository.api.UsuarioRepository;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/usuario")
@Api(tags = "Usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository_;

	@Autowired
	private PasswordEncoder enconder;

	@GetMapping("listarTodos")
	public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {

		try {

			List<Usuario> users = usuarioRepository_.findAll();
			return ResponseEntity.ok(UsuarioDTO.converter(users));
		} catch (Exception e) {

			return null;
		}

	}

	@PostMapping("salvar")
	public ResponseEntity<UsuarioDTO> salvar(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder) {

		try {

			Usuario user = form.converter(form, enconder);
			usuarioRepository_.save(user);
			URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(user.getId()).toUri();
			return ResponseEntity.created(uri).body(new UsuarioDTO(user));

		} catch (Exception e) {
			return null;
		}

	}

	@GetMapping("validarSenha")
	public ResponseEntity<List<Usuario>> validarSenha() {
		return ResponseEntity.ok(usuarioRepository_.findAll());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {

		try {

			Optional<Usuario> optional = usuarioRepository_.findById(id);
			if (optional.isPresent()) {
				usuarioRepository_.deleteById(id);
				return ResponseEntity.ok().build();
			}

			return ResponseEntity.notFound().build();

		} catch (Exception e) {
			return null;
		}

	}
}
