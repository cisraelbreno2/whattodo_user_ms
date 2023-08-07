package br.com.user_ms.infra.external;

import br.com.user_ms.domain.adapters.ImageAdapter;
import br.com.user_ms.domain.adapters.model.ImageModifyRequest;
import br.com.user_ms.domain.adapters.model.ImageResponse;
import br.com.user_ms.domain.adapters.model.ImageSaveRequest;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ImageExternal implements ImageAdapter {
    @Override
    public String saveImage(ImageSaveRequest imageSaveRequest) {
        return null;
    }

    @Override
    public String modifyImage(ImageModifyRequest imageModifyRequest) {
        return null;
    }

    @Override
    public Optional<ImageResponse> findImageByLink(String link) {
        return null;
    }
}
