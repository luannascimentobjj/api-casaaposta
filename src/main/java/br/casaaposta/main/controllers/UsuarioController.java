package br.casaaposta.main.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.casaaposta.main.entity.api.Usuario;
import br.casaaposta.main.repository.api.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository_;

	@Autowired
	private PasswordEncoder encoder;

	@GetMapping("/listarTodos")
	public ResponseEntity<List<Usuario>> listarTodosUsuarios() {

		return ResponseEntity.ok(usuarioRepository_.findAll());

	}

	@PostMapping("/salvarUsuario")
	public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario) {
		usuario.setSenha(encoder.encode(usuario.getSenha()));
		return ResponseEntity.ok(usuarioRepository_.save(usuario));
	}

	@GetMapping("/validarSenha")
	public ResponseEntity<Boolean> validarSenha(@RequestParam String usuario, @RequestParam String senha) {

		Optional<Usuario> user = usuarioRepository_.findByUsuario(usuario);
		if (user.isEmpty()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
		}

		boolean valid = encoder.matches(senha, user.get().getSenha());

		HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
		return ResponseEntity.status(status).body(valid);

	}

}
