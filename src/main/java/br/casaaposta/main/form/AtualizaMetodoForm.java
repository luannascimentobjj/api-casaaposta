package br.casaaposta.main.form;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.casaaposta.main.entity.api.Metodo;
import br.casaaposta.main.repository.api.MetodoRespository;
import lombok.Data;

@Data
public class AtualizaMetodoForm {


    @NotNull @NotEmpty
    private String metodo;

    @NotNull @NotEmpty
    private String equipeCasa;

    @NotNull @NotEmpty
    private String equipeVisitante;

    @NotNull @NotEmpty
    private String mercado;

    @NotNull @NotEmpty
    private String odds;

    @NotNull @NotEmpty
    private String liga;

    @NotNull @NotEmpty
    private String entradas;

    @NotNull @NotEmpty
    private String resultados;

    @NotNull @NotEmpty
    private String hora;

    @NotNull @NotEmpty
    private String data;

    public Metodo atualizar (Long id, MetodoRespository metodoRepository_){
    	Metodo met = metodoRepository_.getById(id);
    	met.setMetodo(this.metodo);
    	met.setEquipeCasa(this.equipeCasa);
    	met.setEquipeVisitante(this.equipeVisitante);
    	met.setMercado(this.mercado);
    	met.setOdds(this.odds);
    	met.setLiga(this.liga);
    	met.setEntradas(this.entradas);
    	met.setResultados(this.resultados);
    	met.setHora(this.hora);
    	met.setData(this.data);
    	return met;
    }
	
}
