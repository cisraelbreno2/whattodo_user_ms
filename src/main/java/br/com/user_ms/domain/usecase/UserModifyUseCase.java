package br.com.user_ms.domain.usecase;

import br.com.user_ms.domain.repository.UserRepository;
import br.com.user_ms.domain.entity.factory.UserFactory;
import br.com.user_ms.domain.exceptions.UserModifyException;
import br.com.user_ms.domain.port.UserModifyPort;
import br.com.user_ms.domain.port.model.UserModifyRequest;
import br.com.user_ms.domain.port.model.UserModifyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static br.com.user_ms.domain.entity.enums.Status.MODIFY;
import static br.com.user_ms.domain.util.ObjectUtils.isNullOrEmpty;
import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class UserModifyUseCase implements UserModifyPort {

    private final UserRepository userRepository;

    @Override
    public UserModifyResponse modify(UserModifyRequest userModifyRequest) {
        if (isNull(userModifyRequest) || isNullOrEmpty(userModifyRequest.getId(), userModifyRequest.getName(), userModifyRequest.getSurname())) {
            throw new UserModifyException("Os campos de identificador, nome e sobrenome não podem estar vazios");
        }

        var user = userRepository.findById(userModifyRequest.getId());
        user.modifyName(userModifyRequest.getName());
        user.modifySurname(userModifyRequest.getSurname());
        user.modificarStatus(MODIFY);

        userRepository.saveUser(user);

        return UserFactory.toModifyResponse(user);
    }
}
