package br.casaaposta.main.entity.api;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Usuario")
@Data
public class Usuario {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String usuario;
	private String senha;
	private boolean isAdmin;
	private LocalDateTime dataInclusaoRegistro;
}
