/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger;

import com.truthbean.Logger;
import com.truthbean.logger.util.MessageHelper;

import java.util.function.Supplier;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-12-01 11:06
 */
public class DefaultBaseLogger implements BaseLogger {
    private String loggerName;
    private LogLevel level;
    private Logger logger;
    private boolean useName;

    public DefaultBaseLogger() {
    }

    public DefaultBaseLogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    public ConfigurableLogger setClass(Class<?> tracedClass) {
        this.loggerName = tracedClass.getName();
        return this;
    }

    @Override
    public ConfigurableLogger setName(CharSequence name) {
        this.loggerName = name.toString();
        return this;
    }

    @Override
    public ConfigurableLogger setName(String name) {
        this.loggerName = name;
        return this;
    }

    @Override
    public ConfigurableLogger setUseName(boolean useName) {
        this.useName = useName;
        return this;
    }

    @Override
    public String getLoggerName() {
        return loggerName;
    }

    @Override
    public BaseLogger setDefaultLevel(LogLevel level) {
        this.level = level;
        return this;
    }

    @Override
    public LogLevel getDefaultLevel() {
        return this.level;
    }

    @Override
    public Logger logger() {
        this.level = getLevel();
        return this;
    }

    @Override
    public boolean isLoggable(LogLevel level) {
        if (this.logger == null) {
            return this.level.compareTo(level) >= 0;
        } else {
            return this.logger.isLoggable(level);
        }
    }

    @Override
    public void log(LogLevel level, Object message) {
        if (this.logger != null) {
            this.logger.log(level, message);
            return;
        }
        if (isLoggable(level)) {
            this.log(level, MessageHelper.toString(message));
        }
    }

    @Override
    public void log(LogLevel level, String message) {
        if (this.logger != null) {
            this.logger.log(level, message);
        }
    }

    @Override
    public void log(LogLevel level, Supplier<String> supplier) {
        if (this.logger != null) {
            this.logger.log(level, supplier);
            return;
        }
        if (isLoggable(level)) {
            log(level, supplier.get());
        }
    }

