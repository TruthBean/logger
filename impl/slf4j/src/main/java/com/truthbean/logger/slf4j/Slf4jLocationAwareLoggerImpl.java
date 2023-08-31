/**
 * Copyright (c) 2023 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.slf4j;

import com.truthbean.Logger;
import com.truthbean.logger.ConfigurableLogger;
import com.truthbean.logger.LogLevel;
import com.truthbean.LoggerFactory;
import com.truthbean.logger.util.MessageHelper;
import org.slf4j.spi.LocationAwareLogger;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * @author TruthBean
 * @since 0.0.1
 * Created on 2018-02-01 22:31.
 */
class Slf4jLocationAwareLoggerImpl implements ConfigurableLogger {

    private static final String CALLER_FQCN = Slf4jImpl.class.getName();

    private final LocationAwareLogger log;

    private final String name;

    /**
     * @param log slf4j location aware logger
     */
    Slf4jLocationAwareLoggerImpl(LocationAwareLogger log, String name) {
        this.log = log;
        this.name = name;
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

    public int getLevel(LogLevel level) {
        return switch (level) {
            case OFF -> Integer.MAX_VALUE;
            case FATAL -> 40;
            case ERROR -> 40;
            case WARN -> 30;
            case INFO -> 20;
            case DEBUG -> 10;
            case TRACE -> 0;
            default -> 0;
            case ALL -> Integer.MIN_VALUE;
        };
    }

    @Override
    public Logger logger() {
        return this;
    }

    @Override
    public boolean isLoggable(LogLevel level) {
        return switch (level) {
            case OFF -> true;
            case FATAL -> true;
            case ERROR -> this.log.isErrorEnabled(Slf4jImpl.MARKER);
            case WARN -> this.log.isWarnEnabled(Slf4jImpl.MARKER);
            case INFO -> this.log.isInfoEnabled(Slf4jImpl.MARKER);
            case DEBUG -> this.log.isDebugEnabled(Slf4jImpl.MARKER);
            case TRACE -> this.log.isTraceEnabled(Slf4jImpl.MARKER);
            default -> false;
            case ALL -> true;
        };
    }

    @Override
    public void log(LogLevel level, Object message) {
        if (isLoggable(level)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, getLevel(level), MessageHelper.toString(message), null, null);
        }
    }

