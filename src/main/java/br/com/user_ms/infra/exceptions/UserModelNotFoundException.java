package br.com.user_ms.infra.exceptions;

public class UserModelNotFoundException extends RuntimeException {

    public UserModelNotFoundException(String msg){
        super(msg);
    }
}
