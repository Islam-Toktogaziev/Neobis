package com.example.AvtoShop.Exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Long id){
        super("Could not find it " + id);
    }

}
