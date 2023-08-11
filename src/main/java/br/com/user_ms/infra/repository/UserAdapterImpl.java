package br.com.user_ms.infra.repository;

import br.com.user_ms.domain.adapters.UserAdapter;
import br.com.user_ms.domain.entity.User;
import br.com.user_ms.infra.exceptions.UserModelNotFoundException;
import br.com.user_ms.infra.repository.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class UserAdapterImpl implements UserAdapter {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public User saveUser(User user) {
        var userModel = modelMapper.map(user, UserModel.class);
        userModel = userRepository.save(userModel);
        return  modelMapper.map(userModel, User.class);
    }

    @Override
    public User findById(String id) {
        var userModel = userRepository.findById(id);
        if(userModel.isEmpty()){
            throw new UserModelNotFoundException("Não foi possivel encontrar o usuario solicitado");
        }
        return modelMapper.map(userModel.get(), User.class);
    }
}
