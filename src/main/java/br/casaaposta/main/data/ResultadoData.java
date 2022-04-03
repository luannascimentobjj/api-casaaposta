package br.casaaposta.main.data;

import java.util.List;

import br.casaaposta.main.entity.consumer.Liga;
import br.casaaposta.main.entity.consumer.Resultado;
import br.casaaposta.main.interfaces.ResultadoDataInterface;

public class ResultadoData implements ResultadoDataInterface{

	@Override
	public Resultado findByTollTipAndMinutoAndHoraAndResultadoTipo(String toolTip, int minuto, int hora,
			String resultadoTipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resultado> findByCodLigaOrderByResultadoTipoAsc(Liga liga) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resultado> findByDataOrderByResultadoTipoAsc(String data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resultado> findByResultadoTipoOrderByResultadoTipoAsc(String resultadoTipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resultado> findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(String timeCasa,
			String timeVisitante) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resultado> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resultado> findByTimeCasaOrderByResultadoTipoAsc(String timeVisitante) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resultado> findByHoraOrderByResultadoTipoAsc(String hora) {
		// TODO Auto-generated method stub
		return null;
	}

}
