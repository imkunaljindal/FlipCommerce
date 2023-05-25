package com.example.FlipCommerce.exception;

public class EmptyCartException extends Exception{

    public EmptyCartException(String message){
        super(message);
    }
}
