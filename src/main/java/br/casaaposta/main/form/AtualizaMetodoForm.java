package br.casaaposta.main.form;
import java.util.Optional;
import javax.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;
import br.casaaposta.main.entity.api.Metodo;
import lombok.Data;

@Data
@Component
public class AtualizaMetodoForm {


	@NotBlank(message = "O campo metodo é obrigatório!")
    private String metodo;

	@NotBlank(message = "O campo equipeCasa é obrigatório!")
    private String equipeCasa;

	@NotBlank(message = "O campo equipeVisitante é obrigatório!")
    private String equipeVisitante;

	@NotBlank(message = "O campo mercado é obrigatório!")
    private String mercado;

	@NotBlank(message = "O campo odds é obrigatório!")
    private String odds;

	@NotBlank(message = "O campo liga é obrigatório!")
    private String liga;

	@NotBlank(message = "O campo entradas é obrigatório!")
    private String entradas;

	@NotBlank(message = "O campo resultados é obrigatório!")
    private String resultados;

	@NotBlank(message = "O campo hora é obrigatório!")
    private String hora;

	@NotBlank(message = "O campo data é obrigatório!")
    private String data;

    public Metodo atualizar (Optional<Metodo> optMetodo, AtualizaMetodoForm form){
    	
    	
    	optMetodo.get().setMetodo(form.metodo);
    	optMetodo.get().setEquipeCasa(form.equipeCasa);
    	optMetodo.get().setEquipeVisitante(form.equipeVisitante);
    	optMetodo.get().setMercado(form.mercado);
    	optMetodo.get().setOdds(form.odds);
    	optMetodo.get().setLiga(form.liga);
    	optMetodo.get().setEntradas(form.entradas);
    	optMetodo.get().setResultados(form.resultados);
    	optMetodo.get().setHora(form.hora);
    	optMetodo.get().setData(form.data);
    	Metodo  met = optMetodo.get();
    	return met;
    }
	
}
