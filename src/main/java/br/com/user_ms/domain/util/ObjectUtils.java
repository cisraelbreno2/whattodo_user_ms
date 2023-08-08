package br.com.user_ms.domain.util;

import java.util.Objects;
import java.util.stream.Stream;

public class ObjectUtils {

    private ObjectUtils(){}

    public static boolean isNullOrEmpty(Object...objects){
        if (objects == null || objects.length == 0) {
            return true;
        }

        if(Stream.of(objects).anyMatch(o -> o instanceof String && String.valueOf(o).isEmpty())){
            return true;
        }

        return Stream.of(objects).anyMatch(Objects::isNull);
    }

}
