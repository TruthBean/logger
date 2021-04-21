/**
 * Copyright (c) 2021 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.log4j2;

import com.truthbean.Logger;
import com.truthbean.logger.LogLevel;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.spi.AbstractLogger;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-12-06 23:32
 */
public class TruthBeanLogger extends AbstractLogger {

    private final Logger logger;
    public TruthBeanLogger(Logger logger) {
        this.logger = logger;
    }

    public LogLevel fromLevel(Level level) {
        if (level == null) {
            return LogLevel.OFF;
        }
        switch (level.getStandardLevel()) {
            case OFF:
                return LogLevel.OFF;
            case FATAL:
                return LogLevel.FATAL;
            case ERROR:
                return LogLevel.ERROR;
            case WARN:
                return LogLevel.WARN;
            case INFO:
                return LogLevel.INFO;
            case DEBUG:
                return LogLevel.DEBUG;
            case TRACE:
                return LogLevel.TRACE;
            default:
                return LogLevel.OFF;
        }
    }

    @Override
    public boolean isEnabled(Level level, Marker marker, Message message, Throwable t) {
        return this.logger.isLoggable(fromLevel(level));
    }

    @Override
    public boolean isEnabled(Level level, Marker marker, CharSequence message, Throwable t) {
        return this.logger.isLoggable(fromLevel(level));
    }

    @Override
    public boolean isEnabled(Level level, Marker marker, Object message, Throwable t) {
        return this.logger.isLoggable(fromLevel(level));
    }

    @Override
    public boolean isEnabled(Level level, Marker marker, String message, Throwable t) {
        return this.logger.isLoggable(fromLevel(level));
    }

    @Override
    public boolean isEnabled(Level level, Marker marker, String message) {
        return this.logger.isLoggable(fromLevel(level));
    }

    @Override
    public boolean isEnabled(Level level, Marker marker, String message, Object... params) {
        return this.logger.isLoggable(fromLevel(level));
    }

    @Override
    public boolean isEnabled(Level level, Marker marker, String message, Object p0) {
        return this.logger.isLoggable(fromLevel(level));
    }

    @Override
    public boolean isEnabled(Level level, Marker marker, String message, Object p0, Object p1) {
        return this.logger.isLoggable(fromLevel(level));
    }

    @Override
    public boolean isEnabled(Level level, Marker marker, String message, Object p0, Object p1, Object p2) {
        return this.logger.isLoggable(fromLevel(level));
    }

    @Override
    public boolean isEnabled(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3) {
        return this.logger.isLoggable(fromLevel(level));
    }

    @Override
    public boolean isEnabled(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        return this.logger.isLoggable(fromLevel(level));
    }

    @Override
    public boolean isEnabled(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        return this.logger.isLoggable(fromLevel(level));
    }

    @Override
    public boolean isEnabled(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        return this.logger.isLoggable(fromLevel(level));
    }

    @Override
    public boolean isEnabled(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        return this.logger.isLoggable(fromLevel(level));
    }

    @Override
    public boolean isEnabled(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        return this.logger.isLoggable(fromLevel(level));
    }

    @Override
    public boolean isEnabled(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        return this.logger.isLoggable(fromLevel(level));
    }

    @Override
    public void logMessage(String fqcn, Level level, Marker marker, Message message, Throwable t) {
        this.logger.log(fromLevel(level), message.getFormattedMessage(), t, (Object[]) null);
    }

    @Override
    public Level getLevel() {
        if (this.logger.isTraceEnabled()) {
            return Level.TRACE;
        }
        if (this.logger.isDebugEnabled()) {
            return Level.DEBUG;
        }
        if (this.logger.isInfoEnabled()) {
            return Level.INFO;
        }
        if (this.logger.isWarnEnabled()) {
            return Level.WARN;
        }
        if (this.logger.isErrorEnabled()) {
            return Level.ERROR;
        }
        if (this.logger.isFatalEnabled()) {
            return Level.FATAL;
        }
        return Level.OFF;
    }
}
