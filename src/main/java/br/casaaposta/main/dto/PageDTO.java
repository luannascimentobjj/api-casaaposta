package br.casaaposta.main.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageDTO {

	private int totalPages;
	
	private Long totalElemtents;
	
	private int size;
	
	private int numberOfElements;
	
	private int pageNumber;
	
	private List<OddsDTO> listaOdds;
	
}
