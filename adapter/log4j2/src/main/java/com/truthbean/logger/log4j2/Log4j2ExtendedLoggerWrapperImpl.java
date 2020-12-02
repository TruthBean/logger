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
import com.truthbean.logger.BaseLogger;
import com.truthbean.logger.ConfigurableLogger;
import com.truthbean.logger.LogLevel;
import com.truthbean.logger.LoggerFactory;
import com.truthbean.logger.util.MessageHelper;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.spi.AbstractLogger;
import org.apache.logging.log4j.spi.ExtendedLoggerWrapper;

import java.util.Objects;
import java.util.function.Supplier;

import static com.truthbean.logger.log4j2.Log4j2Impl.FQCN;
import static com.truthbean.logger.log4j2.Log4j2Impl.MARKER;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-05-11 23:13
 */
class Log4j2ExtendedLoggerWrapperImpl implements ConfigurableLogger {
    private final ExtendedLoggerWrapper logger;
    private LogLevel level;
    private Level defaultLevel;
    private String name;
    Log4j2ExtendedLoggerWrapperImpl(AbstractLogger logger, String name) {
        this.name = name;
        this.logger = new ExtendedLoggerWrapper(logger, logger.getName(), logger.getMessageFactory());
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
        return this.name;
    }

    @Override
    public ConfigurableLogger setDefaultLevel(LogLevel level) {
        this.level = level;
        defaultLevel = Log4j2Impl.toLevel(level).orElse(Level.ERROR);
        return this;
    }

    @Override
    public LogLevel getDefaultLevel() {
        return this.level;
    }

    @Override
    public LogLevel getLevel() {
        var config = LoggerFactory.getConfig();
        var level = config.getLevel(logger.getName());
        LogLevel logLevel = Log4j2Impl.fromLevel(logger.getLevel()).orElseGet(() -> Objects.requireNonNullElse(getDefaultLevel(), LogLevel.ERROR));
        return level.orElse(logLevel);
    }

    @Override
    public Logger logger() {
        this.level = getLevel();
        return this;
    }

    @Override
    public boolean isLoggable(LogLevel level) {
        var bool = this.level.compareTo(level) >= 0;
        var optional = Log4j2Impl.toLevel(level);
        return optional.map(value -> bool && this.logger.isEnabled(value, MARKER)).orElse(bool);
    }

    @Override
    public void log(LogLevel level, Object message) {
        if (isLoggable(level)) {
            this.logger.logIfEnabled(FQCN, Log4j2Impl.toLevel(level).orElse(defaultLevel), MARKER, MessageHelper.toString(message));
        }
    }

    @Override
    public void log(LogLevel level, String message) {
        if (isLoggable(level)) {
            this.logger.logIfEnabled(FQCN, Log4j2Impl.toLevel(level).orElse(defaultLevel), MARKER, message);
        }
    }

    @Override
    public void log(LogLevel level, Supplier<String> supplier) {
        if (isLoggable(level)) {
            this.logger.logIfEnabled(FQCN, Log4j2Impl.toLevel(level).orElse(defaultLevel), MARKER, supplier.get());
        }
    }

    @Override
    public void log(LogLevel level, Object message, Object... params) {
        if (isLoggable(level)) {
            this.logger.logIfEnabled(FQCN, Log4j2Impl.toLevel(level).orElse(defaultLevel), MARKER, MessageHelper.format(message, params));
        }
    }

    @Override
    public void log(LogLevel level, String message, Object... params) {
        if (isLoggable(level)) {
            this.logger.logIfEnabled(FQCN, Log4j2Impl.toLevel(level).orElse(defaultLevel), MARKER, MessageHelper.format(message, params));
        }
    }

    @Override
    public void log(LogLevel level, Object message, Throwable e) {
        if (isLoggable(level)) {
            this.logger.logIfEnabled(FQCN, Log4j2Impl.toLevel(level).orElse(defaultLevel), MARKER, message, e);
        }
    }

    @Override
    public void log(LogLevel level, String message, Throwable e) {
        if (isLoggable(level)) {
            this.logger.logIfEnabled(FQCN, Log4j2Impl.toLevel(level).orElse(defaultLevel), MARKER, message, e);
        }
    }

    @Override
    public void log(LogLevel level, Supplier<String> supplier, Throwable e) {
        if (isLoggable(level)) {
            this.logger.logIfEnabled(FQCN, Log4j2Impl.toLevel(level).orElse(defaultLevel), MARKER, supplier.get(), e);
        }
    }

