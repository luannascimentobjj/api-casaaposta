package br.casaaposta.main.form;

import br.casaaposta.main.dto.MetodoDTO;
import br.casaaposta.main.entity.api.Metodo;
import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class MetodoForm {

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

    public Metodo converter (MetodoForm metodo){
        return new Metodo(metodo);
    }

    public MetodoDTO converterToDTO (Metodo metodo){
        return new MetodoDTO(metodo);
    }
    
}
