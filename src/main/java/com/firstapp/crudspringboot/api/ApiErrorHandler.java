package com.firstapp.crudspringboot.api;

import com.firstapp.crudspringboot.exception.ApplicationError;
import com.firstapp.crudspringboot.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ApiErrorHandler extends ResponseEntityExceptionHandler {

    @Value("${api_doc_url}")
    private String details;

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ApplicationError> handlerCustomerNotFoundException(CustomerNotFoundException cnfe,
                                                                             WebRequest webRequest) {
        ApplicationError error = new ApplicationError();
        error.setCode(404);
        error.setDetails(details);
        error.setMessage(cnfe.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}

