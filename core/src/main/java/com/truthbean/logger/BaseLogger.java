/**
 * Copyright (c) 2024 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger;

import com.truthbean.LoggerFactory;
import com.truthbean.logger.util.MessageHelper;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-11-30 14:05
 */
public interface BaseLogger extends ConfigurableLogger {

    @Override
    default LogLevel getLevel() {
        var config = LoggerFactory.getConfig();
        var level = config.getLevel(getLoggerName());
        return level.orElseGet(() -> Objects.requireNonNullElse(getDefaultLevel(), LogLevel.ERROR));
    }

    @Override
    default void log(LogLevel level, Object message) {
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), null, (Object[]) null);
        }
    }

    @Override
    default void log(LogLevel level, String message) {
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), null, (Object[]) null);
        }
    }

    @Override
    default void log(LogLevel level, Supplier<String> supplier) {
        if (isLoggable(level)) {
            log(level, supplier.get(), null, (Object[]) null);
        }
    }

    @Override
    default void log(LogLevel level, Object message, Object... params) {
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), params, null);
        }
    }

    @Override
    default void log(LogLevel level, String message, Object... params) {
        if (isLoggable(level)) {
            log(level, message, null, params);
        }
    }

    @Override
    default void log(LogLevel level, Object message, Throwable e) {
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), e, (Object[]) null);
        }
    }

    @Override
    default void log(LogLevel level, String message, Throwable e) {
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), e, (Object[]) null);
        }
    }

    @Override
    default void log(LogLevel level, Supplier<String> supplier, Throwable e) {
        if (isLoggable(level)) {
            log(level, supplier.get(), e, (Object[]) null);
        }
    }

    @Override
    default void log(LogLevel level, Object message, Throwable e, Object... params) {
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), e, params);
        }
    }

    @Override
    default boolean isTraceEnabled() {
        return isLoggable(LogLevel.TRACE);
    }

    @Override
    default void trace(Object message) {
        var level = LogLevel.TRACE;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), null, (Object[]) null);
        }
    }

    @Override
    default void trace(String message) {
        var level = LogLevel.TRACE;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), null, (Object[]) null);
        }
    }

    @Override
    default void trace(Supplier<String> supplier) {
        var level = LogLevel.TRACE;
        if (isLoggable(level)) {
            log(level, supplier.get(), null, (Object[]) null);
        }
    }

    @Override
    default void trace(Object message, Object... params) {
        var level = LogLevel.TRACE;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), params, null);
        }
    }

    @Override
    default void trace(String message, Object... params) {
        var level = LogLevel.TRACE;
        if (isLoggable(level)) {
            log(level, message, null, params);
        }
    }

    @Override
    default void trace(Object message, Throwable e) {
        var level = LogLevel.TRACE;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), e, (Object[]) null);
        }
    }

    @Override
    default void trace(String message, Throwable e) {
        var level = LogLevel.TRACE;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), e, (Object[]) null);
        }
    }

    @Override
    default void trace(Supplier<String> supplier, Throwable e) {
        var level = LogLevel.TRACE;
        if (isLoggable(level)) {
            log(level, supplier.get(), e, (Object[]) null);
        }
    }

    @Override
    default void trace(Object message, Throwable e, Object... params) {
        var level = LogLevel.TRACE;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), e, params);
        }
    }

    @Override
    default void trace(String message, Throwable e, Object... params) {
        var level = LogLevel.TRACE;
        if (isLoggable(level)) {
            log(level, message, e, params);
        }
    }


    @Override
    default boolean isDebugEnabled() {
        return isLoggable(LogLevel.DEBUG);
    }

    @Override
    default void debug(Object message) {
        var level = LogLevel.DEBUG;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), null, (Object[]) null);
        }
    }

    @Override
    default void debug(String message) {
        var level = LogLevel.DEBUG;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), null, (Object[]) null);
        }
    }

    @Override
    default void debug(Supplier<String> supplier) {
        var level = LogLevel.DEBUG;
        if (isLoggable(level)) {
            log(level, supplier.get(), null, (Object[]) null);
        }
    }

    @Override
    default void debug(Object message, Object... params) {
        var level = LogLevel.DEBUG;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), params, null);
        }
    }

    @Override
    default void debug(String message, Object... params) {
        var level = LogLevel.DEBUG;
        if (isLoggable(level)) {
            log(level, message, null, params);
        }
    }

    @Override
    default void debug(Object message, Throwable e) {
        var level = LogLevel.DEBUG;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), e, (Object[]) null);
        }
    }

    @Override
    default void debug(String message, Throwable e) {
        var level = LogLevel.DEBUG;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), e, (Object[]) null);
        }
    }

    @Override
    default void debug(Supplier<String> supplier, Throwable e) {
        var level = LogLevel.DEBUG;
        if (isLoggable(level)) {
            log(level, supplier.get(), e, (Object[]) null);
        }
    }

    @Override
    default void debug(Object message, Throwable e, Object... params) {
        var level = LogLevel.DEBUG;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), e, params);
        }
    }

    @Override
    default void debug(String message, Throwable e, Object... params) {
        var level = LogLevel.DEBUG;
        if (isLoggable(level)) {
            log(level, message, e, params);
        }
    }


    @Override
    default boolean isInfoEnabled() {
        return isLoggable(LogLevel.INFO);
    }

    @Override
    default void info(Object message) {
        var level = LogLevel.INFO;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), null, (Object[]) null);
        }
    }

    @Override
    default void info(String message) {
        var level = LogLevel.INFO;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), null, (Object[]) null);
        }
    }

    @Override
    default void info(Supplier<String> supplier) {
        var level = LogLevel.INFO;
        if (isLoggable(level)) {
            log(level, supplier.get(), null, (Object[]) null);
        }
    }

    @Override
    default void info(Object message, Object... params) {
        var level = LogLevel.INFO;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), params, null);
        }
    }

    @Override
    default void info(String message, Object... params) {
        var level = LogLevel.INFO;
        if (isLoggable(level)) {
            log(level, message, null, params);
        }
    }

    @Override
    default void info(Object message, Throwable e) {
        var level = LogLevel.INFO;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), e, (Object[]) null);
        }
    }

    @Override
    default void info(String message, Throwable e) {
        var level = LogLevel.INFO;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), e, (Object[]) null);
        }
    }

    @Override
    default void info(Supplier<String> supplier, Throwable e) {
        var level = LogLevel.INFO;
        if (isLoggable(level)) {
            log(level, supplier.get(), e, (Object[]) null);
        }
    }

    @Override
    default void info(Object message, Throwable e, Object... params) {
        var level = LogLevel.INFO;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), e, params);
        }
    }

    @Override
    default void info(String message, Throwable e, Object... params) {
        var level = LogLevel.INFO;
        if (isLoggable(level)) {
            log(level, message, e, params);
        }
    }


    @Override
    default boolean isWarnEnabled() {
        return isLoggable(LogLevel.WARN);
    }

    @Override
    default void warn(Object message) {
        var level = LogLevel.WARN;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), null, (Object[]) null);
        }
    }

    @Override
    default void warn(String message) {
        var level = LogLevel.WARN;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), null, (Object[]) null);
        }
    }

    @Override
    default void warn(Supplier<String> supplier) {
        var level = LogLevel.WARN;
        if (isLoggable(level)) {
            log(level, supplier.get(), null, (Object[]) null);
        }
    }

    @Override
    default void warn(Object message, Object... params) {
        var level = LogLevel.WARN;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), params, null);
        }
    }

    @Override
    default void warn(String message, Object... params) {
        var level = LogLevel.WARN;
        if (isLoggable(level)) {
            log(level, message, null, params);
        }
    }

    @Override
    default void warn(Object message, Throwable e) {
        var level = LogLevel.WARN;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), e, (Object[]) null);
        }
    }

    @Override
    default void warn(String message, Throwable e) {
        var level = LogLevel.WARN;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), e, (Object[]) null);
        }
    }

    @Override
    default void warn(Supplier<String> supplier, Throwable e) {
        var level = LogLevel.WARN;
        if (isLoggable(level)) {
            log(level, supplier.get(), e, (Object[]) null);
        }
    }

    @Override
    default void warn(Object message, Throwable e, Object... params) {
        var level = LogLevel.WARN;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), e, params);
        }
    }

    @Override
    default void warn(String message, Throwable e, Object... params) {
        var level = LogLevel.WARN;
        if (isLoggable(level)) {
            log(level, message, e, params);
        }
    }


    @Override
    default boolean isErrorEnabled() {
        return isLoggable(LogLevel.ERROR);
    }

    @Override
    default void error(Object message) {
        var level = LogLevel.ERROR;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), null, (Object[]) null);
        }
    }

    @Override
    default void error(String message) {
        var level = LogLevel.ERROR;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), null, (Object[]) null);
        }
    }

    @Override
    default void error(Supplier<String> supplier) {
        var level = LogLevel.ERROR;
        if (isLoggable(level)) {
            log(level, supplier.get(), null, (Object[]) null);
        }
    }

    @Override
    default void error(Object message, Object... params) {
        var level = LogLevel.ERROR;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), params, null);
        }
    }

    @Override
    default void error(String message, Object... params) {
        var level = LogLevel.ERROR;
        if (isLoggable(level)) {
            log(level, message, null, params);
        }
    }

    @Override
    default void error(Object message, Throwable e) {
        var level = LogLevel.ERROR;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), e, (Object[]) null);
        }
    }

    @Override
    default void error(String message, Throwable e) {
        var level = LogLevel.ERROR;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), e, (Object[]) null);
        }
    }

    @Override
    default void error(Supplier<String> supplier, Throwable e) {
        var level = LogLevel.ERROR;
        if (isLoggable(level)) {
            log(level, supplier.get(), e, (Object[]) null);
        }
    }

    @Override
    default void error(Object message, Throwable e, Object... params) {
        var level = LogLevel.ERROR;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), e, params);
        }
    }

    @Override
    default void error(String message, Throwable e, Object... params) {
        var level = LogLevel.ERROR;
        if (isLoggable(level)) {
            log(level, message, e, params);
        }
    }


    @Override
    default boolean isFatalEnabled() {
        return isLoggable(LogLevel.FATAL);
    }

    @Override
    default void fatal(Object message) {
        var level = LogLevel.FATAL;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), null, (Object[]) null);
        }
    }

    @Override
    default void fatal(String message) {
        var level = LogLevel.FATAL;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), null, (Object[]) null);
        }
    }

    @Override
    default void fatal(Supplier<String> supplier) {
        var level = LogLevel.FATAL;
        if (isLoggable(level)) {
            log(level, supplier.get(), null, (Object[]) null);
        }
    }

    @Override
    default void fatal(Object message, Object... params) {
        var level = LogLevel.FATAL;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), params, null);
        }
    }

    @Override
    default void fatal(String message, Object... params) {
        var level = LogLevel.FATAL;
        if (isLoggable(level)) {
            log(level, message, null, params);
        }
    }

    @Override
    default void fatal(Object message, Throwable e) {
        var level = LogLevel.FATAL;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), e, (Object[]) null);
        }
    }

    @Override
    default void fatal(String message, Throwable e) {
        var level = LogLevel.FATAL;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), e, (Object[]) null);
        }
    }

    @Override
    default void fatal(Supplier<String> supplier, Throwable e) {
        var level = LogLevel.FATAL;
        if (isLoggable(level)) {
            log(level, supplier.get(), e, (Object[]) null);
        }
    }

    @Override
    default void fatal(Object message, Throwable e, Object... params) {
        var level = LogLevel.FATAL;
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), e, params);
        }
    }

    @Override
    default void fatal(String message, Throwable e, Object... params) {
        var level = LogLevel.FATAL;
        if (isLoggable(level)) {
            log(level, message, e, params);
        }
    }
}
