package br.com.blz.testjava.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class ProdutoDuplicadoException extends RuntimeException {

    public ProdutoDuplicadoException(String message) {
        super(message);
    }
}
