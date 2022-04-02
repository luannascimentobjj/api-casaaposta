package br.casaaposta.main.form;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

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

	
}