    @Override
    public void log(LogLevel level, Object message, Throwable e, Object... params) {
        if (isLoggable(level)) {
            this.logger.logIfEnabled(FQCN, Log4j2Impl.toLevel(level).orElse(defaultLevel), MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public void log(LogLevel level, String message, Throwable e, Object... params) {
        if (isLoggable(level)) {
            this.logger.logIfEnabled(FQCN, Log4j2Impl.toLevel(level).orElse(defaultLevel), MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public boolean isTraceEnabled() {
        return this.level.compareTo(LogLevel.TRACE) >= 0 && this.logger.isTraceEnabled(MARKER);
    }

    @Override
    public void trace(Object message) {

    }

    @Override
    public void trace(String message) {
        if (this.isTraceEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.TRACE, MARKER, message);
        }
    }

    @Override
    public void trace(Supplier<String> supplier) {
        if (this.isTraceEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.TRACE, MARKER, supplier::get, null);
        }
    }

    @Override
    public void trace(Object message, Object... params) {
        if (this.isTraceEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.TRACE, MARKER, MessageHelper.format(message, params));
        }
    }

    @Override
    public void trace(String message, Object... params) {
        if (this.isTraceEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.TRACE, MARKER, message, params);
        }
    }

    @Override
    public void trace(Object message, Throwable e) {
        if (this.isTraceEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.TRACE, MARKER, MessageHelper.toString(message), e);
        }
    }

    @Override
    public void trace(String message, Throwable e) {
        if (this.isTraceEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.TRACE, MARKER, message, e);
        }
    }

