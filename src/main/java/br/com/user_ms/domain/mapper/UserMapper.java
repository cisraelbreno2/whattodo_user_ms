package br.com.user_ms.domain.mapper;

import br.com.user_ms.domain.entity.User;
import br.com.user_ms.domain.port.model.UserModifyRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userModifyRequestToUser(UserModifyRequest userModifyRequest);
}
