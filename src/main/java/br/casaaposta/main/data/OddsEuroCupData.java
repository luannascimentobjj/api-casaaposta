package br.casaaposta.main.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.casaaposta.main.entity.consumer.OddsEuroCup;
import br.casaaposta.main.interfaces.OddsEuroCupDataInterface;
import br.casaaposta.main.repository.consumer.OddsEuroCupRepository;
@Component
public class OddsEuroCupData implements OddsEuroCupDataInterface{

	@Autowired
	private OddsEuroCupRepository oddsEuroCupRepository_;
	
	@Override
	public OddsEuroCup findByTollTipAndMinutoAndHoraAndResultadoTipo(String toolTip, int minuto, int hora,
			String resultadoTipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OddsEuroCup> findByDataOrderByResultadoTipoAsc(String data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OddsEuroCup> findByResultadoTipoOrderByResultadoTipoAsc(String resultadoTipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OddsEuroCup> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OddsEuroCup> findByTimeCasaOrderByResultadoTipoAsc(String timeVisitante) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OddsEuroCup> findByHoraOrderByResultadoTipoAsc(String hora) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OddsEuroCup> findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(String timeCasa,
			String timeVisitante) {
		// TODO Auto-generated method stub
		return null;
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
