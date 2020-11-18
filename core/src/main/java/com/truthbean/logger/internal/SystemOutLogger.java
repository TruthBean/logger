/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.internal;

import com.truthbean.Logger;
import com.truthbean.logger.LogLevel;
import com.truthbean.logger.util.DateTimeHelper;
import com.truthbean.logger.util.MessageHelper;

import java.util.function.Supplier;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-11-18 14:18
 */
public class SystemOutLogger implements Logger {
    private String loggerName;
    private LogLevel level;

    @Override
    public Logger setName(String name) {
        this.loggerName = name;
        return this;
    }

    @Override
    public Logger setClass(Class<?> tracedClass) {
        this.loggerName = tracedClass.getName();
        return this;
    }

    @Override
    public Logger setLevel(LogLevel level) {
        this.level = level;
        return this;
    }

    @Override
    public LogLevel getLevel() {
        if (this.level == null)
            return LogLevel.ERROR;
        return this.level;
    }

    @Override
    public void trace(String message) {
        if (isTraceEnabled()) {
            log(LogLevel.TRACE, null, message);
        }
    }

    @Override
    public void trace(Supplier<String> supplier) {
        if (isTraceEnabled()) {
            log(LogLevel.TRACE, null, supplier.get());
        }
    }

    @Override
    public void trace(String message, Object... params) {
        if (isTraceEnabled()) {
            log(LogLevel.TRACE, null, message, params);
        }
    }

    @Override
    public void trace(String message, Throwable e) {
        if (isTraceEnabled()) {
            log(LogLevel.TRACE, null, message);
        }
    }

    @Override
    public void trace(Supplier<String> supplier, Throwable e) {
        if (isTraceEnabled()) {
            log(LogLevel.TRACE, e, supplier.get());
        }
    }

    @Override
    public void trace(String message, Throwable e, Object... params) {
        if (isTraceEnabled()) {
            log(LogLevel.TRACE, e, message, params);
        }
    }

    @Override
    public void debug(String message) {
        if (isDebugEnabled()) {
            log(LogLevel.DEBUG, null, message);
        }
    }

    @Override
    public void debug(Supplier<String> supplier) {
        if (isDebugEnabled()) {
            log(LogLevel.DEBUG, null, supplier.get());
        }
    }

    @Override
    public void debug(String message, Object... params) {
        if (isDebugEnabled()) {
            log(LogLevel.DEBUG, null, message, params);
        }
    }

    @Override
    public void debug(String message, Throwable e) {
        if (isDebugEnabled()) {
            log(LogLevel.DEBUG, e, message);
        }
    }

    @Override
    public void debug(Supplier<String> supplier, Throwable e) {
        if (isDebugEnabled()) {
            log(LogLevel.DEBUG, e, supplier.get());
        }
    }

    @Override
    public void debug(String message, Throwable e, Object... params) {
        if (isDebugEnabled()) {
            log(LogLevel.DEBUG, e, message, params);
        }
    }

    @Override
    public void info(String message) {
        if (isInfoEnabled()) {
            log(LogLevel.INFO, null, message);
        }
    }

    @Override
    public void info(Supplier<String> supplier) {
        if (isInfoEnabled())
            log(LogLevel.INFO, null, supplier.get());
    }

    @Override
    public void info(String message, Object... params) {
        if (isInfoEnabled())
            log(LogLevel.INFO, null, message, params);
    }

    @Override
    public void info(String message, Throwable e) {
        if (isInfoEnabled())
            log(LogLevel.INFO, e, message);
    }

    @Override
    public void info(Supplier<String> supplier, Throwable e) {
        if (isInfoEnabled())
            log(LogLevel.INFO, e, supplier.get());
    }

    @Override
    public void info(String message, Throwable e, Object... params) {
        if (isInfoEnabled())
            log(LogLevel.INFO, e, message, params);
    }

    @Override
    public void warn(String message) {
        if (isWarnEnabled())
            log(LogLevel.WARN, null, message);
    }

    @Override
    public void warn(Supplier<String> supplier) {
        if (isWarnEnabled())
            log(LogLevel.WARN, null, supplier.get());
    }

    @Override
    public void warn(String message, Object... params) {
        if (isWarnEnabled())
            log(LogLevel.WARN, null, message, params);
    }

    @Override
    public void warn(String message, Throwable e) {
        if (isWarnEnabled())
            log(LogLevel.WARN, e, message);
    }

    @Override
    public void warn(Supplier<String> supplier, Throwable e) {
        if (isWarnEnabled())
            log(LogLevel.WARN, e, supplier.get());
    }

