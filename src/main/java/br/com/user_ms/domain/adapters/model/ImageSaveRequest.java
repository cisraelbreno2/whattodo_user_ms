package br.com.user_ms.domain.adapters.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ImageSaveRequest {

    private Byte image;
    private String microsservice;
}
