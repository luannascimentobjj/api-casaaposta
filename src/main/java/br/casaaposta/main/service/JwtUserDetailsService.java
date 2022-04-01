package br.casaaposta.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.casaaposta.main.entity.api.Usuario;
import br.casaaposta.main.form.UserDetail;
import br.casaaposta.main.repository.api.UsuarioRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService{

	
	@Autowired
	private UsuarioRepository userRepository_;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Usuario> usuario = userRepository_.findByUsuario(username);
		if(usuario.isEmpty()) {
			throw new UsernameNotFoundException("Usuário [" + usuario + "] não encontrado");
		}
		
		return new UserDetail(usuario);
	
		}
	}