    @Override
    public void warn(String message, Throwable e, Object... params) {
        if (isWarnEnabled())
            log(LogLevel.WARN, e, message, params);
    }

    @Override
    public void error(String message) {
        if (isErrorEnabled())
            log(LogLevel.ERROR, null, message);
    }

    @Override
    public void error(Supplier<String> supplier) {
        if (isErrorEnabled())
            log(LogLevel.ERROR, null, supplier.get());
    }

    @Override
    public void error(String message, Object... params) {
        log(LogLevel.ERROR, null, message, params);
    }

    @Override
    public void error(String message, Throwable e) {
        if (isErrorEnabled())
            log(LogLevel.ERROR, e, message);
    }

    @Override
    public void error(Supplier<String> supplier, Throwable e) {
        if (isErrorEnabled())
            log(LogLevel.ERROR, e, supplier.get());
    }

    @Override
    public void error(String message, Throwable e, Object... params) {
        if (isErrorEnabled())
            log(LogLevel.ERROR, e, message, params);
    }

    @Override
    public void fatal(String message) {
        if (isFatalEnabled())
            log(LogLevel.FATAL, null, message);
    }

    @Override
    public void fatal(Supplier<String> supplier) {
        if (isFatalEnabled())
            log(LogLevel.FATAL, null, supplier.get());
    }

    @Override
    public void fatal(String message, Object... params) {
        if (isFatalEnabled())
            log(LogLevel.FATAL, null, message, params);
    }

    @Override
    public void fatal(String message, Throwable e) {
        if (isFatalEnabled())
            log(LogLevel.FATAL, e, message);
    }

    @Override
    public void fatal(Supplier<String> supplier, Throwable e) {
        if (isFatalEnabled())
            log(LogLevel.FATAL, e, supplier.get());
    }

    @Override
    public void fatal(String message, Throwable e, Object... params) {
        if (isFatalEnabled())
            log(LogLevel.FATAL, e, message, params);
    }

    public void log(LogLevel level, Throwable ex, String message, Object... params) {
        // Hack (?) to get the stack trace.
        var dummyException = new Throwable();
        var locations = dummyException.getStackTrace();
        // Caller will be the third element
        var cname = loggerName;
        var method = "";
        if (locations != null && locations.length > 2) {
            var caller = locations[2];
            cname = caller.getClassName();
            method = caller.getMethodName();
        }

        var threadName = Thread.currentThread().getName();
        var logger = new StringBuilder();
        logger.append("\33[98;1m").append(DateTimeHelper.nowStr()).append("\033[0m ");
        switch (level) {
            case FATAL:
                logger.append("\33[30;1m").append(level).append("\033[0m ")
                        .append("[\33[93;1m").append(threadName).append("\033[0m] ")
                        .append("\33[98;4m").append(cname).append(".").append(method)
                        .append("()\033[0m : \33[39;1m");
                break;
            case ERROR:
                logger.append("\33[31;1m").append(level).append("\033[0m ")
                        .append("[\33[93;1m").append(threadName).append("\033[0m] ")
                        .append("\33[91;4m").append(cname).append(".").append(method)
                        .append("()\033[0m : \33[39;1m");
                break;
            case WARN:
                logger.append("\33[32;1m").append(level).append(" \033[0m ")
                        .append("[\33[93;1m").append(threadName).append("\033[0m] ")
                        .append("\33[92;4m").append(cname).append(".").append(method)
                        .append("()\033[0m : \33[39;1m");
                break;
            case INFO:
                logger.append("\33[36;1m").append(level).append(" \033[0m ")
                        .append("[\33[93;1m").append(threadName).append("\033[0m] ")
                        .append("\33[96;4m").append(cname).append(".").append(method)
                        .append("()\033[0m : \33[39;1m");
                break;
            case DEBUG:
                logger.append("\33[34;1m").append(level).append("\033[0m ")
                        .append("[\33[93;1m").append(threadName).append("\033[0m] ")
                        .append("\33[94;4m").append(cname).append(".").append(method)
                        .append("()\033[0m : \33[39;1m");
                break;
            case TRACE:
                logger.append("\33[35;1m").append(level).append("\033[0m ")
                        .append("[\33[93;1m").append(threadName).append("\033[0m] ")
                        .append("\33[95;4m").append(cname).append(".").append(method)
                        .append("()\033[0m : \33[39;1m");
                break;
        }
        var newMessage = MessageHelper.format(message, params) + "\033[0m";
        logger.append(newMessage);

        System.out.println(logger.toString());
        if (ex != null) {
            ex.printStackTrace();
        }
    }
}
