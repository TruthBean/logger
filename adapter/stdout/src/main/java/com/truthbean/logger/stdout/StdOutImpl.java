/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.stdout;

import com.truthbean.Logger;
import com.truthbean.logger.LogLevel;
import com.truthbean.logger.util.DateTimeHelper;
import com.truthbean.logger.util.MessageHelper;

import java.util.function.Supplier;

import static com.truthbean.logger.util.DateTimeHelper.nowStr;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 */
public class StdOutImpl implements Logger {
    public static final String TRACE = "TRACE";
    public static final String DEBUG = "DEBUG";
    public static final String INFO = "INFO";
    public static final String WARN = "WARN";
    public static final String ERROR = "ERROR";
    public static final String FATAL = "FATAL";

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
            log(TRACE, null, message);
        }
    }

    @Override
    public void trace(Supplier<String> supplier) {
        if (isTraceEnabled()) {
            log(TRACE, null, supplier.get());
        }
    }

    @Override
    public void trace(String message, Object... params) {
        if (isTraceEnabled()) {
            log(TRACE, null, message, params);
        }
    }

    @Override
    public void trace(String message, Throwable e) {
        if (isTraceEnabled()) {
            log(TRACE, null, message);
        }
    }

    @Override
    public void trace(Supplier<String> supplier, Throwable e) {
        if (isTraceEnabled()) {
            log(TRACE, e, supplier.get());
        }
    }

    @Override
    public void trace(String message, Throwable e, Object... params) {
        if (isTraceEnabled()) {
            log(TRACE, e, message, params);
        }
    }

    @Override
    public void debug(String message) {
        if (isDebugEnabled()) {
            log(DEBUG, null, message);
        }
    }

    @Override
    public void debug(Supplier<String> supplier) {
        if (isDebugEnabled()) {
            log(DEBUG, null, supplier.get());
        }
    }

    @Override
    public void debug(String message, Object... params) {
        if (isDebugEnabled()) {
            log(DEBUG, null, message, params);
        }
    }

    @Override
    public void debug(String message, Throwable e) {
        if (isDebugEnabled()) {
            log(DEBUG, e, message);
        }
    }

    @Override
    public void debug(Supplier<String> supplier, Throwable e) {
        if (isDebugEnabled()) {
            log(DEBUG, e, supplier.get());
        }
    }

    @Override
    public void debug(String message, Throwable e, Object... params) {
        if (isDebugEnabled()) {
            log(DEBUG, e, message, params);
        }
    }

    @Override
    public void info(String message) {
        if (isInfoEnabled()) {
            log(INFO, null, message);
        }
    }

    @Override
    public void info(Supplier<String> supplier) {
        if (isInfoEnabled())
            log(INFO, null, supplier.get());
    }

    @Override
    public void info(String message, Object... params) {
        if (isInfoEnabled())
            log(INFO, null, message, params);
    }

    @Override
    public void info(String message, Throwable e) {
        if (isInfoEnabled())
            log(INFO, e, message);
    }

    @Override
    public void info(Supplier<String> supplier, Throwable e) {
        if (isInfoEnabled())
            log(INFO, e, supplier.get());
    }

    @Override
    public void info(String message, Throwable e, Object... params) {
        if (isInfoEnabled())
            log(INFO, e, message, params);
    }

    @Override
    public void warn(String message) {
        if (isWarnEnabled())
            log(WARN, null, message);
    }

    @Override
    public void warn(Supplier<String> supplier) {
        if (isWarnEnabled())
            log(WARN, null, supplier.get());
    }

    @Override
    public void warn(String message, Object... params) {
        if (isWarnEnabled())
            log(WARN, null, message, params);
    }

    @Override
    public void warn(String message, Throwable e) {
        if (isWarnEnabled())
            log(WARN, e, message);
    }

    @Override
    public void warn(Supplier<String> supplier, Throwable e) {
        if (isWarnEnabled())
            log(WARN, e, supplier.get());
    }

    @Override
    public void warn(String message, Throwable e, Object... params) {
        if (isWarnEnabled())
            log(WARN, e, message, params);
    }

    @Override
    public void error(String message) {
        if (isErrorEnabled())
            log(ERROR, null, message);
    }

    @Override
    public void error(Supplier<String> supplier) {
        if (isErrorEnabled())
            log(ERROR, null, supplier.get());
    }

    @Override
    public void error(String message, Object... params) {
        log(ERROR, null, message, params);
    }

    @Override
    public void error(String message, Throwable e) {
        if (isErrorEnabled())
            log(ERROR, e, message);
    }

    @Override
    public void error(Supplier<String> supplier, Throwable e) {
        if (isErrorEnabled())
            log(ERROR, e, supplier.get());
    }

    @Override
    public void error(String message, Throwable e, Object... params) {
        if (isErrorEnabled())
            log(ERROR, e, message, params);
    }

    @Override
    public void fatal(String message) {
        if (isFatalEnabled())
            log(FATAL, null, message);
    }

    @Override
    public void fatal(Supplier<String> supplier) {
        if (isFatalEnabled())
            log(FATAL, null, supplier.get());
    }

    @Override
    public void fatal(String message, Object... params) {
        if (isFatalEnabled())
            log(FATAL, null, message, params);
    }

    @Override
    public void fatal(String message, Throwable e) {
        if (isFatalEnabled())
            log(FATAL, e, message);
    }

    @Override
    public void fatal(Supplier<String> supplier, Throwable e) {
        if (isFatalEnabled())
            log(FATAL, e, supplier.get());
    }

    @Override
    public void fatal(String message, Throwable e, Object... params) {
        if (isFatalEnabled())
            log(FATAL, e, message, params);
    }

    private void log(String level, Throwable ex, String message, Object... params) {
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
