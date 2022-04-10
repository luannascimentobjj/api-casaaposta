package br.casaaposta.main.form;

import javax.validation.constraints.NotBlank;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.casaaposta.main.dto.UsuarioDTO;
import br.casaaposta.main.entity.api.Usuario;
import lombok.Data;
@Data
@Component
public class UsuarioForm {
	
	@NotBlank(message = "The user field is required!")
	private String user;
	@NotBlank(message = "The password field is required!")
	private String password;
	@NotBlank(message = "The isAdmin field is required!")
	private boolean isAdmin;
	@NotBlank(message = "The email field is required!")
	private String email;
	@NotBlank(message = "The name field is required!")
	private String name;

	
    public Usuario converter (UsuarioForm user, PasswordEncoder enconder){
        return new Usuario(user, enconder);
    }

    public UsuarioDTO converterToDTO (Usuario user){
        return new UsuarioDTO(user);
    }	
	
}
