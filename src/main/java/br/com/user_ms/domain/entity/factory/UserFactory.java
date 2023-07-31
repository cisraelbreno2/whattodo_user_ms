package br.com.user_ms.domain.entity.factory;

import br.com.user_ms.domain.port.model.UserRegisterRequest;
import br.com.user_ms.domain.port.model.UserRegisterResponse;
import br.com.user_ms.domain.entity.User;
import br.com.user_ms.domain.entity.enums.Status;
import br.com.user_ms.domain.exceptions.UserCreateException;

import static br.com.user_ms.domain.util.Util.*;

public class UserFactory {

    public User create(UserRegisterRequest dto){

        if(isNullOrEmpty(dto, dto.getEmail(), dto.getName(), dto.getSurname(), dto.getPassword())){
            throw new UserCreateException("Os campos 'name', 'surname', 'email' e 'password' não podem ser nulos");
        }
        return new User(dto.getName(), dto.getSurname(), dto.getEmail(), dto.getPassword(), Status.ATIVO);
    }

    public UserRegisterResponse create(User user){
        if(isNull(user) || isNullOrEmpty(user.getId())){
            throw new UserCreateException("Erro ao salvar usuario");
        }

        return new UserRegisterResponse(user.getId(), "Usuario criado com sucesso", user.getStatus());
    }
}
