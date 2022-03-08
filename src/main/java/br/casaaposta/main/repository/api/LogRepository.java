package br.casaaposta.main.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;

import br.casaaposta.main.entity.api.Log;

public interface LogRepository extends JpaRepository<Log, Long>{

}
