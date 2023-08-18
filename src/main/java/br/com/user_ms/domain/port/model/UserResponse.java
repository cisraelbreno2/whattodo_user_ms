package br.com.user_ms.domain.port.model;

import br.com.user_ms.domain.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponse {
    private String id;
    private String name;
    private String surname;
    private String email;
    private String linkPictureProfile;
    private Status status;
}
