package br.casaaposta.main.interfaces;
import br.casaaposta.main.dto.MetodoDTO;
import br.casaaposta.main.entity.api.Metodo;

public interface MetodoDataInterface {

	public Metodo findByCodLiga(MetodoDTO metodoDTO);
	
}
