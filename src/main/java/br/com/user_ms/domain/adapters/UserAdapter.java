package br.com.user_ms.domain.adapters;

import br.com.user_ms.domain.entity.User;

public interface UserAdapter {

    User saveUser(User user);

    User findById(String id);
}
