package br.casaaposta.main.models;

import java.sql.Date;
import java.util.ArrayList;

import lombok.Data;

@Data
public class MetodoModel {

	
	private String metodo;
	private String equipeCasa;
	private String mercado;
	private String odds;
	private String liga;
	private ArrayList<Integer> entradas;
	private ArrayList<String> resultados;
	private String hora;
	private Date data;
}
