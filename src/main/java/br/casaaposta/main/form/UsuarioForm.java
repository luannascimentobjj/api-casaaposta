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
	
	@NotBlank(message = "O campo usuário é obrigatório!")
	private String usuario;
	@NotBlank(message = "O campo senha é obrigatório!")
	private String senha;
	@NotBlank(message = "O campo isAdmin é obrigatório!")
	private boolean isAdmin;

	
    public Usuario converter (UsuarioForm user, PasswordEncoder enconder){
        return new Usuario(user, enconder);
    }

    public UsuarioDTO converterToDTO (Usuario user){
        return new UsuarioDTO(user);
    }	
	
}
