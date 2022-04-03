package br.casaaposta.main.data;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.casaaposta.main.entity.api.Usuario;
import br.casaaposta.main.interfaces.UsuarioDataInterface;
import br.casaaposta.main.repository.api.UsuarioRepository;
@Component
public class UsuarioData implements UsuarioDataInterface{

	@Autowired
	private UsuarioRepository usuarioRepository_;
	
	@Override
	public Optional<Usuario> findByUsuario(String usuario) {
		try {
			return usuarioRepository_.findByUsuario(usuario);
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public List<Usuario> findAll() {
		try {
			return usuarioRepository_.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void save(Usuario usuario) {

		try {
			usuarioRepository_.save(usuario);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public Optional<Usuario> findById(Long id) {
		try {
			return usuarioRepository_.findById(id);
		} catch (Exception e) {
			return null;
		}
		
		
	}

	@Override
	public void deleteById(Long id) {
		try {
			usuarioRepository_.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
