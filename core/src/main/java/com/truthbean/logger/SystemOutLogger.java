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

import java.util.Objects;
import java.util.function.Supplier;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-11-18 14:18
 */
public class SystemOutLogger implements ConfigurableLogger {

    private String loggerName;
    private LogLevel level;
    private boolean useName;

    public SystemOutLogger() {
    }

    public static Logger getLogger(Class<?> tracedClass) {
        /**
         * don't use <code>SystemOutLogger.logger()</code> method to void use callback self
         */
        return new SystemOutLogger().setClass(tracedClass).setDefaultLevel(LogLevel.WARN);
    }

    public static Logger getLogger(LoggerConfig loggerConfig, Class<?> tracedClass) {
        SystemOutLogger logger = new SystemOutLogger();
        logger.setClass(tracedClass);
        logger.setDefaultLevel(LogLevel.WARN);
        logger.level = logger.getLevel(loggerConfig);
        return logger;
    }

    public static void err(String message, Throwable e) {
        new SystemOutLogger().logging(LogLevel.ERROR, e, message);
    }

    @Override
    public ConfigurableLogger setClass(Class<?> tracedClass) {
        this.loggerName = tracedClass.getName();
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
        return this.loggerName;
    }

    @Override
    public ConfigurableLogger setName(CharSequence name) {
        this.loggerName = name.toString();
        return this;
    }

    @Override
    public ConfigurableLogger setDefaultLevel(LogLevel level) {
        this.level = level;
        return this;
    }

    @Override
    public LogLevel getDefaultLevel() {
        return this.level;
    }

    @Override
    public LogLevel getLevel() {
        var config = LoggerFactory.getConfig();
        if (config == null) {
            return LogLevel.ERROR;
        }
        var level = config.getLevel(getLoggerName());
        return level.orElseGet(() -> Objects.requireNonNullElse(getDefaultLevel(), LogLevel.ERROR));
    }

    public LogLevel getLevel(LoggerConfig config) {
        var level = config.getLevel(getLoggerName());
        return level.orElseGet(() -> Objects.requireNonNullElse(getDefaultLevel(), LogLevel.ERROR));
    }

    @Override
    public Logger logger() {
        this.level = getLevel();
        return this;
    }

    @Override
    public boolean isLoggable(LogLevel level) {
        return this.level.compareTo(level) >= 0;
    }

    @Override
    public void log(LogLevel level, Object message) {
        if (isLoggable(level)) {
            this.logging(level, null, MessageHelper.toString(message));
        }
    }

    @Override
    public void log(LogLevel level, String message) {
        if (isLoggable(level)) {
            this.logging(level, null, message);
        }
    }

    @Override
    public void log(LogLevel level, Supplier<String> supplier) {
        if (isLoggable(level)) {
            this.logging(level, null, supplier.get());
        }
    }

    @Override
    public void log(LogLevel level, Object message, Object... params) {
        if (isLoggable(level)) {
            this.logging(level, null, MessageHelper.toString(message), params);
        }
    }

    @Override
    public void log(LogLevel level, String message, Object... params) {
        if (isLoggable(level)) {
            this.logging(level, null, message, params);
        }
    }

    @Override
    public void log(LogLevel level, Object message, Throwable e) {
        if (isLoggable(level)) {
            this.logging(level, e, MessageHelper.toString(message));
        }
    }

    @Override
    public void log(LogLevel level, String message, Throwable e) {
        if (isLoggable(level)) {
            this.logging(level, e, message);
        }
    }

    @Override
    public void log(LogLevel level, Supplier<String> supplier, Throwable e) {
        if (isLoggable(level)) {
            this.logging(level, e, supplier.get());
        }
    }

    @Override
    public void log(LogLevel level, Object message, Throwable e, Object... params) {
        if (isLoggable(level)) {
            this.logging(level, e, MessageHelper.toString(message), params);
        }
    }

    @Override
    public void log(LogLevel level, String message, Throwable e, Object... params) {
        if (isLoggable(level)) {
            this.logging(level, e, message, params);
        }
    }

