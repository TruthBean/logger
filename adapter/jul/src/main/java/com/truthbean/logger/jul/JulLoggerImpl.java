/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.jul;

import com.truthbean.Logger;
import com.truthbean.logger.LogLevel;
import com.truthbean.logger.util.MessageHelper;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-05-08 22:36
 */
public class JulLoggerImpl implements Logger {
    private java.util.logging.Logger logger;
    private String name;
    private LogLevel level;

    static {
        var handlers = java.util.logging.Logger.getGlobal().getParent().getHandlers();
        for (var handler : handlers) {
            if (handler instanceof ConsoleHandler) {
                handler.setLevel(Level.ALL);
                handler.setFormatter(new TruthBeanJulFormatter());
            }
        }
    }

    public JulLoggerImpl() {
    }

    @Override
    public boolean isLoggable(LogLevel level) {
        var bool = getLevel().compareTo(level) >= 0;
        var optional = toLevel(level);
        return optional.map(value -> bool && logger.isLoggable(value)).orElse(bool);
    }

    @Override
    public boolean isTraceEnabled() {
        return getLevel().compareTo(LogLevel.TRACE) >= 0 && logger.isLoggable(JulLevel.TRACE);
    }

    @Override
    public void trace(String message) {
        if (!logger.isLoggable(JulLevel.TRACE)) {
            return;
        }
        log(JulLevel.TRACE, null, message);
    }

    @Override
    public void trace(Supplier<String> supplier) {
        if (!logger.isLoggable(JulLevel.TRACE)) {
            return;
        }
        log(JulLevel.TRACE, null, supplier.get());
    }

    @Override
    public void trace(String message, Object... params) {
        if (!logger.isLoggable(JulLevel.TRACE)) {
            return;
        }
        log(JulLevel.TRACE, null, message, params);
    }

    @Override
    public void trace(String message, Throwable e) {
        if (!logger.isLoggable(JulLevel.TRACE)) {
            return;
        }
        log(JulLevel.TRACE, e, message);
    }

    @Override
    public void trace(Supplier<String> supplier, Throwable e) {
        if (!logger.isLoggable(JulLevel.TRACE)) {
            return;
        }
        log(JulLevel.TRACE, e, supplier.get());
    }

    @Override
    public void trace(String message, Throwable e, Object... params) {
        if (!logger.isLoggable(JulLevel.TRACE)) {
            return;
        }
        log(JulLevel.TRACE, e, message, params);
    }

    @Override
    public boolean isDebugEnabled() {
        return getLevel().compareTo(LogLevel.DEBUG) >= 0 && logger.isLoggable(JulLevel.DEBUG);
    }

    @Override
    public void debug(String message) {
        if (!logger.isLoggable(JulLevel.DEBUG)) {
            return;
        }
        log(JulLevel.DEBUG, null, message);
    }

    @Override
    public void debug(Supplier<String> supplier) {
        if (!logger.isLoggable(JulLevel.DEBUG)) {
            return;
        }
        log(JulLevel.DEBUG, null, supplier.get());
    }

    @Override
    public void debug(String message, Object... params) {
        if (!logger.isLoggable(JulLevel.DEBUG)) {
            return;
        }
        log(JulLevel.DEBUG, null, message, params);
    }

    @Override
    public void debug(String message, Throwable e) {
        if (!logger.isLoggable(JulLevel.DEBUG)) {
            return;
        }
        log(JulLevel.DEBUG, e, message);
    }

    @Override
    public void debug(Supplier<String> supplier, Throwable e) {
        if (!logger.isLoggable(JulLevel.DEBUG)) {
            return;
        }
        log(JulLevel.DEBUG, e, supplier.get());
    }

    @Override
    public void debug(String message, Throwable e, Object... params) {
        if (!logger.isLoggable(JulLevel.DEBUG)) {
            return;
        }
        log(JulLevel.DEBUG, e, message, params);
    }

    @Override
    public boolean isInfoEnabled() {
        return getLevel().compareTo(LogLevel.INFO) >= 0 && logger.isLoggable(JulLevel.INFO);
    }

    @Override
    public void info(String message) {
        if (!logger.isLoggable(JulLevel.INFO)) {
            return;
        }
        log(JulLevel.INFO, null, message);
    }

    @Override
    public void info(Supplier<String> supplier) {
        if (!logger.isLoggable(JulLevel.INFO)) {
            return;
        }
        log(JulLevel.INFO, null, supplier.get());
    }

    @Override
    public void info(String message, Object... params) {
        if (!logger.isLoggable(JulLevel.INFO)) {
            return;
        }
        log(JulLevel.INFO, null, message, params);
    }

    @Override
    public void info(String message, Throwable e) {
        if (!logger.isLoggable(JulLevel.INFO)) {
            return;
        }
        log(JulLevel.INFO, e, message);
    }

    @Override
    public void info(Supplier<String> supplier, Throwable e) {
        if (!logger.isLoggable(JulLevel.INFO)) {
            return;
        }
        log(JulLevel.INFO, e, supplier.get());
    }

    @Override
    public void info(String message, Throwable e, Object... params) {
        var level = JulLevel.INFO;
        if (!logger.isLoggable(level)) {
            return;
        }
        log(level, e, message, params);
    }

    @Override
    public boolean isWarnEnabled() {
        return getLevel().compareTo(LogLevel.WARN) >= 0 && logger.isLoggable(JulLevel.WARNING);
    }

    @Override
    public void warn(String message) {
        if (!logger.isLoggable(JulLevel.WARNING)) {
            return;
        }
        log(JulLevel.WARNING, null, message);
    }

