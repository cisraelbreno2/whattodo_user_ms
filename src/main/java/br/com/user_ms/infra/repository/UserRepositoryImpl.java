package br.com.user_ms.infra.repository;

import br.com.user_ms.domain.repository.UserRepository;
import br.com.user_ms.domain.entity.User;
import br.com.user_ms.infra.exceptions.UserModelNotFoundException;
import br.com.user_ms.infra.repository.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryJpa userRepositoryJpa;
    private final ModelMapper modelMapper;

    @Override
    public User saveUser(User user) {
        var userModel = modelMapper.map(user, UserModel.class);
        userModel = userRepositoryJpa.save(userModel);
        return  modelMapper.map(userModel, User.class);
    }

    @Override
    public User findById(String id) {
        var userModel = userRepositoryJpa.findById(id);
        if(userModel.isEmpty()){
            throw new UserModelNotFoundException("Não foi possivel encontrar o usuario solicitado");
        }
        return modelMapper.map(userModel.get(), User.class);
    }
}
