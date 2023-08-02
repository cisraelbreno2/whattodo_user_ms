package br.com.user_ms.domain.adapters;

import br.com.user_ms.domain.entity.User;

import java.util.UUID;

public interface UserAdapter {

    User saveUser(User user);

    User findById(UUID id);
}
