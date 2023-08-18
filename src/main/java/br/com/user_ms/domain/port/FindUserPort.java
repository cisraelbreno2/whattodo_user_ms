package br.com.user_ms.domain.port;

import br.com.user_ms.domain.port.model.UserResponse;

public interface FindUserPort {

    UserResponse findById(String id);
}
