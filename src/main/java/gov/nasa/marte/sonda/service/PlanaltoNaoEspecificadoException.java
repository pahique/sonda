package gov.nasa.marte.sonda.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Planalto não encontrado!")
public class PlanaltoNaoEspecificadoException extends RuntimeException {

	private static final long serialVersionUID = 6771361913055248961L;
	
	public PlanaltoNaoEspecificadoException(String message) {
		super(message);
	}
}


