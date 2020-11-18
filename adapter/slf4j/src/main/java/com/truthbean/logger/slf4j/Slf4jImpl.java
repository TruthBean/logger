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
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.slf4j.spi.LocationAwareLogger;

import java.util.function.Supplier;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-02-14 14:11
 */
public class Slf4jImpl implements Logger {
    static final Marker MARKER = MarkerFactory.getMarker("truthbean");
    private Logger logger;
    private org.slf4j.Logger rawLogger;
    private LogLevel level;

    static {
        try {
            Class<?> handlerClass = Class.forName("org.slf4j.bridge.SLF4JBridgeHandler");
            var removeHandlersForRootLogger = handlerClass.getMethod("removeHandlersForRootLogger");
            removeHandlersForRootLogger.invoke(null);
            var install = handlerClass.getMethod("install");
            install.invoke(null);
        } catch (Throwable ignored) {
        }
    }

    public Slf4jImpl() {
    }

    @Override
    public Logger setClass(Class<?> tracedClass) {
        this.rawLogger = LoggerFactory.getLogger(tracedClass);
        return getLogger();
    }

    @Override
    public Logger setName(String name) {
        this.rawLogger = LoggerFactory.getLogger(name);
        return getLogger();
    }

    private Logger getLogger() {
        if (rawLogger instanceof LocationAwareLogger) {
            this.logger = new Slf4jLocationAwareLoggerImpl((LocationAwareLogger) rawLogger);
        } else {
            rawLogger.warn("{} is not a suitable logger", rawLogger.getClass());
            this.logger = new Slf4jLoggerImpl(rawLogger);
        }
        return this;
    }

    @Override
    public Logger setLevel(LogLevel level) {
        this.level = level;
        return this;
    }

    @Override
    public LogLevel getLevel() {
        if (this.level == null) {
            return LogLevel.ERROR;
        }
        return level;
    }

    @Override
    public boolean isLoggable(LogLevel level) {
        return getLevel().compareTo(level) >= 0 && logger.isLoggable(level);
    }

    @Override
    public boolean isTraceEnabled() {
        return getLevel().compareTo(LogLevel.TRACE) >= 0 && logger.isTraceEnabled();
    }

    @Override
    public void trace(String message) {
        if (isTraceEnabled()) {
            logger.trace(message);
        }
    }

    @Override
    public void trace(Supplier<String> supplier) {
        if (isTraceEnabled()) {
            logger.trace(supplier);
        }
    }

    @Override
    public void trace(String message, Object... params) {
        if (isTraceEnabled()) {
            logger.trace(message, params);
        }
    }

    @Override
    public void trace(String message, Throwable e) {
        if (isTraceEnabled()) {
            logger.trace(message, e);
        }
    }

    @Override
    public void trace(Supplier<String> supplier, Throwable e) {
        if (isTraceEnabled()) {
            logger.trace(supplier, e);
        }
    }

    @Override
    public void trace(String message, Throwable e, Object... params) {
        if (isTraceEnabled()) {
            logger.trace(message, e, params);
        }
    }

    @Override
    public boolean isDebugEnabled() {
        return getLevel().compareTo(LogLevel.DEBUG) >= 0 && logger.isDebugEnabled();
    }

    @Override
    public void debug(String message) {
        if (isDebugEnabled()) {
            logger.debug(message);
        }
    }

    @Override
    public void debug(Supplier<String> supplier) {
        if (isDebugEnabled()) {
            logger.debug(supplier);
        }
    }

    @Override
    public void debug(String message, Object... params) {
        if (isDebugEnabled()) {
            logger.debug(message, params);
        }
    }

    @Override
    public void debug(String message, Throwable e) {
        if (isDebugEnabled()) {
            logger.debug(message, e);
        }
    }

    @Override
    public void debug(Supplier<String> supplier, Throwable e) {
        if (isDebugEnabled()) {
            logger.debug(supplier, e);
        }
    }

    @Override
    public void debug(String message, Throwable e, Object... params) {
        if (isDebugEnabled()) {
            logger.debug(message, e, params);
        }
    }