    @Override
    public void warn(Supplier<String> supplier) {
        if (!logger.isLoggable(JulLevel.WARNING)) {
            return;
        }
        log(JulLevel.WARNING, null, supplier.get());
    }

    @Override
    public void warn(String message, Object... params) {
        if (!logger.isLoggable(JulLevel.WARNING)) {
            return;
        }
        log(JulLevel.WARNING, null, message, params);
    }

    @Override
    public void warn(String message, Throwable e) {
        if (!logger.isLoggable(JulLevel.WARNING)) {
            return;
        }
        log(JulLevel.WARNING, e, message);
    }

    @Override
    public void warn(Supplier<String> supplier, Throwable e) {
        if (!logger.isLoggable(JulLevel.WARNING)) {
            return;
        }
        log(JulLevel.WARNING, e, supplier.get());
    }

    @Override
    public void warn(String message, Throwable e, Object... params) {
        if (!logger.isLoggable(JulLevel.WARNING)) {
            return;
        }
        log(JulLevel.WARNING, e, message, params);
    }

    @Override
    public boolean isErrorEnabled() {
        return getLevel().compareTo(LogLevel.ERROR) >= 0 && logger.isLoggable(JulLevel.SEVERE);
    }

    @Override
    public void error(String message) {
        if (!logger.isLoggable(JulLevel.SEVERE)) {
            return;
        }
        log(JulLevel.SEVERE, null, message);
    }

    @Override
    public void error(Supplier<String> supplier) {
        if (!logger.isLoggable(JulLevel.SEVERE)) {
            return;
        }
        log(JulLevel.SEVERE, null, supplier.get());
    }

    @Override
    public void error(String message, Object... params) {
        if (!logger.isLoggable(JulLevel.SEVERE)) {
            return;
        }
        log(JulLevel.SEVERE, null, message, params);
    }

    @Override
    public void error(String message, Throwable e) {
        if (!logger.isLoggable(JulLevel.SEVERE)) {
            return;
        }
        log(JulLevel.SEVERE, e, message);
    }

    @Override
    public void error(Supplier<String> supplier, Throwable e) {
        if (!logger.isLoggable(JulLevel.SEVERE)) {
            return;
        }
        log(JulLevel.SEVERE, e, supplier.get());
    }

    @Override
    public void error(String message, Throwable e, Object... params) {
        if (!logger.isLoggable(JulLevel.SEVERE)) {
            return;
        }
        log(JulLevel.SEVERE, e, message, params);
    }

    @Override
    public boolean isFatalEnabled() {
        return getLevel().compareTo(LogLevel.FATAL) >= 0 && logger.isLoggable(JulLevel.FATAL);
    }

    @Override
    public void fatal(String message) {
        if (!logger.isLoggable(JulLevel.FATAL)) {
            return;
        }
        log(JulLevel.FATAL, null, message);
    }

    @Override
    public void fatal(Supplier<String> supplier) {
        if (!logger.isLoggable(JulLevel.FATAL)) {
            return;
        }
        log(JulLevel.FATAL, null, supplier.get());
    }

    @Override
    public void fatal(String message, Object... params) {
        if (!logger.isLoggable(JulLevel.FATAL)) {
            return;
        }
        log(JulLevel.FATAL, null, message, params);
    }

    @Override
    public void fatal(String message, Throwable e) {
        if (!logger.isLoggable(JulLevel.FATAL)) {
            return;
        }
        log(JulLevel.FATAL, e, message);
    }

    @Override
    public void fatal(Supplier<String> supplier, Throwable e) {
        if (!logger.isLoggable(JulLevel.FATAL)) {
            return;
        }
        log(JulLevel.FATAL, e, supplier.get());
    }

    @Override
    public void fatal(String message, Throwable e, Object... params) {
        if (!logger.isLoggable(JulLevel.FATAL)) {
            return;
        }
        log(JulLevel.FATAL, e, message, params);
    }

    private void log(Level level, Throwable ex, String message, Object... params) {
        // Hack (?) to get the stack trace.
        var dummyException = new Throwable();
        var locations = dummyException.getStackTrace();
        // Caller will be the third element
        var cname = name;
        var method = "unknown";
        if (locations != null && locations.length > 2) {
            var caller = locations[2];
            cname = caller.getClassName();
            method = caller.getMethodName();
        }

        var logRecord = new LogRecord(level, MessageHelper.format(message, params));
        logRecord.setSourceClassName(cname);
        logRecord.setSourceMethodName(method);
        if (ex != null) {
            logRecord.setThrown(ex);
        }
        this.logger.log(logRecord);
    }

    @Override
    public Logger setClass(Class<?> tracedClass) {
        return setName(tracedClass.getName());
    }

    @Override
    public Logger setName(String name) {
        this.name = name;
        this.logger = java.util.logging.Logger.getLogger(name);
        return this;
    }

    @Override
    public Logger setLevel(LogLevel level) {
        this.level = level;
        var julLevel = toLevel(level);
        julLevel.ifPresent(l -> this.logger.setLevel(l));
        return this;
    }

    public Optional<Level> toLevel(LogLevel level) {
        switch (level) {
            case FATAL:
                return Optional.of(JulLevel.FATAL);
            case ERROR:
                return Optional.of(JulLevel.SEVERE);
            case WARN:
                return Optional.of(JulLevel.WARNING);
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
    public LogLevel getLevel() {
        if (level == null) {
            return LogLevel.ERROR;
        }
        return level;
    }
}
