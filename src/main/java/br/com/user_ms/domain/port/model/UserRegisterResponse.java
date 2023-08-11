package br.com.user_ms.domain.port.model;

import br.com.user_ms.domain.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRegisterResponse {

    private String id;
    private String feedback;
    private Status status;
}
