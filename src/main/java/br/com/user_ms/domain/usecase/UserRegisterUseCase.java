package br.com.user_ms.domain.usecase;

import br.com.user_ms.domain.exceptions.UserCreateException;
import br.com.user_ms.domain.port.model.UserRegisterRequest;
import br.com.user_ms.domain.port.model.UserRegisterResponse;
import br.com.user_ms.domain.adapters.UserAdapter;
import br.com.user_ms.domain.entity.factory.UserFactory;
import br.com.user_ms.domain.port.UserRegisterPort;

import static br.com.user_ms.domain.util.Util.isNull;
import static br.com.user_ms.domain.util.Util.isNullOrEmpty;

public class UserRegisterUseCase implements UserRegisterPort {

    private final UserAdapter userAdapter;

    public UserRegisterUseCase(final UserAdapter userAdapter) {
        this.userAdapter = userAdapter;
    }

    @Override
    public UserRegisterResponse register(final UserRegisterRequest userRegisterRequest) {
        if(isNullOrEmpty(userRegisterRequest, userRegisterRequest.getEmail(), userRegisterRequest.getName(), userRegisterRequest.getSurname(), userRegisterRequest.getPassword())){
            throw new UserCreateException("Os campos 'name', 'surname', 'email' e 'password' não podem ser nulos");
        }

        var user = UserFactory.fromRequest(userRegisterRequest);
        user = userAdapter.saveUser(user);

        if(isNull(user) || isNullOrEmpty(user.getId())){
            throw new UserCreateException("Erro ao salvar usuario");
        }

        return UserFactory.toResponse(user);
    }
}
