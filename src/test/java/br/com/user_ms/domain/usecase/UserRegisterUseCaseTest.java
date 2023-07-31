package br.com.user_ms.domain.usecase;

import br.com.user_ms.domain.adapters.UserAdapter;
import br.com.user_ms.domain.port.model.UserRegisterRequest;
import br.com.user_ms.domain.port.model.UserRegisterResponse;
import br.com.user_ms.domain.entity.User;
import br.com.user_ms.domain.entity.enums.Status;
import br.com.user_ms.domain.entity.factory.UserFactory;
import br.com.user_ms.domain.exceptions.UserCreateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest("Israel", "Costa", "cisraelbreno@gmail.com", "12345678", null);
        User user = new UserFactory().create(userRegisterRequest);

        when(userAdapter.saveUser(any())).thenReturn(new User(java.util.UUID.randomUUID(),"Israel", "Costa", "cisraelbreno@gmail.com", "12341234", Status.ATIVO));

        UserRegisterResponse userRegisterResponse = userRegisterUseCase.register(userRegisterRequest);

        assertNotEquals(null, userRegisterResponse.getId());
    }

    @Test
    @DisplayName("Teste para verificar se o UserRegisterRequestDto esta com todos os parametros para ser salvo")
    public void userRegisterRequestExeption(){
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest("Israel", "Costa", "cisraelbreno@gmail.com", null, null);

        assertThrows(UserCreateException.class, () -> {
            userRegisterUseCase.register(userRegisterRequest);
        });
    }


    @Test
    @DisplayName("Teste para verificar se o usuario não foi salvo")
    public void userRegisterResponseExeption(){
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest("Israel", "Costa", "cisraelbreno@gmail.com", "12345678", null);
        User user = new UserFactory().create(userRegisterRequest);

        when(userAdapter.saveUser(user)).thenReturn(new User(null,"Israel", "Costa", "cisraelbreno@gmail.com", "12341234", Status.ATIVO));

        assertThrows(UserCreateException.class, () -> {
            userRegisterUseCase.register(userRegisterRequest);
        });
    }



}


