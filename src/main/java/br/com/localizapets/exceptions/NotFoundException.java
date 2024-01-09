package br.com.localizapets.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String erroMenssage) {
        super(erroMenssage);
    }
}
