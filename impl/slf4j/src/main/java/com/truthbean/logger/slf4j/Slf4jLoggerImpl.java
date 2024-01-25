/**
 * Copyright (c) 2024 TruthBean(Rogar·Q)
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
        return this;
    }

    @Override
    public LogLevel getDefaultLevel() {
        return LogLevel.ERROR;
    }

    @Override
    public LogLevel getLevel() {
        return LogLevel.ERROR;
    }

    @Override
    public Logger logger() {
        return this;
    }

    @Override
    public boolean isLoggable(LogLevel level) {
        return switch (level) {
            case FATAL -> true;
            case ERROR -> this.logger.isErrorEnabled(Slf4jImpl.MARKER);
            case WARN -> this.logger.isWarnEnabled(Slf4jImpl.MARKER);
            case INFO -> this.logger.isInfoEnabled(Slf4jImpl.MARKER);
            case DEBUG -> this.logger.isDebugEnabled(Slf4jImpl.MARKER);
            case TRACE -> this.logger.isTraceEnabled(Slf4jImpl.MARKER);
            default -> false;
        };
    }

    @Override
    public void log(LogLevel level, Object message) {
        if (isLoggable(level)) {
            switch (level) {
                case FATAL -> this.fatal(message);
                case ERROR -> this.error(message);
                case WARN -> this.warn(message);
                case INFO -> this.info(message);
                case DEBUG -> this.debug(message);
                case TRACE -> this.trace(message);
                default -> {
                }
            }
        }
    }

    @Override
    public void log(LogLevel level, String message) {
        if (isLoggable(level)) {
            switch (level) {
                case FATAL -> this.fatal(message);
                case ERROR -> this.error(message);
                case WARN -> this.warn(message);
                case INFO -> this.info(message);
                case DEBUG -> this.debug(message);
                case TRACE -> this.trace(message);
                default -> {
                }
            }
        }
    }

    @Override
    public void log(LogLevel level, Supplier<String> supplier) {
        if (isLoggable(level)) {
            switch (level) {
                case FATAL -> this.fatal(supplier);
                case ERROR -> this.error(supplier);
                case WARN -> this.warn(supplier);
                case INFO -> this.info(supplier);
                case DEBUG -> this.debug(supplier);
                case TRACE -> this.trace(supplier);
                default -> {
                }
            }
        }
    }

    @Override
    public void log(LogLevel level, Object message, Object... params) {
        if (isLoggable(level)) {
            switch (level) {
                case FATAL -> this.fatal(message, params);
                case ERROR -> this.error(message, params);
                case WARN -> this.warn(message, params);
                case INFO -> this.info(message, params);
                case DEBUG -> this.debug(message, params);
                case TRACE -> this.trace(message, params);
                default -> {
                }
            }
        }
    }

    @Override
    public void log(LogLevel level, String message, Object... params) {
        if (isLoggable(level)) {
            switch (level) {
                case FATAL -> this.fatal(message, params);
                case ERROR -> this.error(message, params);
                case WARN -> this.warn(message, params);
                case INFO -> this.info(message, params);
                case DEBUG -> this.debug(message, params);
                case TRACE -> this.trace(message, params);
                default -> {
                }
            }
        }
    }

    @Override
    public void log(LogLevel level, Object message, Throwable e) {
        if (isLoggable(level)) {
            switch (level) {
                case FATAL -> this.fatal(message, e);
                case ERROR -> this.error(message, e);
                case WARN -> this.warn(message, e);
                case INFO -> this.info(message, e);
                case DEBUG -> this.debug(message, e);
                case TRACE -> this.trace(message, e);
                default -> {
                }
            }
        }
    }

    @Override
    public void log(LogLevel level, String message, Throwable e) {
        if (isLoggable(level)) {
            switch (level) {
                case FATAL -> this.fatal(message, e);
                case ERROR -> this.error(message, e);
                case WARN -> this.warn(message, e);
                case INFO -> this.info(message, e);
                case DEBUG -> this.debug(message, e);
                case TRACE -> this.trace(message, e);
                default -> {
                }
            }
        }
    }

    @Override
    public void log(LogLevel level, Supplier<String> supplier, Throwable e) {
        if (isLoggable(level)) {
            switch (level) {
                case FATAL -> this.fatal(supplier, e);
                case ERROR -> this.error(supplier, e);
                case WARN -> this.warn(supplier, e);
                case INFO -> this.info(supplier, e);
                case DEBUG -> this.debug(supplier, e);
                case TRACE -> this.trace(supplier, e);
                default -> {
                }
            }
        }
    }

    @Override
    public void log(LogLevel level, Object message, Throwable e, Object... params) {
        if (isLoggable(level)) {
            switch (level) {
                case FATAL -> this.fatal(message, e, params);
                case ERROR -> this.error(message, e, params);
                case WARN -> this.warn(message, e, params);
                case INFO -> this.info(message, e, params);
                case DEBUG -> this.debug(message, e, params);
                case TRACE -> this.trace(message, e, params);
                default -> {
                }
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
        return logger.isTraceEnabled(Slf4jImpl.MARKER);
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
        return logger.isDebugEnabled(Slf4jImpl.MARKER);
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
        return logger.isInfoEnabled(Slf4jImpl.MARKER);
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
        return logger.isWarnEnabled(Slf4jImpl.MARKER);
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
        return logger.isErrorEnabled(Slf4jImpl.MARKER);
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
        return true;
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
