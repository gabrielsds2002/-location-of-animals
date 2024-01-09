package br.com.locationpets.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String erroMenssage) {
        super(erroMenssage);
    }
}
