package com.ust.student.Exception;

public class InvalidPassword extends BusinessException{

    public InvalidPassword(){
        super("Invalid password");
    }
}