    @Override
    public void log(LogLevel level, Object message, Object... params) {
        if (this.logger != null) {
            this.logger.log(level, message, params);
            return;
        }
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), params);
        }
    }

    @Override
    public void log(LogLevel level, String message, Object... params) {
        if (this.logger != null) {
            this.logger.log(level, message, params);
        }
    }

    @Override
    public void log(LogLevel level, Object message, Throwable e) {
        if (this.logger != null) {
            this.logger.log(level, message, e);
            return;
        }
        if (isLoggable(level)) {
            log(level, MessageHelper.toString(message), e);
        }
    }

    @Override
    public void log(LogLevel level, String message, Throwable e) {
        if (this.logger != null) {
            this.logger.log(level, message, e);
        }
    }

    @Override
    public void log(LogLevel level, Supplier<String> supplier, Throwable e) {
        if (this.logger != null) {
            this.logger.log(level, supplier, e);
        }
    }

    @Override
    public void log(LogLevel level, Object message, Throwable e, Object... params) {
        if (this.logger != null) {
            this.logger.log(level, message, e, params);
            return;
        }
        if (isLoggable(level)) {
            trace(MessageHelper.toString(message), e, params);
        }
    }

    @Override
    public void log(LogLevel level, String message, Throwable e, Object... params) {
        if (this.logger != null) {
            this.logger.log(level, message, e, params);
        }
    }

    @Override
    public boolean isTraceEnabled() {
        if (this.logger != null) {
            return this.logger.isTraceEnabled();
        }
        return isLoggable(LogLevel.TRACE);
    }

    @Override
    public void trace(Object message) {
        if (this.logger != null) {
            this.logger.trace(message);
            return;
        }
        if (isTraceEnabled()) {
            trace(MessageHelper.toString(message));
        }
    }

    @Override
    public void trace(String message) {
        if (this.logger != null) {
            this.logger.trace(message);
        }
    }

    @Override
    public void trace(Supplier<String> supplier) {
        if (this.logger != null) {
            this.logger.trace(supplier);
            return;
        }
        if (isTraceEnabled()) {
            trace(supplier.get());
        }
    }

    @Override
    public void trace(Object message, Object... params) {
        if (this.logger != null) {
            this.logger.trace(message, params);
            return;
        }
        if (isTraceEnabled()) {
            trace(MessageHelper.toString(message), params);
        }
    }

    @Override
    public void trace(String message, Object... params) {
        if (this.logger != null) {
            this.logger.trace(message, params);
        }
    }

    @Override
    public void trace(Object message, Throwable e) {
        if (this.logger != null) {
            this.logger.trace(message, e);
            return;
        }
        if (isTraceEnabled()) {
            trace(MessageHelper.toString(message), e);
        }
    }

    @Override
    public void trace(String message, Throwable e) {
        if (this.logger != null) {
            this.logger.trace(message, e);
        }
    }

    @Override
    public void trace(Supplier<String> supplier, Throwable e) {
        if (this.logger != null) {
            this.logger.trace(supplier, e);
        }
    }

    @Override
    public void trace(Object message, Throwable e, Object... params) {
        if (this.logger != null) {
            this.logger.trace(message, e, params);
            return;
        }
        if (isTraceEnabled()) {
            trace(MessageHelper.toString(message), e, params);
        }
    }

    @Override
    public void trace(String message, Throwable e, Object... params) {
        if (this.logger != null) {
            this.logger.trace(message, e, params);
        }
    }

    @Override
    public boolean isDebugEnabled() {
        if (this.logger != null) {
            return this.logger.isDebugEnabled();
        }
        return isLoggable(LogLevel.DEBUG);
    }

    @Override
    public void debug(Object message) {
        if (this.logger != null) {
            this.logger.debug(message);
            return;
        }
        if (isDebugEnabled()) {
            debug(MessageHelper.toString(message));
        }
    }

    @Override
    public void debug(String message) {
        if (this.logger != null) {
            this.logger.debug(message);
        }
    }

    @Override
    public void debug(Supplier<String> supplier) {
        if (this.logger != null) {
            this.logger.debug(supplier);
        }
    }

    @Override
    public void debug(Object message, Object... params) {
        if (this.logger != null) {
            this.logger.debug(message, params);
            return;
        }
        if (isDebugEnabled()) {
            debug(MessageHelper.toString(message), params);
        }
    }

    @Override
    public void debug(String message, Object... params) {
        if (this.logger != null) {
            this.logger.debug(message, params);
        }
    }

    @Override
    public void debug(Object message, Throwable e) {
        if (this.logger != null) {
            this.logger.debug(message, e);
            return;
        }
        if (isDebugEnabled()) {
            debug(MessageHelper.toString(message), e);
        }
    }

    @Override
    public void debug(String message, Throwable e) {
        if (this.logger != null) {
            this.logger.debug(message, e);
        }
    }

    @Override
    public void debug(Supplier<String> supplier, Throwable e) {
        if (this.logger != null) {
            this.logger.debug(supplier, e);
        }
    }

    @Override
    public void debug(Object message, Throwable e, Object... params) {
        if (this.logger != null) {
            this.logger.debug(message, e, params);
            return;
        }
        if (isDebugEnabled()) {
            debug(MessageHelper.toString(message), e, params);
        }
    }

    @Override
    public void debug(String message, Throwable e, Object... params) {
        if (this.logger != null) {
            this.logger.debug(message, e, params);
        }
    }

    @Override
    public boolean isInfoEnabled() {
        if (this.logger != null) {
            return this.logger.isInfoEnabled();
        }
        return isLoggable(LogLevel.INFO);
    }

    @Override
    public void info(Object message) {
        if (this.logger != null) {
            this.logger.info(message);
            return;
        }
        if (isInfoEnabled()) {
            info(MessageHelper.toString(message));
        }
    }

    @Override
    public void info(String message) {
        if (this.logger != null) {
            this.logger.info(message);
        }
    }

    @Override
    public void info(Supplier<String> supplier) {
        if (this.logger != null) {
            this.logger.info(supplier);
        }
    }

    @Override
    public void info(Object message, Object... params) {
        if (this.logger != null) {
            this.logger.info(message, params);
            return;
        }
        if (isInfoEnabled()) {
            info(MessageHelper.toString(message), params);
        }
    }

    @Override
    public void info(String message, Object... params) {
        if (this.logger != null) {
            this.logger.info(message, params);
        }
    }

    @Override
    public void info(Object message, Throwable e) {
        if (this.logger != null) {
            this.logger.info(message, e);
            return;
        }
        if (isInfoEnabled()) {
            info(MessageHelper.toString(message), e);
        }
    }

    @Override
    public void info(String message, Throwable e) {
        if (this.logger != null) {
            this.logger.info(message, e);
        }
    }

    @Override
    public void info(Supplier<String> supplier, Throwable e) {
        if (this.logger != null) {
            this.logger.info(supplier, e);
        }
    }

    @Override
    public void info(Object message, Throwable e, Object... params) {
        if (this.logger != null) {
            this.logger.info(message, e, params);
            return;
        }
        if (isInfoEnabled()) {
            info(MessageHelper.toString(message), e, params);
        }
    }

    @Override
    public void info(String message, Throwable e, Object... params) {
        if (this.logger != null) {
            this.logger.info(message, e, params);
        }
    }

    @Override
    public boolean isWarnEnabled() {
        if (this.logger != null) {
            return this.logger.isWarnEnabled();
        }
        return isLoggable(LogLevel.WARN);
    }

    @Override
    public void warn(Object message) {
        if (this.logger != null) {
            this.logger.warn(message);
            return;
        }
        if (isWarnEnabled()) {
            warn(MessageHelper.toString(message));
        }
    }

    @Override
    public void warn(String message) {
        if (this.logger != null) {
            this.logger.warn(message);
        }
    }

    @Override
    public void warn(Supplier<String> supplier) {
        if (this.logger != null) {
            this.logger.warn(supplier);
        }
    }

    @Override
    public void warn(Object message, Object... params) {
        if (this.logger != null) {
            this.logger.warn(message, params);
            return;
        }
        if (isWarnEnabled()) {
            warn(MessageHelper.toString(message), params);
        }
    }

    @Override
    public void warn(String message, Object... params) {
        if (this.logger != null) {
            this.logger.warn(message, params);
        }
    }

    @Override
    public void warn(Object message, Throwable e) {
        if (this.logger != null) {
            this.logger.warn(message, e);
            return;
        }
        if (isWarnEnabled()) {
            warn(MessageHelper.toString(message), e);
        }
    }

    @Override
    public void warn(String message, Throwable e) {
        if (this.logger != null) {
            this.logger.warn(message, e);
        }
    }

    @Override
    public void warn(Supplier<String> supplier, Throwable e) {
        if (this.logger != null) {
            this.logger.warn(supplier, e);
        }
    }

    @Override
    public void warn(Object message, Throwable e, Object... params) {
        if (this.logger != null) {
            this.logger.warn(message, e, params);
            return;
        }
        if (isWarnEnabled()) {
            warn(MessageHelper.toString(message), e, params);
        }
    }

    @Override
    public void warn(String message, Throwable e, Object... params) {
        if (this.logger != null) {
            this.logger.warn(message, e, params);
        }
    }

    @Override
    public boolean isErrorEnabled() {
        if (this.logger != null) {
            return this.logger.isErrorEnabled();
        }
        return isLoggable(LogLevel.ERROR);
    }

    @Override
    public void error(Object message) {
        if (this.logger != null) {
            this.logger.error(message);
            return;
        }
        if (isErrorEnabled()) {
            error(MessageHelper.toString(message));
        }
    }

    @Override
    public void error(String message) {
        if (this.logger != null) {
            this.logger.error(message);
        }
    }

    @Override
    public void error(Supplier<String> supplier) {
        if (this.logger != null) {
            this.logger.error(supplier);
        }
    }

    @Override
    public void error(Object message, Object... params) {
        if (this.logger != null) {
            this.logger.error(message, params);
            return;
        }
        if (isErrorEnabled()) {
            error(MessageHelper.toString(message), params);
        }
    }

    @Override
    public void error(String message, Object... params) {
        if (this.logger != null) {
            this.logger.error(message, params);
        }
    }

    @Override
    public void error(Object message, Throwable e) {
        if (this.logger != null) {
            this.logger.error(message, e);
            return;
        }
        if (isErrorEnabled()) {
            error(MessageHelper.toString(message), e);
        }
    }

    @Override
    public void error(String message, Throwable e) {
        if (this.logger != null) {
            this.logger.error(message, e);
        }
    }

    @Override
    public void error(Supplier<String> supplier, Throwable e) {
        if (this.logger != null) {
            this.logger.error(supplier, e);
        }
    }

    @Override
    public void error(Object message, Throwable e, Object... params) {
        if (this.logger != null) {
            this.logger.error(message, e, params);
            return;
        }
        if (isErrorEnabled()) {
            error(MessageHelper.toString(message), e, params);
        }
    }

    @Override
    public void error(String message, Throwable e, Object... params) {
        if (this.logger != null) {
            this.logger.error(message, e, params);
        }
    }

    @Override
    public boolean isFatalEnabled() {
        if (this.logger != null) {
            return this.logger.isFatalEnabled();
        }
        return isLoggable(LogLevel.FATAL);
    }

    @Override
    public void fatal(Object message) {
        if (this.logger != null) {
            this.logger.fatal(message);
            return;
        }
        if (isFatalEnabled()) {
            fatal(MessageHelper.toString(message));
        }
    }

    @Override
    public void fatal(String message) {
        if (this.logger != null) {
            this.logger.fatal(message);
        }
    }

    @Override
    public void fatal(Supplier<String> supplier) {
        if (this.logger != null) {
            this.logger.fatal(supplier);
        }
    }

    @Override
    public void fatal(Object message, Object... params) {
        if (this.logger != null) {
            this.logger.fatal(message, params);
            return;
        }
        if (isFatalEnabled()) {
            fatal(MessageHelper.toString(message), params);
        }
    }

    @Override
    public void fatal(String message, Object... params) {
        if (this.logger != null) {
            this.logger.fatal(message, params);
        }
    }

    @Override
    public void fatal(Object message, Throwable e) {
        if (this.logger != null) {
            this.logger.fatal(message, e);
            return;
        }
        if (isFatalEnabled()) {
            fatal(MessageHelper.toString(message), e);
        }
    }

    @Override
    public void fatal(String message, Throwable e) {
        if (this.logger != null) {
            this.logger.fatal(message, e);
        }
    }

    @Override
    public void fatal(Supplier<String> supplier, Throwable e) {
        if (this.logger != null) {
            this.logger.fatal(supplier, e);
        }
    }

    @Override
    public void fatal(Object message, Throwable e, Object... params) {
        if (this.logger != null) {
            this.logger.fatal(message, e, params);
            return;
        }
        if (isFatalEnabled()) {
            fatal(MessageHelper.toString(message), e, params);
        }
    }

    @Override
    public void fatal(String message, Throwable e, Object... params) {
        if (this.logger != null) {
            this.logger.fatal(message, e, params);
        }
    }
}
