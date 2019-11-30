package gov.nasa.marte.sonda.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Posição inválida!")
public class PosicaoInvalidaException extends RuntimeException {

	private static final long serialVersionUID = -658972870264833589L;
	
	public PosicaoInvalidaException(String message) {
		super(message);
	}

}
