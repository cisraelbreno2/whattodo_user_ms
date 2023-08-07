package br.com.user_ms.domain.adapters;

import br.com.user_ms.domain.adapters.model.ImageModifyRequest;
import br.com.user_ms.domain.adapters.model.ImageResponse;
import br.com.user_ms.domain.adapters.model.ImageSaveRequest;

import java.util.Optional;

public interface ImageAdapter {

    String saveImage(final ImageSaveRequest imageSaveRequest);
    String modifyImage(final ImageModifyRequest imageModifyRequest);

    Optional<ImageResponse> findImageByLink(String link);


}
