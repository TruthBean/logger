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

import com.truthbean.logger.BaseLogger;
import com.truthbean.logger.ConfigurableLogger;
import com.truthbean.logger.LogLevel;
import com.truthbean.logger.LoggerFactory;
import com.truthbean.logger.util.MessageHelper;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import java.util.Objects;
import java.util.function.Supplier;

import static com.truthbean.logger.log4j2.Log4j2Impl.FQCN;
import static com.truthbean.logger.log4j2.Log4j2Impl.MARKER;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-05-11 22:27
 */
class Log4j2LoggerImpl implements ConfigurableLogger {
    private final Marker marker = MarkerManager.getMarker(Log4j2LoggerImpl.class.getName());

    private final String name;
    private final Logger logger;

    private LogLevel level;
    private Level defaultLevel;
    
    Log4j2LoggerImpl(Logger logger, String name) {
        this.logger = logger;
        this.name = name;
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
        LogLevel logLevel = Log4j2Impl.fromLevel(logger.getLevel()).orElse(getDefaultLevel());
        var config = LoggerFactory.getConfig();
        var level = config.getLevel(logger.getName());
        return level.orElseGet(() -> Objects.requireNonNullElse(getDefaultLevel(), logLevel));
    }

    @Override
    public com.truthbean.Logger logger() {
        this.level = getLevel();
        return this;
    }

    @Override
    public boolean isLoggable(LogLevel level) {
        var bool = this.level.compareTo(level) >= 0;
        var optional = Log4j2Impl.toLevel(level);
        return optional.map(value -> bool && this.logger.isEnabled(value, marker)).orElse(bool);
    }

    @Override
    public void log(LogLevel level, Object message) {
        if (isLoggable(level)) {
            this.logger.log(Log4j2Impl.toLevel(level).orElse(defaultLevel), MARKER, message);
        }
    }

    @Override
    public void log(LogLevel level, String message) {
        if (isLoggable(level)) {
            this.logger.log(Log4j2Impl.toLevel(level).orElse(defaultLevel), MARKER, message);
        }
    }

    @Override
    public void log(LogLevel level, Supplier<String> supplier) {
        if (isLoggable(level)) {
            this.logger.log(Log4j2Impl.toLevel(level).orElse(defaultLevel), MARKER, supplier.get());
        }
    }

    @Override
    public void log(LogLevel level, Object message, Object... params) {
        if (isLoggable(level)) {
            this.logger.log(Log4j2Impl.toLevel(level).orElse(defaultLevel), MARKER, MessageHelper.format(message, params));
        }
    }

    @Override
    public void log(LogLevel level, String message, Object... params) {
        if (isLoggable(level)) {
            this.logger.log(Log4j2Impl.toLevel(level).orElse(defaultLevel), MARKER, MessageHelper.format(message, params));
        }
    }

    @Override
    public void log(LogLevel level, Object message, Throwable e) {
        if (isLoggable(level)) {
            this.logger.log(Log4j2Impl.toLevel(level).orElse(defaultLevel), MARKER, message, e);
        }
    }

    @Override
    public void log(LogLevel level, String message, Throwable e) {
        if (isLoggable(level)) {
            this.logger.log(Log4j2Impl.toLevel(level).orElse(defaultLevel), MARKER, message, e);
        }
    }

    @Override
    public void log(LogLevel level, Supplier<String> supplier, Throwable e) {
        if (isLoggable(level)) {
            this.logger.log(Log4j2Impl.toLevel(level).orElse(defaultLevel), MARKER, supplier.get(), e);
        }
    }

