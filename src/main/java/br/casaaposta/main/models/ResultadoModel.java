package br.casaaposta.main.models;

import lombok.Data;

@Data
public class ResultadoModel {

	private int Id;
	
	private int IdLiga;
	
	private String resultado;
	
	private String data;
	
	private String jogo;
	
	private String resultadoTipo;
	
}
