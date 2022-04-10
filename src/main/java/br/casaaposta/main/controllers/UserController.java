package br.casaaposta.main.controllers;

import java.net.URI;
import java.time.LocalDateTime;
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

import br.casaaposta.main.business.LogBusiness;
import br.casaaposta.main.dto.UsuarioDTO;
import br.casaaposta.main.entity.api.Log;
import br.casaaposta.main.entity.api.Usuario;
import br.casaaposta.main.form.UsuarioForm;
import br.casaaposta.main.interfaces.UsuarioBusinessInterface;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/user")
@Api(tags = "User")
public class UserController {

	@Autowired
	private UsuarioBusinessInterface usuarioBusiness_;

	@Autowired
	private PasswordEncoder enconder;

	@Autowired 
	LogBusiness logger_;
	
	Log log = new Log();
	
	@GetMapping("/listAllUsers")
	public ResponseEntity<List<UsuarioDTO>> listAllUsers() {

		try {

			List<Usuario> users = usuarioBusiness_.findAll();
			return ResponseEntity.ok(UsuarioDTO.converter(users));
			
		} catch (Exception e) {

			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, UserController.listAllUsers");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}

	}

	@PostMapping("/save")
	public ResponseEntity<UsuarioDTO> save(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder) {

		try {

			Usuario user = form.converter(form, enconder);
			usuarioBusiness_.save(user);
			URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(user.getId()).toUri();
			return ResponseEntity.created(uri).body(new UsuarioDTO(user));

		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, UserController.save");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
			
			
		}

	}

	@GetMapping("/validatePassword")
	public ResponseEntity<Boolean> validatePassword(@RequestParam String user, @RequestParam String password) {
		
		try {
			
			Optional<Usuario> userToScreen = usuarioBusiness_.findByUsuario(user);
			if(userToScreen.isEmpty()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
			}
			
			 boolean valid = enconder.matches(password, userToScreen.get().getSenha());
			 
			 HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
			
			 return ResponseEntity.status(status).body(valid);
			 
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, UserController.validatePassword");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}
		
	
		 
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		try {

			Optional<Usuario> optional = usuarioBusiness_.findById(id);
			if (optional.isPresent()) {
				usuarioBusiness_.deleteById(id);
				return ResponseEntity.ok().build();
			}

			return ResponseEntity.notFound().build();

		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, UserController.delete");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			return ResponseEntity.internalServerError().build();
		}

	}
}
