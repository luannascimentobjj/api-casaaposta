package br.casaaposta.main.interfaces;

import java.util.List;
import java.util.Optional;

import br.casaaposta.main.entity.api.Usuario;

public interface UsuarioBusinessInterface {

	public Optional<Usuario> findByUsuario(String usuario) throws Exception;
	
	List<Usuario> findAll() throws Exception;
	
	void save(Usuario usuario) throws Exception;
	
	Optional<Usuario> findById(Long id) throws Exception;
	
	void deleteById(Long id) throws Exception;
}
