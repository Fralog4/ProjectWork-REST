package com.example.ProjectWorkRest.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestController
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value={NotFoundException.class})
    public final ResponseEntity<ErrorResponse> exceptionNotFoundHandler(Exception exception, WebRequest request){
        log.info("Not found exception caught!");
        ErrorResponse error=new ErrorResponse();
        error.setCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setPath(((ServletWebRequest)request).getRequest().getRequestURI());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

}
