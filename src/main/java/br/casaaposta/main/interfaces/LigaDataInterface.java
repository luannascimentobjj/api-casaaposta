package br.casaaposta.main.interfaces;

import java.util.List;
import java.util.Optional;

import br.casaaposta.main.entity.consumer.Liga;

public interface LigaDataInterface {

	public Optional<Liga> findByCodLiga(String codLiga);
	
		List<Liga> findAll();
}
