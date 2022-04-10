package br.casaaposta.main.business;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.casaaposta.main.entity.api.Log;
import br.casaaposta.main.entity.consumer.TipoResultado;
import br.casaaposta.main.interfaces.TipoResultadoBusinessInterface;
import br.casaaposta.main.repository.consumer.TipoResultadoRepository;

@Component
public class TipoResultadoBusiness implements TipoResultadoBusinessInterface{

	@Autowired 
	private TipoResultadoRepository tipoResultadoRepository_;
	
	@Autowired 
	LogBusiness logger_;
	
	Log log = new Log();
	
	@Override
	public List<TipoResultado> findAll() throws Exception {
		try {
			
			return  tipoResultadoRepository_.findAll();
			
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, TipoResultadoBusiness.findAll");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
			
		}
		
	}

}
