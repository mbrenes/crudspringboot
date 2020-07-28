package com.firstapp.crudspringboot.exception;

import org.springframework.http.converter.json.GsonBuilderUtils;

public class CustomerNotFoundException extends RuntimeException {


    public CustomerNotFoundException (String message) {

        super(message);
    }

}
