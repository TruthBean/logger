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

import com.truthbean.logger.util.MessageHelper;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import java.util.function.Supplier;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-05-11 22:27
 */
class Log4j2LoggerImpl implements com.truthbean.Logger {
    private final Marker marker = MarkerManager.getMarker(Log4j2LoggerImpl.class.getName());

    private final Logger logger;
    Log4j2LoggerImpl(Logger logger) {
        this.logger = logger;
    }

    @Override
    public boolean isTraceEnabled() {
        return logger.isTraceEnabled(marker);
    }

    @Override
    public void trace(String message) {
        if (logger.isTraceEnabled(marker)) {
            this.logger.trace(marker, message);
        }
    }

    @Override
    public void trace(Supplier<String> supplier) {
        if (logger.isTraceEnabled(marker)) {
            this.logger.trace(marker, supplier::get);
        }
    }

    @Override
    public void trace(String message, Object... params) {
        if (logger.isTraceEnabled(marker)) {
            this.logger.trace(marker, message, params);
        }
    }

    @Override
    public void trace(String message, Throwable e) {
        if (logger.isTraceEnabled(marker)) {
            this.logger.trace(marker, message, e);
        }
    }

    @Override
    public void trace(Supplier<String> supplier, Throwable e) {
        if (logger.isTraceEnabled(marker)) {
            this.logger.trace(marker, supplier::get, e);
        }
    }

    @Override
    public void trace(String message, Throwable e, Object... params) {
        if (logger.isTraceEnabled(marker)) {
            this.logger.trace(marker, () -> MessageHelper.format(message, params), e);
        }
    }

    @Override
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled(marker);
    }

    @Override
    public void debug(String message) {
        if (logger.isDebugEnabled(marker)) {
            this.logger.debug(marker, message);
        }
    }

    @Override
    public void debug(Supplier<String> supplier) {
        if (logger.isDebugEnabled(marker)) {
            logger.debug(marker, supplier::get);
        }
    }

    @Override
    public void debug(String message, Object... params) {
        if (logger.isDebugEnabled(marker)) {
            logger.debug(marker);
        }
    }

    @Override
    public void debug(String message, Throwable e) {
        if (logger.isDebugEnabled(marker)) {
            logger.log(Level.DEBUG, marker, message, e);
        }
    }

    @Override
    public void debug(Supplier<String> supplier, Throwable e) {
        if (logger.isEnabled(Level.DEBUG, marker)) {
            logger.log(Level.DEBUG, marker, supplier::get, e);
        }
    }

    @Override
    public void debug(String message, Throwable e, Object... params) {
        if (logger.isEnabled(Level.DEBUG, marker)) {
            logger.log(Level.DEBUG, marker, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public boolean isInfoEnabled() {
        return logger.isEnabled(Level.INFO, marker);
    }

    @Override
    public void info(String message) {
        if (logger.isEnabled(Level.INFO, marker)) {
            logger.log(Level.INFO, marker, message);
        }
    }

    @Override
    public void info(Supplier<String> supplier) {
        if (logger.isEnabled(Level.INFO, marker)) {
            logger.log(Level.INFO, marker, supplier::get);
        }
    }

    @Override
    public void info(String message, Object... params) {
        if (logger.isInfoEnabled(marker)) {
            logger.info(marker, message, params);
        }
    }

    @Override
    public void info(String message, Throwable e) {
        if (logger.isInfoEnabled(marker)) {
            logger.info(marker, message, e);
        }
    }

    @Override
    public void info(Supplier<String> supplier, Throwable e) {
        if (logger.isInfoEnabled(marker)) {
            logger.info(marker, supplier::get, e);
        }
    }

    @Override
    public void info(String message, Throwable e, Object... params) {
        if (logger.isInfoEnabled(marker)) {
            logger.info(marker, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public boolean isWarnEnabled() {
        return logger.isWarnEnabled(marker);
    }

    @Override
    public void warn(String message) {
        if (logger.isWarnEnabled(marker)) {
            logger.warn(marker, message);
        }
    }

    @Override
    public void warn(Supplier<String> supplier) {
        if (logger.isWarnEnabled(marker)) {
            logger.warn(marker, supplier::get);
        }
    }

    @Override
    public void warn(String message, Object... params) {
        if (logger.isWarnEnabled(marker)) {
            logger.warn(marker, message, params);
        }
    }

    @Override
    public void warn(String message, Throwable e) {
        if (logger.isWarnEnabled(marker)) {
            logger.warn(marker, message, e);
        }
    }

    @Override
    public void warn(Supplier<String> supplier, Throwable e) {
        if (logger.isWarnEnabled(marker)) {
            logger.warn(marker, supplier::get, e);
        }
    }

    @Override
    public void warn(String message, Throwable e, Object... params) {
        if (logger.isWarnEnabled(marker)) {
            logger.warn(marker, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public boolean isErrorEnabled() {
        return logger.isErrorEnabled(marker);
    }

    @Override
    public void error(String message) {
        if (logger.isErrorEnabled(marker)) {
            logger.error(marker, message);
        }
    }

    @Override
    public void error(Supplier<String> supplier) {
        if (logger.isErrorEnabled(marker)) {
            logger.error(marker, supplier::get);
        }
    }

    @Override
    public void error(String message, Object... params) {
        if (logger.isErrorEnabled(marker)) {
            logger.error(marker, message, params);
        }
    }

    @Override
    public void error(String message, Throwable e) {
        if (logger.isErrorEnabled(marker)) {
            logger.error(marker, message, e);
        }
    }

    @Override
    public void error(Supplier<String> supplier, Throwable e) {
        if (logger.isErrorEnabled(marker)) {
            logger.error(marker, supplier::get, e);
        }
    }

    @Override
    public void error(String message, Throwable e, Object... params) {
        if (logger.isErrorEnabled(marker)) {
            logger.error(marker, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public boolean isFatalEnabled() {
        return logger.isFatalEnabled(marker);
    }

    @Override
    public void fatal(String message) {
        if (logger.isFatalEnabled(marker)) {
            logger.fatal(marker, message);
        }
    }

    @Override
    public void fatal(Supplier<String> supplier) {
        if (logger.isFatalEnabled(marker)) {
            logger.fatal(marker, supplier::get);
        }
    }

    @Override
    public void fatal(String message, Object... params) {
        if (logger.isFatalEnabled(marker)) {
            logger.fatal(marker, message, params);
        }
    }

    @Override
    public void fatal(String message, Throwable e) {
        if (logger.isFatalEnabled(marker)) {
            logger.fatal(marker, message, e);
        }
    }

    @Override
    public void fatal(Supplier<String> supplier, Throwable e) {
        if (logger.isFatalEnabled(marker)) {
            logger.fatal(marker, supplier::get, e);
        }
    }

    @Override
    public void fatal(String message, Throwable e, Object... params) {
        if (logger.isFatalEnabled(marker)) {
            logger.fatal(marker, MessageHelper.format(message, params), e);
        }
    }
}
