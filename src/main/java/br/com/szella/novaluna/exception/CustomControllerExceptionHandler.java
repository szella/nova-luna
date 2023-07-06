package br.com.szella.novaluna.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(JogoException.class)
    protected ResponseEntity<ErroResponse> handleJogoException(JogoException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErroResponse.builder()
                        .mensagem(e.getMessage())
                        .build());
    }
}
