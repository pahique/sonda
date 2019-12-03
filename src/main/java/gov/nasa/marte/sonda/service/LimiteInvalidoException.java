package gov.nasa.marte.sonda.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Limite inválido!")
public class LimiteInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 8620013312149559969L;

	public LimiteInvalidoException(String message) {
		super(message);
	}
}
