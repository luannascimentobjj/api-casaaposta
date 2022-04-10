package br.casaaposta.main.form;
import java.util.Optional;
import javax.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;
import br.casaaposta.main.entity.api.Metodo;
import lombok.Data;

@Data
@Component
public class AtualizaMetodoForm {


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

    public Metodo atualizar (Optional<Metodo> optMetodo, AtualizaMetodoForm form){
    	
    	
    	optMetodo.get().setMetodo(form.method);
    	optMetodo.get().setEquipeCasa(form.homeTeam);
    	optMetodo.get().setEquipeVisitante(form.visitingTeam);
    	optMetodo.get().setMercado(form.market);
    	optMetodo.get().setOdds(form.odds);
    	optMetodo.get().setLiga(form.league);
    	optMetodo.get().setEntradas(form.bets);
    	optMetodo.get().setResultados(form.results);
    	optMetodo.get().setHora(form.hour);
    	optMetodo.get().setData(form.date);
    	Metodo  met = optMetodo.get();
    	return met;
    }
	
}
