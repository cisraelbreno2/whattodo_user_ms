package br.com.user_ms.domain.repository;

import br.com.user_ms.domain.entity.User;

public interface UserRepository {

    User saveUser(User user);

    User findById(String id);
}
