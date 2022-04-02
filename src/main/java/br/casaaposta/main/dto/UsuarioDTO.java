package br.casaaposta.main.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.casaaposta.main.entity.api.Usuario;
import lombok.Data;

@Data
public class UsuarioDTO {
	
	
	private Long id;
	private String usuario;
	private String senha;
	private boolean isAdmin;
	private LocalDateTime dataInclusaoRegistro;
	
	
	public UsuarioDTO(Usuario usuario){
		this.id = usuario.getId();
		this.usuario = usuario.getUsuario();
		this.senha = usuario.getSenha();
		this.isAdmin = usuario.isAdmin();	
		this.dataInclusaoRegistro = usuario.getDataInclusaoRegistro();
		
	}
	
	public UsuarioDTO() {
		// TODO Auto-generated constructor stub
	}

	public static List<UsuarioDTO> converter(List<Usuario> users) {
		return users.stream().map(UsuarioDTO::new).collect(Collectors.toList());
	}
	
}