    @Override
    public void log(LogLevel level, String message) {
        if (isLoggable(level)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, getLevel(level), message, null, null);
        }
    }

    @Override
    public void log(LogLevel level, Supplier<String> supplier) {
        if (isLoggable(level)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, getLevel(level), supplier.get(), null, null);
        }
    }

    @Override
    public void log(LogLevel level, Object message, Object... params) {
        if (isLoggable(level)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, getLevel(level), MessageHelper.toString(message), params, null);
        }
    }

    @Override
    public void log(LogLevel level, String message, Object... params) {
        if (isLoggable(level)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, getLevel(level), message, params, null);
        }
    }

    @Override
    public void log(LogLevel level, Object message, Throwable e) {
        if (isLoggable(level)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, getLevel(level), MessageHelper.toString(message), null, e);
        }
    }

    @Override
    public void log(LogLevel level, String message, Throwable e) {
        if (isLoggable(level)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, getLevel(level), message, null, e);
        }
    }

    @Override
    public void log(LogLevel level, Supplier<String> supplier, Throwable e) {
        if (isLoggable(level)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, getLevel(level), supplier.get(), null, e);
        }
    }

    @Override
    public void log(LogLevel level, Object message, Throwable e, Object... params) {
        if (isLoggable(level)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, getLevel(level), MessageHelper.toString(message), params, e);
        }
    }

    @Override
    public void log(LogLevel level, String message, Throwable e, Object... params) {
        if (isLoggable(level)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, getLevel(level), message, params, e);
        }
    }

    @Override
    public boolean isTraceEnabled() {
        return this.log.isTraceEnabled(Slf4jImpl.MARKER);
    }

    @Override
    public void trace(Object message) {
        if (isTraceEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.TRACE_INT, MessageHelper.toString(message), null, null);
        }
    }

    @Override
    public void trace(String message) {
        if (this.isTraceEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.TRACE_INT, message, null, null);
        }
    }

    @Override
    public void trace(Supplier<String> supplier) {
        if (this.isTraceEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.TRACE_INT, supplier.get(), null, null);
        }
    }

    @Override
    public void trace(Object message, Object... params) {
        if (isTraceEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.TRACE_INT, MessageHelper.toString(message), params, null);
        }
    }

    @Override
    public void trace(String message, Object... params) {
        if (this.isTraceEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.TRACE_INT, message, params, null);
        }
    }

    @Override
    public void trace(Object message, Throwable e) {
        if (isTraceEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.TRACE_INT, MessageHelper.toString(message), null, e);
        }
    }

    @Override
    public void trace(String message, Throwable e) {
        if (this.isTraceEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.TRACE_INT, message, null, e);
        }
    }

    @Override
    public void trace(Supplier<String> supplier, Throwable e) {
        if (this.isTraceEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.TRACE_INT, supplier.get(), null, e);
        }
    }

    @Override
    public void trace(Object message, Throwable e, Object... params) {
        if (isTraceEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.TRACE_INT, MessageHelper.toString(message), params, e);
        }
    }

    @Override
    public void trace(String message, Throwable e, Object... params) {
        if (this.isTraceEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.TRACE_INT, message, params, e);
        }
    }

    @Override
    public boolean isDebugEnabled() {
        return this.log.isDebugEnabled(Slf4jImpl.MARKER);
    }

    @Override
    public void debug(Object message) {
        if (isDebugEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.DEBUG_INT, MessageHelper.toString(message), null, null);
        }
    }

    @Override
    public void debug(String message) {
        if (isDebugEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.DEBUG_INT, message, null, null);
        }
    }

    @Override
    public void debug(Supplier<String> supplier) {
        if (isDebugEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.DEBUG_INT, supplier.get(), null, null);
        }
    }

    @Override
    public void debug(Object message, Object... params) {
        if (isDebugEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.DEBUG_INT, MessageHelper.toString(message), params, null);
        }
    }

    @Override
    public void debug(String message, Object... params) {
        if (isDebugEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.DEBUG_INT, message, params, null);
        }
    }

    @Override
    public void debug(Object message, Throwable e) {
        if (isDebugEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.DEBUG_INT, MessageHelper.toString(message), null, e);
        }
    }

    @Override
    public void debug(String message, Throwable e) {
        if (isDebugEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.DEBUG_INT, message, null, e);
        }
    }

    @Override
    public void debug(Supplier<String> supplier, Throwable e) {
        if (isDebugEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.DEBUG_INT, supplier.get(), null, e);
        }
    }

    @Override
    public void debug(Object message, Throwable e, Object... params) {
        if (isDebugEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.DEBUG_INT, MessageHelper.toString(message), params, e);
        }
    }

    @Override
    public void debug(String message, Throwable e, Object... params) {
        if (isDebugEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.DEBUG_INT, message, params, e);
        }
    }

    @Override
    public boolean isInfoEnabled() {
        return this.log.isInfoEnabled(Slf4jImpl.MARKER);
    }

    @Override
    public void info(Object message) {
        if (isInfoEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.INFO_INT, MessageHelper.toString(message), null, null);
        }
    }

    @Override
    public void info(String message) {
        if (isInfoEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.INFO_INT, message, null, null);
        }
    }

    @Override
    public void info(Supplier<String> supplier) {
        if (isInfoEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.INFO_INT, supplier.get(), null, null);
        }
    }

    @Override
    public void info(Object message, Object... params) {
        if (isInfoEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.INFO_INT, MessageHelper.toString(message), params, null);
        }
    }

    @Override
    public void info(String message, Object... params) {
        if (isInfoEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.INFO_INT, message, params, null);
        }
    }

    @Override
    public void info(Object message, Throwable e) {
        if (isInfoEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.INFO_INT, MessageHelper.toString(message), null, e);
        }
    }

    @Override
    public void info(String message, Throwable e) {
        if (isInfoEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.INFO_INT, message, null, e);
        }
    }

    @Override
    public void info(Supplier<String> supplier, Throwable e) {
        if (isInfoEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.INFO_INT, supplier.get(), null, e);
        }
    }

    @Override
    public void info(Object message, Throwable e, Object... params) {
        if (isInfoEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.INFO_INT, MessageHelper.toString(message), params, e);
        }
    }

    @Override
    public void info(String message, Throwable e, Object... params) {
        if (isInfoEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.INFO_INT, message, params, e);
        }
    }

    @Override
    public boolean isWarnEnabled() {
        return this.log.isWarnEnabled(Slf4jImpl.MARKER);
    }

    @Override
    public void warn(Object message) {
        if (isWarnEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.WARN_INT, MessageHelper.toString(message), null, null);
        }
    }

    @Override
    public void warn(String message) {
        if (isWarnEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.WARN_INT, message, null, null);
        }
    }

    @Override
    public void warn(Supplier<String> supplier) {
        if (isWarnEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.WARN_INT, supplier.get(), null, null);
        }
    }

    @Override
    public void warn(Object message, Object... params) {
        if (isWarnEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.WARN_INT, MessageHelper.toString(message), params, null);
        }
    }

    @Override
    public void warn(String message, Object... params) {
        if (isWarnEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.WARN_INT, message, params, null);
        }
    }

    @Override
    public void warn(Object message, Throwable e) {
        if (isWarnEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.WARN_INT, MessageHelper.toString(message), null, e);
        }
    }

    @Override
    public void warn(String message, Throwable e) {
        if (isWarnEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.WARN_INT, message, null, e);
        }
    }

    @Override
    public void warn(Supplier<String> supplier, Throwable e) {
        if (isWarnEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.WARN_INT, supplier.get(), null, e);
        }
    }

    @Override
    public void warn(Object message, Throwable e, Object... params) {
        if (isWarnEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.WARN_INT, MessageHelper.toString(message), params, e);
        }
    }

    @Override
    public void warn(String message, Throwable e, Object... params) {
        if (isWarnEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.WARN_INT, message, params, e);
        }
    }

    @Override
    public boolean isErrorEnabled() {
        return this.log.isErrorEnabled(Slf4jImpl.MARKER);
    }

    @Override
    public void error(Object message) {
        if (isErrorEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, MessageHelper.toString(message), null, null);
        }
    }

    @Override
    public void error(String message) {
        if (isErrorEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, message, null, null);
        }
    }

    @Override
    public void error(Supplier<String> supplier) {
        if (isErrorEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, supplier.get(), null, null);
        }
    }

    @Override
    public void error(Object message, Object... params) {
        if (isErrorEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, MessageHelper.toString(message), params, null);
        }
    }

    @Override
    public void error(String message, Object... params) {
        if (isErrorEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, message, params, null);
        }
    }

    @Override
    public void error(Object message, Throwable e) {
        if (isErrorEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, MessageHelper.toString(message), null, e);
        }
    }

    @Override
    public void error(String message, Throwable e) {
        if (isErrorEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, message, null, e);
        }
    }

    @Override
    public void error(Supplier<String> supplier, Throwable e) {
        if (isErrorEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, supplier.get(), null, e);
        }
    }

    @Override
    public void error(Object message, Throwable e, Object... params) {
        if (isErrorEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, MessageHelper.toString(message), params, e);
        }
    }

    @Override
    public void error(String message, Throwable e, Object... params) {
        if (isErrorEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, message, params, e);
        }
    }

    @Override
    public boolean isFatalEnabled() {
        return true;
    }

    @Override
    public void fatal(Object message) {
        if (isFatalEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, MessageHelper.toString(message), null, null);
        }
    }

    @Override
    public void fatal(String message) {
        if (isFatalEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, message, null, null);
        }
    }

    @Override
    public void fatal(Supplier<String> supplier) {
        if (isFatalEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, supplier.get(), null, null);
        }
    }

    @Override
    public void fatal(Object message, Object... params) {
        if (isFatalEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, MessageHelper.toString(message), params, null);
        }
    }

    @Override
    public void fatal(String message, Object... params) {
        if (isFatalEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, message, params, null);
        }
    }

    @Override
    public void fatal(Object message, Throwable e) {
        if (isFatalEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, MessageHelper.toString(message), null, e);
        }
    }

    @Override
    public void fatal(String message, Throwable e) {
        if (isFatalEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, message, null, e);
        }
    }

    @Override
    public void fatal(Supplier<String> supplier, Throwable e) {
        if (isFatalEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, supplier.get(), null, e);
        }
    }

    @Override
    public void fatal(Object message, Throwable e, Object... params) {
        if (isFatalEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, MessageHelper.toString(message), params, e);
        }
    }

    @Override
    public void fatal(String message, Throwable e, Object... params) {
        if (isFatalEnabled()) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, message, params, e);
        }
    }
}
