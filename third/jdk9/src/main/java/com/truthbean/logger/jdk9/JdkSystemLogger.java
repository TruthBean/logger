/**
 * Copyright (c) 2023 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.jdk9;

import com.truthbean.Logger;
import com.truthbean.logger.LogLevel;
import com.truthbean.LoggerFactory;

import java.util.ResourceBundle;
import java.util.function.Supplier;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-11-18 14:28
 */
public class JdkSystemLogger implements System.Logger {

    private LogLevel level;
    private final String name;
    private final Logger logger;

    public JdkSystemLogger(Logger logger, String name) {
        super();
        this.logger = logger;
        this.name = name;
    }

    public LogLevel getLevel() {
        var config = LoggerFactory.getConfig();
        if (config != null) {
            var level = config.getLevel(name);
            if (level.isPresent()) {
                return level.get();
            }
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
        return name;
    }

    private LogLevel toLevel(Level level) {
        switch (level) {
            case ALL:
                return LogLevel.ALL;
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
            case OFF:
                return LogLevel.OFF;
        }
    }

    private Level ofLevel(LogLevel level) {
        switch (level) {
            case ALL:
                return Level.ALL;
            case FATAL:
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
            case OFF:
            default:
                return Level.OFF;
        }
    }

    @Override
    public boolean isLoggable(Level level) {
        if (this.level == null) {
            this.level = getLevel();
        }
        return this.level.compareTo(toLevel(level)) >= 0;
    }

    @Override
    public void log(Level level, String msg) {
        if (isLoggable(level)) {
            this.logger.log(toLevel(level), msg, null, (Object[]) null);
        }
    }

    @Override
    public void log(Level level, Supplier<String> msgSupplier) {
        if (isLoggable(level)) {
            this.logger.log(toLevel(level), msgSupplier.get(), null, (Object[]) null);
        }
    }

    @Override
    public void log(Level level, Object obj) {
        if (isLoggable(level)) {
            this.logger.log(toLevel(level), obj, null, (Object[]) null);
        }
    }

    @Override
    public void log(Level level, String msg, Throwable thrown) {
        if (isLoggable(level)) {
            this.logger.log(toLevel(level), msg, thrown, (Object[]) null);
        }
    }

    @Override
    public void log(Level level, Supplier<String> msgSupplier, Throwable thrown) {
        if (isLoggable(level)) {
            this.logger.log(toLevel(level), msgSupplier.get(), thrown, (Object[]) null);
        }
    }

    @Override
    public void log(Level level, String format, Object... params) {
        if (isLoggable(level)) {
            this.logger.log(toLevel(level), format, null, params);
        }
    }

    @Override
    public void log(Level level, ResourceBundle bundle, String msg, Throwable thrown) {
        if (isLoggable(level)) {
            this.logger.log(toLevel(level), msg, thrown, new Object[]{});
        }
    }

    @Override
    public void log(Level level, ResourceBundle bundle, String format, Object... params) {
        if (isLoggable(level)) {
            this.logger.log(toLevel(level), format, null, params);
        }
    }
}
