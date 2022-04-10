package br.casaaposta.main.business;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.casaaposta.main.entity.api.Log;
import br.casaaposta.main.entity.consumer.OddsEuroCup;
import br.casaaposta.main.interfaces.OddsEuroCupBusinessInterface;
import br.casaaposta.main.repository.consumer.OddsEuroCupRepository;

@Component
public class OddsEuroCupBusiness implements OddsEuroCupBusinessInterface {

	@Autowired
	private OddsEuroCupRepository oddsEuroCupRepository_;
	
	@Autowired 
	LogBusiness logger_;
	
	Log log = new Log();
	
	
	@Override
	public List<OddsEuroCup> findByDataOrderByResultadoTipoAsc(String date) throws Exception {

		try {

			return oddsEuroCupRepository_.findByDataOrderByResultadoTipoAsc(date.replace("-", "/"));

		} catch (Exception e) {

			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsEuroCupBusiness.findByDataOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}

	}

	@Override
	public List<OddsEuroCup> findByResultadoTipoOrderByResultadoTipoAsc(String type) throws Exception {

		try {

			return oddsEuroCupRepository_.findByResultadoTipoOrderByResultadoTipoAsc(type);

		} catch (Exception e) {

			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsEuroCupBusiness.findByResultadoTipoOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}

	}

	@Override
	public List<OddsEuroCup> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante) throws Exception {

		try {

			return oddsEuroCupRepository_.findByTimeVisitanteOrderByResultadoTipoAsc(timeVisitante);

		} catch (Exception e) {

			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsEuroCupBusiness.findByTimeVisitanteOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}

	}

	@Override
	public List<OddsEuroCup> findByTimeCasaOrderByResultadoTipoAsc(String timeCasa) throws Exception {
		try {
			return oddsEuroCupRepository_.findByTimeCasaOrderByResultadoTipoAsc(timeCasa);

		} catch (Exception e) {

			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsEuroCupBusiness.findByTimeCasaOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}

	}

	@Override
	public List<OddsEuroCup> findByHoraOrderByResultadoTipoAsc(String hora) throws Exception {

		try {
			return oddsEuroCupRepository_.findByHoraOrderByResultadoTipoAsc(hora);

		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsEuroCupBusiness.findByHoraOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}

	}

	@Override
	public List<OddsEuroCup> findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(String timeCasa,
			String timeVisitante) throws Exception {

		try {

			return oddsEuroCupRepository_.findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(timeCasa,
					timeVisitante);

		} catch (Exception e) {

			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsEuroCupBusiness.findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}

	}

	@Override
	public List<OddsEuroCup> findAll() throws Exception {

		try {
			return oddsEuroCupRepository_.findAll();
		} catch (Exception e) {

			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsEuroCupBusiness.findAll");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}

	}

	@Override
	public List<OddsEuroCup> findByTollTipIsNotNull() throws Exception {
		
		try {
			
			return oddsEuroCupRepository_.findByTollTipIsNotNull();
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsEuroCupBusiness.findAll");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}
		
		
		
	}

}
