package br.com.localizapets.exceptions;

public class UnprocessableException extends RuntimeException {

    public UnprocessableException(String mensagem) {
        super(mensagem);
    }
}
