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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.spi.AbstractLogger;

import java.util.function.Supplier;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-05-11 22:25
 */
public class Log4j2Impl implements Logger {

    private Logger logger;
    private org.apache.logging.log4j.Logger originLogger;

    static final Marker MARKER = MarkerManager.getMarker("truthbean");
    static final String FQCN = Log4j2Impl.class.getName();

    @Override
    public Logger setClass(Class<?> tracedClass) {
        var logger = LogManager.getLogger(tracedClass);
        this.originLogger = logger;
        if (logger instanceof AbstractLogger) {
            this.logger = new Log4j2ExtendedLoggerWrapperImpl((AbstractLogger) logger);
        } else {
            this.logger = new Log4j2LoggerImpl(logger);
        }
        return this;
    }

    @Override
    public Logger setName(String name) {
        var logger = LogManager.getLogger(name);
        this.originLogger = logger;
        if (logger instanceof AbstractLogger) {
            this.logger = new Log4j2ExtendedLoggerWrapperImpl((AbstractLogger) logger);
        } else {
            this.logger = new Log4j2LoggerImpl(logger);
        }
        return this;
    }

    @Override
    public boolean isTraceEnabled() {
        return originLogger.isTraceEnabled();
    }

    @Override
    public void trace(String message) {
        if (originLogger.isTraceEnabled()) {
            logger.trace(message);
        }
    }

    @Override
    public void trace(Supplier<String> supplier) {
        if (originLogger.isTraceEnabled()) {
            logger.trace(supplier);
        }
    }

    @Override
    public void trace(String message, Object... params) {
        if (originLogger.isTraceEnabled()) {
            logger.trace(message, params);
        }
    }

    @Override
    public void trace(String message, Throwable e) {
        if (originLogger.isTraceEnabled()) {
            logger.trace(message, e);
        }
    }

    @Override
    public void trace(Supplier<String> supplier, Throwable e) {
        if (originLogger.isTraceEnabled()) {
            logger.trace(supplier, e);
        }
    }

    @Override
    public void trace(String message, Throwable e, Object... params) {
        if (originLogger.isTraceEnabled()) {
            logger.trace(message, e, params);
        }
    }

    @Override
    public boolean isDebugEnabled() {
        return originLogger.isDebugEnabled();
    }

    @Override
    public void debug(String message) {
        if (originLogger.isDebugEnabled()) {
            logger.debug(message);
        }
    }

    @Override
    public void debug(Supplier<String> supplier) {
        if (originLogger.isDebugEnabled()) {
            logger.debug(supplier);
        }
    }

    @Override
    public void debug(String message, Object... params) {
        if (originLogger.isDebugEnabled()) {
            logger.debug(message, params);
        }
    }

    @Override
    public void debug(String message, Throwable e) {
        if (originLogger.isDebugEnabled()) {
            logger.debug(message, e);
        }
    }

    @Override
    public void debug(Supplier<String> supplier, Throwable e) {
        if (originLogger.isDebugEnabled()) {
            logger.debug(supplier, e);
        }
    }

    @Override
    public void debug(String message, Throwable e, Object... params) {
        if (originLogger.isDebugEnabled()) {
            logger.debug(message, e, params);
        }
    }

    @Override
    public boolean isInfoEnabled() {
        return originLogger.isInfoEnabled();
    }

    @Override
    public void info(String message) {
        if (originLogger.isInfoEnabled()) {
            logger.info(message);
        }
    }

    @Override
    public void info(Supplier<String> supplier) {
        if (originLogger.isInfoEnabled()) {
            logger.info(supplier);
        }
    }

    @Override
    public void info(String message, Object... params) {
        if (originLogger.isInfoEnabled()) {
            logger.info(message, params);
        }
    }

    @Override
    public void info(String message, Throwable e) {
        if (originLogger.isInfoEnabled()) {
            logger.info(message, e);
        }
    }

    @Override
    public void info(Supplier<String> supplier, Throwable e) {
        if (originLogger.isInfoEnabled()) {
            logger.info(supplier, e);
        }
    }

    @Override
    public void info(String message, Throwable e, Object... params) {
        if (originLogger.isInfoEnabled()) {
            logger.info(message, e, params);
        }
    }

    @Override
    public boolean isWarnEnabled() {
        return originLogger.isWarnEnabled();
    }

    @Override
    public void warn(String message) {
        if (originLogger.isWarnEnabled()) {
            logger.warn(message);
        }
    }

    @Override
    public void warn(Supplier<String> supplier) {
        if (originLogger.isWarnEnabled()) {
            logger.warn(supplier);
        }
    }

    @Override
    public void warn(String message, Object... params) {
        if (originLogger.isWarnEnabled()) {
            logger.warn(message, params);
        }
    }

    @Override
    public void warn(String message, Throwable e) {
        if (originLogger.isWarnEnabled()) {
            logger.warn(message, e);
        }
    }

    @Override
    public void warn(Supplier<String> supplier, Throwable e) {
        if (originLogger.isWarnEnabled()) {
            logger.warn(supplier, e);
        }
    }

    @Override
    public void warn(String message, Throwable e, Object... params) {
        if (originLogger.isWarnEnabled()) {
            logger.warn(message, e, params);
        }
    }

    @Override
    public boolean isErrorEnabled() {
        return originLogger.isErrorEnabled();
    }

    @Override
    public void error(String message) {
        if (originLogger.isErrorEnabled()) {
            logger.error(message);
        }
    }

    @Override
    public void error(Supplier<String> supplier) {
        if (originLogger.isErrorEnabled()) {
            logger.error(supplier);
        }
    }

    @Override
    public void error(String message, Object... params) {
        if (originLogger.isErrorEnabled()) {
            logger.error(message, params);
        }
    }

    @Override
    public void error(String message, Throwable e) {
        if (originLogger.isErrorEnabled()) {
            logger.error(message, e);
        }
    }

    @Override
    public void error(Supplier<String> supplier, Throwable e) {
        if (originLogger.isErrorEnabled()) {
            logger.error(supplier, e);
        }
    }

    @Override
    public void error(String message, Throwable e, Object... params) {
        if (originLogger.isErrorEnabled()) {
            logger.error(message, e, params);
        }
    }

    @Override
    public boolean isFatalEnabled() {
        return originLogger.isFatalEnabled();
    }

    @Override
    public void fatal(String message) {
        if (originLogger.isFatalEnabled()) {
            logger.error(message);
        }
    }

    @Override
    public void fatal(Supplier<String> supplier) {
        if (originLogger.isFatalEnabled()) {
            logger.error(supplier);
        }
    }

    @Override
    public void fatal(String message, Object... params) {
        if (originLogger.isFatalEnabled()) {
            logger.error(message, params);
        }
    }

    @Override
    public void fatal(String message, Throwable e) {
        if (originLogger.isFatalEnabled()) {
            logger.error(message, e);
        }
    }

    @Override
    public void fatal(Supplier<String> supplier, Throwable e) {
        if (originLogger.isFatalEnabled()) {
            logger.error(supplier, e);
        }
    }

    @Override
    public void fatal(String message, Throwable e, Object... params) {
        if (originLogger.isFatalEnabled()) {
            logger.error(message, e, params);
        }
    }
}
