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
import com.truthbean.logger.util.DateTimeHelper;
import com.truthbean.logger.util.MessageHelper;

import java.util.function.Supplier;

import static com.truthbean.logger.util.DateTimeHelper.nowStr;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 */
public class StdOutImpl implements Logger {
    private String loggerName;
    public static final String TRACE = "TRACE";
    public static final String DEBUG = "DEBUG";
    public static final String INFO = "INFO";
    public static final String WARN = "WARN";
    public static final String ERROR = "ERROR";
    public static final String FATAL = "FATAL";

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
    public boolean isTraceEnabled() {
        return true;
    }

    @Override
    public void trace(String message) {
        log(TRACE, null, message);
    }

    @Override
    public void trace(Supplier<String> supplier) {
        log(TRACE, null, supplier.get());
    }

    @Override
    public void trace(String message, Object... params) {
        log(TRACE, null, message, params);
    }

    @Override
    public void trace(String message, Throwable e) {
        log(TRACE, null, message);
    }

    @Override
    public void trace(Supplier<String> supplier, Throwable e) {
        log(TRACE, e, supplier.get());
    }

    @Override
    public void trace(String message, Throwable e, Object... params) {
        log(TRACE, e, message, params);
    }

    @Override
    public boolean isDebugEnabled() {
        return true;
    }

    @Override
    public void debug(String message) {
        log(DEBUG, null, message);
    }

    @Override
    public void debug(Supplier<String> supplier) {
        log(DEBUG, null, supplier.get());
    }

    @Override
    public void debug(String message, Object... params) {
        log(DEBUG, null, message, params);
    }

    @Override
    public void debug(String message, Throwable e) {
        log(DEBUG, e, message);
    }

    @Override
    public void debug(Supplier<String> supplier, Throwable e) {
        log(DEBUG, e, supplier.get());
    }

    @Override
    public void debug(String message, Throwable e, Object... params) {
        log(DEBUG, e, message, params);
    }

    @Override
    public boolean isInfoEnabled() {
        return true;
    }

    @Override
    public void info(String message) {
        log(INFO, null, message);
    }

    @Override
    public void info(Supplier<String> supplier) {
        log(INFO, null, supplier.get());
    }

    @Override
    public void info(String message, Object... params) {
        log(INFO, null, message, params);
    }

    @Override
    public void info(String message, Throwable e) {
        log(INFO, e, message);
    }

    @Override
    public void info(Supplier<String> supplier, Throwable e) {
        log(INFO, e, supplier.get());
    }

    @Override
    public void info(String message, Throwable e, Object... params) {
        log(INFO, e, message, params);
    }

    @Override
    public boolean isWarnEnabled() {
        return true;
    }

    @Override
    public void warn(String message) {
        log(WARN, null, message);
    }

    @Override
    public void warn(Supplier<String> supplier) {
        log(WARN, null, supplier.get());
    }

    @Override
    public void warn(String message, Object... params) {
        log(WARN, null, message, params);
    }

    @Override
    public void warn(String message, Throwable e) {
        log(WARN, e, message);
    }

    @Override
    public void warn(Supplier<String> supplier, Throwable e) {
        log(WARN, e, supplier.get());
    }

    @Override
    public void warn(String message, Throwable e, Object... params) {
        log(WARN, e, message, params);
    }

    @Override
    public boolean isErrorEnabled() {
        return true;
    }

    @Override
    public void error(String message) {
        log(ERROR, null, message);
    }

    @Override
    public void error(Supplier<String> supplier) {
        log(ERROR, null, supplier.get());
    }

    @Override
    public void error(String message, Object... params) {
        log(ERROR, null, message, params);
    }

    @Override
    public void error(String message, Throwable e) {
        log(ERROR, e, message);
    }

    @Override
    public void error(Supplier<String> supplier, Throwable e) {
        log(ERROR, e, supplier.get());
    }

    @Override
    public void error(String message, Throwable e, Object... params) {
        log(ERROR, e, message, params);
    }

    @Override
    public boolean isFatalEnabled() {
        return true;
    }

    @Override
    public void fatal(String message) {
        log(FATAL, null, message);
    }

    @Override
    public void fatal(Supplier<String> supplier) {
        log(FATAL, null, supplier.get());
    }

    @Override
    public void fatal(String message, Object... params) {
        log(FATAL, null, message, params);
    }

    @Override
    public void fatal(String message, Throwable e) {
        log(FATAL, e, message);
    }

    @Override
    public void fatal(Supplier<String> supplier, Throwable e) {
        log(FATAL, e, supplier.get());
    }

    @Override
    public void fatal(String message, Throwable e, Object... params) {

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
                logger.append("\33[32;1m").append(level).append("\033[0m ")
                        .append("[\33[93;1m").append(threadName).append("\033[0m] ")
                        .append("\33[92;4m").append(cname).append(".").append(method)
                        .append("()\033[0m : \33[39;1m");
                break;
            case INFO:
                logger.append("\33[36;1m").append(level).append("\033[0m ")
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
