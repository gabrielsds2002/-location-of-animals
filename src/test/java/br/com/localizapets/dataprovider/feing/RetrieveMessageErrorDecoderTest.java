package br.com.localizapets.dataprovider.feing;

import br.com.localizapets.exceptions.BadRequestExcepition;
import br.com.localizapets.exceptions.InternalServerError;
import br.com.localizapets.exceptions.NotFoundExcepition;
import br.com.localizapets.exceptions.UnprocessableException;
import feign.Response;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RetrieveMessageErrorDecoderTest {


    @Test
    public void testDecodeBadRequest() {
        Response response = Response.builder()
                .status(400)
                .build();
        RetreiveMessageErrorDecoder decoder = new RetreiveMessageErrorDecoder();
        BadRequestExcepition exception = assertThrows(BadRequestExcepition.class,
                () -> decoder.decode("methodKey", response));
        assertEquals("Data sent to api Invalid", exception.getMessage());
    }

    @Test
    public void testNotFoundExcepition() {

        Response response = Response.builder()
                .status(404)
                .build();
        RetreiveMessageErrorDecoder decoder = new RetreiveMessageErrorDecoder();
        NotFoundExcepition exception = assertThrows(NotFoundExcepition.class,
                () -> decoder.decode("methodKey", response));
        assertEquals("Data not found", exception.getMessage());
    }

    @Test
    public void testDecodeNotFound() {
        Response response = Response.builder()
                .build();
        RetreiveMessageErrorDecoder decoder = new RetreiveMessageErrorDecoder();
        NotFoundExcepition exception = assertThrows(NotFoundExcepition.class,
                () -> decoder.decode("methodKey", response));
        assertEquals("Data not found", exception.getMessage());
    }

    @Test
    public void testUnprocessableException() {
        Response response = Response.builder()
                .status(422)
                .build();
        RetreiveMessageErrorDecoder decoder = new RetreiveMessageErrorDecoder();
        UnprocessableException exception = assertThrows(UnprocessableException.class,
                () -> decoder.decode("methodKey", response));
        assertEquals("Unable to process data", exception.getMessage());
    }

    @Test
    public void testInternalServerError() {
        Response response = Response.builder()
                .status(422)
                .body("".getBytes())
                .build();
        RetreiveMessageErrorDecoder decoder = new RetreiveMessageErrorDecoder();
        InternalServerError exception = assertThrows(InternalServerError.class,
                () -> decoder.decode("methodKey", response));
        assertEquals("Unable to process data", exception.getMessage());
    }
}
