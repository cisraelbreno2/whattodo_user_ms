package br.com.user_ms.domain.port;

import br.com.user_ms.domain.port.model.UserModifyRequest;
import br.com.user_ms.domain.port.model.UserModifyResponse;
import br.com.user_ms.domain.port.model.UserRegisterRequest;
import br.com.user_ms.domain.port.model.UserRegisterResponse;

public interface UserModifyPort {

    UserModifyResponse modify(UserModifyRequest userModifyRequest);

}
