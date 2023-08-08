package br.com.user_ms.domain.usecase;

import br.com.user_ms.domain.adapters.ImageAdapter;
import br.com.user_ms.domain.adapters.UserAdapter;
import br.com.user_ms.domain.adapters.model.ImageModifyRequest;
import br.com.user_ms.domain.adapters.model.ImageSaveRequest;
import br.com.user_ms.domain.entity.User;
import br.com.user_ms.domain.entity.factory.UserFactory;
import br.com.user_ms.domain.exceptions.UserCreateException;
import br.com.user_ms.domain.exceptions.UserModifyExeption;
import br.com.user_ms.domain.port.UserModifyPort;
import br.com.user_ms.domain.port.model.UserModifyRequest;
import br.com.user_ms.domain.port.model.UserModifyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static br.com.user_ms.domain.entity.enums.Microsservice.USUARIO;
import static br.com.user_ms.domain.entity.enums.Status.MODIFICADO;
import static br.com.user_ms.domain.util.ObjectUtils.isNullOrEmpty;
import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class UserModifyUseCase implements UserModifyPort {

    private final UserAdapter userAdapter;

    @Override
    public UserModifyResponse modify(UserModifyRequest userModifyRequest) {
        if(isNullOrEmpty(userModifyRequest.getId(), userModifyRequest.getName(), userModifyRequest.getSurname())){
            throw new UserModifyExeption("Os campos de identificador, nome e sobrenome não podem estar vazios");
        }
        var user = userAdapter.findById(userModifyRequest.getId());

        user = User
                .builder()
                .id(userModifyRequest.getId())
                .status(MODIFICADO)
                .name(userModifyRequest.getName())
                .surname(userModifyRequest.getSurname()).build();

        user = userAdapter.saveUser(user);

        if(isNull(user) || isNull(user.getId())){
            throw new UserCreateException("Erro ao salvar usuario");
        }

        return UserFactory.toModifyResponse(user);
    }
}