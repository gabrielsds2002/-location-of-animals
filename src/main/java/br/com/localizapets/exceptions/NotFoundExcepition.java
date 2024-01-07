package br.com.localizapets.exceptions;

public class NotFoundExcepition extends RuntimeException {

    public NotFoundExcepition(String erroMenssage) {
        super(erroMenssage);
    }
}
