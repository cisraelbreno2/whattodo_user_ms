package br.com.user_ms.useCase.util;

import java.util.Arrays;

public class Util {

    public static boolean isNullOrEmpty(Object object){
        if(object instanceof String){
            return object == null || ((String) object).isEmpty();
        }
        return false;
    }

    public static boolean isNullOrEmpty(Object...objects){
        if (objects == null || objects.length == 0) {
            return true;
        }

        for (Object obj : objects) {
            if (obj == null) {
                return true;
            }

            if (obj instanceof String && ((String) obj).isEmpty()) {
                return true;
            }
        }

        return false;
    }

    public static boolean isNull(Object object){
        if(object == null){
            return true;
        }
        return false;
    }
}
