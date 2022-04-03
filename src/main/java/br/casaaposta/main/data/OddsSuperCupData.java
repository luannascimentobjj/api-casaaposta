package br.casaaposta.main.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.casaaposta.main.entity.consumer.OddsSuperCup;
import br.casaaposta.main.interfaces.OddsSuperCupDataInterface;
import br.casaaposta.main.repository.consumer.OddsSuperCupRepository;

@Component
public class OddsSuperCupData implements OddsSuperCupDataInterface {

	@Autowired
	private OddsSuperCupRepository oddsSuperCupRepository_;

	@Override
	public List<OddsSuperCup> findByDataOrderByResultadoTipoAsc(String date) {

		try {

			return oddsSuperCupRepository_.findByDataOrderByResultadoTipoAsc(date.replace("-", "/"));

		} catch (Exception e) {

			return null;

		}

	}

	@Override
	public List<OddsSuperCup> findByResultadoTipoOrderByResultadoTipoAsc(String type) {

		try {

			return oddsSuperCupRepository_.findByResultadoTipoOrderByResultadoTipoAsc(type);

		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public List<OddsSuperCup> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante) {

		try {

			return oddsSuperCupRepository_.findByTimeVisitanteOrderByResultadoTipoAsc(timeVisitante);

		} catch (Exception e) {

			return null;

		}

	}

	@Override
	public List<OddsSuperCup> findByTimeCasaOrderByResultadoTipoAsc(String timeCasa) {
	
		try {
			
			return oddsSuperCupRepository_.findByTimeCasaOrderByResultadoTipoAsc(timeCasa);
			
		} catch (Exception e) {
			
			return null;
		}
	
	}

	@Override
	public List<OddsSuperCup> findByHoraOrderByResultadoTipoAsc(String hora) {
		
		try {
		
			return oddsSuperCupRepository_.findByHoraOrderByResultadoTipoAsc(hora);
		
		} catch (Exception e) {
			
			return null;
		}
		
		
		
		
	}

	@Override
	public List<OddsSuperCup> findAll() {

		try {

			return oddsSuperCupRepository_.findAll();

		} catch (Exception e) {

			return null;
		}

	}

}
