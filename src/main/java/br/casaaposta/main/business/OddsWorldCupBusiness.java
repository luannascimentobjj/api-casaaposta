package br.casaaposta.main.business;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.casaaposta.main.entity.api.Log;
import br.casaaposta.main.entity.consumer.OddsWorldCup;
import br.casaaposta.main.interfaces.OddsWorldCupBusinessInterface;
import br.casaaposta.main.repository.consumer.OddsWorldCupRepository;

@Component
public class OddsWorldCupBusiness implements OddsWorldCupBusinessInterface{


	@Autowired
	private OddsWorldCupRepository oddsWorldCupRepository_;
	
	@Autowired 
	LogBusiness logger_;
	
	Log log = new Log();
	
	
	@Override
	public List<OddsWorldCup> findByDataOrderByResultadoTipoAsc(String date) throws Exception {
		try {
			
			return oddsWorldCupRepository_.findByDataOrderByResultadoTipoAsc(date.replace("-", "/"));
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsWorldCupBusiness.findByDataOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}
			
		
	}

	@Override
	public List<OddsWorldCup> findByResultadoTipoOrderByResultadoTipoAsc(String type) throws Exception {
		
		try {
			
			return oddsWorldCupRepository_.findByResultadoTipoOrderByResultadoTipoAsc(type);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsWorldCupBusiness.findByResultadoTipoOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}
		
		
	}

	@Override
	public List<OddsWorldCup> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante) throws Exception {
		
		try {
			
			return oddsWorldCupRepository_.findByTimeVisitanteOrderByResultadoTipoAsc(timeVisitante);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsWorldCupBusiness.findByTimeVisitanteOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}
		
		
	}

	@Override
	public List<OddsWorldCup> findByTimeCasaOrderByResultadoTipoAsc(String timeCasa) throws Exception {

		try {
			return oddsWorldCupRepository_.findByTimeCasaOrderByResultadoTipoAsc(timeCasa);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsWorldCupBusiness.findByTimeCasaOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}
		
		
	}

	@Override
	public List<OddsWorldCup> findByHoraOrderByResultadoTipoAsc(String hora) throws Exception {
		
		try {
			
			return oddsWorldCupRepository_.findByHoraOrderByResultadoTipoAsc(hora);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsWorldCupBusiness.findByHoraOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
			
		}
		
		
	}

	@Override
	public List<OddsWorldCup> findAll() throws Exception {
		try {
			
			return oddsWorldCupRepository_.findAll();
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsWorldCupBusiness.findAll");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
			
		}
		
	}

	@Override
	public List<OddsWorldCup> findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(String timeCasa,
			String timeVisitante) throws Exception {
		
		try {
			return oddsWorldCupRepository_.findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(timeCasa, timeVisitante);
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsWorldCupBusiness.findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}
		
	}

	@Override
	public List<OddsWorldCup> findByTollTipIsNotNull() throws Exception {
		try {
			
			return oddsWorldCupRepository_.findByTollTipIsNotNull();
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsWorldCupBusiness.findByTollTipIsNotNull");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}
	}

}
