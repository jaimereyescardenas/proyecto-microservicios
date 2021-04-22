package cl.escalab.microservices.exception;

import lombok.Getter;

@Getter
public class UsuarioAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 4038145292285916981L;
	
	private String message;

	public UsuarioAlreadyExistsException(String message) {
		super();
		this.message = message;
	}

}
