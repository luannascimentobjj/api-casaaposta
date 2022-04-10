package br.casaaposta.main.business;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.casaaposta.main.entity.api.Log;
import br.casaaposta.main.entity.consumer.OddsSuperCup;
import br.casaaposta.main.interfaces.OddsSuperCupBusinessInterface;
import br.casaaposta.main.repository.consumer.OddsSuperCupRepository;

@Component
public class OddsSuperCupBusiness implements OddsSuperCupBusinessInterface {

	@Autowired
	private OddsSuperCupRepository oddsSuperCupRepository_;

	@Autowired 
	LogBusiness logger_;
	
	Log log = new Log();
	
	@Override
	public List<OddsSuperCup> findByDataOrderByResultadoTipoAsc(String date) throws Exception {

		try {

			return oddsSuperCupRepository_.findByDataOrderByResultadoTipoAsc(date.replace("-", "/"));

		} catch (Exception e) {

			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsSuperCupBusiness.findByDataOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);

		}

	}

	@Override
	public List<OddsSuperCup> findByResultadoTipoOrderByResultadoTipoAsc(String type) throws Exception {

		try {

			return oddsSuperCupRepository_.findByResultadoTipoOrderByResultadoTipoAsc(type);

		} catch (Exception e) {

			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsSuperCupBusiness.findByResultadoTipoOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}

	}

	@Override
	public List<OddsSuperCup> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante) throws Exception {

		try {

			return oddsSuperCupRepository_.findByTimeVisitanteOrderByResultadoTipoAsc(timeVisitante);

		} catch (Exception e) {

			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsSuperCupBusiness.findByTimeVisitanteOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);

		}

	}

	@Override
	public List<OddsSuperCup> findByTimeCasaOrderByResultadoTipoAsc(String timeCasa) throws Exception {
	
		try {
			
			return oddsSuperCupRepository_.findByTimeCasaOrderByResultadoTipoAsc(timeCasa);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsSuperCupBusiness.findByTimeCasaOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}
	
	}

	@Override
	public List<OddsSuperCup> findByHoraOrderByResultadoTipoAsc(String hora) throws Exception {
		
		try {
		
			return oddsSuperCupRepository_.findByHoraOrderByResultadoTipoAsc(hora);
		
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsSuperCupBusiness.findByHoraOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}
		
		
		
		
	}

	@Override
	public List<OddsSuperCup> findAll() throws Exception {

		try {

			return oddsSuperCupRepository_.findAll();

		} catch (Exception e) {

			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsSuperCupBusiness.findAll");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}

	}

	@Override
	public List<OddsSuperCup> findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(String timeCasa,
			String timeVisitante) throws Exception {
		
		try {
			
			return oddsSuperCupRepository_.findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(timeCasa, timeVisitante);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsSuperCupBusiness.findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}
		
		
	}

}
