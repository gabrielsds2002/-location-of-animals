package br.com.localizapets.exceptions;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;


import java.io.IOException;
import java.io.InputStream;

public class RetreiveMessageErrorDecoder implements ErrorDecoder {
    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {

            switch (response.status()) {
                case 400:
                    return new BadRequestExcepition("Dados Enviados para api Invalido");
                case 404:
                    return new NotFoundExcepition ("Dados não encontrados");
                case 422:
                    return new UnprocessableException("Não foi possivel processar os dados");
                default:
                    return errorDecoder.decode(methodKey, response);
            }



    }
}

