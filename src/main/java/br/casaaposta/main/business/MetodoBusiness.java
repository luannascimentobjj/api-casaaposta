package br.casaaposta.main.business;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.casaaposta.main.dto.MetodoDTO;
import br.casaaposta.main.entity.api.Log;
import br.casaaposta.main.entity.api.Metodo;
import br.casaaposta.main.interfaces.MetodoBusinessInterface;
import br.casaaposta.main.repository.api.MetodoRespository;

@Component
public class MetodoBusiness implements MetodoBusinessInterface {

	@Autowired
	private MetodoRespository metodoRepository_;

	@Autowired
	LogBusiness logger_;

	Log log = new Log();

	@Override
	public Metodo findByMetodo(MetodoDTO metodoDTO) {

		try {

		} catch (Exception e) {

		}

		return null;
	}

	@Override
	public void save(Metodo metodo) throws Exception {

		try {
			metodoRepository_.save(metodo);

		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, MetodoBusiness.save");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}

	}

	@Override
	public Optional<Metodo> findById(Long id) throws Exception {

		try {
			
			Optional<Metodo> metsOps = metodoRepository_.findById(id);
			if (metsOps.isEmpty()) {
				return Optional.empty();
			}else {
				return metsOps;
			}
			
		} catch (Exception e) {

			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, MetodoBusiness.findById");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}

	}

	@Override
	public List<Metodo> findAll() throws Exception {

		try {
			return metodoRepository_.findAll();
		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, MetodoBusiness.findAll");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}

	}

	@Override
	public void deleteById(Long id) throws Exception {

		try {

			metodoRepository_.deleteById(id);

		} catch (Exception e) {
			
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao executar o método, MetodoBusiness.deleteById");
			log.setDataInclusao(LocalDateTime.now());
			logger_.save(log);
			throw new Exception(e);
		}

	}

}
