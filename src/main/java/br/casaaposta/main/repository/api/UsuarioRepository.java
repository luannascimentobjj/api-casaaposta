package br.casaaposta.main.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;

import br.casaaposta.main.entity.api.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
