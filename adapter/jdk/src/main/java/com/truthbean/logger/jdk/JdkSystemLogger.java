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
    private String name;

    public JdkSystemLogger() {
        super();
    }

    public JdkSystemLogger(String name) {
        super();
        this.name = name;
        super.setName(name);
        super.setLevel(getDefaultLevel());
    }

    private LogLevel getDefaultLevel() {
        var config = LoggerFactory.getConfig();
        var level = config.getLevel(name);
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
    public String getName() {
        return name;
    }

    @Override
    public boolean isLoggable(Level level) {
        return super.isLoggable(toLevel(level));
    }

    @Override
    public void log(Level level, String msg) {
        if (isLoggable(level)) {
            super.log(toLevel(level), null, msg);
        }
    }

    @Override
    public void log(Level level, Supplier<String> msgSupplier) {
        if (isLoggable(level)) {
            super.log(toLevel(level), null, msgSupplier.get());
        }
    }

    @Override
    public void log(Level level, Object obj) {
        if (isLoggable(level)) {
            super.log(toLevel(level), null, MessageHelper.toString(obj));
        }
    }

    @Override
    public void log(Level level, String msg, Throwable thrown) {
        if (isLoggable(level)) {
            super.log(toLevel(level), thrown, msg);
        }
    }

    @Override
    public void log(Level level, Supplier<String> msgSupplier, Throwable thrown) {
        if (isLoggable(level)) {
            super.log(toLevel(level), thrown, msgSupplier.get());
        }
    }

    @Override
    public void log(Level level, String format, Object... params) {
        if (isLoggable(level)) {
            super.log(toLevel(level), null, format, params);
        }
    }

    @Override
    public void log(Level level, ResourceBundle bundle, String msg, Throwable thrown) {
        if (isLoggable(level)) {
            super.log(toLevel(level), thrown, msg);
        }
    }

    @Override
    public void log(Level level, ResourceBundle bundle, String format, Object... params) {
        if (isLoggable(level)) {
            super.log(toLevel(level), null, format, params);
        }
    }
}
