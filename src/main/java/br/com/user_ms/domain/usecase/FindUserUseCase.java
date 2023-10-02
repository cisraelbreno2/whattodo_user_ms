package br.com.user_ms.domain.usecase;

import br.com.user_ms.domain.port.FindUserPort;
import br.com.user_ms.domain.port.UserModifyPort;
import br.com.user_ms.domain.port.model.UserResponse;
import br.com.user_ms.domain.repository.UserRepository;
import br.com.user_ms.infra.repository.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindUserUseCase implements FindUserPort {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserResponse findById(String id) {
        return modelMapper.map(userRepository.findById(id), UserResponse.class);
    }
}
