package br.com.user_ms.domain.port.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserModifyRequest {

    private String id;
    private String name;
    private String surname;
}
