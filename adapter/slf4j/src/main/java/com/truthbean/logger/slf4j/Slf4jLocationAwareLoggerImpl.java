/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.slf4j;

import com.truthbean.Logger;
import com.truthbean.logger.LogLevel;
import org.slf4j.spi.LocationAwareLogger;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author TruthBean
 * @since 0.0.1
 * Created on 2018-02-01 22:31.
 */
class Slf4jLocationAwareLoggerImpl implements Logger {

    private static final String CALLER_FQCN = Slf4jImpl.class.getName();

    private final LocationAwareLogger log;

    /**
     * @param log slf4j location aware logger
     */
    Slf4jLocationAwareLoggerImpl(LocationAwareLogger log) {
        this.log = log;
    }

    @Override
    public boolean isLoggable(LogLevel level) {
        var bool = getLevel().compareTo(level) >= 0;
        switch (level) {
            case FATAL:
                return bool;
            case ERROR:
                return isErrorEnabled();
            case WARN:
                return this.isWarnEnabled();
            case INFO:
                return this.isInfoEnabled();
            case DEBUG:
                return this.isDebugEnabled();
            case TRACE:
                return this.isTraceEnabled();
            default:
                return false;
        }
    }

    @Override
    public boolean isTraceEnabled() {
        return getLevel().compareTo(LogLevel.TRACE) >= 0 && this.log.isTraceEnabled(Slf4jImpl.MARKER);
    }

    @Override
    public void trace(String message) {
        if (this.log.isTraceEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.TRACE_INT, message, null, null);
        }
    }

    @Override
    public void trace(Supplier<String> supplier) {
        if (this.log.isTraceEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.TRACE_INT, supplier.get(), null, null);
        }
    }

    @Override
    public void trace(String message, Object... params) {
        if (this.log.isTraceEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.TRACE_INT, message, params, null);
        }
    }

    @Override
    public void trace(String message, Throwable e) {
        if (this.log.isTraceEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.TRACE_INT, message, null, e);
        }
    }

    @Override
    public void trace(Supplier<String> supplier, Throwable e) {
        if (this.log.isTraceEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.TRACE_INT, supplier.get(), null, e);
        }
    }

    @Override
    public void trace(String message, Throwable e, Object... params) {
        if (this.log.isTraceEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.TRACE_INT, message, params, e);
        }
    }

    @Override
    public boolean isDebugEnabled() {
        return getLevel().compareTo(LogLevel.DEBUG) >= 0 && this.log.isDebugEnabled(Slf4jImpl.MARKER);
    }

    @Override
    public void debug(String message) {
        if (this.log.isDebugEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.DEBUG_INT, message, null, null);
        }
    }

    @Override
    public void debug(Supplier<String> supplier) {
        if (this.log.isDebugEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.DEBUG_INT, supplier.get(), null, null);
        }
    }

    @Override
    public void debug(String message, Object... params) {
        if (this.log.isDebugEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.DEBUG_INT, message, params, null);
        }
    }

    @Override
    public void debug(String message, Throwable e) {
        if (this.log.isDebugEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.DEBUG_INT, message, null, e);
        }
    }

    @Override
    public void debug(Supplier<String> supplier, Throwable e) {
        if (this.log.isDebugEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.DEBUG_INT, supplier.get(), null, e);
        }
    }

    @Override
    public void debug(String message, Throwable e, Object... params) {
        if (this.log.isDebugEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.DEBUG_INT, message, params, e);
        }
    }

    @Override
    public boolean isInfoEnabled() {
        return getLevel().compareTo(LogLevel.INFO) >= 0 && this.log.isInfoEnabled(Slf4jImpl.MARKER);
    }

    @Override
    public void info(String message) {
        if (this.log.isInfoEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.INFO_INT, message, null, null);
        }
    }

    @Override
    public void info(Supplier<String> supplier) {
        if (this.log.isInfoEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.INFO_INT, supplier.get(), null, null);
        }
    }

    @Override
    public void info(String message, Object... params) {
        if (this.log.isInfoEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.INFO_INT, message, params, null);
        }
    }

    @Override
    public void info(String message, Throwable e) {
        if (this.log.isInfoEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.INFO_INT, message, null, e);
        }
    }

    @Override
    public void info(Supplier<String> supplier, Throwable e) {
        if (this.log.isInfoEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.INFO_INT, supplier.get(), null, e);
        }
    }

    @Override
    public void info(String message, Throwable e, Object... params) {
        if (this.log.isInfoEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.INFO_INT, message, params, e);
        }
    }

    @Override
    public boolean isWarnEnabled() {
        return getLevel().compareTo(LogLevel.WARN) >= 0 && this.log.isWarnEnabled(Slf4jImpl.MARKER);
    }

    @Override
    public void warn(String message) {
        if (this.log.isWarnEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.WARN_INT, message, null, null);
        }
    }

    @Override
    public void warn(Supplier<String> supplier) {
        if (this.log.isWarnEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.WARN_INT, supplier.get(), null, null);
        }
    }

    @Override
    public void warn(String message, Object... params) {
        if (this.log.isWarnEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.WARN_INT, message, params, null);
        }
    }

    @Override
    public void warn(String message, Throwable e) {
        if (this.log.isWarnEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.WARN_INT, message, null, e);
        }
    }

    @Override
    public void warn(Supplier<String> supplier, Throwable e) {
        if (this.log.isWarnEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.WARN_INT, supplier.get(), null, e);
        }
    }

    @Override
    public void warn(String message, Throwable e, Object... params) {
        if (this.log.isWarnEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.WARN_INT, message, params, e);
        }
    }

    @Override
    public boolean isErrorEnabled() {
        return getLevel().compareTo(LogLevel.ERROR) >= 0 && this.log.isErrorEnabled(Slf4jImpl.MARKER);
    }

    @Override
    public void error(String message) {
        if (this.log.isErrorEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, message, null, null);
        }
    }

    @Override
    public void error(Supplier<String> supplier) {
        if (this.log.isErrorEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, supplier.get(), null, null);
        }
    }

    @Override
    public void error(String message, Object... params) {
        if (this.log.isErrorEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, message, params, null);
        }
    }

    @Override
    public void error(String message, Throwable e) {
        if (this.log.isErrorEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, message, null, e);
        }
    }

    @Override
    public void error(Supplier<String> supplier, Throwable e) {
        if (this.log.isErrorEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, supplier.get(), null, e);
        }
    }

    @Override
    public void error(String message, Throwable e, Object... params) {
        if (this.log.isErrorEnabled(Slf4jImpl.MARKER)) {
            this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, message, params, e);
        }
    }

    @Override
    public boolean isFatalEnabled() {
        return true;
    }

    @Override
    public void fatal(String message) {
        this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, message, null, null);
    }

    @Override
    public void fatal(Supplier<String> supplier) {
        this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, supplier.get(), null, null);
    }

    @Override
    public void fatal(String message, Object... params) {
        this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, message, params, null);
    }

    @Override
    public void fatal(String message, Throwable e) {
        this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, message, null, e);
    }

    @Override
    public void fatal(Supplier<String> supplier, Throwable e) {
        this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, supplier.get(), null, e);
    }

    @Override
    public void fatal(String message, Throwable e, Object... params) {
        this.log.log(Slf4jImpl.MARKER, CALLER_FQCN, LocationAwareLogger.ERROR_INT, message, params, e);
    }
}
