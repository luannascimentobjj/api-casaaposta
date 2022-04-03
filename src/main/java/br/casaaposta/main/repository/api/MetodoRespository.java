package br.casaaposta.main.repository.api;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.casaaposta.main.dto.MetodoDTO;
import br.casaaposta.main.entity.api.Metodo;
@Repository
public interface MetodoRespository extends JpaRepository<Metodo, Long>{
	
	@Query("Select m from Metodo m where m.id = :metodoDTO")
	Optional<Metodo> findByMetodo(MetodoDTO metodoDTO);

	

}
