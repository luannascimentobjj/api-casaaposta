package br.casaaposta.main.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import br.casaaposta.main.entity.consumer.OddsEuroCup;
import br.casaaposta.main.entity.consumer.OddsPremierCup;
import br.casaaposta.main.entity.consumer.OddsSuperCup;
import br.casaaposta.main.entity.consumer.OddsWorldCup;
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
	
	public static PageDTO convertEuroCupToPaging(Page<OddsEuroCup> rpageable, List<OddsDTO> listToConver) {
		PageDTO paging = new PageDTO(rpageable.getTotalPages(), rpageable.getTotalElements(), rpageable.getSize(),
				rpageable.getNumberOfElements(), rpageable.getNumber(), listToConver);
		return paging;
	}
	
	
	public static PageDTO convertPremierCupToPaging(Page<OddsPremierCup> rpageable, List<OddsDTO> listToConver) {
		PageDTO paging = new PageDTO(rpageable.getTotalPages(), rpageable.getTotalElements(), rpageable.getSize(),
				rpageable.getNumberOfElements(), rpageable.getNumber(), listToConver);
		return paging;
	}
	
	public static PageDTO convertSuperCupToPaging(Page<OddsSuperCup> rpageable, List<OddsDTO> listToConver) {
		PageDTO paging = new PageDTO(rpageable.getTotalPages(), rpageable.getTotalElements(), rpageable.getSize(),
				rpageable.getNumberOfElements(), rpageable.getNumber(), listToConver);
		return paging;
	}
	
	public static PageDTO convertWorldCupToPaging(Page<OddsWorldCup> rpageable, List<OddsDTO> listToConver) {
		PageDTO paging = new PageDTO(rpageable.getTotalPages(), rpageable.getTotalElements(), rpageable.getSize(),
				rpageable.getNumberOfElements(), rpageable.getNumber(), listToConver);
		return paging;
	}
	
}
