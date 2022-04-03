package br.casaaposta.main.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.casaaposta.main.entity.consumer.OddsPremierCup;
import br.casaaposta.main.interfaces.OddsPremierCupDataInterface;
import br.casaaposta.main.repository.consumer.OddsPremierCupRepository;

@Component
public class OddsPremierCupData implements OddsPremierCupDataInterface {

	@Autowired
	private OddsPremierCupRepository oddsPremierCupRepository_;


	@Override
	public List<OddsPremierCup> findByDataOrderByResultadoTipoAsc(String date) {
		try {
			
			return oddsPremierCupRepository_.findByDataOrderByResultadoTipoAsc(date.replace("-", "/"));
			
		} catch (Exception e) {
			
			return null;
		}
		
	}

	@Override
	public List<OddsPremierCup> findByResultadoTipoOrderByResultadoTipoAsc(String type) {

		try {
			
			return oddsPremierCupRepository_.findByResultadoTipoOrderByResultadoTipoAsc(type);
			
		} catch (Exception e) {
			
			return null;
			
		}
		
	
	}

	@Override
	public List<OddsPremierCup> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante) {

		try {
			
			return oddsPremierCupRepository_.findByTimeVisitanteOrderByResultadoTipoAsc(timeVisitante);
			
		} catch (Exception e) {
			
			return null;
			
		}
	
		
		
	}

	@Override
	public List<OddsPremierCup> findByTimeCasaOrderByResultadoTipoAsc(String timeCasa) {

		try {
			return oddsPremierCupRepository_.findByTimeCasaOrderByResultadoTipoAsc(timeCasa);
			
		} catch (Exception e) {
			
			return null;
		}

		
	}

	@Override
	public List<OddsPremierCup> findByHoraOrderByResultadoTipoAsc(String hora) {

		try {
			return oddsPremierCupRepository_.findByHoraOrderByResultadoTipoAsc(hora);

		} catch (Exception e) {
			
			return null;
		}

	}

	@Override
	public List<OddsPremierCup> findAll() {
		try {
			return oddsPremierCupRepository_.findAll();
		} catch (Exception e) {
			
			return null;
		}
		
	}

}