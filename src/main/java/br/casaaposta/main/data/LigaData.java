package br.casaaposta.main.data;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.casaaposta.main.entity.consumer.Liga;
import br.casaaposta.main.interfaces.LigaDataInterface;
import br.casaaposta.main.repository.consumer.LigaRepository;

public class LigaData implements LigaDataInterface{

	
	@Autowired
	private LigaRepository ligaRepoRespository_;
	
	@Override
	public Optional<Liga> findByCodLiga(String codLiga) {
		return ligaRepoRespository_.findByCodLiga(codLiga);
	}

	@Override
	public List<Liga> findAll() {
		return ligaRepoRespository_.findAll();
		
	}

}
