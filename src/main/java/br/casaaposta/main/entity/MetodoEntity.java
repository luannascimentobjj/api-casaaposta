package br.casaaposta.main.entity;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class MetodoEntity {

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
