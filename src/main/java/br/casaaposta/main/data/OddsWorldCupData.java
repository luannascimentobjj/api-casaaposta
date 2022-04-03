package br.casaaposta.main.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.casaaposta.main.entity.consumer.OddsWorldCup;
import br.casaaposta.main.interfaces.OddsWorldCupDataInterface;
import br.casaaposta.main.repository.consumer.OddsWorldCupRepository;

@Component
public class OddsWorldCupData implements OddsWorldCupDataInterface{


	@Autowired
	private OddsWorldCupRepository oddsWorldCupRepository_;
	
	
	@Override
	public List<OddsWorldCup> findByDataOrderByResultadoTipoAsc(String date) {
		try {
			
			return oddsWorldCupRepository_.findByDataOrderByResultadoTipoAsc(date.replace("-", "/"));
			
		} catch (Exception e) {
			
			return null;
		}
			
		
	}

	@Override
	public List<OddsWorldCup> findByResultadoTipoOrderByResultadoTipoAsc(String type) {
		
		try {
			
			return oddsWorldCupRepository_.findByResultadoTipoOrderByResultadoTipoAsc(type);
			
		} catch (Exception e) {
			
			return null;
		}
		
		
	}

	@Override
	public List<OddsWorldCup> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante) {
		
		try {
			
			return oddsWorldCupRepository_.findByTimeVisitanteOrderByResultadoTipoAsc(timeVisitante);
			
		} catch (Exception e) {
			
			return null;
		}
		
		
	}

	@Override
	public List<OddsWorldCup> findByTimeCasaOrderByResultadoTipoAsc(String timeCasa) {

		try {
			return oddsWorldCupRepository_.findByTimeCasaOrderByResultadoTipoAsc(timeCasa);
			
		} catch (Exception e) {
			
			return null;
		}
		
		
	}

	@Override
	public List<OddsWorldCup> findByHoraOrderByResultadoTipoAsc(String hora) {
		
		try {
			
			return oddsWorldCupRepository_.findByHoraOrderByResultadoTipoAsc(hora);
			
		} catch (Exception e) {
			
			return null;
			
		}
		
		
	}

	@Override
	public List<OddsWorldCup> findAll() {
		try {
			
			return oddsWorldCupRepository_.findAll();
			
		} catch (Exception e) {
			
			return null;
			
		}
		
	}

}
