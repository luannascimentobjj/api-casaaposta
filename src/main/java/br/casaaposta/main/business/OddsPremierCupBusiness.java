package br.casaaposta.main.business;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.casaaposta.main.entity.api.Log;
import br.casaaposta.main.entity.consumer.OddsPremierCup;
import br.casaaposta.main.interfaces.OddsPremierCupBusinessInterface;
import br.casaaposta.main.repository.consumer.OddsPremierCupRepository;

@Component
public class OddsPremierCupBusiness implements OddsPremierCupBusinessInterface {

	@Autowired
	private OddsPremierCupRepository oddsPremierCupRepository_;
	
	@Autowired 
	LogBusiness logger_;
	
	Log log = new Log();

	@Override
	public List<OddsPremierCup> findByDataOrderByResultadoTipoAsc(String date) throws Exception {
		try {
			
			return oddsPremierCupRepository_.findByDataOrderByResultadoTipoAsc(date.replace("-", "/"));
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsPremierCupBusiness.findByDataOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}
		
	}

	@Override
	public List<OddsPremierCup> findByResultadoTipoOrderByResultadoTipoAsc(String type) throws Exception {

		try {
			
			return oddsPremierCupRepository_.findByResultadoTipoOrderByResultadoTipoAsc(type);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsPremierCupBusiness.findByResultadoTipoOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
			
		}
		
	
	}

	@Override
	public List<OddsPremierCup> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante) throws Exception {

		try {
			
			return oddsPremierCupRepository_.findByTimeVisitanteOrderByResultadoTipoAsc(timeVisitante);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsPremierCupBusiness.findByTimeVisitanteOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
			
		}
	
		
		
	}

	@Override
	public List<OddsPremierCup> findByTimeCasaOrderByResultadoTipoAsc(String timeCasa) throws Exception {

		try {
			return oddsPremierCupRepository_.findByTimeCasaOrderByResultadoTipoAsc(timeCasa);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsPremierCupBusiness.findByTimeCasaOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}

		
	}

	@Override
	public List<OddsPremierCup> findByHoraOrderByResultadoTipoAsc(String hora) throws Exception {

		try {
			return oddsPremierCupRepository_.findByHoraOrderByResultadoTipoAsc(hora);

		} catch (Exception e) {
			

			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsPremierCupBusiness.findByHoraOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}

	}

	@Override
	public List<OddsPremierCup> findAll() throws Exception {
		try {
			return oddsPremierCupRepository_.findAll();
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsPremierCupBusiness.findByHoraOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}
		
	}

	@Override
	public List<OddsPremierCup> findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(String timeCasa,
			String timeVisitante) throws Exception {
		
		try {
			return oddsPremierCupRepository_.findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(timeCasa, timeVisitante);
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsPremierCupBusiness.findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}
		
	
	}

	@Override
	public List<OddsPremierCup> findByTollTipIsNotNull() throws Exception {

		try {
			
			return oddsPremierCupRepository_.findByTollTipIsNotNull();
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsPremierCupBusiness.findByTollTipIsNotNull");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}
		
	}
	
	@Override
	public List<String> findDistinctTimeVisitanteByTimeVisitanteIsNotNull() throws Exception {
	
		try {
			
			return oddsPremierCupRepository_.findDistinctTimeVisitanteByTimeVisitanteIsNotNull();
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsPremierCupBusiness.findDistinctHora");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}
				
	}

	@Override
	public List<String> findDistinctHora() throws Exception {
		
		try {
			
			return oddsPremierCupRepository_.findDistinctHora();
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsPremierCupBusiness.findDistinctHora");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}
		
		
	}



}