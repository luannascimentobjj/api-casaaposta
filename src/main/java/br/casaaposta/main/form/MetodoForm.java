package br.casaaposta.main.form;

import br.casaaposta.main.dto.MetodoDTO;
import br.casaaposta.main.entity.api.Metodo;
import lombok.Data;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

@Data
@Component
public class MetodoForm {

	@NotBlank(message = "The method field is required!")
    private String method;

	@NotBlank(message = "The homeTeam field is required!")
    private String homeTeam;

	@NotBlank(message = "The visitingTeam field is required!")
    private String visitingTeam;

	@NotBlank(message = "The market field is required!")
    private String market;

	@NotBlank(message = "The odds field is required!")
    private String odds;

	@NotBlank(message = "The league field is required!")
    private String league;

	@NotBlank(message = "The bets field is required!")
    private String bets;

	@NotBlank(message = "The method field is required!")
    private String results;

	@NotBlank(message = "The method field is required!")
    private String hour;

	@NotBlank(message = "The method field is required!")
    private String date;

    public Metodo converter (MetodoForm metodo){
        return new Metodo(metodo);
    }

    public MetodoDTO converterToDTO (Metodo metodo){
        return new MetodoDTO(metodo);
    }
    
}