    @Override
    public boolean isTraceEnabled() {
        return isLoggable(LogLevel.TRACE);
    }

    @Override
    public void trace(Object message) {
        if (isTraceEnabled()) {
            this.logging(LogLevel.TRACE, null, MessageHelper.toString(message));
        }
    }

    @Override
    public void trace(String message) {
        if (isTraceEnabled()) {
            this.logging(LogLevel.TRACE, null, message);
        }
    }

    @Override
    public void trace(Supplier<String> supplier) {
        if (isTraceEnabled()) {
            this.logging(LogLevel.TRACE, null, supplier.get());
        }
    }

    @Override
    public void trace(Object message, Object... params) {
        if (isTraceEnabled()) {
            this.logging(LogLevel.TRACE, null, MessageHelper.toString(message));
        }
    }

    @Override
    public void trace(String message, Object... params) {
        if (isTraceEnabled()) {
            this.logging(LogLevel.TRACE, null, message, params);
        }
    }

    @Override
    public void trace(Object message, Throwable e) {
        if (isTraceEnabled()) {
            this.logging(LogLevel.TRACE, e, MessageHelper.toString(message));
        }
    }

    @Override
    public void trace(String message, Throwable e) {
        if (isTraceEnabled()) {
            this.logging(LogLevel.TRACE, e, message);
        }
    }

    @Override
    public void trace(Supplier<String> supplier, Throwable e) {
        if (isTraceEnabled()) {
            this.logging(LogLevel.TRACE, e, supplier.get());
        }
    }

    @Override
    public void trace(Object message, Throwable e, Object... params) {
        if (isTraceEnabled()) {
            this.logging(LogLevel.TRACE, e, MessageHelper.toString(message), params);
        }
    }

    @Override
    public void trace(String message, Throwable e, Object... params) {
        if (isTraceEnabled()) {
            this.logging(LogLevel.TRACE, e, message, params);
        }
    }

    @Override
    public boolean isDebugEnabled() {
        return isLoggable(LogLevel.DEBUG);
    }

    @Override
    public void debug(Object message) {
        if (isDebugEnabled()) {
            this.logging(LogLevel.DEBUG, null, MessageHelper.toString(message));
        }
    }

    @Override
    public void debug(String message) {
        if (isDebugEnabled()) {
            this.logging(LogLevel.DEBUG, null, message);
        }
    }

    @Override
    public void debug(Supplier<String> supplier) {
        if (isDebugEnabled()) {
            this.logging(LogLevel.DEBUG, null, supplier.get());
        }
    }

    @Override
    public void debug(Object message, Object... params) {
        if (isDebugEnabled()) {
            this.logging(LogLevel.DEBUG, null, MessageHelper.toString(message), params);
        }
    }

    @Override
    public void debug(String message, Object... params) {
        if (isDebugEnabled()) {
            this.logging(LogLevel.DEBUG, null, message, params);
        }
    }

    @Override
    public void debug(Object message, Throwable e) {
        if (isDebugEnabled()) {
            this.logging(LogLevel.DEBUG, e, MessageHelper.toString(message));
        }
    }

    @Override
    public void debug(String message, Throwable e) {
        if (isDebugEnabled()) {
            this.logging(LogLevel.DEBUG, e, message);
        }
    }

    @Override
    public void debug(Supplier<String> supplier, Throwable e) {
        if (isDebugEnabled()) {
            this.logging(LogLevel.DEBUG, e, supplier.get());
        }
    }

    @Override
    public void debug(Object message, Throwable e, Object... params) {
        if (isDebugEnabled()) {
            this.logging(LogLevel.DEBUG, e, MessageHelper.toString(message), params);
        }
    }

    @Override
    public void debug(String message, Throwable e, Object... params) {
        if (isDebugEnabled()) {
            this.logging(LogLevel.DEBUG, e, message, params);
        }
    }

    @Override
    public boolean isInfoEnabled() {
        return isLoggable(LogLevel.INFO);
    }

