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
import com.truthbean.logger.util.MessageHelper;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.spi.AbstractLogger;
import org.apache.logging.log4j.spi.ExtendedLoggerWrapper;

import java.util.function.Supplier;

import static com.truthbean.logger.log4j2.Log4j2Impl.FQCN;
import static com.truthbean.logger.log4j2.Log4j2Impl.MARKER;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-05-11 23:13
 */
class Log4j2ExtendedLoggerWrapperImpl implements Logger {
    private final ExtendedLoggerWrapper logger;
    Log4j2ExtendedLoggerWrapperImpl(AbstractLogger logger) {
        this.logger = new ExtendedLoggerWrapper(logger, logger.getName(), logger.getMessageFactory());
    }

    @Override
    public boolean isTraceEnabled() {
        return this.logger.isTraceEnabled(MARKER);
    }

    @Override
    public void trace(String message) {
        if (this.logger.isTraceEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.TRACE, MARKER, message);
        }
    }

    @Override
    public void trace(Supplier<String> supplier) {
        if (this.logger.isTraceEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.TRACE, MARKER, supplier::get, null);
        }
    }

    @Override
    public void trace(String message, Object... params) {
        if (this.logger.isTraceEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.TRACE, MARKER, message, params);
        }
    }

    @Override
    public void trace(String message, Throwable e) {
        if (this.logger.isTraceEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.TRACE, MARKER, message, e);
        }
    }

    @Override
    public void trace(Supplier<String> supplier, Throwable e) {
        if (this.logger.isTraceEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.TRACE, MARKER, supplier::get, e);
        }
    }

    @Override
    public void trace(String message, Throwable e, Object... params) {
        if (this.logger.isTraceEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.TRACE, MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public boolean isDebugEnabled() {
        return this.logger.isDebugEnabled(MARKER);
    }

    @Override
    public void debug(String message) {
        if (this.logger.isDebugEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.DEBUG, MARKER, message);
        }
    }

    @Override
    public void debug(Supplier<String> supplier) {
        if (this.logger.isDebugEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.DEBUG, MARKER, supplier::get, null);
        }
    }

    @Override
    public void debug(String message, Object... params) {
        if (this.logger.isDebugEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.DEBUG, MARKER, message, params);
        }
    }

    @Override
    public void debug(String message, Throwable e) {
        if (this.logger.isDebugEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.DEBUG, MARKER, message, e);
        }
    }

    @Override
    public void debug(Supplier<String> supplier, Throwable e) {
        if (this.logger.isDebugEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.DEBUG, MARKER, supplier::get, e);
        }
    }

    @Override
    public void debug(String message, Throwable e, Object... params) {
        if (this.logger.isDebugEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.DEBUG, MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public boolean isInfoEnabled() {
        return this.logger.isInfoEnabled(MARKER);
    }

    @Override
    public void info(String message) {
        if (this.logger.isInfoEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.INFO, MARKER, message);
        }
    }

    @Override
    public void info(Supplier<String> supplier) {
        if (this.logger.isInfoEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.INFO, MARKER, supplier::get, null);
        }
    }

    @Override
    public void info(String message, Object... params) {
        if (this.logger.isInfoEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.INFO, MARKER, message, params);
        }
    }

    @Override
    public void info(String message, Throwable e) {
        if (this.logger.isInfoEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.INFO, MARKER, message, e);
        }
    }

    @Override
    public void info(Supplier<String> supplier, Throwable e) {
        if (this.logger.isInfoEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.INFO, MARKER, supplier::get, e);
        }
    }

    @Override
    public void info(String message, Throwable e, Object... params) {
        if (this.logger.isInfoEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.INFO, MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public boolean isWarnEnabled() {
        return this.logger.isWarnEnabled(MARKER);
    }

    @Override
    public void warn(String message) {
        if (this.logger.isWarnEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.WARN, MARKER, message);
        }
    }

    @Override
    public void warn(Supplier<String> supplier) {
        if (this.logger.isWarnEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.WARN, MARKER, supplier::get, null);
        }
    }

    @Override
    public void warn(String message, Object... params) {
        if (this.logger.isWarnEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.WARN, MARKER, message, params);
        }
    }

    @Override
    public void warn(String message, Throwable e) {
        if (this.logger.isWarnEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.WARN, MARKER, message, e);
        }
    }

    @Override
    public void warn(Supplier<String> supplier, Throwable e) {
        if (this.logger.isWarnEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.WARN, MARKER, supplier::get, e);
        }
    }

    @Override
    public void warn(String message, Throwable e, Object... params) {
        if (this.logger.isWarnEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.WARN, MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public boolean isErrorEnabled() {
        return this.logger.isErrorEnabled(MARKER);
    }

    @Override
    public void error(String message) {
        if (this.logger.isErrorEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.ERROR, MARKER, message);
        }
    }

    @Override
    public void error(Supplier<String> supplier) {
        if (this.logger.isErrorEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.ERROR, MARKER, supplier::get, null);
        }
    }

    @Override
    public void error(String message, Object... params) {
        if (this.logger.isErrorEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.ERROR, MARKER, message, params);
        }
    }

    @Override
    public void error(String message, Throwable e) {
        if (this.logger.isErrorEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.ERROR, MARKER, message, e);
        }
    }

    @Override
    public void error(Supplier<String> supplier, Throwable e) {
        if (this.logger.isErrorEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.ERROR, MARKER, supplier::get, e);
        }
    }

    @Override
    public void error(String message, Throwable e, Object... params) {
        if (this.logger.isErrorEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.ERROR, MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public boolean isFatalEnabled() {
        return this.logger.isFatalEnabled(MARKER);
    }

    @Override
    public void fatal(String message) {
        if (this.logger.isFatalEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.FATAL, MARKER, message);
        }
    }

    @Override
    public void fatal(Supplier<String> supplier) {
        if (this.logger.isFatalEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.FATAL, MARKER, supplier::get, null);
        }
    }

    @Override
    public void fatal(String message, Object... params) {
        if (this.logger.isFatalEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.FATAL, MARKER, message, params);
        }
    }

    @Override
    public void fatal(String message, Throwable e) {
        if (this.logger.isFatalEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.FATAL, MARKER, message, e);
        }
    }

    @Override
    public void fatal(Supplier<String> supplier, Throwable e) {
        if (this.logger.isFatalEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.FATAL, MARKER, supplier::get, e);
        }
    }

    @Override
    public void fatal(String message, Throwable e, Object... params) {
        if (this.logger.isFatalEnabled(MARKER)) {
            this.logger.logIfEnabled(FQCN, Level.FATAL, MARKER, MessageHelper.format(message, params), e);
        }
    }
}
