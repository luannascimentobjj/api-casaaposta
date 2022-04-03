package br.casaaposta.main.data;

import java.util.List;

import br.casaaposta.main.entity.consumer.OddsEuroCup;
import br.casaaposta.main.entity.consumer.OddsPremierCup;
import br.casaaposta.main.interfaces.OddsPremierCupDataInterface;

public class OddsPremierCupData implements OddsPremierCupDataInterface {

	@Override
	public OddsEuroCup findByTollTipAndMinutoAndHoraAndResultadoTipo(String toolTip, int minuto, int hora,
			String resultadoTipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OddsPremierCup> findByDataOrderByResultadoTipoAsc(String data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OddsPremierCup> findByResultadoTipoOrderByResultadoTipoAsc(String resultadoTipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OddsPremierCup> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OddsPremierCup> findByTimeCasaOrderByResultadoTipoAsc(String timeVisitante) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OddsPremierCup> findByHoraOrderByResultadoTipoAsc(String hora) {
		// TODO Auto-generated method stub
		return null;
	}

}