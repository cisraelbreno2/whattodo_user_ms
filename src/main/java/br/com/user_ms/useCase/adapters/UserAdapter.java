package br.com.user_ms.useCase.adapters;

import br.com.user_ms.useCase.entity.User;

import java.util.UUID;

public interface UserAdapter {

    User saveUser(User user);
}
