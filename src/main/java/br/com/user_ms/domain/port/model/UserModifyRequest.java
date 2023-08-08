package br.com.user_ms.domain.port.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class UserModifyRequest {

    private UUID id;
    private String name;
    private String surname;
}
