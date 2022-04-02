package br.casaaposta.main.entity.api;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.password.PasswordEncoder;

import br.casaaposta.main.form.UsuarioForm;
import lombok.Data;

@Entity
@Table(name = "Usuario")
@Data
public class Usuario {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String usuario;
	private String senha;
	private boolean isAdmin;
	private LocalDateTime dataInclusaoRegistro;
	
	
	
	public Usuario(UsuarioForm usuario, PasswordEncoder enconder) {
		this.usuario = usuario.getUsuario();
		this.senha = enconder.encode(usuario.getSenha());
		this.isAdmin = usuario.isAdmin();
		this.dataInclusaoRegistro = LocalDateTime.now();
	}
	
	public Usuario() {
		
	}
	
}
