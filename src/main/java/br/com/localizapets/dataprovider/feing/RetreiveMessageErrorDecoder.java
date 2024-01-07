package br.com.localizapets.dataprovider.feing;

import br.com.localizapets.exceptions.BadRequestExcepition;
import br.com.localizapets.exceptions.InternalServerError;
import br.com.localizapets.exceptions.NotFoundExcepition;
import br.com.localizapets.exceptions.UnprocessableException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;


import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class RetreiveMessageErrorDecoder implements ErrorDecoder {
    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {

        return switch (response.status()) {
            case 400 -> new BadRequestExcepition("Data sent to api Invalid");
            case 404 -> new NotFoundExcepition("Data not found");
            case 422 -> new UnprocessableException("Unable to process data");
            case 500 -> new InternalServerError("Internal error");
            default -> errorDecoder.decode(methodKey, response);
        };



    }
}

