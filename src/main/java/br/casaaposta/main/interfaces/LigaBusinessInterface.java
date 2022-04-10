package br.casaaposta.main.interfaces;

import java.util.List;
import java.util.Optional;

import br.casaaposta.main.entity.consumer.Liga;

public interface LigaBusinessInterface {

	public Optional<Liga> findByCodLiga(String codLiga) throws Exception;
	
		List<Liga> findAll() throws Exception;
}
