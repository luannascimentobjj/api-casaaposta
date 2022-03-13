package br.casaaposta.main.repository.consumer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.casaaposta.main.entity.consumer.TipoResultado;

public interface TipoResultadoRepository extends JpaRepository<TipoResultado, Long>{
	
	List<TipoResultado> findAll();

}
