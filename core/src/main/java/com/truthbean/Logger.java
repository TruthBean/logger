/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean;

import com.truthbean.logger.LogLevel;

import java.util.function.Supplier;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-05-08 22:14
 */
public interface Logger {
    default Logger setClass(Class<?> tracedClass) {
        // do nothing
        return this;
    }

    default Logger setName(CharSequence name) {
        // do noting
        return setName(name.toString());
    }

    default Logger setName(String name) {
        // do noting
        return this;
    }

    default Logger setLevel(LogLevel level) {
        return this;
    }

    default LogLevel getLevel() {
        return LogLevel.TRACE;
    }

    private String toString(Object message) {
        if (message == null) {
            return "null";
        }
        return message.toString();
    }

    default boolean isTraceEnabled() {
        return getLevel().compareTo(LogLevel.TRACE) >= 0;
    }

    default void trace(Object message) {
        if (isTraceEnabled()) {
            trace(toString(message));
        }
    }

    default void trace(String message) {
    }

    default void trace(Supplier<String> supplier) {
        if (isTraceEnabled()) {
            trace(supplier.get());
        }
    }

    default void trace(Object message, Object... params) {
        if (isTraceEnabled()) {
            trace(toString(message), params);
        }
    }

    default void trace(String message, Object... params) {
    }

    default void trace(Object message, Throwable e) {
        if (isTraceEnabled()) {
            trace(toString(message), e);
        }
    }

    default void trace(String message, Throwable e) {
    }

    default void trace(Supplier<String> supplier, Throwable e) {
    }

    default void trace(Object message, Throwable e, Object... params) {
        if (isTraceEnabled()) {
            trace(toString(message), e, params);
        }
    }

    default void trace(String message, Throwable e, Object... params) {
    }

    default boolean isDebugEnabled() {
        return getLevel().compareTo(LogLevel.DEBUG) >= 0;
    }

    default void debug(Object message) {
        if (isDebugEnabled()) {
            debug(toString(message));
        }
    }

    default void debug(String message) {
    }

    default void debug(Supplier<String> supplier) {
    }

    default void debug(Object message, Object... params) {
        if (isDebugEnabled()) {
            debug(toString(message), params);
        }
    }

    default void debug(String message, Object... params) {
    }

    default void debug(Object message, Throwable e) {
        if (isDebugEnabled()) {
            debug(toString(message), e);
        }
    }

    default void debug(String message, Throwable e) {
    }

    default void debug(Supplier<String> supplier, Throwable e) {
    }

    default void debug(Object message, Throwable e, Object... params) {
        if (isDebugEnabled()) {
            debug(toString(message), e, params);
        }
    }

    default void debug(String message, Throwable e, Object... params) {
    }

    default boolean isInfoEnabled() {
        return getLevel().compareTo(LogLevel.INFO) >= 0;
    }

    default void info(Object message) {
        if (isInfoEnabled()) {
            info(toString(message));
        }
    }

    default void info(String message) {
    }

    default void info(Supplier<String> supplier) {
    }

    default void info(Object message, Object... params) {
        if (isInfoEnabled()) {
            info(toString(message), params);
        }
    }

    default void info(String message, Object... params) {
    }

    default void info(Object message, Throwable e) {
        if (isInfoEnabled()) {
            info(toString(message), e);
        }
    }

    default void info(String message, Throwable e) {
    }

    default void info(Supplier<String> supplier, Throwable e) {
    }

    default void info(Object message, Throwable e, Object... params) {
        if (isInfoEnabled()) {
            info(toString(message), e, params);
        }
    }

    default void info(String message, Throwable e, Object... params) {
    }

    default boolean isWarnEnabled() {
        return getLevel().compareTo(LogLevel.WARN) >= 0;
    }

    default void warn(Object message) {
        if (isWarnEnabled()) {
            warn(toString(message));
        }
    }

    default void warn(String message) {
    }

    default void warn(Supplier<String> supplier) {
    }

    default void warn(Object message, Object... params) {
        if (isWarnEnabled()) {
            warn(toString(message), params);
        }
    }

    default void warn(String message, Object... params) {
    }

    default void warn(Object message, Throwable e) {
        if (isWarnEnabled()) {
            warn(toString(message), e);
        }
    }

    default void warn(String message, Throwable e) {
    }

    default void warn(Supplier<String> supplier, Throwable e) {
    }

    default void warn(Object message, Throwable e, Object... params) {
        if (isWarnEnabled()) {
            warn(toString(message), e, params);
        }
    }

    default void warn(String message, Throwable e, Object... params) {
    }

    default boolean isErrorEnabled() {
        return getLevel().compareTo(LogLevel.ERROR) >= 0;
    }

    default void error(Object message) {
        if (isErrorEnabled()) {
            error(toString(message));
        }
    }

    default void error(String message) {
    }

    default void error(Supplier<String> supplier) {
    }

    default void error(Object message, Object... params) {
        if (isErrorEnabled()) {
            error(toString(message), params);
        }
    }

    default void error(String message, Object... params) {
    }

    default void error(Object message, Throwable e) {
        if (isErrorEnabled()) {
            error(toString(message), e);
        }
    }

    default void error(String message, Throwable e) {
    }

    default void error(Supplier<String> supplier, Throwable e) {
    }

    default void error(Object message, Throwable e, Object... params) {
        if (isErrorEnabled()) {
            error(toString(message), e, params);
        }
    }

    default void error(String message, Throwable e, Object... params) {
    }

    default boolean isFatalEnabled() {
        return getLevel().compareTo(LogLevel.FATAL) >= 0;
    }

    default void fatal(Object message) {
        if (isFatalEnabled()) {
            fatal(toString(message));
        }
    }

    default void fatal(String message) {
    }

    default void fatal(Supplier<String> supplier) {
    }

    default void fatal(Object message, Object... params) {
        if (isFatalEnabled()) {
            fatal(toString(message), params);
        }
    }

    default void fatal(String message, Object... params) {
    }

    default void fatal(Object message, Throwable e) {
        if (isFatalEnabled()) {
            fatal(toString(message), e);
        }
    }

    default void fatal(String message, Throwable e) {
    }

    default void fatal(Supplier<String> supplier, Throwable e) {
    }

    default void fatal(Object message, Throwable e, Object... params) {
        if (isFatalEnabled()) {
            fatal(toString(message), e, params);
        }
    }

    default void fatal(String message, Throwable e, Object... params) {
    }
}
