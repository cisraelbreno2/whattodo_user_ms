package br.com.user_ms.domain.faker;

import br.com.user_ms.domain.entity.User;
import br.com.user_ms.domain.entity.enums.Status;
import br.com.user_ms.domain.port.model.UserModifyRequest;
import br.com.user_ms.domain.port.model.UserRegisterRequest;

import static br.com.user_ms.domain.entity.enums.Status.ACTIVE;

public class UserFaker {

    private UserFaker(){}

    public static User createRegisterValidUser(){
        return new User("a9819780-38ad-11ee-be56-0242ac120002","Israel", "Costa", "cisraelbreno@gmail.com", "12341234", Status.ACTIVE);
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
        return new UserModifyRequest("a9819780-38ad-11ee-be56-0242ac120002", "Israel", "Costa");
    }

    public static User createModifyValidUser(){
        return new User("a9819780-38ad-11ee-be56-0242ac120002","Israel", "Costa", "cisraelbreno@gmail.com", "12341234", Status.MODIFY);
    }

    public static User createModifyUnsavedUser() {
        return new User(null,"Israel", "Costa", "cisraelbreno@gmail.com", "12341234", Status.MODIFY);
    }

    public static UserModifyRequest createModifyRequestWithNoName(){
        return new UserModifyRequest("a9819780-38ad-11ee-be56-0242ac120002", "", "Costa");
    }
    public static UserModifyRequest createModifyRequestWithNoSurname(){
        return new UserModifyRequest("a9819780-38ad-11ee-be56-0242ac120002","Israel", "");
    }

    public static User findByIdValidUser() {
        return new User("a9819780-38ad-11ee-be56-0242ac120002", "Zico", "Costa", "zico1998@hotmail.com", "11111111", "http://linkPicture", ACTIVE);
    }

}
