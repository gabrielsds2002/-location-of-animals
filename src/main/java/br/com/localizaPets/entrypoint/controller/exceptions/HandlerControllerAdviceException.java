package br.com.localizapets.entrypoint.controller.exceptions;

import br.com.localizapets.entrypoint.controller.exceptions.enums.UrlErrorEnum;
import br.com.localizapets.exceptions.*;
import br.com.localizapets.usecase.domain.response.ErrorModelResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerControllerAdviceException extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<?> handleNoContent() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler({ Exception.class, InternalServerError.class })
    public ResponseEntity<?> handleInternalServer(Exception exception) {
        ErrorModelResponse errorModelResponse = ErrorModelResponse.builder()
                .code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .message(exception.getMessage())
                .urlError(UrlErrorEnum.searchUrl(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .build();

        return new ResponseEntity<>(errorModelResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ NotFoundExcepition.class })
    public ResponseEntity<?> handleNotFound(Exception exception) {
        ErrorModelResponse errorModelResponse = ErrorModelResponse.builder()
                .code(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .message(exception.getMessage())
                .urlError(UrlErrorEnum.searchUrl(HttpStatus.NOT_FOUND.value()))
                .build();

        return new ResponseEntity<>(errorModelResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ BadRequestException.class })
    public ResponseEntity<?> handleBadRequest(Exception exception) {
        ErrorModelResponse errorModelResponse = ErrorModelResponse.builder()
                .code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .message(exception.getMessage())
                .urlError(UrlErrorEnum.searchUrl(HttpStatus.BAD_REQUEST.value()))
                .build();

        return new ResponseEntity<>(errorModelResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler({ UnprocessableException.class })
    public ResponseEntity<?> handleunprocessableEntityRequest(Exception exception) {
        ErrorModelResponse errorModelResponse = ErrorModelResponse.builder()
                .code(String.valueOf(HttpStatus.UNPROCESSABLE_ENTITY.value()))
                .message(exception.getMessage())
                .urlError(UrlErrorEnum.searchUrl(HttpStatus.UNPROCESSABLE_ENTITY.value()))
                .build();

        return new ResponseEntity<>(errorModelResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }



}

