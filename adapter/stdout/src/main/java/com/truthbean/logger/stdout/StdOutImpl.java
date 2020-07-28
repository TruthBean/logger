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

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 */
public class StdOutImpl implements Logger {
    private String loggerName;

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
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        System.out.println(time + " TRACE [" + threadName + "] " + loggerName + " --- " + message);
    }

    @Override
    public void trace(Supplier<String> supplier) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        System.out.println(time + " TRACE [" + threadName + "] " + loggerName + " --- " + supplier.get());
    }

    @Override
    public void trace(String message, Object... params) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        var msg = MessageHelper.format(message, params);
        System.out.println(time + " TRACE [" + threadName + "] " + loggerName + " --- " + msg);
    }

    @Override
    public void trace(String message, Throwable e) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        System.out.println(time + " TRACE [" + threadName + "] " + loggerName + " --- " + message);
        e.printStackTrace();
    }

    @Override
    public void trace(Supplier<String> supplier, Throwable e) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        System.out.println(time + " TRACE [" + threadName + "] " + loggerName + " --- " + supplier.get());
        e.printStackTrace();
    }

    @Override
    public void trace(String message, Throwable e, Object... params) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        var msg = MessageHelper.format(message, params);
        System.out.println(time + " TRACE [" + threadName + "] " + loggerName + " --- " + msg);
        e.printStackTrace();
    }

    @Override
    public boolean isDebugEnabled() {
        return true;
    }

    @Override
    public void debug(String message) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        System.out.println(time + " DEBUG [" + threadName + "] " + loggerName + " --- " + message);
    }

    @Override
    public void debug(Supplier<String> supplier) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        System.out.println(time + " DEBUG [" + threadName + "] " + loggerName + " --- " + supplier.get());
    }

    @Override
    public void debug(String message, Object... params) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        var msg = MessageHelper.format(message, params);
        System.out.println(time + " DEBUG [" + threadName + "] " + loggerName + " --- " + msg);
    }

    @Override
    public void debug(String message, Throwable e) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        System.out.println(time + " DEBUG [" + threadName + "] " + loggerName + " --- " + message);
        e.printStackTrace();
    }

    @Override
    public void debug(Supplier<String> supplier, Throwable e) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        System.out.println(time + " DEBUG [" + threadName + "] " + loggerName + " --- " + supplier.get());
        e.printStackTrace();
    }

    @Override
    public void debug(String message, Throwable e, Object... params) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        var msg = MessageHelper.format(message, params);
        System.out.println(time + " DEBUG [" + threadName + "] " + loggerName + " --- " + msg);
        e.printStackTrace();
    }

    @Override
    public boolean isInfoEnabled() {
        return true;
    }

    @Override
    public void info(String message) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        System.out.println(time + " INFO [" + threadName + "] " + loggerName + " --- " + message);
    }

    @Override
    public void info(Supplier<String> supplier) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        System.out.println(time + " INFO [" + threadName + "] " + loggerName + " --- " + supplier.get());
    }

    @Override
    public void info(String message, Object... params) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        var msg = MessageHelper.format(message, params);
        System.out.println(time + " INFO [" + threadName + "] " + loggerName + " --- " + msg);
    }

    @Override
    public void info(String message, Throwable e) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        System.out.println(time + " INFO [" + threadName + "] " + loggerName + " --- " + message);
        e.printStackTrace();
    }

    @Override
    public void info(Supplier<String> supplier, Throwable e) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        System.out.println(time + " INFO [" + threadName + "] " + loggerName + " --- " + supplier.get());
        e.printStackTrace();
    }

    @Override
    public void info(String message, Throwable e, Object... params) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        var msg = MessageHelper.format(message, params);
        System.out.println(time + " INFO [" + threadName + "] " + loggerName + " --- " + msg);
        e.printStackTrace();
    }

    @Override
    public boolean isWarnEnabled() {
        return true;
    }

    @Override
    public void warn(String message) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        System.out.println(time + " WARN [" + threadName + "] " + loggerName + " --- " + message);
    }

    @Override
    public void warn(Supplier<String> supplier) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        System.out.println(time + " WARN [" + threadName + "] " + loggerName + " --- " + supplier.get());
    }

    @Override
    public void warn(String message, Object... params) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        var msg = MessageHelper.format(message, params);
        System.out.println(time + " WARN [" + threadName + "] " + loggerName + " --- " + msg);
    }

    @Override
    public void warn(String message, Throwable e) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        System.out.println(time + " WARN [" + threadName + "] " + loggerName + " --- " + message);
        e.printStackTrace();
    }

    @Override
    public void warn(Supplier<String> supplier, Throwable e) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        System.out.println(time + " WARN [" + threadName + "] " + loggerName + " --- " + supplier.get());
        e.printStackTrace();
    }

    @Override
    public void warn(String message, Throwable e, Object... params) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        var msg = MessageHelper.format(message, params);
        System.out.println(time + " WARN [" + threadName + "] " + loggerName + " --- " + msg);
        e.printStackTrace();
    }

    @Override
    public boolean isErrorEnabled() {
        return true;
    }

    @Override
    public void error(String message) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        System.err.println(time + " ERROR [" + threadName + "] " + loggerName + " --- " + message);
    }

    @Override
    public void error(Supplier<String> supplier) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        System.err.println(time + " ERROR [" + threadName + "] " + loggerName + " --- " + supplier.get());
    }

    @Override
    public void error(String message, Object... params) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        var msg = MessageHelper.format(message, params);
        System.err.println(time + " ERROR [" + threadName + "] " + loggerName + " --- " + msg);
    }

    @Override
    public void error(String message, Throwable e) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        System.err.println(time + " ERROR [" + threadName + "] " + loggerName + " --- " + message);
        e.printStackTrace();
    }

    @Override
    public void error(Supplier<String> supplier, Throwable e) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        System.err.println(time + " ERROR [" + threadName + "] " + loggerName + " --- " + supplier.get());
        e.printStackTrace();
    }

    @Override
    public void error(String message, Throwable e, Object... params) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        var msg = MessageHelper.format(message, params);
        System.err.println(time + " ERROR [" + threadName + "] " + loggerName + " --- " + msg);
        e.printStackTrace();
    }

    @Override
    public boolean isFatalEnabled() {
        return true;
    }

    @Override
    public void fatal(String message) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        System.err.println(time + " FATAL [" + threadName + "] " + loggerName + " --- " + message);
    }

    @Override
    public void fatal(Supplier<String> supplier) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        System.err.println(time + " FATAL [" + threadName + "] " + loggerName + " --- " + supplier.get());
    }

    @Override
    public void fatal(String message, Object... params) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        var msg = MessageHelper.format(message, params);
        System.err.println(time + " FATAL [" + threadName + "] " + loggerName + " --- " + msg);
    }

    @Override
    public void fatal(String message, Throwable e) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        System.err.println(time + " FATAL [" + threadName + "] " + loggerName + " --- " + message);
        e.printStackTrace();
    }

    @Override
    public void fatal(Supplier<String> supplier, Throwable e) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        System.err.println(time + " FATAL [" + threadName + "] " + loggerName + " --- " + supplier.get());
        e.printStackTrace();
    }

    @Override
    public void fatal(String message, Throwable e, Object... params) {
        var time = DateTimeHelper.nowStr();
        var threadName = Thread.currentThread().getName();
        var msg = MessageHelper.format(message, params);
        System.err.println(time + " FATAL [" + threadName + "] " + loggerName + " --- " + msg);
        e.printStackTrace();
    }
}
