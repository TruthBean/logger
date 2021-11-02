/**
 * Copyright (c) 2021 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.slf4j;

import com.truthbean.Logger;
import com.truthbean.logger.BaseLogger;
import com.truthbean.logger.ConfigurableLogger;
import com.truthbean.logger.LogLevel;
import com.truthbean.LoggerFactory;
import com.truthbean.logger.util.MessageHelper;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-02-14 14:13
 */
class Slf4jLoggerImpl implements ConfigurableLogger {

    private LogLevel level;
    private final String name;

    private final org.slf4j.Logger logger;
    Slf4jLoggerImpl(org.slf4j.Logger logger, String name) {
        this.logger = logger;
        this.name = name;
    }

    @Override
    public ConfigurableLogger setClass(Class<?> tracedClass) {
        return this;
    }

    @Override
    public ConfigurableLogger setName(CharSequence name) {
        return this;
    }

    @Override
    public ConfigurableLogger setName(String name) {
        return this;
    }

    @Override
    public String getLoggerName() {
        return name;
    }

    @Override
    public ConfigurableLogger setDefaultLevel(LogLevel level) {
        if (ConfigurableLogger.isNoLogger()) {
            this.level = LogLevel.OFF;
        } else {
            this.level = level;
        }
        return this;
    }

    @Override
    public LogLevel getDefaultLevel() {
        return level;
    }

    @Override
    public LogLevel getLevel() {
        var config = LoggerFactory.getConfig();
        var level = config.getLevel(getLoggerName());
        return level.orElseGet(() -> Objects.requireNonNullElse(getDefaultLevel(), LogLevel.ERROR));
    }

    @Override
    public Logger logger() {
        this.level = getLevel();
        return this;
    }

    @Override
    public boolean isLoggable(LogLevel level) {
        var bool = this.level.compareTo(level) >= 0;
        boolean result;
        switch (level) {
            case FATAL:
                result = bool;
                break;
            case ERROR:
                result = isErrorEnabled();
                break;
            case WARN:
                result = this.logger.isWarnEnabled(Slf4jImpl.MARKER);
                break;
            case INFO:
                result = this.logger.isInfoEnabled(Slf4jImpl.MARKER);
                break;
            case DEBUG:
                result = this.logger.isDebugEnabled(Slf4jImpl.MARKER);
                break;
            case TRACE:
                result = this.logger.isTraceEnabled(Slf4jImpl.MARKER);
                break;
            default:
                result = false;
                break;
        }
        return result && bool;
    }