    @Override
    public void info(Object message) {
        if (isInfoEnabled()) {
            this.logging(LogLevel.INFO, null, MessageHelper.toString(message));
        }
    }

    @Override
    public void info(String message) {
        if (isInfoEnabled()) {
            this.logging(LogLevel.INFO, null, message);
        }
    }

    @Override
    public void info(Supplier<String> supplier) {
        if (isInfoEnabled()) {
            this.logging(LogLevel.INFO, null, supplier.get());
        }
    }

    @Override
    public void info(Object message, Object... params) {
        if (isInfoEnabled()) {
            this.logging(LogLevel.INFO, null, MessageHelper.toString(message), params);
        }
    }

    @Override
    public void info(String message, Object... params) {
        if (isInfoEnabled()) {
            this.logging(LogLevel.INFO, null, message, params);
        }
    }

    @Override
    public void info(Object message, Throwable e) {
        if (isInfoEnabled()) {
            this.logging(LogLevel.INFO, e, MessageHelper.toString(message));
        }
    }

    @Override
    public void info(String message, Throwable e) {
        if (isInfoEnabled()) {
            this.logging(LogLevel.INFO, e, message);
        }
    }

    @Override
    public void info(Supplier<String> supplier, Throwable e) {
        if (isInfoEnabled()) {
            this.logging(LogLevel.INFO, e, supplier.get());
        }
    }

    @Override
    public void info(Object message, Throwable e, Object... params) {
        if (isInfoEnabled()) {
            this.logging(LogLevel.INFO, e, MessageHelper.toString(message), params);
        }
    }

    @Override
    public void info(String message, Throwable e, Object... params) {
        if (isInfoEnabled()) {
            this.logging(LogLevel.INFO, e, message, params);
        }
    }


    @Override
    public boolean isWarnEnabled() {
        return isLoggable(LogLevel.WARN);
    }

    @Override
    public void warn(Object message) {
        if (isWarnEnabled()) {
            this.logging(LogLevel.WARN, null, MessageHelper.toString(message));
        }
    }

    @Override
    public void warn(String message) {
        if (isWarnEnabled()) {
            this.logging(LogLevel.WARN, null, message);
        }
    }

    @Override
    public void warn(Supplier<String> supplier) {
        if (isWarnEnabled()) {
            this.logging(LogLevel.WARN, null, supplier.get());
        }
    }

    @Override
    public void warn(Object message, Object... params) {
        if (isWarnEnabled()) {
            this.logging(LogLevel.WARN, null, MessageHelper.toString(message), params);
        }
    }

    @Override
    public void warn(String message, Object... params) {
        if (isWarnEnabled()) {
            this.logging(LogLevel.WARN, null, message, params);
        }
    }

    @Override
    public void warn(Object message, Throwable e) {
        if (isWarnEnabled()) {
            this.logging(LogLevel.WARN, e, MessageHelper.toString(message));
        }
    }

    @Override
    public void warn(String message, Throwable e) {
        if (isWarnEnabled()) {
            this.logging(LogLevel.WARN, e, message);
        }
    }

    @Override
    public void warn(Supplier<String> supplier, Throwable e) {
        if (isWarnEnabled()) {
            this.logging(LogLevel.WARN, e, supplier.get());
        }
    }

    @Override
    public void warn(Object message, Throwable e, Object... params) {
        if (isWarnEnabled()) {
            this.logging(LogLevel.WARN, e, MessageHelper.toString(message), params);
        }
    }

    @Override
    public void warn(String message, Throwable e, Object... params) {
        if (isWarnEnabled()) {
            this.logging(LogLevel.WARN, e, message, params);
        }
    }

    @Override
    public boolean isErrorEnabled() {
        return isLoggable(LogLevel.ERROR);
    }

    @Override
    public void error(Object message) {
        if (isErrorEnabled()) {
            this.logging(LogLevel.ERROR, null, MessageHelper.toString(message));
        }
    }

    @Override
    public void error(String message) {
        if (isErrorEnabled()) {
            this.logging(LogLevel.ERROR, null, message);
        }
    }

