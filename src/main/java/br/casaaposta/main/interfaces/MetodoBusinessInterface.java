package br.casaaposta.main.interfaces;
import java.util.List;
import java.util.Optional;

import br.casaaposta.main.dto.MetodoDTO;
import br.casaaposta.main.entity.api.Metodo;

public interface MetodoBusinessInterface {

	Metodo findByMetodo(MetodoDTO metodoDTO);
	
	void save(Metodo  metodo) throws Exception;
	
	Optional<Metodo> findById(Long id) throws Exception;
	
	List<Metodo> findAll() throws Exception;
	
	void deleteById(Long id) throws Exception;
	
}
