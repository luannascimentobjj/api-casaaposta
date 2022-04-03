package br.casaaposta.main.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.casaaposta.main.entity.consumer.OddsEuroCup;
import br.casaaposta.main.interfaces.OddsEuroCupDataInterface;
import br.casaaposta.main.repository.consumer.OddsEuroCupRepository;

@Component
public class OddsEuroCupData implements OddsEuroCupDataInterface {

	@Autowired
	private OddsEuroCupRepository oddsEuroCupRepository_;

	@Override
	public List<OddsEuroCup> findByDataOrderByResultadoTipoAsc(String date) {

		try {

			return oddsEuroCupRepository_.findByDataOrderByResultadoTipoAsc(date.replace("-", "/"));

		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public List<OddsEuroCup> findByResultadoTipoOrderByResultadoTipoAsc(String type) {

		try {

			return oddsEuroCupRepository_.findByResultadoTipoOrderByResultadoTipoAsc(type);

		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public List<OddsEuroCup> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante) {

		try {

			return oddsEuroCupRepository_.findByTimeVisitanteOrderByResultadoTipoAsc(timeVisitante);

		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public List<OddsEuroCup> findByTimeCasaOrderByResultadoTipoAsc(String timeCasa) {
		try {
			return oddsEuroCupRepository_.findByTimeCasaOrderByResultadoTipoAsc(timeCasa);

		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public List<OddsEuroCup> findByHoraOrderByResultadoTipoAsc(String hora) {

		try {
			return oddsEuroCupRepository_.findByHoraOrderByResultadoTipoAsc(hora);

		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List<OddsEuroCup> findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(String timeCasa,
			String timeVisitante) {

		try {

			return oddsEuroCupRepository_.findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(timeCasa,
					timeVisitante);

		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public List<OddsEuroCup> findAll() {

		try {
			return oddsEuroCupRepository_.findAll();
		} catch (Exception e) {

			return null;
		}

	}

}
