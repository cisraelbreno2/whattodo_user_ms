package br.com.user_ms.domain.faker;

import br.com.user_ms.domain.entity.User;
import br.com.user_ms.domain.entity.enums.Status;
import br.com.user_ms.domain.port.model.UserModifyRequest;
import br.com.user_ms.domain.port.model.UserRegisterRequest;

import java.util.UUID;

public class UserFaker {

    private UserFaker(){}

    public static User createRegisterValidUser(){
        return new User(java.util.UUID.randomUUID(),"Israel", "Costa", "cisraelbreno@gmail.com", "12341234", Status.ATIVO);
    }

    public static User createRegisterUnsavedUser(){
        return new User(null,"Israel", "Costa", "cisraelbreno@gmail.com", "12341234", Status.ATIVO);
    }

    public static UserRegisterRequest createRegisterValidRequest(){
        return new UserRegisterRequest("Israel", "Costa", "cisraelbreno@gmail.com", "12345678", null);
    }

    public static UserRegisterRequest createRegisterRequestWithNoName(){
        return new UserRegisterRequest(null, "Costa", "cisraelbreno@gmail.com", "123", null);
    }

    public static UserRegisterRequest createRegisterRequestWithNoPassword(){
        return new UserRegisterRequest("Israel", "Costa", "cisraelbreno@gmail.com", null, null);
    }

    public static UserRegisterRequest createRegisterRequestWithNoSurname(){
        return new UserRegisterRequest("Israel", null, "cisraelbreno@gmail.com", "123", null);
    }

    public static UserRegisterRequest createRegisterRequestWithNoEmail(){
        return new UserRegisterRequest("Israel", "Costa", null, "123", null);
    }

    public static UserModifyRequest createModifyValidRequest() {
        return new UserModifyRequest(UUID.randomUUID(), "Israel", "Costa");
    }

    public static User createModifyValidUser(){
        return new User(java.util.UUID.randomUUID(),"Israel", "Costa", "cisraelbreno@gmail.com", "12341234", Status.MODIFICADO);
    }

    public static User createModifyUnsavedUser() {
        return new User(null,"Israel", "Costa", "cisraelbreno@gmail.com", "12341234", Status.MODIFICADO);
    }

    public static UserModifyRequest createModifyRequestWithNoName(){
        return new UserModifyRequest(UUID.randomUUID(), "", "Costa");
    }
    public static UserModifyRequest createModifyRequestWithNoSurname(){
        return new UserModifyRequest(UUID.randomUUID(),"Israel", "");
    }
}
