package br.com.user_ms.domain.usecase;

import br.com.user_ms.domain.adapters.UserAdapter;
import br.com.user_ms.domain.faker.UserFaker;
import br.com.user_ms.domain.port.model.UserRegisterRequest;
import br.com.user_ms.domain.port.model.UserRegisterResponse;
import br.com.user_ms.domain.entity.User;
import br.com.user_ms.domain.entity.enums.Status;
import br.com.user_ms.domain.entity.factory.UserFactory;
import br.com.user_ms.domain.exceptions.UserCreateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static br.com.user_ms.domain.entity.enums.Status.ATIVO;
import static java.util.Objects.nonNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserRegisterUseCaseTest {
    @Mock
    UserAdapter userAdapter;
    @InjectMocks
    UserRegisterUseCase useCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Teste para verificar se o usuario foi salvo")
    public void userRegister(){
        var userRegisterRequest = UserFaker.createValidRequest();

        when(userAdapter.saveUser(any())).thenReturn(UserFaker.createValidUser());

        var userRegisterResponse = useCase.register(userRegisterRequest);

        var userCaptor = ArgumentCaptor.forClass(User.class);

        verify(userAdapter, times(1)).saveUser(userCaptor.capture());

        var user = userCaptor.getValue();

        assert user.getId() == null;
        assertEquals(userRegisterRequest.getName(), user.getName());
        assertEquals(userRegisterRequest.getEmail(), user.getEmail());
        assertEquals(userRegisterRequest.getSurname(), user.getSurname());
        assertEquals(userRegisterRequest.getPassword(), user.getPassword());
        assertEquals(ATIVO, user.getStatus());

        assert nonNull(userRegisterResponse.getId());
        assertEquals(user.getStatus(), userRegisterResponse.getStatus());
    }

    @Test
    @DisplayName("Teste para verificar se o UserRegisterRequestDto esta com todos os parametros para ser salvo")
    public void userRegisterRequestExeption(){
        var userRegisterRequestNoName = UserFaker.createRequestWithNoName();

        assertThrows(UserCreateException.class, () -> useCase.register(userRegisterRequestNoName));

        var userRegisterRequestNoSurname = UserFaker.createRequestWithNoSurname();

        assertThrows(UserCreateException.class, () -> useCase.register(userRegisterRequestNoSurname));

        var userRegisterRequestNoEmail = UserFaker.createRequestWithNoEmail();

        assertThrows(UserCreateException.class, () -> useCase.register(userRegisterRequestNoEmail));

        var userRegisterRequestNoPassword = UserFaker.createRequestWithNoPassword();

        assertThrows(UserCreateException.class, () -> useCase.register(userRegisterRequestNoPassword));
    }


    @Test
    @DisplayName("Teste para verificar se o usuario não foi salvo")
    public void userRegisterResponseExeption(){
        var userRegisterRequest = UserFaker.createValidRequest();

        when(userAdapter.saveUser(any())).thenReturn(UserFaker.createUnsavedUser());

        assertThrows(UserCreateException.class, () -> useCase.register(userRegisterRequest));
    }



}


