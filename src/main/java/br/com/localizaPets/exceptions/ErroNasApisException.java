package br.com.localizaPets.exceptions;

import java.rmi.ServerException;

public class ErroNasApisException extends ServerException {
    public ErroNasApisException(String erroMenssage) {
        super(erroMenssage);
    }

}