    @Override
    public void log(LogLevel level, Object message, Throwable e, Object... params) {
        if (isLoggable(level)) {
            this.logger.log(Log4j2Impl.toLevel(level).orElse(defaultLevel), MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public void log(LogLevel level, String message, Throwable e, Object... params) {
        if (isLoggable(level)) {
            this.logger.log(Log4j2Impl.toLevel(level).orElse(defaultLevel), MARKER, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public boolean isTraceEnabled() {
        return isLoggable(LogLevel.TRACE);
    }

    @Override
    public void trace(Object message) {
        if (isTraceEnabled()) {
            this.logger.trace(marker, message);
        }
    }

    @Override
    public void trace(String message) {
        if (isTraceEnabled()) {
            this.logger.trace(marker, message);
        }
    }

    @Override
    public void trace(Supplier<String> supplier) {
        if (isTraceEnabled()) {
            this.logger.trace(marker, supplier::get);
        }
    }

    @Override
    public void trace(Object message, Object... params) {
        if (isTraceEnabled()) {
            this.logger.trace(marker, MessageHelper.toString(message), params);
        }
    }

    @Override
    public void trace(String message, Object... params) {
        if (isTraceEnabled()) {
            this.logger.trace(marker, message, params);
        }
    }

    @Override
    public void trace(Object message, Throwable e) {
        if (isTraceEnabled()) {
            this.logger.trace(marker, MessageHelper.toString(message), e);
        }
    }

    @Override
    public void trace(String message, Throwable e) {
        if (isTraceEnabled()) {
            this.logger.trace(marker, message, e);
        }
    }

    @Override
    public void trace(Supplier<String> supplier, Throwable e) {
        if (isTraceEnabled()) {
            this.logger.trace(marker, supplier::get, e);
        }
    }

    @Override
    public void trace(Object message, Throwable e, Object... params) {
        if (isTraceEnabled()) {
            this.logger.trace(marker, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public void trace(String message, Throwable e, Object... params) {
        if (isTraceEnabled()) {
            this.logger.trace(marker, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public boolean isDebugEnabled() {
        return isLoggable(LogLevel.DEBUG);
    }

    @Override
    public void debug(Object message) {
        if (isDebugEnabled()) {
            this.logger.debug(marker, message);
        }
    }

    @Override
    public void debug(String message) {
        if (isDebugEnabled()) {
            this.logger.debug(marker, message);
        }
    }

    @Override
    public void debug(Supplier<String> supplier) {
        if (isDebugEnabled()) {
            logger.debug(marker, supplier::get);
        }
    }

    @Override
    public void debug(Object message, Object... params) {
        if (isDebugEnabled()) {
            logger.debug(marker, MessageHelper.toString(message), params);
        }
    }

    @Override
    public void debug(String message, Object... params) {
        if (isDebugEnabled()) {
            logger.debug(marker, message, params);
        }
    }

    @Override
    public void debug(Object message, Throwable e) {
        if (isDebugEnabled()) {
            logger.debug(marker, message, e);
        }
    }

    @Override
    public void debug(String message, Throwable e) {
        if (isDebugEnabled()) {
            logger.log(Level.DEBUG, marker, message, e);
        }
    }

    @Override
    public void debug(Supplier<String> supplier, Throwable e) {
        if (isDebugEnabled()) {
            logger.log(Level.DEBUG, marker, supplier.get(), e);
        }
    }

    @Override
    public void debug(Object message, Throwable e, Object... params) {
        if (isDebugEnabled()) {
            logger.log(Level.DEBUG, marker, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public void debug(String message, Throwable e, Object... params) {
        if (isDebugEnabled()) {
            logger.log(Level.DEBUG, marker, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public boolean isInfoEnabled() {
        return isLoggable(LogLevel.INFO);
    }

    @Override
    public void info(Object message) {
        if (isInfoEnabled()) {
            logger.log(Level.INFO, marker, message);
        }
    }

    @Override
    public void info(String message) {
        if (isInfoEnabled()) {
            logger.log(Level.INFO, marker, message);
        }
    }

    @Override
    public void info(Supplier<String> supplier) {
        if (isInfoEnabled()) {
            logger.log(Level.INFO, marker, supplier::get);
        }
    }

    @Override
    public void info(Object message, Object... params) {
        if (isInfoEnabled()) {
            logger.info(marker, MessageHelper.format(message, params));
        }
    }

    @Override
    public void info(String message, Object... params) {
        if (isInfoEnabled()) {
            logger.info(marker, message, params);
        }
    }

    @Override
    public void info(Object message, Throwable e) {
        if (isInfoEnabled()) {
            logger.info(marker, message, e);
        }
    }

    @Override
    public void info(String message, Throwable e) {
        if (isInfoEnabled()) {
            logger.info(marker, message, e);
        }
    }

    @Override
    public void info(Supplier<String> supplier, Throwable e) {
        if (isInfoEnabled()) {
            logger.info(marker, supplier::get, e);
        }
    }

    @Override
    public void info(Object message, Throwable e, Object... params) {
        if (isInfoEnabled()) {
            logger.info(marker, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public void info(String message, Throwable e, Object... params) {
        if (isInfoEnabled()) {
            logger.info(marker, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public boolean isWarnEnabled() {
        return isLoggable(LogLevel.WARN);
    }

    @Override
    public void warn(Object message) {
        if (isWarnEnabled()) {
            logger.warn(marker, message);
        }
    }

    @Override
    public void warn(String message) {
        if (isWarnEnabled()) {
            logger.warn(marker, message);
        }
    }

    @Override
    public void warn(Supplier<String> supplier) {
        if (isWarnEnabled()) {
            logger.warn(marker, supplier::get);
        }
    }

    @Override
    public void warn(Object message, Object... params) {
        if (isWarnEnabled()) {
            logger.warn(marker, MessageHelper.toString(message), params);
        }
    }

    @Override
    public void warn(String message, Object... params) {
        if (isWarnEnabled()) {
            logger.warn(marker, message, params);
        }
    }

    @Override
    public void warn(Object message, Throwable e) {
        if (isWarnEnabled()) {
            logger.warn(marker, message, e);
        }
    }

    @Override
    public void warn(String message, Throwable e) {
        if (isWarnEnabled()) {
            logger.warn(marker, message, e);
        }
    }

    @Override
    public void warn(Supplier<String> supplier, Throwable e) {
        if (isWarnEnabled()) {
            logger.warn(marker, supplier::get, e);
        }
    }

    @Override
    public void warn(Object message, Throwable e, Object... params) {
        if (isWarnEnabled()) {
            logger.warn(marker, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public void warn(String message, Throwable e, Object... params) {
        if (isWarnEnabled()) {
            logger.warn(marker, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public boolean isErrorEnabled() {
        return isLoggable(LogLevel.ERROR);
    }

    @Override
    public void error(Object message) {
        if (isErrorEnabled()) {
            logger.error(marker, message);
        }
    }

    @Override
    public void error(String message) {
        if (isErrorEnabled()) {
            logger.error(marker, message);
        }
    }

    @Override
    public void error(Supplier<String> supplier) {
        if (isErrorEnabled()) {
            logger.error(marker, supplier::get);
        }
    }

    @Override
    public void error(Object message, Object... params) {
        if (isErrorEnabled()) {
            logger.error(marker, MessageHelper.toString(message), params);
        }
    }

    @Override
    public void error(String message, Object... params) {
        if (isErrorEnabled()) {
            logger.error(marker, message, params);
        }
    }

    @Override
    public void error(Object message, Throwable e) {
        if (isErrorEnabled()) {
            logger.error(marker, message, e);
        }
    }

    @Override
    public void error(String message, Throwable e) {
        if (isErrorEnabled()) {
            logger.error(marker, message, e);
        }
    }

    @Override
    public void error(Supplier<String> supplier, Throwable e) {
        if (isErrorEnabled()) {
            logger.error(marker, supplier::get, e);
        }
    }

    @Override
    public void error(Object message, Throwable e, Object... params) {
        if (isErrorEnabled()) {
            logger.error(marker, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public void error(String message, Throwable e, Object... params) {
        if (isErrorEnabled()) {
            logger.error(marker, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public boolean isFatalEnabled() {
        return isLoggable(LogLevel.FATAL);
    }

    @Override
    public void fatal(Object message) {
        if (isFatalEnabled()) {
            logger.fatal(marker, message);
        }
    }

    @Override
    public void fatal(String message) {
        if (isFatalEnabled()) {
            logger.fatal(marker, message);
        }
    }

    @Override
    public void fatal(Supplier<String> supplier) {
        if (isFatalEnabled()) {
            logger.fatal(marker, supplier::get);
        }
    }

    @Override
    public void fatal(Object message, Object... params) {
        if (isFatalEnabled()) {
            logger.fatal(marker, MessageHelper.toString(message), params);
        }
    }

    @Override
    public void fatal(String message, Object... params) {
        if (isFatalEnabled()) {
            logger.fatal(marker, message, params);
        }
    }

    @Override
    public void fatal(Object message, Throwable e) {
        if (isFatalEnabled()) {
            logger.fatal(marker, message, e);
        }
    }

    @Override
    public void fatal(String message, Throwable e) {
        if (isFatalEnabled()) {
            logger.fatal(marker, message, e);
        }
    }

    @Override
    public void fatal(Supplier<String> supplier, Throwable e) {
        if (isFatalEnabled()) {
            logger.fatal(marker, supplier::get, e);
        }
    }

    @Override
    public void fatal(Object message, Throwable e, Object... params) {
        if (isFatalEnabled()) {
            logger.fatal(marker, MessageHelper.format(message, params), e);
        }
    }

    @Override
    public void fatal(String message, Throwable e, Object... params) {
        if (isFatalEnabled()) {
            logger.fatal(marker, MessageHelper.format(message, params), e);
        }
    }
}
