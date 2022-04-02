package br.casaaposta.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.casaaposta.main.entity.api.Usuario;
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
	public ResponseEntity<List<Usuario>> listarUsuarios(){
		return ResponseEntity.ok(usuarioRepository_.findAll());
	}
	
	
	@PostMapping("salvar")
	public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){
		usuario.setSenha(enconder.encode(usuario.getSenha()));
		return ResponseEntity.ok(usuarioRepository_.save(usuario));
	}

	@GetMapping("validarSenha")
	public ResponseEntity<List<Usuario>> validarSenha(){
		return ResponseEntity.ok(usuarioRepository_.findAll());
	}
	
}
