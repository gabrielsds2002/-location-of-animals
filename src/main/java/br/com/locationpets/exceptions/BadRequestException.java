package br.com.locationpets.exceptions;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String erroMenssage) {
        super(erroMenssage);
    }
}
