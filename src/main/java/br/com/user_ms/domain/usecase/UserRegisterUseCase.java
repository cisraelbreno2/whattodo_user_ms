package br.com.user_ms.domain.usecase;

import br.com.user_ms.domain.port.model.UserRegisterRequest;
import br.com.user_ms.domain.port.model.UserRegisterResponse;
import br.com.user_ms.domain.adapters.UserAdapter;
import br.com.user_ms.domain.entity.factory.UserFactory;
import br.com.user_ms.domain.port.UserRegisterPort;

public class UserRegisterUseCase implements UserRegisterPort {

    private UserAdapter userAdapter;

    public UserRegisterUseCase(UserAdapter userAdapter) {
        this.userAdapter = userAdapter;
    }

    @Override
    public UserRegisterResponse register(UserRegisterRequest userRegisterRequest) {
        var factory = new UserFactory();

        var user = factory.create(userRegisterRequest);
        user = userAdapter.saveUser(user);

        return factory.create(user);
    }
}
