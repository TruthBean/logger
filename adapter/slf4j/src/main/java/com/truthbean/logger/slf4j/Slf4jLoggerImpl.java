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
import com.truthbean.logger.util.MessageHelper;

import java.util.function.Supplier;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-02-14 14:13
 */
class Slf4jLoggerImpl implements Logger {

    private final org.slf4j.Logger logger;
    Slf4jLoggerImpl(org.slf4j.Logger logger) {
        this.logger = logger;
    }

    @Override
    public boolean isTraceEnabled() {
        return logger.isTraceEnabled(Slf4jImpl.MARKER);
    }

    @Override
    public void trace(String message) {
        if (logger.isTraceEnabled(Slf4jImpl.MARKER)) {
            logger.trace(Slf4jImpl.MARKER, message);
        }
    }

    @Override
    public void trace(Supplier<String> supplier) {
        if (logger.isTraceEnabled(Slf4jImpl.MARKER)) {
            logger.trace(Slf4jImpl.MARKER, supplier.get());
        }
    }

    @Override
    public void trace(String message, Object... params) {
        if (logger.isTraceEnabled(Slf4jImpl.MARKER)) {
            logger.trace(Slf4jImpl.MARKER, message, params);
        }
    }

    @Override
    public void trace(String message, Throwable e) {
        if (logger.isTraceEnabled(Slf4jImpl.MARKER)) {
            logger.trace(Slf4jImpl.MARKER, message, e);
        }
    }

    @Override
    public void trace(Supplier<String> supplier, Throwable e) {
        if (logger.isTraceEnabled(Slf4jImpl.MARKER)) {
            logger.trace(Slf4jImpl.MARKER, supplier.get(), e);
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
    public void debug(String message) {
        if (logger.isDebugEnabled(Slf4jImpl.MARKER)) {
            logger.debug(Slf4jImpl.MARKER, message);
        }
    }

    @Override
    public void debug(Supplier<String> supplier) {
        if (logger.isDebugEnabled(Slf4jImpl.MARKER)) {
            logger.debug(Slf4jImpl.MARKER, supplier.get());
        }
    }

    @Override
    public void debug(String message, Object... params) {
        if (logger.isDebugEnabled(Slf4jImpl.MARKER)) {
            logger.debug(Slf4jImpl.MARKER, message, params);
        }
    }

    @Override
    public void debug(String message, Throwable e) {
        if (logger.isDebugEnabled(Slf4jImpl.MARKER)) {
            logger.debug(Slf4jImpl.MARKER, message, e);
        }
    }

    @Override
    public void debug(Supplier<String> supplier, Throwable e) {
        if (logger.isDebugEnabled(Slf4jImpl.MARKER)) {
            logger.debug(Slf4jImpl.MARKER, supplier.get(), e);
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
    public void info(String message) {
        if (logger.isInfoEnabled(Slf4jImpl.MARKER)) {
            logger.info(Slf4jImpl.MARKER, message);
        }
    }

    @Override
    public void info(Supplier<String> supplier) {
        if (logger.isInfoEnabled(Slf4jImpl.MARKER)) {
            logger.info(Slf4jImpl.MARKER, supplier.get());
        }
    }

    @Override
    public void info(String message, Object... params) {
        if (logger.isInfoEnabled(Slf4jImpl.MARKER)) {
            logger.info(Slf4jImpl.MARKER, message, params);
        }
    }

    @Override
    public void info(String message, Throwable e) {
        if (logger.isInfoEnabled(Slf4jImpl.MARKER)) {
            logger.info(Slf4jImpl.MARKER, message, e);
        }
    }

    @Override
    public void info(Supplier<String> supplier, Throwable e) {
        if (logger.isInfoEnabled(Slf4jImpl.MARKER)) {
            logger.info(Slf4jImpl.MARKER, supplier.get(), e);
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
    public void warn(String message) {
        if (logger.isWarnEnabled(Slf4jImpl.MARKER)) {
            logger.warn(Slf4jImpl.MARKER, message);
        }
    }

    @Override
    public void warn(Supplier<String> supplier) {
        if (logger.isWarnEnabled(Slf4jImpl.MARKER)) {
            logger.warn(Slf4jImpl.MARKER, supplier.get());
        }
    }

    @Override
    public void warn(String message, Object... params) {
        if (logger.isWarnEnabled(Slf4jImpl.MARKER)) {
            logger.warn(Slf4jImpl.MARKER, message, params);
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
    public void warn(String message, Throwable e, Object... params) {
        if (logger.isWarnEnabled(Slf4jImpl.MARKER)) {
            logger.warn(Slf4jImpl.MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public boolean isErrorEnabled() {
        return logger.isErrorEnabled(Slf4jImpl.MARKER);
    }

    @Override
    public void error(String message) {
        if (logger.isErrorEnabled(Slf4jImpl.MARKER)) {
            logger.error(Slf4jImpl.MARKER, message);
        }
    }

    @Override
    public void error(Supplier<String> supplier) {
        if (logger.isErrorEnabled(Slf4jImpl.MARKER)) {
            logger.error(Slf4jImpl.MARKER, supplier.get());
        }
    }

    @Override
    public void error(String message, Object... params) {
        if (logger.isErrorEnabled(Slf4jImpl.MARKER)) {
            logger.error(Slf4jImpl.MARKER, message, params);
        }
    }

    @Override
    public void error(String message, Throwable e) {
        if (logger.isErrorEnabled(Slf4jImpl.MARKER)) {
            logger.error(Slf4jImpl.MARKER, message, e);
        }
    }

    @Override
    public void error(Supplier<String> supplier, Throwable e) {
        if (logger.isErrorEnabled(Slf4jImpl.MARKER)) {
            logger.error(Slf4jImpl.MARKER, supplier.get(), e);
        }
    }

    @Override
    public void error(String message, Throwable e, Object... params) {
        if (logger.isErrorEnabled(Slf4jImpl.MARKER)) {
            logger.error(Slf4jImpl.MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public boolean isFatalEnabled() {
        return true;
    }

    @Override
    public void fatal(String message) {
        logger.error(message);
    }

    @Override
    public void fatal(Supplier<String> supplier) {
        logger.error(supplier.get());
    }

    @Override
    public void fatal(String message, Object... params) {
        logger.error(message, params);
    }

    @Override
    public void fatal(String message, Throwable e) {
        logger.error(message, e);
    }

    @Override
    public void fatal(Supplier<String> supplier, Throwable e) {
        logger.error(supplier.get(), e);
    }

    @Override
    public void fatal(String message, Throwable e, Object... params) {
        logger.error(MessageHelper.format(message, params), e);
    }
}
