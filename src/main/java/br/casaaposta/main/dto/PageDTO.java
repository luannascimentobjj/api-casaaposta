package br.casaaposta.main.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import br.casaaposta.main.entity.consumer.OddsEuroCup;
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
	
	public static PageDTO convertEuroPaging(Page<OddsEuroCup> rpageable, List<OddsDTO> listToConver) {
		PageDTO paging = new PageDTO(rpageable.getTotalPages(), rpageable.getTotalElements(), rpageable.getSize(),
				rpageable.getNumberOfElements(), rpageable.getNumber(), listToConver);
		return paging;
	}
	
}
