package br.casaaposta.main.interfaces;

import java.util.List;
import java.util.Optional;

import br.casaaposta.main.entity.api.Usuario;

public interface UsuarioDataInterface {

	public Optional<Usuario> findByUsuario(String usuario);
	
	List<Usuario> findAll();
	
	void save(Usuario usuario);
	
	Optional<Usuario> findById(Long id);
	
	void deleteById(Long id);
}
