package br.casaaposta.main.business;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.casaaposta.main.dto.OddsDTO;
import br.casaaposta.main.dto.PageDTO;
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
	public List<OddsDTO> findByDataOrderByResultadoTipoAsc(String date) throws Exception {

		try {

			return OddsDTO.converterToEuroCup(oddsEuroCupRepository_.findByDataOrderByResultadoTipoAsc(date.replace("-", "/")));

		} catch (Exception e) {

			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsEuroCupBusiness.findByDataOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}

	}

	@Override
	public List<OddsDTO> findByResultadoTipoOrderByResultadoTipoAsc(String type) throws Exception {

		try {
			
			return OddsDTO.converterToEuroCup(oddsEuroCupRepository_.findByResultadoTipoOrderByResultadoTipoAsc(type));

		} catch (Exception e) {

			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsEuroCupBusiness.findByResultadoTipoOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}

	}

	@Override
	public List<OddsDTO> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante) throws Exception {

		try {
			
			return OddsDTO.converterToEuroCup(oddsEuroCupRepository_.findByTimeVisitanteOrderByResultadoTipoAsc(timeVisitante));

		} catch (Exception e) {

			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsEuroCupBusiness.findByTimeVisitanteOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}

	}

	@Override
	public List<OddsDTO> findByTimeCasaOrderByResultadoTipoAsc(String timeCasa) throws Exception {
		try {
			
			
			return OddsDTO.converterToEuroCup(oddsEuroCupRepository_.findByTimeCasaOrderByResultadoTipoAsc(timeCasa));

		} catch (Exception e) {

			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsEuroCupBusiness.findByTimeCasaOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}

	}

	@Override
	public List<OddsDTO> findByHoraOrderByResultadoTipoAsc(int hora) throws Exception {

		try {
			
			return OddsDTO.converterToEuroCup(oddsEuroCupRepository_.findByHoraOrderByResultadoTipoAsc(hora));

		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsEuroCupBusiness.findByHoraOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}

	}

	@Override
	public List<OddsDTO> findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(String timeCasa,
			String timeVisitante) throws Exception {

		try {
			
			return OddsDTO.converterToEuroCup(oddsEuroCupRepository_.findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(timeCasa,
					timeVisitante));

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
	public PageDTO findByTollTipIsNotNull(Pageable pageable) throws Exception {
		
		try {
			
			Page<OddsEuroCup> rpageable = oddsEuroCupRepository_.findByTollTipIsNotNull(pageable);
			List<OddsDTO> listToConvert = OddsDTO.converterPageableEuroCup(rpageable);
			
			// Page<OddsDTO> pages = new PageImpl<OddsDTO>(paging.getListaOdds());

			return PageDTO.convertEuroCupToPaging(rpageable, listToConvert);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsEuroCupBusiness.findAll");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}
		
				
	}



	@Override
	public List<String> findDistinctTimeVisitanteByTimeVisitanteIsNotNull() throws Exception {
		
		try {
			
					
			return oddsEuroCupRepository_.findDistinctTimeVisitanteByTimeVisitanteIsNotNull();
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsEuroCupBusiness.findDistinctTimeVisitanteByTimeVisitanteIsNotNull");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}
		
	}

	@Override
	public List<String> findDistinctHora() throws Exception {

		try {
			
			return oddsEuroCupRepository_.findDistinctHora();
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, OddsEuroCupBusiness.findDistinctHora");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}

	}	

}
