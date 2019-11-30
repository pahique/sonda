package gov.nasa.marte.sonda.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Sonda não encontrada!")
public class SondaNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 6771361913055248961L;
}


