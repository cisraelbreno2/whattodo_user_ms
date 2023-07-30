package br.com.user_ms.useCase.dto;

import br.com.user_ms.useCase.entity.enums.Status;

public class UserRegisterRequestDto {

    private String name;
    private String surname;
    private String email;
    private String password;
    private Byte perfilImage;

    public UserRegisterRequestDto(String name, String surname, String email, String password, Byte perfilImage) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.perfilImage = perfilImage;
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

    public Byte getPerfilImage() {
        return perfilImage;
    }

}