    @Override
    public void log(LogLevel level, Object message) {
        if (isLoggable(level)) {
            switch (level) {
                case FATAL:
                    this.fatal(message);
                    break;
                case ERROR:
                    this.error(message);
                    break;
                case WARN:
                    this.warn(message);
                    break;
                case INFO:
                    this.info(message);
                    break;
                case DEBUG:
                    this.debug(message);
                    break;
                case TRACE:
                    this.trace(message);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void log(LogLevel level, String message) {
        if (isLoggable(level)) {
            switch (level) {
                case FATAL:
                    this.fatal(message);
                    break;
                case ERROR:
                    this.error(message);
                    break;
                case WARN:
                    this.warn(message);
                    break;
                case INFO:
                    this.info(message);
                    break;
                case DEBUG:
                    this.debug(message);
                    break;
                case TRACE:
                    this.trace(message);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void log(LogLevel level, Supplier<String> supplier) {
        if (isLoggable(level)) {
            switch (level) {
                case FATAL:
                    this.fatal(supplier);
                    break;
                case ERROR:
                    this.error(supplier);
                    break;
                case WARN:
                    this.warn(supplier);
                    break;
                case INFO:
                    this.info(supplier);
                    break;
                case DEBUG:
                    this.debug(supplier);
                    break;
                case TRACE:
                    this.trace(supplier);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void log(LogLevel level, Object message, Object... params) {
        if (isLoggable(level)) {
            switch (level) {
                case FATAL:
                    this.fatal(message, params);
                    break;
                case ERROR:
                    this.error(message, params);
                    break;
                case WARN:
                    this.warn(message, params);
                    break;
                case INFO:
                    this.info(message, params);
                    break;
                case DEBUG:
                    this.debug(message, params);
                    break;
                case TRACE:
                    this.trace(message, params);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void log(LogLevel level, String message, Object... params) {
        if (isLoggable(level)) {
            switch (level) {
                case FATAL:
                    this.fatal(message, params);
                    break;
                case ERROR:
                    this.error(message, params);
                    break;
                case WARN:
                    this.warn(message, params);
                    break;
                case INFO:
                    this.info(message, params);
                    break;
                case DEBUG:
                    this.debug(message, params);
                    break;
                case TRACE:
                    this.trace(message, params);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void log(LogLevel level, Object message, Throwable e) {
        if (isLoggable(level)) {
            switch (level) {
                case FATAL:
                    this.fatal(message, e);
                    break;
                case ERROR:
                    this.error(message, e);
                    break;
                case WARN:
                    this.warn(message, e);
                    break;
                case INFO:
                    this.info(message, e);
                    break;
                case DEBUG:
                    this.debug(message, e);
                    break;
                case TRACE:
                    this.trace(message, e);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void log(LogLevel level, String message, Throwable e) {
        if (isLoggable(level)) {
            switch (level) {
                case FATAL:
                    this.fatal(message, e);
                    break;
                case ERROR:
                    this.error(message, e);
                    break;
                case WARN:
                    this.warn(message, e);
                    break;
                case INFO:
                    this.info(message, e);
                    break;
                case DEBUG:
                    this.debug(message, e);
                    break;
                case TRACE:
                    this.trace(message, e);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void log(LogLevel level, Supplier<String> supplier, Throwable e) {
        if (isLoggable(level)) {
            switch (level) {
                case FATAL:
                    this.fatal(supplier, e);
                    break;
                case ERROR:
                    this.error(supplier, e);
                    break;
                case WARN:
                    this.warn(supplier, e);
                    break;
                case INFO:
                    this.info(supplier, e);
                    break;
                case DEBUG:
                    this.debug(supplier, e);
                    break;
                case TRACE:
                    this.trace(supplier, e);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void log(LogLevel level, Object message, Throwable e, Object... params) {
        if (isLoggable(level)) {
            switch (level) {
                case FATAL:
                    this.fatal(message, e, params);
                    break;
                case ERROR:
                    this.error(message, e, params);
                    break;
                case WARN:
                    this.warn(message, e, params);
                    break;
                case INFO:
                    this.info(message, e, params);
                    break;
                case DEBUG:
                    this.debug(message, e, params);
                    break;
                case TRACE:
                    this.trace(message, e, params);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void log(LogLevel level, String message, Throwable e, Object... params) {
        if (isLoggable(level)) {
            message = MessageHelper.format(message, params);
            switch (level) {
                case OFF:
                    break;
                case FATAL:
                    this.fatal(message, e);
                    break;
                default:
                case ERROR:
                    this.error(message, e);
                    break;
                case WARN:
                    this.warn(message, e);
                    break;
                case INFO:
                    this.info(message, e);
                    break;
                case DEBUG:
                    this.debug(message, e);
                    break;
                case TRACE:
                case ALL:
                    this.trace(message, e);
                    break;
            }
        }
    }

    @Override
    public boolean isTraceEnabled() {
        return this.level.compareTo(LogLevel.TRACE) >= 0 && logger.isTraceEnabled(Slf4jImpl.MARKER);
    }

    @Override
    public void trace(Object message) {
        if (isTraceEnabled()) {
            logger.trace(Slf4jImpl.MARKER, MessageHelper.toString(message));
        }
    }

    @Override
    public void trace(String message) {
        if (isTraceEnabled()) {
            logger.trace(Slf4jImpl.MARKER, message);
        }
    }

    @Override
    public void trace(Supplier<String> supplier) {
        if (isTraceEnabled()) {
            logger.trace(Slf4jImpl.MARKER, supplier.get());
        }
    }

    @Override
    public void trace(Object message, Object... params) {
        if (isTraceEnabled()) {
            logger.trace(Slf4jImpl.MARKER, MessageHelper.toString(message), params);
        }
    }

    @Override
    public void trace(String message, Object... params) {
        if (isTraceEnabled()) {
            logger.trace(Slf4jImpl.MARKER, message, params);
        }
    }

    @Override
    public void trace(Object message, Throwable e) {
        if (isTraceEnabled()) {
            logger.trace(Slf4jImpl.MARKER, MessageHelper.toString(message), e);
        }
    }

    @Override
    public void trace(String message, Throwable e) {
        if (isTraceEnabled()) {
            logger.trace(Slf4jImpl.MARKER, message, e);
        }
    }

    @Override
    public void trace(Supplier<String> supplier, Throwable e) {
        if (isTraceEnabled()) {
            logger.trace(Slf4jImpl.MARKER, supplier.get(), e);
        }
    }

    @Override
    public void trace(Object message, Throwable e, Object... params) {
        if (isTraceEnabled()) {
            logger.trace(Slf4jImpl.MARKER, MessageHelper.format(MessageHelper.toString(message), params), e);
        }
    }

    @Override
    public void trace(String message, Throwable e, Object... params) {
        if (logger.isTraceEnabled(Slf4jImpl.MARKER)) {
            logger.trace(Slf4jImpl.MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public boolean isDebugEnabled() {
        return this.level.compareTo(LogLevel.DEBUG) >= 0 && logger.isDebugEnabled(Slf4jImpl.MARKER);
    }

    @Override
    public void debug(Object message) {
        if (isDebugEnabled()) {
            logger.debug(Slf4jImpl.MARKER, MessageHelper.toString(message));
        }
    }

    @Override
    public void debug(String message) {
        if (isDebugEnabled()) {
            logger.debug(Slf4jImpl.MARKER, message);
        }
    }

    @Override
    public void debug(Supplier<String> supplier) {
        if (isDebugEnabled()) {
            logger.debug(Slf4jImpl.MARKER, supplier.get());
        }
    }

    @Override
    public void debug(Object message, Object... params) {
        if (isDebugEnabled()) {
            logger.debug(Slf4jImpl.MARKER, MessageHelper.toString(message), params);
        }
    }

    @Override
    public void debug(String message, Object... params) {
        if (isDebugEnabled()) {
            logger.debug(Slf4jImpl.MARKER, message, params);
        }
    }

    @Override
    public void debug(Object message, Throwable e) {
        if (isDebugEnabled()) {
            logger.debug(Slf4jImpl.MARKER, MessageHelper.toString(message), e);
        }
    }

    @Override
    public void debug(String message, Throwable e) {
        if (isDebugEnabled()) {
            logger.debug(Slf4jImpl.MARKER, message, e);
        }
    }

    @Override
    public void debug(Supplier<String> supplier, Throwable e) {
        if (isDebugEnabled()) {
            logger.debug(Slf4jImpl.MARKER, supplier.get(), e);
        }
    }

    @Override
    public void debug(Object message, Throwable e, Object... params) {
        if (isDebugEnabled()) {
            logger.debug(Slf4jImpl.MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public void debug(String message, Throwable e, Object... params) {
        if (logger.isDebugEnabled(Slf4jImpl.MARKER)) {
            logger.debug(Slf4jImpl.MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public boolean isInfoEnabled() {
        return this.level.compareTo(LogLevel.INFO) >= 0 && logger.isInfoEnabled(Slf4jImpl.MARKER);
    }

    @Override
    public void info(Object message) {
        if (isInfoEnabled()) {
            logger.info(MessageHelper.toString(message));
        }
    }

    @Override
    public void info(String message) {
        if (isInfoEnabled()) {
            logger.info(Slf4jImpl.MARKER, message);
        }
    }

    @Override
    public void info(Supplier<String> supplier) {
        if (isInfoEnabled()) {
            logger.info(Slf4jImpl.MARKER, supplier.get());
        }
    }

    @Override
    public void info(Object message, Object... params) {
        if (isInfoEnabled()) {
            logger.info(Slf4jImpl.MARKER, MessageHelper.format(message, params));
        }
    }

    @Override
    public void info(String message, Object... params) {
        if (logger.isInfoEnabled(Slf4jImpl.MARKER)) {
            logger.info(Slf4jImpl.MARKER, message, params);
        }
    }

    @Override
    public void info(Object message, Throwable e) {
        if (isInfoEnabled()) {
            logger.info(Slf4jImpl.MARKER, MessageHelper.toString(message), e);
        }
    }

    @Override
    public void info(String message, Throwable e) {
        if (isInfoEnabled()) {
            logger.info(Slf4jImpl.MARKER, message, e);
        }
    }

    @Override
    public void info(Supplier<String> supplier, Throwable e) {
        if (isInfoEnabled()) {
            logger.info(Slf4jImpl.MARKER, supplier.get(), e);
        }
    }

    @Override
    public void info(Object message, Throwable e, Object... params) {
        if (isInfoEnabled()) {
            logger.info(Slf4jImpl.MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public void info(String message, Throwable e, Object... params) {
        if (logger.isInfoEnabled(Slf4jImpl.MARKER)) {
            logger.info(Slf4jImpl.MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public boolean isWarnEnabled() {
        return this.level.compareTo(LogLevel.WARN) >= 0 && logger.isWarnEnabled(Slf4jImpl.MARKER);
    }

    @Override
    public void warn(Object message) {
        if (isWarnEnabled()) {
            logger.warn(Slf4jImpl.MARKER, MessageHelper.toString(message));
        }
    }

    @Override
    public void warn(String message) {
        if (isWarnEnabled()) {
            logger.warn(Slf4jImpl.MARKER, message);
        }
    }

    @Override
    public void warn(Supplier<String> supplier) {
        if (isWarnEnabled()) {
            logger.warn(Slf4jImpl.MARKER, supplier.get());
        }
    }

    @Override
    public void warn(Object message, Object... params) {
        if (isWarnEnabled()) {
            logger.warn(Slf4jImpl.MARKER, MessageHelper.format(message, params));
        }
    }

    @Override
    public void warn(String message, Object... params) {
        if (isWarnEnabled()) {
            logger.warn(Slf4jImpl.MARKER, message, params);
        }
    }

    @Override
    public void warn(Object message, Throwable e) {
        if (isWarnEnabled()) {
            logger.warn(Slf4jImpl.MARKER, MessageHelper.toString(message), e);
        }
    }

    @Override
    public void warn(String message, Throwable e) {
        if (logger.isWarnEnabled(Slf4jImpl.MARKER)) {
            logger.warn(Slf4jImpl.MARKER, message, e);
        }
    }

    @Override
    public void warn(Supplier<String> supplier, Throwable e) {
        if (logger.isWarnEnabled(Slf4jImpl.MARKER)) {
            logger.warn(Slf4jImpl.MARKER, supplier.get(), e);
        }
    }

    @Override
    public void warn(Object message, Throwable e, Object... params) {
        if (isWarnEnabled()) {
            logger.warn(Slf4jImpl.MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public void warn(String message, Throwable e, Object... params) {
        if (isWarnEnabled()) {
            logger.warn(Slf4jImpl.MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public boolean isErrorEnabled() {
        return this.level.compareTo(LogLevel.ERROR) >= 0 && logger.isErrorEnabled(Slf4jImpl.MARKER);
    }

    @Override
    public void error(Object message) {
        if (isErrorEnabled()) {
            logger.error(MessageHelper.toString(message));
        }
    }

    @Override
    public void error(String message) {
        if (isErrorEnabled()) {
            logger.error(Slf4jImpl.MARKER, message);
        }
    }

    @Override
    public void error(Supplier<String> supplier) {
        if (isErrorEnabled()) {
            logger.error(Slf4jImpl.MARKER, supplier.get());
        }
    }

    @Override
    public void error(Object message, Object... params) {
        if (isErrorEnabled()) {
            logger.error(Slf4jImpl.MARKER, MessageHelper.format(message, params));
        }
    }

    @Override
    public void error(String message, Object... params) {
        if (isErrorEnabled()) {
            logger.error(Slf4jImpl.MARKER, message, params);
        }
    }

    @Override
    public void error(Object message, Throwable e) {
        if (isErrorEnabled()) {
            logger.error(Slf4jImpl.MARKER, MessageHelper.toString(message), e);
        }
    }

    @Override
    public void error(String message, Throwable e) {
        if (isErrorEnabled()) {
            logger.error(Slf4jImpl.MARKER, message, e);
        }
    }

    @Override
    public void error(Supplier<String> supplier, Throwable e) {
        if (isErrorEnabled()) {
            logger.error(Slf4jImpl.MARKER, supplier.get(), e);
        }
    }

    @Override
    public void error(Object message, Throwable e, Object... params) {
        if (isErrorEnabled()) {
            logger.error(Slf4jImpl.MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public void error(String message, Throwable e, Object... params) {
        if (isErrorEnabled()) {
            logger.error(Slf4jImpl.MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public boolean isFatalEnabled() {
        return this.level.compareTo(LogLevel.FATAL) >= 0;
    }

    @Override
    public void fatal(Object message) {
        if (isFatalEnabled()) {
            logger.error(MessageHelper.toString(message));
        }
    }

    @Override
    public void fatal(String message) {
        if (isFatalEnabled()) {
            logger.error(Slf4jImpl.MARKER, message);
        }
    }

    @Override
    public void fatal(Supplier<String> supplier) {
        if (isFatalEnabled()) {
            logger.error(Slf4jImpl.MARKER, supplier.get());
        }
    }

    @Override
    public void fatal(Object message, Object... params) {
        if (isFatalEnabled()) {
            logger.error(Slf4jImpl.MARKER, MessageHelper.format(message, params));
        }
    }

    @Override
    public void fatal(String message, Object... params) {
        if (isFatalEnabled()) {
            logger.error(Slf4jImpl.MARKER, message, params);
        }
    }

    @Override
    public void fatal(Object message, Throwable e) {
        if (isFatalEnabled()) {
            logger.error(Slf4jImpl.MARKER, MessageHelper.toString(message), e);
        }
    }

    @Override
    public void fatal(String message, Throwable e) {
        if (isFatalEnabled()) {
            logger.error(Slf4jImpl.MARKER, message, e);
        }
    }

    @Override
    public void fatal(Supplier<String> supplier, Throwable e) {
        if (isFatalEnabled()) {
            logger.error(Slf4jImpl.MARKER, supplier.get(), e);
        }
    }

    @Override
    public void fatal(Object message, Throwable e, Object... params) {
        if (isFatalEnabled()) {
            logger.error(Slf4jImpl.MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public void fatal(String message, Throwable e, Object... params) {
        if (isFatalEnabled()) {
            logger.error(Slf4jImpl.MARKER, MessageHelper.format(message, params), e);
        }
    }
}
