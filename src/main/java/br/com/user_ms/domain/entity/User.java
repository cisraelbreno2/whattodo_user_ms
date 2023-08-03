package br.com.user_ms.domain.entity;

import br.com.user_ms.domain.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static java.util.Objects.isNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private UUID id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String linkPictureProfile;
    private Status status;

    public User(UUID id, String name, String surname, String email, String password, Status status) {
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

    public void atribuirName(final String name){
        if(isNull(name) || name.isEmpty()){
            throw new IllegalArgumentException("Nome não pode estar vazio");
        }
        this.name = name;
    }

    public void atribuirSurname(final String surname){
        if(isNull(surname) || surname.isEmpty()){
            throw new IllegalArgumentException("Surnome não pode estar vazio");
        }
        this.surname = surname;
    }
}
