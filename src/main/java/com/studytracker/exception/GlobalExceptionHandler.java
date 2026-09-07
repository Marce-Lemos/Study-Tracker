package com.studytracker.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<String> handleValidationException (MethodArgumentNotValidException ex){
        List<FieldError> erros = ex.getBindingResult().getFieldErrors();

        for (FieldError erro : erros){
            String campo = erro.getField();
            String mensagem = erro.getDefaultMessage();
            System.out.println(campo + " -> " + mensagem);
        }

        return ResponseEntity.badRequest().body("Erro de Validação!");
   }


}
