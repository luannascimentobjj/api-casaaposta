package br.casaaposta.main.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.casaaposta.main.dto.UsuarioDTO;
import br.casaaposta.main.entity.api.Usuario;
import br.casaaposta.main.form.UsuarioForm;
import br.casaaposta.main.interfaces.UsuarioDataInterface;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/usuario")
@Api(tags = "Usuario")
public class UsuarioController {

	@Autowired
	private UsuarioDataInterface usuarioData_;

	@Autowired
	private PasswordEncoder enconder;

	@GetMapping("/listarTodos")
	public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {

		try {

			List<Usuario> users = usuarioData_.findAll();
			return ResponseEntity.ok(UsuarioDTO.converter(users));
		} catch (Exception e) {

			return null;
		}

	}

	@PostMapping("/salvar")
	public ResponseEntity<UsuarioDTO> salvar(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder) {

		try {

			Usuario user = form.converter(form, enconder);
			usuarioData_.save(user);
			URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(user.getId()).toUri();
			return ResponseEntity.created(uri).body(new UsuarioDTO(user));

		} catch (Exception e) {
			return null;
		}

	}

	@GetMapping("/validarSenha")
	public ResponseEntity<Boolean> validarSenha(@RequestParam String usuario, @RequestParam String senha) {
		
		
		
		Optional<Usuario> user = usuarioData_.findByUsuario(usuario);
		if(user.isEmpty()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
		}
		
		 boolean valid = enconder.matches(senha, user.get().getSenha());
		 
		 HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
		
		 return ResponseEntity.status(status).body(valid);
		 
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {

		try {

			Optional<Usuario> optional = usuarioData_.findById(id);
			if (optional.isPresent()) {
				usuarioData_.deleteById(id);
				return ResponseEntity.ok().build();
			}

			return ResponseEntity.notFound().build();

		} catch (Exception e) {
			return null;
		}

	}
}
