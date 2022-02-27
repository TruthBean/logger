/**
 * Copyright (c) 2022 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.slf4j;

import com.truthbean.Logger;
import com.truthbean.logger.LogLevel;
import org.slf4j.Marker;
import org.slf4j.spi.LocationAwareLogger;

import java.io.Serializable;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-12-06 02:05
 */
public class TruthBeanLogger implements LocationAwareLogger, Serializable {

    private final Logger logger;
    private final String name;
    public TruthBeanLogger(Logger logger, String name) {
        this.logger = logger;
        this.name = name;
    }

    public int getLevel(LogLevel level) {
        switch (level) {
            case OFF:
                return Integer.MAX_VALUE;
            case FATAL:
                return 40;
            case ERROR:
                return 40;
            case WARN:
                return 30;
            case INFO:
                return 20;
            case DEBUG:
                return 10;
            case TRACE:
                return 0;
            case ALL:
                return Integer.MAX_VALUE;
            default:
                return 40;
        }
    }

    public LogLevel getLevel(int level) {
        switch (level) {
            case Integer.MAX_VALUE:
                return LogLevel.OFF;
            case ERROR_INT:
                return LogLevel.ERROR;
            case WARN_INT:
                return LogLevel.WARN;
            case INFO_INT:
                return LogLevel.INFO;
            case DEBUG_INT:
                return LogLevel.DEBUG;
            case TRACE_INT:
                return LogLevel.TRACE;
            case Integer.MIN_VALUE:
                return LogLevel.ALL;
            default:
                return LogLevel.FATAL;
        }
    }

