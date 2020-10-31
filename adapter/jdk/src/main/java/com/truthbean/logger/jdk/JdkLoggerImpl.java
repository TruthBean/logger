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
import com.truthbean.logger.util.DateTimeHelper;
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
        log(JdkLevel.TRACE, null, message);
    }

    @Override
    public void trace(Supplier<String> supplier) {
        if (!logger.isLoggable(JdkLevel.TRACE)) {
            return;
        }
        log(JdkLevel.TRACE, null, supplier.get());
    }

    @Override
    public void trace(String message, Object... params) {
        if (!logger.isLoggable(JdkLevel.TRACE)) {
            return;
        }
        log(JdkLevel.TRACE, null, message, params);
    }

    @Override
    public void trace(String message, Throwable e) {
        if (!logger.isLoggable(JdkLevel.TRACE)) {
            return;
        }
        log(JdkLevel.TRACE, e, message);
    }

    @Override
    public void trace(Supplier<String> supplier, Throwable e) {
        if (!logger.isLoggable(JdkLevel.TRACE)) {
            return;
        }
        log(JdkLevel.TRACE, e, supplier.get());
    }

    @Override
    public void trace(String message, Throwable e, Object... params) {
        if (!logger.isLoggable(JdkLevel.TRACE)) {
            return;
        }
        log(JdkLevel.TRACE, e, message, params);
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
        log(JdkLevel.DEBUG, null, message);
    }

    @Override
    public void debug(Supplier<String> supplier) {
        if (!logger.isLoggable(JdkLevel.DEBUG)) {
            return;
        }
        log(JdkLevel.DEBUG, null, supplier.get());
    }

    @Override
    public void debug(String message, Object... params) {
        if (!logger.isLoggable(JdkLevel.DEBUG)) {
            return;
        }
        log(JdkLevel.DEBUG, null, message, params);
    }

    @Override
    public void debug(String message, Throwable e) {
        if (!logger.isLoggable(JdkLevel.DEBUG)) {
            return;
        }
        log(JdkLevel.DEBUG, e, message);
    }

    @Override
    public void debug(Supplier<String> supplier, Throwable e) {
        if (!logger.isLoggable(JdkLevel.DEBUG)) {
            return;
        }
        log(JdkLevel.DEBUG, e, supplier.get());
    }

    @Override
    public void debug(String message, Throwable e, Object... params) {
        if (!logger.isLoggable(JdkLevel.DEBUG)) {
            return;
        }
        log(JdkLevel.DEBUG, e, message, params);
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
        log(JdkLevel.INFO, null, message);
    }

    @Override
    public void info(Supplier<String> supplier) {
        if (!logger.isLoggable(JdkLevel.INFO)) {
            return;
        }
        log(JdkLevel.INFO, null, supplier.get());
    }

    @Override
    public void info(String message, Object... params) {
        if (!logger.isLoggable(JdkLevel.INFO)) {
            return;
        }
        log(JdkLevel.INFO, null, message, params);
    }

    @Override
    public void info(String message, Throwable e) {
        if (!logger.isLoggable(JdkLevel.INFO)) {
            return;
        }
        log(JdkLevel.INFO, e, message);
    }

    @Override
    public void info(Supplier<String> supplier, Throwable e) {
        if (!logger.isLoggable(JdkLevel.INFO)) {
            return;
        }
        log(JdkLevel.INFO, e, supplier.get());
    }

    @Override
    public void info(String message, Throwable e, Object... params) {
        var level = JdkLevel.INFO;
        if (!logger.isLoggable(level)) {
            return;
        }
        log(level, e, message, params);
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
        log(JdkLevel.WARNING, null, message);
    }

    @Override
    public void warn(Supplier<String> supplier) {
        if (!logger.isLoggable(JdkLevel.WARNING)) {
            return;
        }
        log(JdkLevel.WARNING, null, supplier.get());
    }

    @Override
    public void warn(String message, Object... params) {
        if (!logger.isLoggable(JdkLevel.WARNING)) {
            return;
        }
        log(JdkLevel.WARNING, null, message, params);
    }

    @Override
    public void warn(String message, Throwable e) {
        if (!logger.isLoggable(JdkLevel.WARNING)) {
            return;
        }
        log(JdkLevel.WARNING, e, message);
    }

    @Override
    public void warn(Supplier<String> supplier, Throwable e) {
        if (!logger.isLoggable(JdkLevel.WARNING)) {
            return;
        }
        log(JdkLevel.WARNING, e, supplier.get());
    }

    @Override
    public void warn(String message, Throwable e, Object... params) {
        if (!logger.isLoggable(JdkLevel.WARNING)) {
            return;
        }
        log(JdkLevel.WARNING, e, message, params);
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
        log(JdkLevel.SEVERE, null, message);
    }

    @Override
    public void error(Supplier<String> supplier) {
        if (!logger.isLoggable(JdkLevel.SEVERE)) {
            return;
        }
        log(JdkLevel.SEVERE, null, supplier.get());
    }

    @Override
    public void error(String message, Object... params) {
        if (!logger.isLoggable(JdkLevel.SEVERE)) {
            return;
        }
        log(JdkLevel.SEVERE, null, message, params);
    }

    @Override
    public void error(String message, Throwable e) {
        if (!logger.isLoggable(JdkLevel.SEVERE)) {
            return;
        }
        log(JdkLevel.SEVERE, e, message);
    }

    @Override
    public void error(Supplier<String> supplier, Throwable e) {
        if (!logger.isLoggable(JdkLevel.SEVERE)) {
            return;
        }
        log(JdkLevel.SEVERE, e, supplier.get());
    }

    @Override
    public void error(String message, Throwable e, Object... params) {
        if (!logger.isLoggable(JdkLevel.SEVERE)) {
            return;
        }
        log(JdkLevel.SEVERE, e, message, params);
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
        log(JdkLevel.FATAL, null, message);
    }

    @Override
    public void fatal(Supplier<String> supplier) {
        if (!logger.isLoggable(JdkLevel.FATAL)) {
            return;
        }
        log(JdkLevel.FATAL, null, supplier.get());
    }

    @Override
    public void fatal(String message, Object... params) {
        if (!logger.isLoggable(JdkLevel.FATAL)) {
            return;
        }
        log(JdkLevel.FATAL, null, message, params);
    }

    @Override
    public void fatal(String message, Throwable e) {
        if (!logger.isLoggable(JdkLevel.FATAL)) {
            return;
        }
        log(JdkLevel.FATAL, e, message);
    }

    @Override
    public void fatal(Supplier<String> supplier, Throwable e) {
        if (!logger.isLoggable(JdkLevel.FATAL)) {
            return;
        }
        log(JdkLevel.FATAL, e, supplier.get());
    }

    @Override
    public void fatal(String message, Throwable e, Object... params) {
        if (!logger.isLoggable(JdkLevel.FATAL)) {
            return;
        }
        log(JdkLevel.FATAL, e, message, params);
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

        var threadName = Thread.currentThread().getName();
        var logger = new StringBuilder();
        logger.append("\33[98;1m").append(DateTimeHelper.nowStr()).append("\033[0m ");
        switch (level.getName()) {
            case "FATAL":
                logger.append("\33[30;1m").append(level).append("\033[0m ")
                        .append("[\33[93;1m").append(threadName).append("\033[0m] ")
                        .append("\33[98;4m").append(cname).append(".").append(method)
                        .append("()\033[0m : \33[39;1m");
                break;
            case "SEVERE":
                logger.append("\33[31;1m").append("ERROR").append("\033[0m ")
                        .append("[\33[93;1m").append(threadName).append("\033[0m] ")
                        .append("\33[91;4m").append(cname).append(".").append(method)
                        .append("()\033[0m : \33[39;1m");
                break;
            case "WARNING":
                logger.append("\33[32;1m").append("WARN").append("\033[0m ")
                        .append("[\33[93;1m").append(threadName).append("\033[0m] ")
                        .append("\33[92;4m").append(cname).append(".").append(method)
                        .append("()\033[0m : \33[39;1m");
                break;
            case "INFO":
                logger.append("\33[36;1m").append(level).append("\033[0m ")
                        .append("[\33[93;1m").append(threadName).append("\033[0m] ")
                        .append("\33[96;4m").append(cname).append(".").append(method)
                        .append("()\033[0m : \33[39;1m");
                break;
            case "DEBUG":
                logger.append("\33[34;1m").append(level).append("\033[0m ")
                        .append("[\33[93;1m").append(threadName).append("\033[0m] ")
                        .append("\33[94;4m").append(cname).append(".").append(method)
                        .append("()\033[0m : \33[39;1m");
                break;
            case "TRACE":
                logger.append("\33[35;1m").append(level).append("\033[0m ")
                        .append("[\33[93;1m").append(threadName).append("\033[0m] ")
                        .append("\33[95;4m").append(cname).append(".").append(method)
                        .append("()\033[0m : \33[39;1m");
                break;
        }
        var newMessage = MessageHelper.format(message, params) + "\033[0m";
        logger.append(newMessage);

        var logRecord = new LogRecord(level, logger.toString());
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
        this.logger.setLevel(Level.FINER);
        return this;
    }
}
