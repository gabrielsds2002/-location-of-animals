package br.com.localizapets.exceptions;

public class InternalServerError extends RuntimeException {
    public InternalServerError(String erroMenssage) {
        super(erroMenssage);
    }
}