    @Override
    public void trace(Supplier<String> supplier, Throwable e) {
        if (this.isTraceEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.TRACE, MARKER, supplier::get, e);
        }
    }

    @Override
    public void trace(Object message, Throwable e, Object... params) {
        if (this.isTraceEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.TRACE, MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public void trace(String message, Throwable e, Object... params) {
        if (this.isTraceEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.TRACE, MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public boolean isDebugEnabled() {
        return this.level.compareTo(LogLevel.DEBUG) >= 0 && this.logger.isDebugEnabled(MARKER);
    }

    @Override
    public void debug(Object message) {
        if (this.isTraceEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.DEBUG, MARKER, MessageHelper.toString(message));
        }
    }

    @Override
    public void debug(String message) {
        if (this.isDebugEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.DEBUG, MARKER, message);
        }
    }

    @Override
    public void debug(Supplier<String> supplier) {
        if (this.isDebugEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.DEBUG, MARKER, supplier::get, null);
        }
    }

    @Override
    public void debug(Object message, Object... params) {
        if (this.isTraceEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.DEBUG, MARKER, MessageHelper.format(message, params));
        }
    }

    @Override
    public void debug(String message, Object... params) {
        if (this.isDebugEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.DEBUG, MARKER, message, params);
        }
    }

    @Override
    public void debug(Object message, Throwable e) {
        if (this.isTraceEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.DEBUG, MARKER, MessageHelper.toString(message), e);
        }
    }

    @Override
    public void debug(String message, Throwable e) {
        if (this.isDebugEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.DEBUG, MARKER, message, e);
        }
    }

    @Override
    public void debug(Supplier<String> supplier, Throwable e) {
        if (this.isDebugEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.DEBUG, MARKER, supplier::get, e);
        }
    }

    @Override
    public void debug(Object message, Throwable e, Object... params) {
        if (this.isTraceEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.DEBUG, MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public void debug(String message, Throwable e, Object... params) {
        if (this.isDebugEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.DEBUG, MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public boolean isInfoEnabled() {
        return this.level.compareTo(LogLevel.INFO) >= 0 && this.logger.isInfoEnabled(MARKER);
    }

    @Override
    public void info(Object message) {
        if (this.isTraceEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.INFO, MARKER, MessageHelper.toString(message));
        }
    }

    @Override
    public void info(String message) {
        if (this.isInfoEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.INFO, MARKER, message);
        }
    }

    @Override
    public void info(Supplier<String> supplier) {
        if (this.isInfoEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.INFO, MARKER, supplier::get, null);
        }
    }

    @Override
    public void info(Object message, Object... params) {
        if (this.isTraceEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.INFO, MARKER, MessageHelper.format(message, params));
        }
    }

    @Override
    public void info(String message, Object... params) {
        if (this.isInfoEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.INFO, MARKER, message, params);
        }
    }

    @Override
    public void info(Object message, Throwable e) {
        if (this.isTraceEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.INFO, MARKER, MessageHelper.toString(message), e);
        }
    }

    @Override
    public void info(String message, Throwable e) {
        if (this.isInfoEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.INFO, MARKER, message, e);
        }
    }

    @Override
    public void info(Supplier<String> supplier, Throwable e) {
        if (this.isInfoEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.INFO, MARKER, supplier::get, e);
        }
    }

    @Override
    public void info(Object message, Throwable e, Object... params) {
        if (this.isTraceEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.INFO, MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public void info(String message, Throwable e, Object... params) {
        if (this.isInfoEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.INFO, MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public boolean isWarnEnabled() {
        return this.level.compareTo(LogLevel.WARN) >= 0 && this.logger.isWarnEnabled(MARKER);
    }

    @Override
    public void warn(Object message) {
        if (this.isTraceEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.WARN, MARKER, MessageHelper.toString(message));
        }
    }

    @Override
    public void warn(String message) {
        if (this.isWarnEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.WARN, MARKER, message);
        }
    }

    @Override
    public void warn(Supplier<String> supplier) {
        if (this.isWarnEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.WARN, MARKER, supplier::get, null);
        }
    }

    @Override
    public void warn(Object message, Object... params) {
        if (this.isTraceEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.WARN, MARKER, MessageHelper.format(message, params));
        }
    }

    @Override
    public void warn(String message, Object... params) {
        if (this.isWarnEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.WARN, MARKER, message, params);
        }
    }

    @Override
    public void warn(Object message, Throwable e) {
        if (this.isTraceEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.WARN, MARKER, MessageHelper.toString(message), e);
        }
    }

    @Override
    public void warn(String message, Throwable e) {
        if (this.isWarnEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.WARN, MARKER, message, e);
        }
    }

    @Override
    public void warn(Supplier<String> supplier, Throwable e) {
        if (this.isWarnEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.WARN, MARKER, supplier::get, e);
        }
    }

    @Override
    public void warn(Object message, Throwable e, Object... params) {
        if (this.isTraceEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.WARN, MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public void warn(String message, Throwable e, Object... params) {
        if (this.isWarnEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.WARN, MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public boolean isErrorEnabled() {
        return this.level.compareTo(LogLevel.ERROR) >= 0 && this.logger.isErrorEnabled(MARKER);
    }

    @Override
    public void error(Object message) {
        if (this.isTraceEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.ERROR, MARKER, MessageHelper.toString(message));
        }
    }

    @Override
    public void error(String message) {
        if (this.isErrorEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.ERROR, MARKER, message);
        }
    }

    @Override
    public void error(Supplier<String> supplier) {
        if (this.isErrorEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.ERROR, MARKER, supplier::get, null);
        }
    }

    @Override
    public void error(Object message, Object... params) {
        if (this.isTraceEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.ERROR, MARKER, MessageHelper.format(message, params));
        }
    }

    @Override
    public void error(String message, Object... params) {
        if (this.isErrorEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.ERROR, MARKER, message, params);
        }
    }

    @Override
    public void error(Object message, Throwable e) {
        if (this.isTraceEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.ERROR, MARKER, MessageHelper.toString(message), e);
        }
    }

    @Override
    public void error(String message, Throwable e) {
        if (this.isErrorEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.ERROR, MARKER, message, e);
        }
    }

    @Override
    public void error(Supplier<String> supplier, Throwable e) {
        if (this.isErrorEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.ERROR, MARKER, supplier::get, e);
        }
    }

    @Override
    public void error(Object message, Throwable e, Object... params) {
        if (this.isTraceEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.ERROR, MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public void error(String message, Throwable e, Object... params) {
        if (this.isErrorEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.ERROR, MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public boolean isFatalEnabled() {
        return this.level.compareTo(LogLevel.FATAL) >= 0 && this.logger.isFatalEnabled(MARKER);
    }

    @Override
    public void fatal(Object message) {
        if (this.isTraceEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.FATAL, MARKER, MessageHelper.toString(message));
        }
    }

    @Override
    public void fatal(String message) {
        if (this.isFatalEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.FATAL, MARKER, message);
        }
    }

    @Override
    public void fatal(Supplier<String> supplier) {
        if (this.isFatalEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.FATAL, MARKER, supplier::get, null);
        }
    }

    @Override
    public void fatal(Object message, Object... params) {
        if (this.isTraceEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.FATAL, MARKER, MessageHelper.format(message, params));
        }
    }

    @Override
    public void fatal(String message, Object... params) {
        if (this.isFatalEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.FATAL, MARKER, message, params);
        }
    }

    @Override
    public void fatal(Object message, Throwable e) {
        if (this.isTraceEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.FATAL, MARKER, MessageHelper.toString(message), e);
        }
    }

    @Override
    public void fatal(String message, Throwable e) {
        if (this.isFatalEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.FATAL, MARKER, message, e);
        }
    }

    @Override
    public void fatal(Supplier<String> supplier, Throwable e) {
        if (this.isFatalEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.FATAL, MARKER, supplier::get, e);
        }
    }

    @Override
    public void fatal(Object message, Throwable e, Object... params) {
        if (this.isTraceEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.FATAL, MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public void fatal(String message, Throwable e, Object... params) {
        if (this.isFatalEnabled()) {
            this.logger.logIfEnabled(FQCN, Level.FATAL, MARKER, MessageHelper.format(message, params), e);
        }
    }
}