    @Override
    public void log(Marker marker, String fqcn, int level, String message, Object[] argArray, Throwable t) {
        this.logger.log(getLevel(level), message, t, argArray);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isTraceEnabled() {
        return this.logger.isTraceEnabled();
    }

    @Override
    public void trace(String msg) {
        this.logger.log(LogLevel.TRACE, msg, null, (Object[]) null);
    }

    @Override
    public void trace(String format, Object arg) {
        this.logger.log(LogLevel.TRACE, format, null, arg);
    }

    @Override
    public void trace(String format, Object arg1, Object arg2) {
        this.logger.log(LogLevel.TRACE, format, null, arg1, arg2);
    }

    @Override
    public void trace(String format, Object... arguments) {
        this.logger.log(LogLevel.TRACE, format, null, arguments);
    }

    @Override
    public void trace(String msg, Throwable t) {
        this.logger.log(LogLevel.TRACE, msg, t, (Object[]) null);
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return this.logger.isTraceEnabled();
    }

    @Override
    public void trace(Marker marker, String msg) {
        this.logger.log(LogLevel.TRACE, msg, null, (Object[]) null);
    }

    @Override
    public void trace(Marker marker, String format, Object arg) {
        this.logger.log(LogLevel.TRACE, format, null, arg);
    }

    @Override
    public void trace(Marker marker, String format, Object arg1, Object arg2) {
        this.logger.log(LogLevel.TRACE, format, null, arg1, arg2);
    }

    @Override
    public void trace(Marker marker, String format, Object... argArray) {
        this.logger.log(LogLevel.TRACE, format, null, argArray);
    }

    @Override
    public void trace(Marker marker, String msg, Throwable t) {
        this.logger.log(LogLevel.TRACE, msg, t, (Object[]) null);
    }

    @Override
    public boolean isDebugEnabled() {
        return this.logger.isDebugEnabled();
    }

    @Override
    public void debug(String msg) {
        this.logger.log(LogLevel.DEBUG, msg, null, (Object[]) null);
    }

    @Override
    public void debug(String format, Object arg) {
        this.logger.log(LogLevel.DEBUG, format, null, arg);
    }

    @Override
    public void debug(String format, Object arg1, Object arg2) {
        this.logger.log(LogLevel.DEBUG, format, null, arg1, arg2);
    }

    @Override
    public void debug(String format, Object... arguments) {
        this.logger.log(LogLevel.DEBUG, format, null, arguments);
    }

    @Override
    public void debug(String msg, Throwable t) {
        this.logger.log(LogLevel.DEBUG, msg, t, (Object[]) null);
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return this.logger.isDebugEnabled();
    }

    @Override
    public void debug(Marker marker, String msg) {
        this.logger.log(LogLevel.DEBUG, msg, null, (Object[]) null);
    }

    @Override
    public void debug(Marker marker, String format, Object arg) {
        this.logger.log(LogLevel.DEBUG, format, null, arg);
    }

    @Override
    public void debug(Marker marker, String format, Object arg1, Object arg2) {
        this.logger.log(LogLevel.DEBUG, format, null, arg1, arg2);
    }

    @Override
    public void debug(Marker marker, String format, Object... argArray) {
        this.logger.log(LogLevel.DEBUG, format, null, argArray);
    }

    @Override
    public void debug(Marker marker, String msg, Throwable t) {
        this.logger.log(LogLevel.DEBUG, msg, t, (Object[]) null);
    }

    @Override
    public boolean isInfoEnabled() {
        return this.logger.isInfoEnabled();
    }

    @Override
    public void info(String msg) {
        this.logger.log(LogLevel.INFO, msg, null, (Object[]) null);
    }

    @Override
    public void info(String format, Object arg) {
        this.logger.log(LogLevel.INFO, format, null, arg);
    }

    @Override
    public void info(String format, Object arg1, Object arg2) {
        this.logger.log(LogLevel.INFO, format, null, arg1, arg2);
    }

    @Override
    public void info(String format, Object... arguments) {
        this.logger.log(LogLevel.INFO, format, null, arguments);
    }

    @Override
    public void info(String msg, Throwable t) {
        this.logger.log(LogLevel.INFO, msg, t, (Object[]) null);
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return this.logger.isInfoEnabled();
    }

    @Override
    public void info(Marker marker, String msg) {
        this.logger.log(LogLevel.INFO, msg, null, (Object[]) null);
    }

    @Override
    public void info(Marker marker, String format, Object arg) {
        this.logger.log(LogLevel.INFO, format, null, arg);
    }

    @Override
    public void info(Marker marker, String format, Object arg1, Object arg2) {
        this.logger.log(LogLevel.INFO, format, null, arg1, arg2);
    }

    @Override
    public void info(Marker marker, String format, Object... argArray) {
        this.logger.log(LogLevel.INFO, format, null, argArray);
    }

    @Override
    public void info(Marker marker, String msg, Throwable t) {
        this.logger.log(LogLevel.INFO, msg, t, (Object[]) null);
    }

    @Override
    public boolean isWarnEnabled() {
        return this.logger.isWarnEnabled();
    }

    @Override
    public void warn(String msg) {
        this.logger.log(LogLevel.WARN, msg, null, (Object[]) null);
    }

    @Override
    public void warn(String format, Object arg) {
        this.logger.log(LogLevel.WARN, format, null, arg);
    }

    @Override
    public void warn(String format, Object arg1, Object arg2) {
        this.logger.log(LogLevel.WARN, format, null, arg1, arg2);
    }

    @Override
    public void warn(String format, Object... arguments) {
        this.logger.log(LogLevel.WARN, format, null, arguments);
    }

    @Override
    public void warn(String msg, Throwable t) {
        this.logger.log(LogLevel.WARN, msg, t, (Object[]) null);
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return this.logger.isWarnEnabled();
    }

    @Override
    public void warn(Marker marker, String msg) {
        this.logger.log(LogLevel.WARN, msg, null, (Object[]) null);
    }

    @Override
    public void warn(Marker marker, String format, Object arg) {
        this.logger.log(LogLevel.WARN, format, null, arg);
    }

    @Override
    public void warn(Marker marker, String format, Object arg1, Object arg2) {
        this.logger.log(LogLevel.WARN, format, null, arg1, arg2);
    }

    @Override
    public void warn(Marker marker, String format, Object... argArray) {
        this.logger.log(LogLevel.WARN, format, null, argArray);
    }

    @Override
    public void warn(Marker marker, String msg, Throwable t) {
        this.logger.log(LogLevel.WARN, msg, t, (Object[]) null);
    }

    @Override
    public boolean isErrorEnabled() {
        return this.logger.isErrorEnabled();
    }

    @Override
    public void error(String msg) {
        this.logger.log(LogLevel.ERROR, msg, null, (Object[]) null);
    }

    @Override
    public void error(String format, Object arg) {
        this.logger.log(LogLevel.ERROR, format, null, arg);
    }

    @Override
    public void error(String format, Object arg1, Object arg2) {
        this.logger.log(LogLevel.ERROR, format, null, arg1, arg2);
    }

    @Override
    public void error(String format, Object... arguments) {
        this.logger.log(LogLevel.ERROR, format, null, arguments);
    }

    @Override
    public void error(String msg, Throwable t) {
        this.logger.log(LogLevel.ERROR, msg, t, (Object[]) null);
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return this.logger.isErrorEnabled();
    }

    @Override
    public void error(Marker marker, String msg) {
        this.logger.log(LogLevel.ERROR, msg, null, (Object[]) null);
    }

    @Override
    public void error(Marker marker, String format, Object arg) {
        this.logger.log(LogLevel.ERROR, format, null, arg);
    }

    @Override
    public void error(Marker marker, String format, Object arg1, Object arg2) {
        this.logger.log(LogLevel.ERROR, format, null, arg1, arg2);
    }

    @Override
    public void error(Marker marker, String format, Object... argArray) {
        this.logger.log(LogLevel.ERROR, format, null, argArray);
    }

    @Override
    public void error(Marker marker, String msg, Throwable t) {
        this.logger.log(LogLevel.ERROR, msg, t, (Object[]) null);
    }
}
