package br.casaaposta.main.data;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.casaaposta.main.dto.MetodoDTO;
import br.casaaposta.main.entity.api.Metodo;
import br.casaaposta.main.interfaces.MetodoDataInterface;
import br.casaaposta.main.repository.api.MetodoRespository;

@Component
public class MetodoData implements MetodoDataInterface {

	@Autowired
	private MetodoRespository metodoRepository_;

	@Override
	public Metodo findByMetodo(MetodoDTO metodoDTO) {

		try {

		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	@Override
	public void save(Metodo metodo) {

		try {
			metodoRepository_.save(metodo);

		} catch (Exception e) {

		}

	}

	@Override
	public Optional<Metodo> findById(Long id) {

		try {

			return metodoRepository_.findById(id);

		} catch (Exception e) {

			return Optional.empty();
		}

	}

	@Override
	public List<Metodo> findAll() {

		try {
			return metodoRepository_.findAll();
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public void deleteById(Long id) {

		try {

			metodoRepository_.deleteById(id);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
