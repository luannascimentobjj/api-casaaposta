package br.casaaposta.main.business;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.casaaposta.main.entity.api.Log;
import br.casaaposta.main.entity.api.Usuario;
import br.casaaposta.main.entity.consumer.Liga;
import br.casaaposta.main.interfaces.UsuarioBusinessInterface;
import br.casaaposta.main.repository.api.UsuarioRepository;

@Component
public class UsuarioBusiness implements UsuarioBusinessInterface {

	@Autowired
	private UsuarioRepository usuarioRepository_;

	@Autowired
	LogBusiness logger_;

	Log log = new Log();

	@Override
	public Optional<Usuario> findByUsuario(String usuario) throws Exception {
		try {
			return usuarioRepository_.findByUsuario(usuario);
		} catch (Exception e) {

			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, UsuarioBusiness.findByUsuario");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}

	}

	@Override
	public List<Usuario> findAll() throws Exception {
		try {

			return usuarioRepository_.findAll();

		} catch (Exception e) {

			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, UsuarioBusiness.findAll");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}
	}

	@Override
	public void save(Usuario usuario) throws Exception {

		try {
			usuarioRepository_.save(usuario);
		} catch (Exception e) {

			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, UsuarioBusiness.save");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}

	}

	@Override
	public Optional<Usuario> findById(Long id) throws Exception {
		try {

			Optional<Usuario> userOps = usuarioRepository_.findById(id);
			if (userOps.isEmpty()) {
				return Optional.empty();
			} else {
				return userOps;
			}

		} catch (Exception e) {

			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, UsuarioBusiness.findById");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}

	}

	@Override
	public void deleteById(Long id) throws Exception {
		try {
			usuarioRepository_.deleteById(id);
		} catch (Exception e) {

			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, UsuarioBusiness.deleteById");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}

	}

}
