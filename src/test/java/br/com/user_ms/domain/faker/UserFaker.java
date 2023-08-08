package br.com.user_ms.domain.faker;

import br.com.user_ms.domain.entity.User;
import br.com.user_ms.domain.entity.enums.Status;
import br.com.user_ms.domain.port.model.UserModifyRequest;
import br.com.user_ms.domain.port.model.UserRegisterRequest;

import java.util.UUID;

import static br.com.user_ms.domain.entity.enums.Status.ACTIVE;

public class UserFaker {

    private UserFaker(){}

    public static User createRegisterValidUser(){
        return new User(java.util.UUID.randomUUID(),"Israel", "Costa", "cisraelbreno@gmail.com", "12341234", Status.ACTIVE);
    }

    public static User createRegisterUnsavedUser(){
        return new User(null,"Israel", "Costa", "cisraelbreno@gmail.com", "12341234", Status.ACTIVE);
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
        return new User(java.util.UUID.randomUUID(),"Israel", "Costa", "cisraelbreno@gmail.com", "12341234", Status.MODIFY);
    }

    public static User createModifyUnsavedUser() {
        return new User(null,"Israel", "Costa", "cisraelbreno@gmail.com", "12341234", Status.MODIFY);
    }

    public static UserModifyRequest createModifyRequestWithNoName(){
        return new UserModifyRequest(UUID.randomUUID(), "", "Costa");
    }
    public static UserModifyRequest createModifyRequestWithNoSurname(){
        return new UserModifyRequest(UUID.randomUUID(),"Israel", "");
    }

    public static User findByIdValidUser() {
        return new User(UUID.randomUUID(), "Zico", "Costa", "zico1998@hotmail.com", "11111111", "http://linkPicture", ACTIVE);
    }

}
