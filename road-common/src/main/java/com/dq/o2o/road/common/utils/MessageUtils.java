
package com.dq.o2o.road.common.utils;

import java.util.Locale;
import org.springframework.context.MessageSource;

public class MessageUtils {
    private static MessageSource messageSource;

    public MessageUtils() {
    }

    public static String message(String code, Object... args) {
        if (messageSource == null) {
            messageSource = (MessageSource)SpringUtils.getBean(MessageSource.class);
        }

        return messageSource.getMessage(code, args, (Locale)null);
    }
}
