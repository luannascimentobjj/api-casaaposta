package br.casaaposta.main.interfaces;

import java.util.Optional;

import br.casaaposta.main.entity.api.Usuario;

public interface UsuarioDataInterface {

	public Optional<Usuario> findByUsuario(String usuario);
	
}
