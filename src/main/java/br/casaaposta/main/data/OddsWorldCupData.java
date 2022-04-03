package br.casaaposta.main.data;

import java.util.List;

import br.casaaposta.main.entity.consumer.OddsWorldCup;
import br.casaaposta.main.interfaces.OddsWorldCupDataInterface;

public class OddsWorldCupData implements OddsWorldCupDataInterface{

	@Override
	public List<OddsWorldCup> findByDataOrderByResultadoTipoAsc(String data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OddsWorldCup> findByResultadoTipoOrderByResultadoTipoAsc(String resultadoTipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OddsWorldCup> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OddsWorldCup> findByTimeCasaOrderByResultadoTipoAsc(String timeVisitante) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OddsWorldCup> findByHoraOrderByResultadoTipoAsc(String hora) {
		// TODO Auto-generated method stub
		return null;
	}

}
