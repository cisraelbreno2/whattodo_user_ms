package br.com.user_ms.domain.port.model;

import br.com.user_ms.domain.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class UserModifyResponse {

    private String feedback;
    private Status status;
}
