package br.com.user_ms.useCase.port;

import br.com.user_ms.useCase.dto.UserRegisterRequestDto;
import br.com.user_ms.useCase.dto.UserRegisterResponseDto;

public interface UserRegisterPort {

    UserRegisterResponseDto register(UserRegisterRequestDto userRegisterRequestDto);
}
