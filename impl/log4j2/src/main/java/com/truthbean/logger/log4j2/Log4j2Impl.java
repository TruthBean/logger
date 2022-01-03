/**
 * Copyright (c) 2021 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.log4j2;

import com.truthbean.Logger;
import com.truthbean.logger.ConfigurableLogger;
import com.truthbean.logger.LogLevel;
import com.truthbean.LoggerFactory;
import com.truthbean.logger.util.MessageHelper;
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
public class Log4j2Impl implements ConfigurableLogger {

    private String name;

    private Level defaultLevel;
    private LogLevel level;

    // AbstractLogger
    private AbstractLogger abstractLogger;
    private ExtendedLoggerWrapper loggerWrapper;

    private org.apache.logging.log4j.Logger rawLogger;

    static final Marker MARKER = MarkerManager.getMarker("truthbean");
    static final String FQCN = Log4j2Impl.class.getName();

    public Log4j2Impl() {
    }

    @Override
    public ConfigurableLogger setClass(Class<?> tracedClass) {
        this.name = tracedClass.getName();
        var logger = LogManager.getLogger(tracedClass);
        if (logger instanceof AbstractLogger) {
            this.abstractLogger = (AbstractLogger) logger;
        } else {
            this.rawLogger = logger;
        }
        return this;
    }

    @Override
    public ConfigurableLogger setName(CharSequence name) {
        this.name = name.toString();
        var logger = LogManager.getLogger(name);
        if (logger instanceof AbstractLogger) {
            this.abstractLogger = (AbstractLogger) logger;
        } else {
            this.rawLogger = logger;
        }
        return this;
    }

    @Override
    public ConfigurableLogger setName(String name) {
        this.name = name;
        var logger = LogManager.getLogger(name);
        if (logger instanceof AbstractLogger) {
            this.abstractLogger = (AbstractLogger) logger;
        } else {
            this.rawLogger = logger;
        }
        return this;
    }

    @Override
    public String getLoggerName() {
        return this.name;
    }

    @Override
    public ConfigurableLogger setDefaultLevel(LogLevel level) {
        if (ConfigurableLogger.isNoLogger()) {
            this.level = LogLevel.OFF;
        } else {
            this.level = level;
        }
        defaultLevel = Log4j2Impl.toLevel(this.level).orElse(Level.ERROR);
        return this;
    }

    @Override
    public LogLevel getDefaultLevel() {
        return this.level;
    }

    @Override
    public LogLevel getLevel() {
        var config = LoggerFactory.getConfig();
        var level = config.getLevel(this.name);
        if (abstractLogger != null) {
            LogLevel logLevel = Log4j2Impl.fromLevel(this.abstractLogger.getLevel()).orElseGet(() -> Objects.requireNonNullElse(getDefaultLevel(), LogLevel.ERROR));
            return level.orElse(logLevel);
        } else {
            LogLevel logLevel = Log4j2Impl.fromLevel(this.rawLogger.getLevel()).orElseGet(() -> Objects.requireNonNullElse(getDefaultLevel(), LogLevel.ERROR));
            return level.orElse(logLevel);
        }
    }

    public static Optional<Level> toLevel(LogLevel logLevel) {
        return switch (logLevel) {
            case ALL -> Optional.of(Level.ALL);
            case FATAL -> Optional.of(Level.FATAL);
            case ERROR -> Optional.of(Level.ERROR);
            case WARN -> Optional.of(Level.WARN);
            case INFO -> Optional.of(Level.INFO);
            case DEBUG -> Optional.of(Level.DEBUG);
            case TRACE -> Optional.of(Level.TRACE);
            case OFF -> Optional.of(Level.OFF);
        };
    }

    public static Optional<LogLevel> fromLevel(Level level) {
        if (level == null) {
            return Optional.empty();
        }
        return switch (level.intLevel()) {
            case Integer.MIN_VALUE, 0 -> Optional.of(LogLevel.OFF);
            case 100 -> Optional.of(LogLevel.FATAL);
            case 200 -> Optional.of(LogLevel.ERROR);
            case 300 -> Optional.of(LogLevel.WARN);
            case 400 -> Optional.of(LogLevel.INFO);
            case 500 -> Optional.of(LogLevel.DEBUG);
            case 600 -> Optional.of(LogLevel.TRACE);
            case Integer.MAX_VALUE -> Optional.of(LogLevel.ALL);
            default -> Optional.empty();
        };
    }

    @Override
    public Logger logger() {
        this.level = getLevel();
        if (abstractLogger != null) {
            this.loggerWrapper = new ExtendedLoggerWrapper(abstractLogger, abstractLogger.getName(), abstractLogger.getMessageFactory());
        }
        return this;
    }

    @Override
    public boolean isLoggable(LogLevel level) {
        var bool = this.level.compareTo(level) >= 0;
        var optional = toLevel(level);
        if (abstractLogger != null) {
            return optional.map(value -> bool && this.abstractLogger.isEnabled(value)).orElse(bool);
        } else {
            return optional.map(value -> bool && this.rawLogger.isEnabled(value)).orElse(bool);
        }
    }

    @Override
    public void log(LogLevel level, Object message) {
        if (isLoggable(level)) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, toLevel(level).orElse(defaultLevel), MARKER, MessageHelper.toString(message));
            } else {
                this.rawLogger.log(toLevel(level).orElse(defaultLevel), MARKER, message);
            }
        }
    }

    @Override
    public void log(LogLevel level, String message) {
        if (isLoggable(level)) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, toLevel(level).orElse(defaultLevel), MARKER, message);
            } else {
                this.rawLogger.log(toLevel(level).orElse(defaultLevel), MARKER, message);
            }
        }
    }

    @Override
    public void log(LogLevel level, Supplier<String> supplier) {
        if (isLoggable(level)) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, toLevel(level).orElse(defaultLevel), MARKER, supplier.get());
            } else {
                this.rawLogger.log(toLevel(level).orElse(defaultLevel), MARKER, supplier.get());
            }
        }
    }

    @Override
    public void log(LogLevel level, Object message, Object... params) {
        if (isLoggable(level)) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, toLevel(level).orElse(defaultLevel), MARKER, MessageHelper.format(message, params));
            } else {
                this.rawLogger.log(toLevel(level).orElse(defaultLevel), MARKER, MessageHelper.format(message, params));
            }
        }
    }

    @Override
    public void log(LogLevel level, String message, Object... params) {
        if (isLoggable(level)) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, toLevel(level).orElse(defaultLevel), MARKER, MessageHelper.format(message, params));
            } else {
                this.rawLogger.log(toLevel(level).orElse(defaultLevel), MARKER, MessageHelper.format(message, params));
            }
        }
    }

    @Override
    public void log(LogLevel level, Object message, Throwable e) {
        if (isLoggable(level)) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, toLevel(level).orElse(defaultLevel), MARKER, message, e);
            } else {
                this.rawLogger.log(toLevel(level).orElse(defaultLevel), MARKER, message, e);
            }
        }
    }

    @Override
    public void log(LogLevel level, String message, Throwable e) {
        if (isLoggable(level)) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, toLevel(level).orElse(defaultLevel), MARKER, message);
            } else {
                this.rawLogger.log(toLevel(level).orElse(defaultLevel), MARKER, message, e);
            }
        }
    }

    @Override
    public void log(LogLevel level, Supplier<String> supplier, Throwable e) {
        if (isLoggable(level)) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, toLevel(level).orElse(defaultLevel), MARKER, supplier.get(), e);
            } else {
                this.rawLogger.log(toLevel(level).orElse(defaultLevel), MARKER, supplier.get(), e);
            }
        }
    }

    @Override
    public void log(LogLevel level, Object message, Throwable e, Object... params) {
        if (isLoggable(level)) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, toLevel(level).orElse(defaultLevel), MARKER, MessageHelper.format(message, params), e);
            } else {
                this.rawLogger.log(toLevel(level).orElse(defaultLevel), MARKER, MessageHelper.format(message, params), e);
            }
        }
    }

    @Override
    public void log(LogLevel level, String message, Throwable e, Object... params) {
        if (isLoggable(level)) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, toLevel(level).orElse(defaultLevel), MARKER, MessageHelper.format(message, params), e);
            } else {
                this.rawLogger.log(toLevel(level).orElse(defaultLevel), MARKER, MessageHelper.format(message, params), e);
            }
        }
    }

    @Override
    public boolean isTraceEnabled() {
        if (abstractLogger != null) {
            return this.level.compareTo(LogLevel.TRACE) >= 0 && this.abstractLogger.isTraceEnabled();
        } else {
            return this.level.compareTo(LogLevel.TRACE) >= 0 && this.rawLogger.isTraceEnabled();
        }
    }

    @Override
    public void trace(Object message) {
        if (isLoggable(level)) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.TRACE, MARKER, MessageHelper.toString(message));
            } else {
                this.rawLogger.log(Level.TRACE, MARKER, message);
            }
        }
    }

    @Override
    public void trace(String message) {
        if (isTraceEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.TRACE, MARKER, message);
            } else {
                this.rawLogger.log(Level.TRACE, MARKER, message);
            }
        }
    }

    @Override
    public void trace(Supplier<String> supplier) {
        if (isTraceEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.TRACE, MARKER, supplier.get());
            } else {
                this.rawLogger.log(Level.TRACE, MARKER, supplier.get());
            }
        }
    }

    @Override
    public void trace(Object message, Object... params) {
        if (isTraceEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.TRACE, MARKER, MessageHelper.format(message, params));
            } else {
                this.rawLogger.log(Level.TRACE, MARKER, MessageHelper.format(message, params));
            }
        }
    }

    @Override
    public void trace(String message, Object... params) {
        if (isTraceEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.TRACE, MARKER, MessageHelper.format(message, params));
            } else {
                this.rawLogger.log(Level.TRACE, MARKER, MessageHelper.format(message, params));
            }
        }
    }

    @Override
    public void trace(Object message, Throwable e) {
        if (isTraceEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.TRACE, MARKER, message, e);
            } else {
                this.rawLogger.log(Level.TRACE, MARKER, message, e);
            }
        }
    }

    @Override
    public void trace(String message, Throwable e) {
        if (isTraceEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.TRACE, MARKER, message, e);
            } else {
                this.rawLogger.log(Level.TRACE, MARKER, message, e);
            }
        }
    }

    @Override
    public void trace(Supplier<String> supplier, Throwable e) {
        if (isTraceEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.TRACE, MARKER, supplier.get(), e);
            } else {
                this.rawLogger.log(Level.TRACE, MARKER, supplier.get(), e);
            }
        }
    }

    @Override
    public void trace(Object message, Throwable e, Object... params) {
        if (isTraceEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.TRACE, MARKER, MessageHelper.format(message, params), e);
            } else {
                this.rawLogger.log(Level.TRACE, MARKER, MessageHelper.format(message, params), e);
            }
        }
    }

    @Override
    public void trace(String message, Throwable e, Object... params) {
        if (isTraceEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.TRACE, MARKER, MessageHelper.format(message, params), e);
            } else {
                this.rawLogger.log(Level.TRACE, MARKER, MessageHelper.format(message, params), e);
            }
        }
    }

    @Override
    public boolean isDebugEnabled() {
        if (abstractLogger != null) {
            return this.level.compareTo(LogLevel.DEBUG) >= 0 && this.abstractLogger.isDebugEnabled();
        } else {
            return this.level.compareTo(LogLevel.DEBUG) >= 0 && this.rawLogger.isDebugEnabled();
        }
    }

    @Override
    public void debug(Object message) {
        if (isDebugEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.DEBUG, MARKER, MessageHelper.toString(message));
            } else {
                this.rawLogger.log(Level.DEBUG, MARKER, message);
            }
        }
    }

    @Override
    public void debug(String message) {
        if (isDebugEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.DEBUG, MARKER, message);
            } else {
                this.rawLogger.log(Level.DEBUG, MARKER, message);
            }
        }
    }

    @Override
    public void debug(Supplier<String> supplier) {
        if (isDebugEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.DEBUG, MARKER, supplier.get());
            } else {
                this.rawLogger.log(Level.DEBUG, MARKER, supplier.get());
            }
        }
    }

    @Override
    public void debug(Object message, Object... params) {
        if (isDebugEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.DEBUG, MARKER, MessageHelper.format(message, params));
            } else {
                this.rawLogger.log(Level.DEBUG, MARKER, MessageHelper.format(message, params));
            }
        }
    }

    @Override
    public void debug(String message, Object... params) {
        if (isDebugEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.DEBUG, MARKER, MessageHelper.format(message, params));
            } else {
                this.rawLogger.log(Level.DEBUG, MARKER, MessageHelper.format(message, params));
            }
        }
    }

    @Override
    public void debug(Object message, Throwable e) {
        if (isDebugEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.DEBUG, MARKER, message, e);
            } else {
                this.rawLogger.log(Level.DEBUG, MARKER, message, e);
            }
        }
    }

    @Override
    public void debug(String message, Throwable e) {
        if (isDebugEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.DEBUG, MARKER, message, e);
            } else {
                this.rawLogger.log(Level.DEBUG, MARKER, message, e);
            }
        }
    }

    @Override
    public void debug(Supplier<String> supplier, Throwable e) {
        if (isDebugEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.DEBUG, MARKER, supplier.get(), e);
            } else {
                this.rawLogger.log(Level.DEBUG, MARKER, supplier.get(), e);
            }
        }
    }

    @Override
    public void debug(Object message, Throwable e, Object... params) {
        if (isDebugEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.DEBUG, MARKER, MessageHelper.format(message, params), e);
            } else {
                this.rawLogger.log(Level.DEBUG, MARKER, MessageHelper.format(message, params), e);
            }
        }
    }

    @Override
    public void debug(String message, Throwable e, Object... params) {
        if (isDebugEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.DEBUG, MARKER, MessageHelper.format(message, params), e);
            } else {
                this.rawLogger.log(Level.DEBUG, MARKER, MessageHelper.format(message, params), e);
            }
        }
    }

    @Override
    public boolean isInfoEnabled() {
        if (abstractLogger != null) {
            return this.level.compareTo(LogLevel.INFO) >= 0 && this.abstractLogger.isInfoEnabled();
        } else {
            return this.level.compareTo(LogLevel.INFO) >= 0 && this.rawLogger.isInfoEnabled();
        }
    }

    @Override
    public void info(Object message) {
        if (isInfoEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.INFO, MARKER, MessageHelper.toString(message));
            } else {
                this.rawLogger.log(Level.INFO, MARKER, message);
            }
        }
    }

    @Override
    public void info(String message) {
        if (isInfoEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.INFO, MARKER, message);
            } else {
                this.rawLogger.log(Level.INFO, MARKER, message);
            }
        }
    }

    @Override
    public void info(Supplier<String> supplier) {
        if (isInfoEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.INFO, MARKER, supplier.get());
            } else {
                this.rawLogger.log(Level.INFO, MARKER, supplier.get());
            }
        }
    }

    @Override
    public void info(Object message, Object... params) {
        if (isInfoEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.INFO, MARKER, MessageHelper.format(message, params));
            } else {
                this.rawLogger.log(Level.INFO, MARKER, MessageHelper.format(message, params));
            }
        }
    }

    @Override
    public void info(String message, Object... params) {
        if (isInfoEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.INFO, MARKER, MessageHelper.format(message, params));
            } else {
                this.rawLogger.log(Level.INFO, MARKER, MessageHelper.format(message, params));
            }
        }
    }

    @Override
    public void info(Object message, Throwable e) {
        if (isInfoEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.INFO, MARKER, MessageHelper.toString(message), e);
            } else {
                this.rawLogger.log(Level.INFO, MARKER, message, e);
            }
        }
    }

    @Override
    public void info(String message, Throwable e) {
        if (isInfoEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.INFO, MARKER, message, e);
            } else {
                this.rawLogger.log(Level.INFO, MARKER, message, e);
            }
        }
    }

    @Override
    public void info(Supplier<String> supplier, Throwable e) {
        if (isInfoEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.INFO, MARKER, supplier.get(), e);
            } else {
                this.rawLogger.log(Level.INFO, MARKER, supplier.get(), e);
            }
        }
    }

    @Override
    public void info(Object message, Throwable e, Object... params) {
        if (isInfoEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.INFO, MARKER, MessageHelper.format(message, params), e);
            } else {
                this.rawLogger.log(Level.INFO, MARKER, MessageHelper.format(message, params), e);
            }
        }
    }

    @Override
    public void info(String message, Throwable e, Object... params) {
        if (isInfoEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.INFO, MARKER, MessageHelper.format(message, params), e);
            } else {
                this.rawLogger.log(Level.INFO, MARKER, MessageHelper.format(message, params), e);
            }
        }
    }

    @Override
    public boolean isWarnEnabled() {
        if (abstractLogger != null) {
            return this.level.compareTo(LogLevel.WARN) >= 0 && this.abstractLogger.isWarnEnabled();
        } else {
            return this.level.compareTo(LogLevel.WARN) >= 0 && this.rawLogger.isWarnEnabled();
        }
    }

    @Override
    public void warn(Object message) {
        if (isTraceEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.WARN, MARKER, MessageHelper.toString(message));
            } else {
                this.rawLogger.log(Level.WARN, MARKER, message);
            }
        }
    }

    @Override
    public void warn(String message) {
        if (isWarnEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.WARN, MARKER, message);
            } else {
                this.rawLogger.log(Level.WARN, MARKER, message);
            }
        }
    }

    @Override
    public void warn(Supplier<String> supplier) {
        if (isWarnEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.WARN, MARKER, supplier.get());
            } else {
                this.rawLogger.log(Level.WARN, MARKER, supplier.get());
            }
        }
    }

    @Override
    public void warn(Object message, Object... params) {
        if (isWarnEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.WARN, MARKER, MessageHelper.format(message, params));
            } else {
                this.rawLogger.log(Level.WARN, MARKER, MessageHelper.format(message, params));
            }
        }
    }

    @Override
    public void warn(String message, Object... params) {
        if (isWarnEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.WARN, MARKER, MessageHelper.format(message, params));
            } else {
                this.rawLogger.log(Level.WARN, MARKER, MessageHelper.format(message, params));
            }
        }
    }

    @Override
    public void warn(Object message, Throwable e) {
        if (isWarnEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.WARN, MARKER, MessageHelper.toString(message), e);
            } else {
                this.rawLogger.log(Level.WARN, MARKER, message, e);
            }
        }
    }

    @Override
    public void warn(String message, Throwable e) {
        if (isWarnEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.WARN, MARKER, message, e);
            } else {
                this.rawLogger.log(Level.WARN, MARKER, message, e);
            }
        }
    }

    @Override
    public void warn(Supplier<String> supplier, Throwable e) {
        if (isWarnEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.WARN, MARKER, supplier.get(), e);
            } else {
                this.rawLogger.log(Level.WARN, MARKER, supplier.get(), e);
            }
        }
    }

    @Override
    public void warn(Object message, Throwable e, Object... params) {
        if (isWarnEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.WARN, MARKER, MessageHelper.format(message, params), e);
            } else {
                this.rawLogger.log(Level.WARN, MARKER, MessageHelper.format(message, params), e);
            }
        }
    }

    @Override
    public void warn(String message, Throwable e, Object... params) {
        if (isWarnEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.WARN, MARKER, MessageHelper.format(message, params), e);
            } else {
                this.rawLogger.log(Level.WARN, MARKER, MessageHelper.format(message, params), e);
            }
        }
    }

    @Override
    public boolean isErrorEnabled() {
        if (abstractLogger != null) {
            return this.level.compareTo(LogLevel.ERROR) >= 0 && this.abstractLogger.isErrorEnabled();
        } else {
            return this.level.compareTo(LogLevel.ERROR) >= 0 && this.rawLogger.isErrorEnabled();
        }
    }

    @Override
    public void error(Object message) {
        if (isErrorEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.ERROR, MARKER, MessageHelper.toString(message));
            } else {
                this.rawLogger.log(Level.ERROR, MARKER, message);
            }
        }
    }

    @Override
    public void error(String message) {
        if (isErrorEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.ERROR, MARKER, message);
            } else {
                this.rawLogger.log(Level.ERROR, MARKER, message);
            }
        }
    }

    @Override
    public void error(Supplier<String> supplier) {
        if (isErrorEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.ERROR, MARKER, supplier.get());
            } else {
                this.rawLogger.log(Level.ERROR, MARKER, supplier.get());
            }
        }
    }

    @Override
    public void error(Object message, Object... params) {
        if (isErrorEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.ERROR, MARKER, MessageHelper.format(message, params));
            } else {
                this.rawLogger.log(Level.ERROR, MARKER, MessageHelper.format(message, params));
            }
        }
    }

    @Override
    public void error(String message, Object... params) {
        if (isErrorEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.ERROR, MARKER, MessageHelper.format(message, params));
            } else {
                this.rawLogger.log(Level.ERROR, MARKER, MessageHelper.format(message, params));
            }
        }
    }

    @Override
    public void error(Object message, Throwable e) {
        if (isErrorEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.ERROR, MARKER, MessageHelper.toString(message), e);
            } else {
                this.rawLogger.log(Level.ERROR, MARKER, message, e);
            }
        }
    }

    @Override
    public void error(String message, Throwable e) {
        if (isErrorEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.ERROR, MARKER, message, e);
            } else {
                this.rawLogger.log(Level.ERROR, MARKER, message, e);
            }
        }
    }

    @Override
    public void error(Supplier<String> supplier, Throwable e) {
        if (isErrorEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.ERROR, MARKER, supplier.get(), e);
            } else {
                this.rawLogger.log(Level.ERROR, MARKER, supplier.get(), e);
            }
        }
    }

    @Override
    public void error(Object message, Throwable e, Object... params) {
        if (isErrorEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.ERROR, MARKER, MessageHelper.format(message, params), e);
            } else {
                this.rawLogger.log(Level.ERROR, MARKER, MessageHelper.format(message, params), e);
            }
        }
    }

    @Override
    public void error(String message, Throwable e, Object... params) {
        if (isErrorEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.ERROR, MARKER, MessageHelper.format(message, params), e);
            } else {
                this.rawLogger.log(Level.ERROR, MARKER, MessageHelper.format(message, params), e);
            }
        }
    }

    @Override
    public boolean isFatalEnabled() {
        if (abstractLogger != null) {
            return this.level.compareTo(LogLevel.FATAL) >= 0 && this.abstractLogger.isFatalEnabled();
        } else {
            return this.level.compareTo(LogLevel.FATAL) >= 0 && this.rawLogger.isFatalEnabled();
        }
    }

    @Override
    public void fatal(Object message) {
        if (isFatalEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.FATAL, MARKER, MessageHelper.toString(message));
            } else {
                this.rawLogger.log(Level.FATAL, MARKER, message);
            }
        }
    }

    @Override
    public void fatal(String message) {
        if (isFatalEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.FATAL, MARKER, message);
            } else {
                this.rawLogger.log(Level.FATAL, MARKER, message);
            }
        }
    }

    @Override
    public void fatal(Supplier<String> supplier) {
        if (isFatalEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.FATAL, MARKER, supplier.get());
            } else {
                this.rawLogger.log(Level.FATAL, MARKER, supplier.get());
            }
        }
    }

    @Override
    public void fatal(Object message, Object... params) {
        if (isFatalEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.FATAL, MARKER, MessageHelper.format(message, params));
            } else {
                this.rawLogger.log(Level.FATAL, MARKER, MessageHelper.format(message, params));
            }
        }
    }

    @Override
    public void fatal(String message, Object... params) {
        if (isFatalEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.FATAL, MARKER, MessageHelper.format(message, params));
            } else {
                this.rawLogger.log(Level.FATAL, MARKER, MessageHelper.format(message, params));
            }
        }
    }

    @Override
    public void fatal(Object message, Throwable e) {
        if (isFatalEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.FATAL, MARKER, MessageHelper.toString(message), e);
            } else {
                this.rawLogger.log(Level.FATAL, MARKER, message, e);
            }
        }
    }

    @Override
    public void fatal(String message, Throwable e) {
        if (isFatalEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.FATAL, MARKER, message, e);
            } else {
                this.rawLogger.log(Level.FATAL, MARKER, message, e);
            }
        }
    }

    @Override
    public void fatal(Supplier<String> supplier, Throwable e) {
        if (isFatalEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.FATAL, MARKER, supplier.get(), e);
            } else {
                this.rawLogger.log(Level.FATAL, MARKER, supplier.get(), e);
            }
        }
    }

    @Override
    public void fatal(Object message, Throwable e, Object... params) {
        if (isFatalEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.FATAL, MARKER, MessageHelper.format(message, params), e);
            } else {
                this.rawLogger.log(Level.FATAL, MARKER, MessageHelper.format(message, params), e);
            }
        }
    }

    @Override
    public void fatal(String message, Throwable e, Object... params) {
        if (isFatalEnabled()) {
            if (abstractLogger != null) {
                this.loggerWrapper.logIfEnabled(FQCN, Level.FATAL, MARKER, MessageHelper.format(message, params), e);
            } else {
                this.rawLogger.log(Level.FATAL, MARKER, MessageHelper.format(message, params), e);
            }
        }
    }
}
