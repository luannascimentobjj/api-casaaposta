package br.casaaposta.main.business;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.casaaposta.main.entity.api.Log;
import br.casaaposta.main.entity.consumer.Liga;
import br.casaaposta.main.interfaces.LigaBusinessInterface;
import br.casaaposta.main.repository.consumer.LigaRepository;


@Component
public class LigaBusiness implements LigaBusinessInterface{

	
	@Autowired
	private LigaRepository ligaRepoRespository_;
	
	@Autowired 
	LogBusiness logger_;
	
	Log log = new Log();
	
	@Override
	public Optional<Liga> findByCodLiga(String codLiga) throws Exception {
		
		try {	
			
			Optional<Liga> ligaOps = ligaRepoRespository_.findByCodLiga(codLiga);
			if (ligaOps.isEmpty()) {
				return Optional.empty();
			}else {
				return ligaOps;
			}
		
		} catch (Exception e) {
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, LigaBusinessInterface.findByCodLiga");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}
		
		
	}

	@Override
	public List<Liga> findAll() throws Exception {
		
		try {
			
			return ligaRepoRespository_.findAll();
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, LigaBusinessInterface.findAll");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}
		
		
		
		
	}

}