    @Override
    public boolean isInfoEnabled() {
        return getLevel().compareTo(LogLevel.INFO) >= 0 && logger.isInfoEnabled();
    }

    @Override
    public void info(String message) {
        if (isInfoEnabled()) {
            logger.info(message);
        }
    }

    @Override
    public void info(Supplier<String> supplier) {
        if (isInfoEnabled()) {
            logger.info(supplier);
        }
    }

    @Override
    public void info(String message, Object... params) {
        if (isInfoEnabled()) {
            logger.info(message, params);
        }
    }

    @Override
    public void info(String message, Throwable e) {
        if (isInfoEnabled()) {
            logger.info(message, e);
        }
    }

    @Override
    public void info(Supplier<String> supplier, Throwable e) {
        if (isInfoEnabled()) {
            logger.info(supplier, e);
        }
    }

    @Override
    public void info(String message, Throwable e, Object... params) {
        if (isInfoEnabled()) {
            logger.info(message, e, params);
        }
    }

    @Override
    public boolean isWarnEnabled() {
        return getLevel().compareTo(LogLevel.WARN) >= 0 && logger.isWarnEnabled();
    }

    @Override
    public void warn(String message) {
        if (isWarnEnabled()) {
            logger.warn(message);
        }
    }

    @Override
    public void warn(Supplier<String> supplier) {
        if (isWarnEnabled()) {
            logger.warn(supplier);
        }
    }

    @Override
    public void warn(String message, Object... params) {
        if (isWarnEnabled()) {
            logger.warn(message, params);
        }
    }

    @Override
    public void warn(String message, Throwable e) {
        if (isWarnEnabled()) {
            logger.warn(message, e);
        }
    }

    @Override
    public void warn(Supplier<String> supplier, Throwable e) {
        if (isWarnEnabled()) {
            logger.warn(supplier, e);
        }
    }

    @Override
    public void warn(String message, Throwable e, Object... params) {
        if (isWarnEnabled()) {
            logger.warn(message, e, params);
        }
    }

    @Override
    public boolean isErrorEnabled() {
        return getLevel().compareTo(LogLevel.ERROR) >= 0 && logger.isErrorEnabled();
    }

    @Override
    public void error(String message) {
        if (isErrorEnabled()) {
            logger.error(message);
        }
    }

    @Override
    public void error(Supplier<String> supplier) {
        if (isErrorEnabled()) {
            logger.error(supplier);
        }
    }

    @Override
    public void error(String message, Object... params) {
        if (isErrorEnabled()) {
            logger.error(message, params);
        }
    }

    @Override
    public void error(String message, Throwable e) {
        if (isErrorEnabled()) {
            logger.error(message, e);
        }
    }

    @Override
    public void error(Supplier<String> supplier, Throwable e) {
        if (isErrorEnabled()) {
            logger.error(supplier, e);
        }
    }

    @Override
    public void error(String message, Throwable e, Object... params) {
        if (isErrorEnabled()) {
            logger.error(message, e, params);
        }
    }

    @Override
    public boolean isFatalEnabled() {
        return getLevel().compareTo(LogLevel.FATAL) >= 0 && logger.isFatalEnabled();
    }

    @Override
    public void fatal(String message) {
        if (isFatalEnabled()) {
            logger.fatal(message);
        }
    }

    @Override
    public void fatal(Supplier<String> supplier) {
        if (isFatalEnabled()) {
            logger.fatal(supplier);
        }
    }

    @Override
    public void fatal(String message, Object... params) {
        if (isFatalEnabled()) {
            logger.fatal(message, params);
        }
    }

    @Override
    public void fatal(String message, Throwable e) {
        if (isFatalEnabled()) {
            logger.fatal(message, e);
        }
    }

    @Override
    public void fatal(Supplier<String> supplier, Throwable e) {
        if (isFatalEnabled()) {
            logger.fatal(supplier, e);
        }
    }

    @Override
    public void fatal(String message, Throwable e, Object... params) {
        if (isFatalEnabled()) {
            logger.fatal(message, e, params);
        }
    }
}
