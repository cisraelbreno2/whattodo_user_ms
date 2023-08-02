package br.com.user_ms.domain.usecase;

import br.com.user_ms.domain.adapters.UserAdapter;
import br.com.user_ms.domain.entity.factory.UserFactory;
import br.com.user_ms.domain.exceptions.UserCreateException;
import br.com.user_ms.domain.exceptions.UserModifyExeption;
import br.com.user_ms.domain.mapper.UserMapper;
import br.com.user_ms.domain.port.UserModifyPort;
import br.com.user_ms.domain.port.model.UserModifyRequest;
import br.com.user_ms.domain.port.model.UserModifyResponse;
import org.springframework.stereotype.Service;

import static br.com.user_ms.domain.util.ObjectUtils.isNullOrEmpty;
import static java.util.Objects.isNull;

@Service
public class UserModifyUseCase implements UserModifyPort {

    private UserAdapter userAdapter;
    private UserMapper userMapper;

    @Override
    public UserModifyResponse modify(UserModifyRequest userModifyRequest) {
        if(isNullOrEmpty(userModifyRequest.getName(), userModifyRequest.getSurname())){
            throw new UserModifyExeption("Os campos nome e sobrenome não podem estar vazios");
        }

        var user = userAdapter.findById(userModifyRequest.getId());

        user = userMapper.userMofifyRequestToUser(userModifyRequest);
        user = userAdapter.saveUser(user);

        if(isNull(user) || isNull(user.getId())){
            throw new UserCreateException("Erro ao salvar usuario");
        }

        return UserFactory.toModifyResponse(user);
    }
}
