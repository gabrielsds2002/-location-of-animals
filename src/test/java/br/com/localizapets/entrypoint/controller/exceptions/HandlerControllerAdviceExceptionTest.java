package br.com.localizapets.entrypoint.controller.exceptions;

import br.com.localizapets.entrypoint.controller.LocationController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class HandlerControllerAdviceExceptionTest {


    HandlerControllerAdviceException handlerControllerAdviceException;


    @BeforeEach
    public void setup() {

        handlerControllerAdviceException = new HandlerControllerAdviceException();
    }



    @Test
    public void testHandleNotFoundError() {
        Exception exception =new Exception();
        ResponseEntity<?> response = handlerControllerAdviceException.handleNotFound(exception);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testHandleBadRequestError() {
        Exception exception =new Exception();
        ResponseEntity<?> response = handlerControllerAdviceException.handleBadRequest(exception);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testHandleunprocessableEntityRequestError() {
        Exception exception =new Exception();
        ResponseEntity<?> response = handlerControllerAdviceException.handleunprocessableEntityRequest(exception);
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
    }

    @Test
    public void testHandleUnauthorizedEntityRequestError() {
        Exception exception =new Exception();
        ResponseEntity<?> response = handlerControllerAdviceException.handleUnauthorized(exception);
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    }
}
