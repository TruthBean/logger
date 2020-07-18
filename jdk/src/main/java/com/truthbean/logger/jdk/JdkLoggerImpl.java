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
import com.truthbean.logger.util.MessageHelper;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import static com.truthbean.logger.util.DateTimeHelper.nowStr;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-05-08 22:36
 */
public class JdkLoggerImpl implements Logger {
    private java.util.logging.Logger logger;
    private String name;

    public JdkLoggerImpl() {
        java.util.logging.Logger.getGlobal().getParent().getHandlers()[0].setLevel(Level.ALL);
    }

    @Override
    public boolean isTraceEnabled() {
        return logger.isLoggable(JdkLevel.TRACE);
    }

    @Override
    public void trace(String message) {
        if (!logger.isLoggable(JdkLevel.TRACE)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " TRACE [" + threadName + "] " + name + " : ";
        LogRecord logRecord = new LogRecord(JdkLevel.TRACE, prefix + message);
        logger.log(logRecord);
    }

    @Override
    public void trace(Supplier<String> supplier) {
        if (!logger.isLoggable(JdkLevel.TRACE)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " TRACE [" + threadName + "] " + name + " : ";
        LogRecord logRecord = new LogRecord(JdkLevel.TRACE, prefix + supplier.get());
        logger.log(logRecord);
    }

    @Override
    public void trace(String message, Object... params) {
        if (!logger.isLoggable(JdkLevel.TRACE)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " TRACE [" + threadName + "] " + name + " : ";
        var newMessage = MessageHelper.format(message, params);
        LogRecord logRecord = new LogRecord(JdkLevel.TRACE, prefix + newMessage);
        logger.log(logRecord);
    }

    @Override
    public void trace(String message, Throwable e) {
        if (!logger.isLoggable(JdkLevel.TRACE)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " TRACE [" + threadName + "] " + name + " : ";
        LogRecord logRecord = new LogRecord(JdkLevel.TRACE, prefix + message);
        logRecord.setThrown(e);
        logger.log(logRecord);
    }

    @Override
    public void trace(Supplier<String> supplier, Throwable e) {
        if (!logger.isLoggable(JdkLevel.TRACE)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " TRACE [" + threadName + "] " + name + " : ";
        LogRecord logRecord = new LogRecord(JdkLevel.TRACE, prefix + supplier.get());
        logRecord.setThrown(e);
        logger.log(logRecord);
    }

    @Override
    public void trace(String message, Throwable e, Object... params) {
        if (!logger.isLoggable(JdkLevel.TRACE)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " TRACE [" + threadName + "] " + name + " : ";
        var newMessage = MessageHelper.format(message, params);
        LogRecord logRecord = new LogRecord(JdkLevel.TRACE, prefix + newMessage);
        logRecord.setThrown(e);
        logger.log(logRecord);
    }

    @Override
    public boolean isDebugEnabled() {
        return logger.isLoggable(JdkLevel.DEBUG);
    }

    @Override
    public void debug(String message) {
        if (!logger.isLoggable(JdkLevel.DEBUG)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " DEBUG [" + threadName + "] " + name + " : ";
        LogRecord logRecord = new LogRecord(JdkLevel.DEBUG, prefix + message);
        logger.log(logRecord);
    }

    @Override
    public void debug(Supplier<String> supplier) {
        if (!logger.isLoggable(JdkLevel.DEBUG)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " DEBUG [" + threadName + "] " + name + " : ";
        LogRecord logRecord = new LogRecord(JdkLevel.DEBUG, prefix + supplier.get());
        logger.log(logRecord);
    }

    @Override
    public void debug(String message, Object... params) {
        if (!logger.isLoggable(JdkLevel.DEBUG)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " DEBUG [" + threadName + "] " + name + " : ";
        var newMessage = MessageHelper.format(message, params);
        LogRecord logRecord = new LogRecord(JdkLevel.DEBUG, prefix + newMessage);
        logger.log(logRecord);
    }

    @Override
    public void debug(String message, Throwable e) {
        if (!logger.isLoggable(JdkLevel.DEBUG)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " DEBUG [" + threadName + "] " + name + " : ";
        LogRecord logRecord = new LogRecord(JdkLevel.DEBUG, prefix + message);
        logRecord.setThrown(e);
        logger.log(logRecord);
    }

    @Override
    public void debug(Supplier<String> supplier, Throwable e) {
        if (!logger.isLoggable(JdkLevel.DEBUG)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " DEBUG [" + threadName + "] " + name + " : ";
        LogRecord logRecord = new LogRecord(JdkLevel.DEBUG, prefix + supplier.get());
        logRecord.setThrown(e);
        logger.log(logRecord);
    }

    @Override
    public void debug(String message, Throwable e, Object... params) {
        if (!logger.isLoggable(JdkLevel.DEBUG)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " DEBUG [" + threadName + "] " + name + " : ";
        var newMessage = MessageHelper.format(message, params);
        LogRecord logRecord = new LogRecord(JdkLevel.DEBUG, prefix + newMessage);
        logRecord.setThrown(e);
        logger.log(logRecord);
    }

    @Override
    public boolean isInfoEnabled() {
        return logger.isLoggable(JdkLevel.INFO);
    }

    @Override
    public void info(String message) {
        if (!logger.isLoggable(JdkLevel.INFO)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " INFO [" + threadName + "] " + name + " : ";
        LogRecord logRecord = new LogRecord(JdkLevel.INFO, prefix + message);
        logger.log(logRecord);
    }

    @Override
    public void info(Supplier<String> supplier) {
        if (!logger.isLoggable(JdkLevel.INFO)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " INFO [" + threadName + "] " + name + " : ";
        LogRecord logRecord = new LogRecord(JdkLevel.INFO, prefix + supplier.get());
        logger.log(logRecord);
    }

    @Override
    public void info(String message, Object... params) {
        if (!logger.isLoggable(JdkLevel.INFO)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " INFO [" + threadName + "] " + name + " : ";
        var newMessage = MessageHelper.format(message, params);
        LogRecord logRecord = new LogRecord(JdkLevel.INFO, prefix + newMessage);
        logger.log(logRecord);
    }

    @Override
    public void info(String message, Throwable e) {
        if (!logger.isLoggable(JdkLevel.INFO)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " INFO [" + threadName + "] " + name + " : ";
        LogRecord logRecord = new LogRecord(JdkLevel.INFO, prefix + message);
        logRecord.setThrown(e);
        logger.log(logRecord);
    }

    @Override
    public void info(Supplier<String> supplier, Throwable e) {
        if (!logger.isLoggable(JdkLevel.INFO)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " INFO [" + threadName + "] " + name + " : ";
        LogRecord logRecord = new LogRecord(JdkLevel.INFO, prefix + supplier.get());
        logRecord.setThrown(e);
        logger.log(logRecord);
    }

    @Override
    public void info(String message, Throwable e, Object... params) {
        if (!logger.isLoggable(JdkLevel.INFO)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " INFO [" + threadName + "] " + name + " : ";
        var newMessage = MessageHelper.format(message, params);
        LogRecord logRecord = new LogRecord(JdkLevel.INFO, prefix + newMessage);
        logRecord.setThrown(e);
        logger.log(logRecord);
    }

    @Override
    public boolean isWarnEnabled() {
        return logger.isLoggable(JdkLevel.WARNING);
    }

    @Override
    public void warn(String message) {
        if (!logger.isLoggable(JdkLevel.WARNING)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " WARN [" + threadName + "] " + name + " : ";
        LogRecord logRecord = new LogRecord(JdkLevel.WARNING, prefix + message);
        logger.log(logRecord);
    }

    @Override
    public void warn(Supplier<String> supplier) {
        if (!logger.isLoggable(JdkLevel.WARNING)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " WARN [" + threadName + "] " + name + " : ";
        LogRecord logRecord = new LogRecord(JdkLevel.WARNING, prefix + supplier.get());
        logger.log(logRecord);
    }

    @Override
    public void warn(String message, Object... params) {
        if (!logger.isLoggable(JdkLevel.WARNING)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " WARN [" + threadName + "] " + name + " : ";
        var newMessage = MessageHelper.format(message, params);
        LogRecord logRecord = new LogRecord(JdkLevel.WARNING, prefix + newMessage);
        logger.log(logRecord);
    }

    @Override
    public void warn(String message, Throwable e) {
        if (!logger.isLoggable(JdkLevel.WARNING)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " WARN [" + threadName + "] " + name + " : ";
        LogRecord logRecord = new LogRecord(JdkLevel.WARNING, prefix + message);
        logRecord.setThrown(e);
        logger.log(logRecord);
    }

    @Override
    public void warn(Supplier<String> supplier, Throwable e) {
        if (!logger.isLoggable(JdkLevel.WARNING)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " WARN [" + threadName + "] " + name + " : ";
        LogRecord logRecord = new LogRecord(JdkLevel.WARNING, prefix + supplier.get());
        logRecord.setThrown(e);
        logger.log(logRecord);
    }

    @Override
    public void warn(String message, Throwable e, Object... params) {
        if (!logger.isLoggable(JdkLevel.WARNING)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " WARN [" + threadName + "] " + name + " : ";
        var newMessage = MessageHelper.format(message, params);
        LogRecord logRecord = new LogRecord(JdkLevel.WARNING, prefix + newMessage);
        logRecord.setThrown(e);
        logger.log(logRecord);
    }

    @Override
    public boolean isErrorEnabled() {
        return logger.isLoggable(JdkLevel.SEVERE);
    }

    @Override
    public void error(String message) {
        if (!logger.isLoggable(JdkLevel.SEVERE)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " ERROR [" + threadName + "] " + name + " : ";
        LogRecord logRecord = new LogRecord(JdkLevel.SEVERE, prefix + message);
        logger.log(logRecord);
    }

    @Override
    public void error(Supplier<String> supplier) {
        if (!logger.isLoggable(JdkLevel.SEVERE)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " ERROR [" + threadName + "] " + name + " : ";
        LogRecord logRecord = new LogRecord(JdkLevel.SEVERE, prefix + supplier.get());
        logger.log(logRecord);
    }

    @Override
    public void error(String message, Object... params) {
        if (!logger.isLoggable(JdkLevel.SEVERE)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " ERROR [" + threadName + "] " + name + " : ";
        var newMessage = MessageHelper.format(message, params);
        LogRecord logRecord = new LogRecord(JdkLevel.SEVERE, prefix + newMessage);
        logger.log(logRecord);
    }

    @Override
    public void error(String message, Throwable e) {
        if (!logger.isLoggable(JdkLevel.SEVERE)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " ERROR [" + threadName + "] " + name + " : ";
        LogRecord logRecord = new LogRecord(JdkLevel.SEVERE, prefix + message);
        logRecord.setThrown(e);
        logger.log(logRecord);
    }

    @Override
    public void error(Supplier<String> supplier, Throwable e) {
        if (!logger.isLoggable(JdkLevel.SEVERE)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " ERROR [" + threadName + "] " + name + " : ";
        LogRecord logRecord = new LogRecord(JdkLevel.SEVERE, prefix + supplier.get());
        logRecord.setThrown(e);
        logger.log(logRecord);
    }

    @Override
    public void error(String message, Throwable e, Object... params) {
        if (!logger.isLoggable(JdkLevel.SEVERE)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " ERROR [" + threadName + "] " + name + " : ";
        var newMessage = MessageHelper.format(message, params);
        LogRecord logRecord = new LogRecord(JdkLevel.SEVERE, prefix + newMessage);
        logRecord.setThrown(e);
        logger.log(logRecord);
    }

    @Override
    public boolean isFatalEnabled() {
        return logger.isLoggable(JdkLevel.FATAL);
    }

    @Override
    public void fatal(String message) {
        if (!logger.isLoggable(JdkLevel.FATAL)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " FATAL [" + threadName + "] " + name + " : ";
        LogRecord logRecord = new LogRecord(JdkLevel.FATAL, prefix + message);
        logger.log(logRecord);
    }

    @Override
    public void fatal(Supplier<String> supplier) {
        if (!logger.isLoggable(JdkLevel.FATAL)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " FATAL [" + threadName + "] " + name + " : ";
        LogRecord logRecord = new LogRecord(JdkLevel.FATAL, prefix + supplier.get());
        logger.log(logRecord);
    }

    @Override
    public void fatal(String message, Object... params) {
        if (!logger.isLoggable(JdkLevel.FATAL)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " FATAL [" + threadName + "] " + name + " : ";
        var newMessage = MessageHelper.format(message, params);
        LogRecord logRecord = new LogRecord(JdkLevel.FATAL, prefix + newMessage);
        logger.log(logRecord);
    }

    @Override
    public void fatal(String message, Throwable e) {
        if (!logger.isLoggable(JdkLevel.FATAL)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " FATAL [" + threadName + "] " + name + " : ";
        LogRecord logRecord = new LogRecord(JdkLevel.FATAL, prefix + message);
        logRecord.setThrown(e);
        logger.log(logRecord);
    }

    @Override
    public void fatal(Supplier<String> supplier, Throwable e) {
        if (!logger.isLoggable(JdkLevel.FATAL)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " FATAL [" + threadName + "] " + name + " : ";
        LogRecord logRecord = new LogRecord(JdkLevel.FATAL, prefix + supplier.get());
        logRecord.setThrown(e);
        logger.log(logRecord);
    }

    @Override
    public void fatal(String message, Throwable e, Object... params) {
        if (!logger.isLoggable(JdkLevel.FATAL)) {
            return;
        }
        var threadName = Thread.currentThread().getName();
        var prefix = nowStr() + " FATAL [" + threadName + "] " + name + " : ";
        var newMessage = MessageHelper.format(message, params);
        LogRecord logRecord = new LogRecord(JdkLevel.FATAL, prefix + newMessage);
        logRecord.setThrown(e);
        logger.log(logRecord);
    }

    @Override
    public Logger setClass(Class<?> tracedClass) {
        return setName(tracedClass.getName());
    }

    @Override
    public Logger setName(String name) {
        this.name = name;
        this.logger = java.util.logging.Logger.getLogger(name);
        this.logger.setLevel(Level.FINER);
        return this;
    }
}
