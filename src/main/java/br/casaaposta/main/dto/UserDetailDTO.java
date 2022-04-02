package br.casaaposta.main.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.casaaposta.main.entity.api.Usuario;

public class UserDetailDTO implements UserDetails {

	@Autowired
	private final Optional<Usuario> usuarioEntity_;

	private static final long serialVersionUID = -7634559071782723765L;

	public UserDetailDTO(Optional<Usuario> usuario) {
		this.usuarioEntity_ = usuario;
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<>();

	}

	@Override
	public String getPassword() {

		return usuarioEntity_.orElse(new Usuario()).getSenha();
	}

	@Override
	public String getUsername() {
		return usuarioEntity_.orElse(new Usuario()).getUsuario();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
