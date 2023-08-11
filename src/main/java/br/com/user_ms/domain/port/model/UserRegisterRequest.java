package br.com.user_ms.domain.port.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRegisterRequest {

    private String name;
    private String surname;
    private String email;
    private String password;
    private Byte perfilImage;
}
