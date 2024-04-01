package com.sunro.rest.webservices.restfulwebservices.exception;

import com.sunro.rest.webservices.restfulwebservices.Controller.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest requets){
        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), ex.getMessage(), requets.getDescription(false));

        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handlUserNotFoundExceptions(Exception ex, WebRequest requets){
        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), ex.getMessage(), requets.getDescription(false));

        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }

    //상위 클래스에서 가져와서 오버라이딩 해주기
    @Nullable
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),
                "Total Error : " + ex.getErrorCount() + " First Error : "+ex.getFieldError().getDefaultMessage(), request.getDescription(false));
        //필요한 메세지만 출력하게 해줌 -> ex.getFieldError().getDefaultMessage()

        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);

    }
}
