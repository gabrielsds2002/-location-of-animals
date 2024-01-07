package br.com.localizapets.entrypoint.controller.exceptions;

import br.com.localizapets.commons.DataModelResponse;
import br.com.localizapets.entrypoint.controller.SearchController;
import br.com.localizapets.entrypoint.controller.exceptions.response.LocationPetResponse;
import br.com.localizapets.entrypoint.model.request.LocationModelRequest;
import br.com.localizapets.mocks.LocationMock;
import br.com.localizapets.usecase.LocationUseCase;
import br.com.localizapets.usecase.domain.LocationPet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static br.com.localizapets.entrypoint.controller.exceptions.enums.UrlErrorEnum.BAD_REQUEST;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;
public class HandlerControllerAdviceExceptionTest {


    HandlerControllerAdviceException handlerControllerAdviceException;
    SearchController searchController;

    @BeforeEach
    public void setup() {

        handlerControllerAdviceException = new HandlerControllerAdviceException();
    }

    @Test
    public void testHandleInternalServerError() {
        Exception exception =new Exception();
        ResponseEntity<?> response = handlerControllerAdviceException.handleInternalServer(exception);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
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
    public void testHandleNoContentError() {
        ResponseEntity<?> response = handlerControllerAdviceException.handleNoContent();
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }


}
