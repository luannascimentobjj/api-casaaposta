package br.casaaposta.main.interfaces;
import java.util.List;
import java.util.Optional;

import br.casaaposta.main.dto.MetodoDTO;
import br.casaaposta.main.entity.api.Metodo;

public interface MetodoDataInterface {

	Metodo findByMetodo(MetodoDTO metodoDTO);
	
	void save(Metodo  metodo);
	
	Optional<Metodo> findById(Long id);
	
	List<Metodo> findAll();
	
	void deleteById(Long id);
	
}
