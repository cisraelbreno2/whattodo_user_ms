package br.com.user_ms.domain.adapters.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class ImageResponse {

    private UUID id;
    private String microsservice;
}
