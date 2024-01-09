package br.com.locationpets.exceptions;

public class UnprocessableException extends RuntimeException {

    public UnprocessableException(String mensagem) {
        super(mensagem);
    }
}
