package br.com.user_ms.useCase.dto;

import br.com.user_ms.useCase.entity.enums.Status;

import java.util.UUID;

public class UserRegisterResponseDto {

    private UUID id;
    private String feedback;
    private Status status;

    public UserRegisterResponseDto(UUID id, String feedback, Status status) {
        this.id = id;
        this.feedback = feedback;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
