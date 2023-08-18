package br.com.user_ms.domain.usecase;

import br.com.user_ms.domain.repository.UserRepository;
import br.com.user_ms.domain.entity.User;
import br.com.user_ms.domain.exceptions.UserModifyException;
import br.com.user_ms.domain.faker.UserFaker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static br.com.user_ms.domain.entity.enums.Status.MODIFY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserModifyUseCaseTest {

    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserModifyUseCase useCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Teste para verificar se o usuario foi modificado")
    public void userModify(){
        var userModifyRequest = UserFaker.createModifyValidRequest();

        when(userRepository.saveUser(any())).thenReturn(UserFaker.createModifyValidUser());
        when(userRepository.findById(any())).thenReturn(UserFaker.findByIdValidUser());

        var userModifyResponse = useCase.modify(userModifyRequest);

        var userCaptor = ArgumentCaptor.forClass(User.class);

        verify(userRepository, times(1)).saveUser(userCaptor.capture());

        var user = userCaptor.getValue();

        assert user.getId() != null;
        assertEquals(userModifyRequest.getName(), user.getName());
        assertEquals(userModifyRequest.getSurname(), user.getSurname());
        assertEquals(MODIFY, user.getStatus());
        assertEquals(user.getStatus(), userModifyResponse.status());
    }

    @Test
    @DisplayName("Teste para verificar se o UserModifyRequestDto esta com todos os parametros para ser modificado")
    public void userModifyRequestException(){
        var userModifyRequestNoName = UserFaker.createModifyRequestWithNoName();

        assertThrows(UserModifyException.class, () -> useCase.modify(userModifyRequestNoName));

        var userModifyRequestNoSurname = UserFaker.createModifyRequestWithNoSurname();

        assertThrows(UserModifyException.class, () -> useCase.modify(userModifyRequestNoSurname));
    }
}
