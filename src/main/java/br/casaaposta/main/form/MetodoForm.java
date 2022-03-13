package br.casaaposta.main.form;

import br.casaaposta.main.dto.MetodoDTO;
import br.casaaposta.main.entity.api.Metodo;
import lombok.Data;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

@Data
@Component
public class MetodoForm {

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

    public Metodo converter (MetodoForm metodo){
        return new Metodo(metodo);
    }

    public MetodoDTO converterToDTO (Metodo metodo){
        return new MetodoDTO(metodo);
    }
    
}
