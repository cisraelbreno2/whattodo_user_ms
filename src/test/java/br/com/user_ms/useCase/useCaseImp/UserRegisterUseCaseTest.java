package br.com.user_ms.useCase.useCaseImp;

import br.com.user_ms.useCase.adapters.UserAdapter;
import br.com.user_ms.useCase.dto.UserRegisterRequestDto;
import br.com.user_ms.useCase.dto.UserRegisterResponseDto;
import br.com.user_ms.useCase.entity.User;
import br.com.user_ms.useCase.entity.enums.Status;
import br.com.user_ms.useCase.entity.factory.UserFactory;
import br.com.user_ms.useCase.excepions.UserCreateExeption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

import static com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.UUID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class UserRegisterUseCaseTest {
    @Mock
    UserAdapter userAdapter;
    @InjectMocks
    UserRegisterUseCase userRegisterUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Teste para verificar se o usuario foi salvo")
    public void userRegister(){
        UserRegisterRequestDto userRegisterRequestDto = new UserRegisterRequestDto("Israel", "Costa", "cisraelbreno@gmail.com", "12345678", null);
        User user = new UserFactory().create(userRegisterRequestDto);

        when(userAdapter.saveUser(any())).thenReturn(new User(java.util.UUID.randomUUID(),"Israel", "Costa", "cisraelbreno@gmail.com", "12341234", Status.ATIVO));

        UserRegisterResponseDto userRegisterResponseDto = userRegisterUseCase.register(userRegisterRequestDto);

        assertNotEquals(null, userRegisterResponseDto.getId());
    }

    @Test
    @DisplayName("Teste para verificar se o UserRegisterRequestDto esta com todos os parametros para ser salvo")
    public void userRegisterRequestExeption(){
        UserRegisterRequestDto userRegisterRequestDto = new UserRegisterRequestDto("Israel", "Costa", "cisraelbreno@gmail.com", null, null);

        assertThrows(UserCreateExeption.class, () -> {
            userRegisterUseCase.register(userRegisterRequestDto);
        });
    }


    @Test
    @DisplayName("Teste para verificar se o usuario não foi salvo")
    public void userRegisterResponseExeption(){
        UserRegisterRequestDto userRegisterRequestDto = new UserRegisterRequestDto("Israel", "Costa", "cisraelbreno@gmail.com", "12345678", null);
        User user = new UserFactory().create(userRegisterRequestDto);

        when(userAdapter.saveUser(user)).thenReturn(new User(null,"Israel", "Costa", "cisraelbreno@gmail.com", "12341234", Status.ATIVO));

        assertThrows(UserCreateExeption.class, () -> {
            userRegisterUseCase.register(userRegisterRequestDto);
        });
    }



}


