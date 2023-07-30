package br.com.user_ms.useCase.entity;

import br.com.user_ms.useCase.entity.enums.Status;

import java.util.List;
import java.util.UUID;

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

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getLinkPictureProfile() {
        return linkPictureProfile;
    }

    public Status getStatus() {
        return status;
    }
}
