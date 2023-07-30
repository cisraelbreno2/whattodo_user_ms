package br.com.user_ms.useCase.entity.factory;

import br.com.user_ms.useCase.dto.UserRegisterRequestDto;
import br.com.user_ms.useCase.dto.UserRegisterResponseDto;
import br.com.user_ms.useCase.entity.User;
import br.com.user_ms.useCase.entity.enums.Status;
import br.com.user_ms.useCase.excepions.UserCreateExeption;

import static br.com.user_ms.useCase.util.Util.*;

public class UserFactory {

    public User create(UserRegisterRequestDto dto){

        if(isNullOrEmpty(dto, dto.getEmail(), dto.getName(), dto.getSurname(), dto.getPassword())){
            throw new UserCreateExeption("Os campos 'name', 'surname', 'email' e 'password' não podem ser nulos");
        }
        return new User(dto.getName(), dto.getSurname(), dto.getEmail(), dto.getPassword(), Status.ATIVO);
    }

    public UserRegisterResponseDto create(User user){
        if(isNull(user) || isNullOrEmpty(user.getId())){
            throw new UserCreateExeption("Erro ao salvar usuario");
        }

        return new UserRegisterResponseDto(user.getId(), "Usuario criado com sucesso", user.getStatus());
    }
}
