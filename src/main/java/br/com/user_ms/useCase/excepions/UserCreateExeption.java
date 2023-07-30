package br.com.user_ms.useCase.excepions;

public class UserCreateExeption extends RuntimeException{
    public UserCreateExeption(String msg){
        super(msg);
    }
}
