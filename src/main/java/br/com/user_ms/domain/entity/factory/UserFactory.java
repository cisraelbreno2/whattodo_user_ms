package br.com.user_ms.domain.entity.factory;

import br.com.user_ms.domain.port.model.UserRegisterRequest;
import br.com.user_ms.domain.port.model.UserRegisterResponse;
import br.com.user_ms.domain.entity.User;
import br.com.user_ms.domain.entity.enums.Status;
import br.com.user_ms.domain.exceptions.UserCreateException;

import static br.com.user_ms.domain.util.Util.*;

public class UserFactory {

    private UserFactory(){}

    public static User fromRequest(UserRegisterRequest request){
        return new User(request.getName(), request.getSurname(), request.getEmail(), request.getPassword(), Status.ATIVO);
    }

    public static UserRegisterResponse toResponse(User user){
        return new UserRegisterResponse(user.getId(), "Usuario criado com sucesso", user.getStatus());
    }
}
