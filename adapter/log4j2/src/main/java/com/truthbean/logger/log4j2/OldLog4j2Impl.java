/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.log4j2;

import com.truthbean.Logger;
import com.truthbean.logger.BaseLogger;
import com.truthbean.logger.ConfigurableLogger;
import com.truthbean.logger.LogLevel;
import com.truthbean.logger.LoggerFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.spi.AbstractLogger;
import org.apache.logging.log4j.spi.ExtendedLoggerWrapper;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-05-11 22:25
 */
public class OldLog4j2Impl implements BaseLogger {

    private ConfigurableLogger logger;

    static final Marker MARKER = MarkerManager.getMarker("truthbean");
    static final String FQCN = OldLog4j2Impl.class.getName();

    public OldLog4j2Impl() {
    }

    @Override
    public ConfigurableLogger setClass(Class<?> tracedClass) {
        String name = tracedClass.getName();
        var logger = LogManager.getLogger(tracedClass);
        if (logger instanceof AbstractLogger) {
            this.logger = new Log4j2ExtendedLoggerWrapperImpl((AbstractLogger) logger, name);
        } else {
            this.logger = new Log4j2LoggerImpl(logger, name);
        }
        return this.logger;
    }

    @Override
    public ConfigurableLogger setName(CharSequence sequence) {
        String name = sequence.toString();
        var logger = LogManager.getLogger(name);
        if (logger instanceof AbstractLogger) {
            this.logger = new Log4j2ExtendedLoggerWrapperImpl((AbstractLogger) logger, name);
        } else {
            this.logger = new Log4j2LoggerImpl(logger, name);
        }
        return this.logger;
    }

    @Override
    public ConfigurableLogger setName(String name) {
        var logger = LogManager.getLogger(name);
        if (logger instanceof AbstractLogger) {
            this.logger = new Log4j2ExtendedLoggerWrapperImpl((AbstractLogger) logger, name);
        } else {
            this.logger = new Log4j2LoggerImpl(logger, name);
        }
        return this;
    }

    @Override
    public String getLoggerName() {
        return logger.getLoggerName();
    }

    @Override
    public ConfigurableLogger setDefaultLevel(LogLevel level) {
        return logger.setDefaultLevel(level);
    }

    @Override
    public LogLevel getDefaultLevel() {
        return logger.getDefaultLevel();
    }

    @Override
    public Logger logger() {
        return logger.logger();
    }

    public static Optional<Level> toLevel(LogLevel logLevel) {
        switch (logLevel) {
            case FATAL:
                return Optional.of(Level.FATAL);
            case ERROR:
                return Optional.of(Level.ERROR);
            case WARN:
                return Optional.of(Level.WARN);
            case INFO:
                return Optional.of(Level.INFO);
            case DEBUG:
                return Optional.of(Level.DEBUG);
            case TRACE:
                return Optional.of(Level.TRACE);
            default:
                return Optional.empty();
        }
    }

    public static Optional<LogLevel> fromLevel(Level level) {
        if (level == null) {
            return Optional.empty();
        }
        switch (level.intLevel()) {
            case 100:
                return Optional.of(LogLevel.FATAL);
            case 200:
                return Optional.of(LogLevel.ERROR);
            case 300:
                return Optional.of(LogLevel.WARN);
            case 400:
                return Optional.of(LogLevel.INFO);
            case 500:
                return Optional.of(LogLevel.DEBUG);
            case 600:
                return Optional.of(LogLevel.TRACE);
            default:
                return Optional.empty();
        }
    }

    @Override
    public boolean isLoggable(LogLevel level) {
        return logger.isLoggable(level);
    }

    @Override
    public void log(LogLevel level, String message, Throwable e, Object... params) {
        logger.log(level, message, e, params);
    }
}
