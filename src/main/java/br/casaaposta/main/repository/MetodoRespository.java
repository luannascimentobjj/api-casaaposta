package br.casaaposta.main.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.casaaposta.main.dto.MetodoDTO;
import br.casaaposta.main.entity.Metodo;

public interface MetodoRespository extends JpaRepository<Metodo, Long>{

	Optional<Metodo> findBy(MetodoDTO metodoDTO);

	

}
