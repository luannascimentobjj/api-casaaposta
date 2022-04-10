package br.casaaposta.main.interfaces;

import java.util.List;

import br.casaaposta.main.entity.consumer.TipoResultado;

public interface TipoResultadoBusinessInterface {

	List<TipoResultado> findAll() throws Exception;
	
}
