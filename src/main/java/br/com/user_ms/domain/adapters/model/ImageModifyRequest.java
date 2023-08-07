package br.com.user_ms.domain.adapters.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class ImageModifyRequest {

    private UUID id;
    private Byte image;
    private String microsservice;
}
