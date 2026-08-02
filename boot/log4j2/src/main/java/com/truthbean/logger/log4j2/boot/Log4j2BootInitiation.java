/**
 * Copyright (c) 2026 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.log4j2.boot;

import com.truthbean.core.util.StringUtils;
import com.truthbean.logger.LogLevel;
import com.truthbean.LoggerFactory;
import com.truthbean.logger.LoggerInitiation;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.AbstractConfiguration;
import org.apache.logging.log4j.core.config.LoggerConfig;

import java.util.Optional;
import java.util.logging.LogManager;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-11-17 19:42
 */
public class Log4j2BootInitiation implements LoggerInitiation {

    private static final String LOG_MANAGER_CLASS = "org.apache.logging.log4j.jul.LogManager";
    private static final String LOG_MANAGER_KEY = "java.util.logging.manager";
    static {
        String julm = System.getProperty(LOG_MANAGER_KEY);
        try {
            System.setProperty(LOG_MANAGER_KEY, LOG_MANAGER_CLASS);
            LogManager logManager = LogManager.getLogManager();
            if (!LOG_MANAGER_CLASS.equals(logManager.getClass().getName())) {
                try {
                    ClassLoader.getSystemClassLoader().loadClass(LOG_MANAGER_CLASS);
                } catch (ClassNotFoundException ignored) {
                }
            }
        } catch (NoClassDefFoundError ignored) {
            if (julm != null) {
                System.setProperty(LOG_MANAGER_KEY, julm);
            } else {
                System.clearProperty("java.util.logging.manager");
            }
        }
    }

    @Override
    public void init() {
        var config = LoggerFactory.getConfig().getLoggers();
        config.forEach(this::setLogLevel);
    }

    @Override
    public void flush() {
        var config = LoggerFactory.getConfig().getLoggers();
        config.forEach(this::setLogLevel);
    }

    @Override
    public void destroy() {
    }

    public void setLogLevel(String loggerName, LogLevel logLevel) {
        var level = Level.ERROR;
        switch (logLevel) {
            case OFF:
                level = Level.OFF;
                break;
            case FATAL:
                level = Level.FATAL;
                break;
            case WARN:
                level = Level.WARN;
                break;
            case INFO:
                level = Level.INFO;
                break;
            case DEBUG:
                level = Level.DEBUG;
                break;
            case TRACE:
                level = Level.TRACE;
                break;
            case ALL:
                level = Level.ALL;
                break;
            case ERROR:
            default:
                break;
        }
        var logger = getLogger(loggerName);
        if (logger == null) {
            LoggerConfig loggerConfig = new LoggerConfig(loggerName, level, true);
            getLoggerContext().ifPresent(e -> e.getConfiguration().addLogger(loggerName, loggerConfig));
        }
        else {
            logger.setLevel(level);
        }
        getLoggerContext().ifPresent(LoggerContext::updateLoggers);
    }

    private LoggerConfig getLogger(String name) {
        boolean isRootLogger = name != null && !name.isBlank() || "ROOT".equals(name);
        return findLogger(isRootLogger ? org.apache.logging.log4j.LogManager.ROOT_LOGGER_NAME : name);
    }

    private LoggerConfig findLogger(String name) {
        Optional<LoggerContext> contextOptional = getLoggerContext();
        if (contextOptional.isPresent()) {
            var configuration = contextOptional.get().getConfiguration();
            if (configuration instanceof AbstractConfiguration) {
                return ((AbstractConfiguration) configuration).getLogger(name);
            }
            return configuration.getLoggers().get(name);
        }
        return null;
    }

    private Optional<LoggerContext> getLoggerContext() {
        org.apache.logging.log4j.spi.LoggerContext context = org.apache.logging.log4j.LogManager.getContext(false);
        if (context instanceof LoggerContext) {
            return Optional.of((LoggerContext) context);
        }
        return Optional.empty();
    }
}
