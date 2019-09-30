package pe.com.tintegro.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import java.util.Locale;

@Component
public class MessagesSourceConfig {

    private static final Logger LOGGER = Logger.getLogger(MessagesSourceConfig.class);

    @Autowired
    private MessageSource messages;

    public String getMessage(final String code) {
        final Object[] args = null;
        return getMessage(code, args);
    }

    public Boolean getMessageBoolean(final String code) {
        try {
            return Boolean.valueOf(getMessage(code));
        } catch (final Exception e) {
            LOGGER.error("Exception: ", e);
        }
        return false;
    }

    public Long getMessageLong(final String code) {
        try {
            return Long.valueOf(getMessage(code));
        } catch (final Exception e) {
            LOGGER.error("Exception: ", e);
            return null;
        }
    }

    public String getMessage(final String code, final Object... args) {
        final Locale locale = null;
        return getMessage(code, locale, args);
    }

    public String getMessage(final String code, final Locale locale, final Object... args) {
        return messages.getMessage(code, args, locale);
    }
}
