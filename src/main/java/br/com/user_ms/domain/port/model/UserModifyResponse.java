package br.com.user_ms.domain.port.model;

import br.com.user_ms.domain.entity.enums.Status;

public record UserModifyResponse(String feedback, Status status) {
    public UserModifyResponse(String feedback, Status status) {
        this.feedback = feedback;
        this.status = status;
    }
}
