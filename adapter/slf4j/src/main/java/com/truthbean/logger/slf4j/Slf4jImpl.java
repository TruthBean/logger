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
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.slf4j.spi.LocationAwareLogger;

import java.lang.reflect.Method;
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

    static {
        try {
            Class<?> handlerClass = Class.forName("org.slf4j.bridge.SLF4JBridgeHandler");
            Method removeHandlersForRootLogger = handlerClass.getMethod("removeHandlersForRootLogger");
            removeHandlersForRootLogger.invoke(null);
            Method install = handlerClass.getMethod("install");
            install.invoke(null);
        } catch (Throwable ignored) {
        }
    }

    @Override
    public Logger setClass(Class<?> tracedClass) {
        this.rawLogger = LoggerFactory.getLogger(tracedClass);
        if (rawLogger instanceof LocationAwareLogger) {
            this.logger = new Slf4jLocationAwareLoggerImpl((LocationAwareLogger) rawLogger);
        } else {
            rawLogger.warn("{} is not a suitable logger", rawLogger.getClass());
            this.logger = new Slf4jLoggerImpl(rawLogger);
        }
        return this;
    }

    @Override
    public Logger setName(String name) {
        this.rawLogger = LoggerFactory.getLogger(name);
        if (rawLogger instanceof LocationAwareLogger) {
            this.logger = new Slf4jLocationAwareLoggerImpl((LocationAwareLogger) rawLogger);
        } else {
            rawLogger.warn("{} is not a suitable logger", rawLogger.getClass());
            this.logger = new Slf4jLoggerImpl(rawLogger);
        }
        return this;
    }

    @Override
    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    @Override
    public void trace(String message) {
        logger.trace(message);
    }

    @Override
    public void trace(Supplier<String> supplier) {
        logger.trace(supplier);
    }

    @Override
    public void trace(String message, Object... params) {
        logger.trace(message, params);
    }

    @Override
    public void trace(String message, Throwable e) {
        logger.trace(message, e);
    }

    @Override
    public void trace(Supplier<String> supplier, Throwable e) {
        logger.trace(supplier, e);
    }

    @Override
    public void trace(String message, Throwable e, Object... params) {
        logger.trace(message, e, params);
    }

    @Override
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    @Override
    public void debug(String message) {
        logger.debug(message);
    }

    @Override
    public void debug(Supplier<String> supplier) {
        logger.debug(supplier);
    }

    @Override
    public void debug(String message, Object... params) {
        logger.debug(message, params);
    }

    @Override
    public void debug(String message, Throwable e) {
        logger.debug(message, e);
    }

    @Override
    public void debug(Supplier<String> supplier, Throwable e) {
        logger.debug(supplier, e);
    }

    @Override
    public void debug(String message, Throwable e, Object... params) {
        logger.debug(message, e, params);
    }

    @Override
    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    @Override
    public void info(String message) {
        logger.info(message);
    }

    @Override
    public void info(Supplier<String> supplier) {
        logger.info(supplier);
    }

    @Override
    public void info(String message, Object... params) {
        logger.info(message, params);
    }

    @Override
    public void info(String message, Throwable e) {
        logger.info(message, e);
    }

    @Override
    public void info(Supplier<String> supplier, Throwable e) {
        logger.info(supplier, e);
    }

    @Override
    public void info(String message, Throwable e, Object... params) {
        logger.info(message, e, params);
    }

    @Override
    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

    @Override
    public void warn(String message) {
        logger.warn(message);
    }

    @Override
    public void warn(Supplier<String> supplier) {
        logger.warn(supplier);
    }

    @Override
    public void warn(String message, Object... params) {
        logger.warn(message, params);
    }

    @Override
    public void warn(String message, Throwable e) {
        logger.warn(message, e);
    }

    @Override
    public void warn(Supplier<String> supplier, Throwable e) {
        logger.warn(supplier, e);
    }

    @Override
    public void warn(String message, Throwable e, Object... params) {
        logger.warn(message, e, params);
    }

    @Override
    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }

    @Override
    public void error(String message) {
        logger.error(message);
    }

    @Override
    public void error(Supplier<String> supplier) {
        logger.error(supplier);
    }

    @Override
    public void error(String message, Object... params) {
        logger.error(message, params);
    }

    @Override
    public void error(String message, Throwable e) {
        logger.error(message, e);
    }

    @Override
    public void error(Supplier<String> supplier, Throwable e) {
        logger.error(supplier, e);
    }

    @Override
    public void error(String message, Throwable e, Object... params) {
        logger.error(message, e, params);
    }

    @Override
    public boolean isFatalEnabled() {
        return logger.isFatalEnabled();
    }

    @Override
    public void fatal(String message) {
        logger.fatal(message);
    }

    @Override
    public void fatal(Supplier<String> supplier) {
        logger.fatal(supplier);
    }

    @Override
    public void fatal(String message, Object... params) {
        logger.fatal(message, params);
    }

    @Override
    public void fatal(String message, Throwable e) {
        logger.fatal(message, e);
    }

    @Override
    public void fatal(Supplier<String> supplier, Throwable e) {
        logger.fatal(supplier, e);
    }

    @Override
    public void fatal(String message, Throwable e, Object... params) {
        logger.fatal(message, e, params);
    }
}
