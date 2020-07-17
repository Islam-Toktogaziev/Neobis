package com.example.AvtoShop.Exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long id){
        super("Could not find customer " + id);
    }
}
