package br.com.user_ms.domain.entity.factory;

import br.com.user_ms.domain.entity.User;
import br.com.user_ms.domain.entity.enums.Status;
import br.com.user_ms.domain.port.model.UserModifyResponse;
import br.com.user_ms.domain.port.model.UserRegisterRequest;
import br.com.user_ms.domain.port.model.UserRegisterResponse;

public class UserFactory {

    private UserFactory(){}

    public static User fromRegisterRequest(UserRegisterRequest request){
        return new User(request.getName(), request.getSurname(), request.getEmail(), request.getPassword(), Status.ACTIVE);
    }

    public static UserRegisterResponse toRegisterResponse(User user){
        return new UserRegisterResponse(user.getId(), "Usuario criado com sucesso", user.getStatus());
    }

    public static UserModifyResponse toModifyResponse(User user){
        return new UserModifyResponse("Usuario alterado com sucesso", user.getStatus());
    }

}
