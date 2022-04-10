package br.casaaposta.main.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.casaaposta.main.entity.api.Log;
import br.casaaposta.main.interfaces.LogBusinessInterface;
import br.casaaposta.main.repository.api.LogRepository;

@Component
public class LogBusiness implements LogBusinessInterface {

	@Autowired
	LogRepository logRepository_;

	@Override
	public void save(Log log) {

		logRepository_.save(log);

	}

}
