package br.com.user_ms.domain.port;

import br.com.user_ms.domain.port.model.UserRegisterRequest;
import br.com.user_ms.domain.port.model.UserRegisterResponse;

public interface UserRegisterPort {

    UserRegisterResponse register(UserRegisterRequest userRegisterRequest);
}
