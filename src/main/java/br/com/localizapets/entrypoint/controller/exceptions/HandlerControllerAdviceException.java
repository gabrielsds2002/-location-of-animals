package br.com.localizapets.entrypoint.controller.exceptions;

import br.com.localizapets.entrypoint.controller.exceptions.enums.UrlErrorEnum;
import br.com.localizapets.entrypoint.controller.exceptions.response.ErrorModelResponse;
import br.com.localizapets.exceptions.BadRequestException;
import br.com.localizapets.exceptions.NotFoundException;
import br.com.localizapets.exceptions.UnauthorizedExcepition;
import br.com.localizapets.exceptions.UnprocessableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static net.logstash.logback.marker.Markers.append;

@ControllerAdvice
@Slf4j
public class HandlerControllerAdviceException extends ResponseEntityExceptionHandler {


    @ExceptionHandler({NotFoundException.class})
    public final ResponseEntity<?> handleNotFound(Exception exception) {
        ErrorModelResponse errorModelResponse = ErrorModelResponse.builder()
                .code(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .message(exception.getMessage())
                .urlError(UrlErrorEnum.searchUrl(HttpStatus.NOT_FOUND.value()))
                .build();
        log.error(append("PAYLOAD_ERROR_NOT_FOUND", exception),
                "Error: Result not found ");
        return new ResponseEntity<>(errorModelResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({UnauthorizedExcepition.class})
    public final ResponseEntity<?> handleUnauthorized(Exception exception) {
        ErrorModelResponse errorModelResponse = ErrorModelResponse.builder()
                .code(String.valueOf(HttpStatus.UNAUTHORIZED.value()))
                .message(exception.getMessage())
                .urlError(UrlErrorEnum.searchUrl(HttpStatus.UNAUTHORIZED.value()))
                .build();
        log.error(append("PAYLOAD_ERROR_UNAUTHORIZED", exception),
                "Error: Unauthorized user ");
        return new ResponseEntity<>(errorModelResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({BadRequestException.class})
    public final ResponseEntity<?> handleBadRequest(Exception exception) {
        ErrorModelResponse errorModelResponse = ErrorModelResponse.builder()
                .code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .message(exception.getMessage())
                .urlError(UrlErrorEnum.searchUrl(HttpStatus.BAD_REQUEST.value()))
                .build();
        log.error(append("PAYLOAD_ERROR_BAD_REQUEST", exception),
                "Error: Bad request");
        return new ResponseEntity<>(errorModelResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({UnprocessableException.class})
    public final ResponseEntity<?> handleunprocessableEntityRequest(Exception exception) {
        ErrorModelResponse errorModelResponse = ErrorModelResponse.builder()
                .code(String.valueOf(HttpStatus.UNPROCESSABLE_ENTITY.value()))
                .message(exception.getMessage())
                .urlError(UrlErrorEnum.searchUrl(HttpStatus.UNPROCESSABLE_ENTITY.value()))
                .build();
        log.error(append("PAYLOAD_ERROR_UNPROCESSABLE_ENTITY", exception),
                "Error: Unable to process entity");
        return new ResponseEntity<>(errorModelResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}

