package br.com.user_ms.useCase.useCaseImp;

import br.com.user_ms.useCase.dto.UserRegisterRequestDto;
import br.com.user_ms.useCase.dto.UserRegisterResponseDto;
import br.com.user_ms.useCase.adapters.UserAdapter;
import br.com.user_ms.useCase.entity.factory.UserFactory;
import br.com.user_ms.useCase.port.UserRegisterPort;

public class UserRegisterUseCase implements UserRegisterPort {

    private UserAdapter userAdapter;

    public UserRegisterUseCase(UserAdapter userAdapter) {
        this.userAdapter = userAdapter;
    }

    @Override
    public UserRegisterResponseDto register(UserRegisterRequestDto userRegisterRequestDto) {
        var factory = new UserFactory();

        var user = factory.create(userRegisterRequestDto);
        user = userAdapter.saveUser(user);

        return factory.create(user);
    }
}
