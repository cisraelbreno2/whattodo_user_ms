package br.com.user_ms.infra.repository;

import br.com.user_ms.domain.adapters.UserAdapter;
import br.com.user_ms.domain.entity.User;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserAdapterImpl implements UserAdapter {
    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public User findById(UUID id) {
        return null;
    }
}
