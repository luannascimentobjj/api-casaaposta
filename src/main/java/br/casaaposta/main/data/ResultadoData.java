package br.casaaposta.main.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.casaaposta.main.entity.consumer.Liga;
import br.casaaposta.main.entity.consumer.Resultado;
import br.casaaposta.main.interfaces.ResultadoDataInterface;
import br.casaaposta.main.repository.consumer.ResultadoRepository;

@Component
public class ResultadoData implements ResultadoDataInterface{

	@Autowired
	private ResultadoRepository resultadoRepoRespository_;
	

	@Override
	public List<Resultado> findByCodLigaOrderByResultadoTipoAsc(Liga liga) {
		try {
			
			return resultadoRepoRespository_.findByCodLigaOrderByResultadoTipoAsc(liga);
			
		} catch (Exception e) {
			
			return null;
		}
		
	}

	@Override
	public List<Resultado> findByDataOrderByResultadoTipoAsc(String data) {
		try {
			
			return resultadoRepoRespository_.findByDataOrderByResultadoTipoAsc(data.replace("-", "/"));
			
		} catch (Exception e) {
			
			return null;
		}
		
	}

	@Override
	public List<Resultado> findByResultadoTipoOrderByResultadoTipoAsc(String type) {
		
		try {
			
			return resultadoRepoRespository_.findByResultadoTipoOrderByResultadoTipoAsc(type);
			
		} catch (Exception e) {
			
			return null;
		}
		
	}

	@Override
	public List<Resultado> findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(String timeCasa,
			String timeVisitante) {
		try {
			return resultadoRepoRespository_.findByTimeCasaAndTimeVisitanteOrderByResultadoTipoAsc(timeCasa, timeVisitante);
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public List<Resultado> findByTimeVisitanteOrderByResultadoTipoAsc(String timeVisitante) {
		try {
			return  resultadoRepoRespository_.findByTimeVisitanteOrderByResultadoTipoAsc(timeVisitante);
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public List<Resultado> findByTimeCasaOrderByResultadoTipoAsc(String timeCasa) {
		try {
			return resultadoRepoRespository_.findByTimeCasaOrderByResultadoTipoAsc(timeCasa);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Resultado> findByHoraOrderByResultadoTipoAsc(String hora) {
		try {
			return resultadoRepoRespository_.findByHoraOrderByResultadoTipoAsc(hora);
		} catch (Exception e) {
			return null;
		}
	}

}
