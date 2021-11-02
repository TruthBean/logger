/**
 * Copyright (c) 2021 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.jul;

import com.truthbean.Logger;
import com.truthbean.LoggerFactory;
import com.truthbean.logger.*;
import com.truthbean.logger.jdk.common.JulLevel;
import com.truthbean.logger.jdk.common.TruthBeanJulFormatter;
import com.truthbean.logger.util.MessageHelper;

import java.util.Objects;
import java.util.Optional;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-05-08 22:36
 */
public class JulLoggerImpl implements BaseLogger {
    private java.util.logging.Logger logger;
    private String name;
    private LogLevel level;
    private boolean useName;

    static {
        var handlers = java.util.logging.Logger.getGlobal().getParent().getHandlers();
        var colorStr = System.getProperty(LoggerConfig.COLOR_LOGGER, "true");
        boolean color = Boolean.parseBoolean(colorStr);
        for (var handler : handlers) {
            if (handler instanceof ConsoleHandler) {
                handler.setLevel(Level.ALL);
                handler.setFormatter(new TruthBeanJulFormatter(color));
            }
        }
    }

    public JulLoggerImpl() {
    }

    @Override
    public ConfigurableLogger setClass(Class<?> tracedClass) {
        return setName(tracedClass.getName());
    }

    @Override
    public ConfigurableLogger setName(CharSequence name) {
        return setName(name.toString());
    }

    @Override
    public ConfigurableLogger setName(String name) {
        this.name = name;
        this.logger = java.util.logging.Logger.getLogger(name);
        return this;
    }

    @Override
    public ConfigurableLogger setUseName(boolean useName) {
        this.useName = useName;
        return this;
    }

    @Override
    public String getLoggerName() {
        return this.name;
    }

    @Override
    public ConfigurableLogger setDefaultLevel(LogLevel level) {
        if (ConfigurableLogger.isNoLogger()) {
            this.level = LogLevel.OFF;
        } else {
            this.level = level;
        }
        return this;
    }

    public Optional<Level> toLevel(LogLevel level) {
        switch (level) {
            case FATAL:
                return Optional.of(JulLevel.FATAL);
            case ERROR:
                return Optional.of(JulLevel.ERROR);
            case WARN:
                return Optional.of(JulLevel.WARN);
            case INFO:
                return Optional.of(JulLevel.INFO);
            case DEBUG:
                return Optional.of(JulLevel.DEBUG);
            case TRACE:
                return Optional.of(JulLevel.TRACE);
            default:
                return Optional.empty();
        }
    }

    @Override
    public LogLevel getDefaultLevel() {
        return this.level;
    }

    @Override
    public LogLevel getLevel() {
        var config = LoggerFactory.getConfig();
        var level = config.getLevel(getLoggerName());
        return level.orElseGet(() -> Objects.requireNonNullElse(getDefaultLevel(), LogLevel.ERROR));
    }

    @Override
    public Logger logger() {
        this.level = getLevel();
        var julLevel = toLevel(this.level);
        julLevel.ifPresent(l -> this.logger.setLevel(l));
        return this;
    }

    @Override
    public boolean isLoggable(LogLevel level) {
        var bool = this.level.compareTo(level) >= 0;
        var optional = toLevel(level);
        return optional.map(value -> bool && logger.isLoggable(value)).orElse(bool);
    }

    @Override
    public void log(LogLevel level, String message, Throwable e, Object... params) {
        if (isLoggable(level)) {
            var julLevel = toLevel(level);
            julLevel.ifPresent(l -> this.logging(l, e, message, params));
        }
    }

    private void logging(Level level, Throwable ex, String message, Object... params) {
        LoggerLocation location;
        if (!useName) {
            location = ConfigurableLogger.getLoggerMethod(getLoggerName());
        } else {
            location = new LoggerLocation();
            location.setLoggerName(getLoggerName());
        }

        var logRecord = new LogRecord(level, MessageHelper.format(message, params));
        logRecord.setSourceClassName(location.getClassName());
        logRecord.setSourceMethodName(location.getMethodName());
        logRecord.setLoggerName(location.getLoggerName());
        if (ex != null) {
            logRecord.setThrown(ex);
        }
        this.logger.log(logRecord);
    }
}
