package br.com.localizapets.exceptions;

import java.rmi.ServerException;

public class InternalServerError extends RuntimeException {
    public InternalServerError(String erroMenssage) {
        super(erroMenssage);
    }



}
