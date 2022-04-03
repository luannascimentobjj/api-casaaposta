package br.casaaposta.main.data;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.casaaposta.main.entity.consumer.TipoResultado;
import br.casaaposta.main.interfaces.TipoResultadoDataInterface;
import br.casaaposta.main.repository.consumer.TipoResultadoRepository;

@Component
public class TipoResultadoData implements TipoResultadoDataInterface{

	@Autowired 
	private TipoResultadoRepository tipoResultadoRepository_;
	
	@Override
	public List<TipoResultado> findAll() {
		try {
			
			return  tipoResultadoRepository_.findAll();
			
		} catch (Exception e) {
			
			return null;
			
		}
		
	}

}
