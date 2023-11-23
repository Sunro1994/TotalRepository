package com.TravelMaker.Handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(org.springframework.dao.DuplicateKeyException.class)
    public String handleDuplicateKeyException() {
        return "DuplicateKeyexception"; // 예시로 "error/duplicateKeyError" 뷰로 리디렉션
    }

    @ExceptionHandler(java.sql.SQLIntegrityConstraintViolationException.class)
    public String handleSQLIntegrityConstraintViolationException() {
        return "DuplicateKeyexception"; // 예시로 "error/sqlIntegrityConstraintViolationError" 뷰로 리디렉션
    }
}

