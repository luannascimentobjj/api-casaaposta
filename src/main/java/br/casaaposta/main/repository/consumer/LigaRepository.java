package br.casaaposta.main.repository.consumer;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.casaaposta.main.entity.consumer.Liga;

public interface LigaRepository extends JpaRepository<Liga, Integer> {

	@Query("Select l from Liga l where l.codLiga = :codLiga")
	Optional<Liga> findByCodLiga(String codLiga);

	List<Liga> findAll();
	
	
}
