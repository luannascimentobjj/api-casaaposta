package br.casaaposta.main.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LigaDTO")
@NoArgsConstructor
@Data
public class Liga implements Serializable {
	

	private static final long serialVersionUID = 2772217429037525001L;

	
	@Id
	@Column(name = "codLiga")
	public String codLiga;
	
	@Column(name ="NomeLiga")
	private String nomeLiga;
		
	@OneToMany(mappedBy = "codLiga")
	private List<OddsEuroCup> oddsEuroCup;
	
	@OneToMany(mappedBy = "codLiga")
	private List<Resultado> resultado;
	

}
