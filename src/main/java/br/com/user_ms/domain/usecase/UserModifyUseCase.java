package br.com.user_ms.domain.usecase;

import br.com.user_ms.domain.adapters.UserAdapter;
import br.com.user_ms.domain.entity.factory.UserFactory;
import br.com.user_ms.domain.exceptions.UserModifyExeption;
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

    private final UserAdapter userAdapter;

    @Override
    public UserModifyResponse modify(UserModifyRequest userModifyRequest) {
        if (isNull(userModifyRequest) || isNullOrEmpty(userModifyRequest.getId(), userModifyRequest.getName(), userModifyRequest.getSurname())) {
            throw new UserModifyExeption("Os campos de identificador, nome e sobrenome não podem estar vazios");
        }

        var user = userAdapter.findById(userModifyRequest.getId());
        user.modificarName(userModifyRequest.getName());
        user.modificarSurname(userModifyRequest.getSurname());
        user.modificarStatus(MODIFY);

        userAdapter.saveUser(user);

        return UserFactory.toModifyResponse(user);
    }
}
