package br.com.user_ms.domain.exceptions;

public class UserCreateException extends RuntimeException{
    public UserCreateException(String msg){
        super(msg);
    }
}
