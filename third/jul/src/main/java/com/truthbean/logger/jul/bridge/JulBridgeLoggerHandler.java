package com.truthbean.logger.jul.bridge;

import com.truthbean.Logger;
import com.truthbean.logger.LogLevel;
import com.truthbean.logger.LoggerFactory;
import com.truthbean.logger.jdk.common.JulLevel;
import com.truthbean.logger.jdk.common.LogLevelFilter;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.*;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 */
public class JulBridgeLoggerHandler extends Handler {

    public JulBridgeLoggerHandler() {
    }

    public static void install() {
        if (!isInstalled()) {
            removeConsoleHandlersForRootLogger();
            JulBridgeLoggerHandler handler = new JulBridgeLoggerHandler();
            handler.setLevel(Level.ALL);
            handler.setFilter(new LogLevelFilter());
            getRootLogger().addHandler(handler);
        }
    }

    private static java.util.logging.Logger getRootLogger() {
        return LogManager.getLogManager().getLogger("");
    }

    public static void uninstall() throws SecurityException {
        java.util.logging.Logger rootLogger = getRootLogger();
        Handler[] handlers = rootLogger.getHandlers();
        for (Handler handler : handlers) {
            if (handler instanceof JulBridgeLoggerHandler) {
                rootLogger.removeHandler(handler);
            }
        }
    }

    public static boolean isInstalled() throws SecurityException {
        java.util.logging.Logger rootLogger = getRootLogger();
        Handler[] handlers = rootLogger.getHandlers();
        for (Handler handler : handlers) {
            if (handler instanceof JulBridgeLoggerHandler) {
                return true;
            }
        }
        return false;
    }

    public static void removeHandlersForRootLogger() {
        java.util.logging.Logger rootLogger = getRootLogger();
        java.util.logging.Handler[] handlers = rootLogger.getHandlers();
        for (Handler handler : handlers) {
            rootLogger.removeHandler(handler);
        }
    }

    public static void removeConsoleHandlersForRootLogger() {
        java.util.logging.Logger rootLogger = getRootLogger();
        java.util.logging.Handler[] handlers = rootLogger.getHandlers();
        for (Handler handler : handlers) {
            if (handler instanceof ConsoleHandler) {
                rootLogger.removeHandler(handler);
            }
        }
    }

    protected Logger getTruthBeanLogger(LogRecord record) {
        String name = record.getLoggerName();
        if (name == null) {
            name = "";
        }
        return LoggerFactory.getLogger(name);
    }

    protected void logging(Logger logger, LogRecord record) {
        int julLevelValue = record.getLevel().intValue();
        LogLevel level = JulLevel.toLogLevel(julLevelValue);
        String i18nMessage = getMessageI18N(record);
        Throwable throwable = record.getThrown();
        logger.log(level, i18nMessage, i18nMessage, throwable, (Object[]) null);
    }

    /**
     * Get the record's message, possibly via a resource bundle.
     *
     * @param record jul logger record
     * @return logger message
     */
    private String getMessageI18N(LogRecord record) {
        String message = record.getMessage();

        if (message == null) {
            return null;
        }

        ResourceBundle bundle = record.getResourceBundle();
        if (bundle != null) {
            try {
                message = bundle.getString(message);
            } catch (MissingResourceException e) {
            }
        }
        Object[] params = record.getParameters();
        if (params != null && params.length > 0) {
            try {
                message = MessageFormat.format(message, params);
            } catch (IllegalArgumentException e) {
                return message;
            }
        }
        return message;
    }

    @Override
    public void publish(LogRecord record) {
        // Silently ignore null records.
        if (record == null) {
            return;
        }

        Logger logger = getTruthBeanLogger(record);
        this.logging(logger, record);
    }

    @Override
    public void flush() {
    }

    @Override
    public void close() throws SecurityException {
    }
}