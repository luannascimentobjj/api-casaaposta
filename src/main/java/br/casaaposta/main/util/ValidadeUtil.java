package br.casaaposta.main.util;

import br.casaaposta.main.entity.api.Usuario;

public class ValidadeUtil {

	public boolean validaEmail(Usuario usuario) {

		try {

			if (usuario.getEmail().matches("/^[a-z0-9.]+@[a-z0-9]+\\.[a-z]+\\.([a-z]+)?$/i")) {
				return true;
			}
			return false;

		} catch (Exception e) {
			return false;
		}
		
	}
	
}
