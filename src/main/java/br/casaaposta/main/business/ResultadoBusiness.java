package br.casaaposta.main.business;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.casaaposta.main.entity.api.Log;
import br.casaaposta.main.entity.consumer.Liga;
import br.casaaposta.main.entity.consumer.Resultado;
import br.casaaposta.main.interfaces.ResultadoBusinessInterface;
import br.casaaposta.main.repository.consumer.ResultadoRepository;

@Component
public class ResultadoBusiness implements ResultadoBusinessInterface{

	@Autowired
	private ResultadoRepository resultadoRepoRespository_;
	
	@Autowired 
	LogBusiness logger_;
	
	Log log = new Log();


	@Override
	public List<Resultado> findByCodLigaOrderByResultadoTipoAsc(Liga liga) throws Exception {
		try {
			
			return resultadoRepoRespository_.findByCodLigaOrderByResultadoTipoAsc(liga);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, ResultadoBusiness.findByCodLigaOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}
		
	}

	@Override
	public List<Resultado> findByDataOrderByResultadoTipoAsc(String data) throws Exception {
		try {
			
			return resultadoRepoRespository_.findByDataOrderByResultadoTipoAsc(data.replace("-", "/"));
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, ResultadoBusiness.findByDataOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}
		
	}

	@Override
	public List<Resultado> findByResultadoTipoOrderByResultadoTipoAsc(String type) throws Exception {
		
		try {
			
			return resultadoRepoRespository_.findByResultadoTipoOrderByResultadoTipoAsc(type);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, ResultadoBusiness.findByResultadoTipoOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}
		
	}

	@Override
	public List<Resultado> findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(String timeCasa,
			String timeVisitante) throws Exception {
		try {
			return resultadoRepoRespository_.findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(timeCasa, timeVisitante);
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, ResultadoBusiness.findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}
		
	}

	@Override
	public List<Resultado> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante) throws Exception {
		try {
			
			return  resultadoRepoRespository_.findByTimeVisitanteOrderByResultadoTipoAsc(timeVisitante);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, ResultadoBusiness.findByTimeVisitanteOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}
		
	}

	@Override
	public List<Resultado> findByTimeCasaOrderByResultadoTipoAsc(String timeCasa) throws Exception {
		try {
			
			return resultadoRepoRespository_.findByTimeCasaOrderByResultadoTipoAsc(timeCasa);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, ResultadoBusiness.findByTimeCasaOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}
	}

	@Override
	public List<Resultado> findByHoraOrderByResultadoTipoAsc(String hora) throws Exception {
		try {
			
			return resultadoRepoRespository_.findByHoraOrderByResultadoTipoAsc(hora);
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, ResultadoBusiness.findByHoraOrderByResultadoTipoAsc");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}
	}

}
