/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.jdk;

import com.truthbean.Logger;
import com.truthbean.logger.ConfigurableLogger;
import com.truthbean.logger.LogLevel;
import com.truthbean.logger.LoggerFactory;
import com.truthbean.logger.SystemOutLogger;
import com.truthbean.logger.util.MessageHelper;

import java.util.ResourceBundle;
import java.util.function.Supplier;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-11-18 14:28
 */
public class JdkSystemLogger extends SystemOutLogger implements System.Logger {

    private LogLevel level;

    public JdkSystemLogger() {
        super();
    }

    public JdkSystemLogger(String name) {
        super();
        super.setName(name);
        super.setDefaultLevel(getLevel());
    }

    @Override
    public LogLevel getLevel() {
        var config = LoggerFactory.getConfig();
        var level = config.getLevel(getLoggerName());
        if (level.isPresent()) {
            return level.get();
        }
        String levelName = System.getProperty("jdk.system.logger.level", "INFO");
        try {
            return LogLevel.valueOf(levelName);
        } catch (IllegalArgumentException iae) {
            return LogLevel.INFO;
        }
    }

    @Override
    public String getName() {
        return super.getLoggerName();
    }

    private LogLevel toLevel(Level level) {
        switch (level) {
            case ERROR:
                return LogLevel.ERROR;
            case WARNING:
                return LogLevel.WARN;
            case INFO:
                return LogLevel.INFO;
            case DEBUG:
                return LogLevel.DEBUG;
            case TRACE:
                return LogLevel.TRACE;
            default:
                return LogLevel.FATAL;
        }
    }

    private Level ofLevel(LogLevel level) {
        switch (level) {
            case ERROR:
                return Level.ERROR;
            case WARN:
                return Level.WARNING;
            case INFO:
                return Level.INFO;
            case DEBUG:
                return Level.DEBUG;
            case TRACE:
                return Level.TRACE;
            default:
                return Level.OFF;
        }
    }

    @Override
    public ConfigurableLogger setDefaultLevel(LogLevel level) {
        this.level = level;
        super.setDefaultLevel(level);
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
    public boolean isLoggable(Level level) {
        if (this.level == null) {
            this.level = getLevel();
            super.setDefaultLevel(this.level);
        }
        return this.level.compareTo(toLevel(level)) >= 0;
    }

    @Override
    public boolean isTraceEnabled() {
        if (this.level == null) {
            this.level = getLevel();
            super.setDefaultLevel(this.level);
        }
        return this.level.compareTo(LogLevel.TRACE) >= 0;
    }

    @Override
    public boolean isDebugEnabled() {
        if (this.level == null) {
            this.level = getLevel();
            super.setDefaultLevel(this.level);
        }
        return this.level.compareTo(LogLevel.DEBUG) >= 0;
    }

    @Override
    public boolean isInfoEnabled() {
        if (this.level == null) {
            this.level = getLevel();
            super.setDefaultLevel(this.level);
        }
        return this.level.compareTo(LogLevel.INFO) >= 0;
    }

    @Override
    public boolean isWarnEnabled() {
        if (this.level == null) {
            this.level = getLevel();
            super.setDefaultLevel(this.level);
        }
        return this.level.compareTo(LogLevel.WARN) >= 0;
    }

    @Override
    public boolean isErrorEnabled() {
        if (this.level == null) {
            this.level = getLevel();
            super.setDefaultLevel(this.level);
        }
        return this.level.compareTo(LogLevel.ERROR) >= 0;
    }

    @Override
    public boolean isFatalEnabled() {
        if (this.level == null) {
            this.level = getLevel();
            super.setDefaultLevel(this.level);
        }
        return this.level.compareTo(LogLevel.FATAL) >= 0;
    }

    @Override
    public boolean isLoggable(LogLevel level) {
        if (this.level == null) {
            this.level = getLevel();
            super.setDefaultLevel(this.level);
        }
        return this.level.compareTo(level) >= 0;
    }

    @Override
    public void log(Level level, String msg) {
        if (isLoggable(level)) {
            super.logging(toLevel(level), null, msg);
        }
    }

    @Override
    public void log(Level level, Supplier<String> msgSupplier) {
        if (isLoggable(level)) {
            super.logging(toLevel(level), null, msgSupplier.get());
        }
    }

    @Override
    public void log(Level level, Object obj) {
        if (isLoggable(level)) {
            super.logging(toLevel(level), null, MessageHelper.toString(obj));
        }
    }

    @Override
    public void log(Level level, String msg, Throwable thrown) {
        if (isLoggable(level)) {
            super.logging(toLevel(level), thrown, msg);
        }
    }

    @Override
    public void log(Level level, Supplier<String> msgSupplier, Throwable thrown) {
        if (isLoggable(level)) {
            super.logging(toLevel(level), thrown, msgSupplier.get());
        }
    }

    @Override
    public void log(Level level, String format, Object... params) {
        if (isLoggable(level)) {
            super.logging(toLevel(level), null, format, params);
        }
    }

    @Override
    public void log(Level level, ResourceBundle bundle, String msg, Throwable thrown) {
        if (isLoggable(level)) {
            super.logging(toLevel(level), thrown, msg);
        }
    }

    @Override
    public void log(Level level, ResourceBundle bundle, String format, Object... params) {
        if (isLoggable(level)) {
            super.logging(toLevel(level), null, format, params);
        }
    }
}
