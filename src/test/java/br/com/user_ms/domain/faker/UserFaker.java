package br.com.user_ms.domain.faker;

import br.com.user_ms.domain.entity.User;
import br.com.user_ms.domain.entity.enums.Status;
import br.com.user_ms.domain.port.model.UserRegisterRequest;

public class UserFaker {

    private UserFaker(){}

    public static User createValidUser(){
        return new User(java.util.UUID.randomUUID(),"Israel", "Costa", "cisraelbreno@gmail.com", "12341234", Status.ATIVO);
    }

    public static User createUnsavedUser(){
        return new User(null,"Israel", "Costa", "cisraelbreno@gmail.com", "12341234", Status.ATIVO);
    }

    public static UserRegisterRequest createValidRequest(){
        return new UserRegisterRequest("Israel", "Costa", "cisraelbreno@gmail.com", "12345678", null);
    }

    public static UserRegisterRequest createRequestWithNoName(){
        return new UserRegisterRequest(null, "Costa", "cisraelbreno@gmail.com", "123", null);
    }

    public static UserRegisterRequest createRequestWithNoPassword(){
        return new UserRegisterRequest("Israel", "Costa", "cisraelbreno@gmail.com", null, null);
    }

    public static UserRegisterRequest createRequestWithNoSurname(){
        return new UserRegisterRequest("Israel", null, "cisraelbreno@gmail.com", "123", null);
    }

    public static UserRegisterRequest createRequestWithNoEmail(){
        return new UserRegisterRequest("Israel", "Costa", null, "123", null);
    }
}