    @Override
    public void error(Supplier<String> supplier) {
        if (isErrorEnabled()) {
            this.logging(LogLevel.ERROR, null, supplier.get());
        }
    }

    @Override
    public void error(Object message, Object... params) {
        if (isErrorEnabled()) {
            this.logging(LogLevel.ERROR, null, MessageHelper.toString(message), params);
        }
    }

    @Override
    public void error(String message, Object... params) {
        this.logging(LogLevel.ERROR, null, message, params);
    }

    @Override
    public void error(Object message, Throwable e) {
        if (isErrorEnabled()) {
            this.logging(LogLevel.ERROR, e, MessageHelper.toString(message));
        }
    }

    @Override
    public void error(String message, Throwable e) {
        if (isErrorEnabled()) {
            this.logging(LogLevel.ERROR, e, message);
        }
    }

    @Override
    public void error(Supplier<String> supplier, Throwable e) {
        if (isErrorEnabled()) {
            this.logging(LogLevel.ERROR, e, supplier.get());
        }
    }

    @Override
    public void error(Object message, Throwable e, Object... params) {
        if (isErrorEnabled()) {
            this.logging(LogLevel.ERROR, e, MessageHelper.toString(message), params);
        }
    }

    @Override
    public void error(String message, Throwable e, Object... params) {
        if (isErrorEnabled()) {
            this.logging(LogLevel.ERROR, e, message, params);
        }
    }

    @Override
    public boolean isFatalEnabled() {
        return isLoggable(LogLevel.FATAL);
    }

    @Override
    public void fatal(Object message) {
        if (isErrorEnabled()) {
            this.logging(LogLevel.FATAL, null, MessageHelper.toString(message));
        }
    }

    @Override
    public void fatal(String message) {
        if (isFatalEnabled()) {
            this.logging(LogLevel.FATAL, null, message);
        }
    }

    @Override
    public void fatal(Supplier<String> supplier) {
        if (isFatalEnabled()) {
            this.logging(LogLevel.FATAL, null, supplier.get());
        }
    }

    @Override
    public void fatal(Object message, Object... params) {
        if (isErrorEnabled()) {
            this.logging(LogLevel.FATAL, null, MessageHelper.toString(message), params);
        }
    }

    @Override
    public void fatal(String message, Object... params) {
        if (isFatalEnabled()) {
            this.logging(LogLevel.FATAL, null, message, params);
        }
    }

    @Override
    public void fatal(Object message, Throwable e) {
        if (isErrorEnabled()) {
            this.logging(LogLevel.FATAL, e, MessageHelper.toString(message));
        }
    }

    @Override
    public void fatal(String message, Throwable e) {
        if (isFatalEnabled()) {
            this.logging(LogLevel.FATAL, e, message);
        }
    }

    @Override
    public void fatal(Supplier<String> supplier, Throwable e) {
        if (isFatalEnabled()) {
            this.logging(LogLevel.FATAL, e, supplier.get());
        }
    }

    @Override
    public void fatal(Object message, Throwable e, Object... params) {
        if (isErrorEnabled()) {
            this.logging(LogLevel.FATAL, e, MessageHelper.toString(message), params);
        }
    }

    @Override
    public void fatal(String message, Throwable e, Object... params) {
        if (isFatalEnabled()) {
            this.logging(LogLevel.FATAL, e, message, params);
        }
    }

    public void logging(LogLevel level, Throwable ex, String message, Object... params) {
        LoggerLocation location;
        if (!useName) {
            location = ConfigurableLogger.getLoggerMethod(getLoggerName());
        } else {
            location = new LoggerLocation();
            location.setLoggerName(getLoggerName());
        }

        var threadName = Thread.currentThread().getName();

        var logger = MessageHelper.buildMessage(level.name(), threadName, location.toString());
        var newMessage = MessageHelper.format(message, params) + "\033[0m";
        logger.append(newMessage);

        System.out.println(logger.toString());
        if (ex != null) {
            ex.printStackTrace();
        }
    }
}
