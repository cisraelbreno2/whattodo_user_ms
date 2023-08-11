package br.com.user_ms.domain.entity;

import br.com.user_ms.domain.entity.enums.Status;
import lombok.*;

import static java.util.Objects.isNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private String id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String linkPictureProfile;
    private Status status;

    public User(String id, String name, String surname, String email, String password, Status status) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public User(String name, String surname, String email, String password, Status status) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public void modificarName(final String name){
        if(isNull(name) || name.isEmpty()){
            throw new IllegalArgumentException("Nome não pode estar vazio");
        }
        this.name = name;
    }

    public void modificarSurname(final String surname){
        if(isNull(surname) || surname.isEmpty()){
            throw new IllegalArgumentException("Surnome não pode estar vazio");
        }
        this.surname = surname;
    }

    public void modificarStatus(Status status){
        this.status = status;
    }
}
