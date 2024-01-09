package br.com.localizapets.exceptions;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String erroMenssage) {
        super(erroMenssage);
    }
}
