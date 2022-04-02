package br.casaaposta.main.model;
import java.io.Serializable;
import lombok.Data;

@Data
public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -6701101199287976087L;
	
	private final String jwttoken;
	
	
	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}
}
