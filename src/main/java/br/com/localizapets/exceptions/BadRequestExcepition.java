package br.com.localizapets.exceptions;

public class BadRequestExcepition extends RuntimeException {

    public BadRequestExcepition(String erroMenssage) {
        super(erroMenssage);
    }
}
