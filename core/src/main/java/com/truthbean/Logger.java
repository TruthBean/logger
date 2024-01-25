/**
 * Copyright (c) 2024 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean;

import com.truthbean.logger.LogLevel;

import java.util.function.Supplier;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-05-08 22:14
 */
public interface Logger {

    boolean isLoggable(LogLevel level);

    void log(LogLevel level, Object message);

    void log(LogLevel level, String message);

    void log(LogLevel level, Supplier<String> supplier);

    void log(LogLevel level, Object message, Object... params);

    void log(LogLevel level, String message, Object... params);

    void log(LogLevel level, Object message, Throwable e);

    void log(LogLevel level, String message, Throwable e);

    void log(LogLevel level, Supplier<String> supplier, Throwable e);

    void log(LogLevel level, Object message, Throwable e, Object... params);

    void log(LogLevel level, String message, Throwable e, Object... params);


    boolean isTraceEnabled();

    void trace(Object message);

    void trace(String message);

    void trace(Supplier<String> supplier);

    void trace(Object message, Object... params);

    void trace(String message, Object... params);

    void trace(Object message, Throwable e);

    void trace(String message, Throwable e);

    void trace(Supplier<String> supplier, Throwable e);

    void trace(Object message, Throwable e, Object... params);

    void trace(String message, Throwable e, Object... params);


    boolean isDebugEnabled();

    void debug(Object message);

    void debug(String message);

    void debug(Supplier<String> supplier);

    void debug(Object message, Object... params);

    void debug(String message, Object... params);

    void debug(Object message, Throwable e);

    void debug(String message, Throwable e);

    void debug(Supplier<String> supplier, Throwable e);

    void debug(Object message, Throwable e, Object... params);

    void debug(String message, Throwable e, Object... params);


    boolean isInfoEnabled();

    void info(Object message);

    void info(String message);

    void info(Supplier<String> supplier);

    void info(Object message, Object... params);

    void info(String message, Object... params);

    void info(Object message, Throwable e);

    void info(String message, Throwable e);

    void info(Supplier<String> supplier, Throwable e);

    void info(Object message, Throwable e, Object... params);

    void info(String message, Throwable e, Object... params);


    boolean isWarnEnabled();

    void warn(Object message);

    void warn(String message);

    void warn(Supplier<String> supplier);

    void warn(Object message, Object... params);

    void warn(String message, Object... params);

    void warn(Object message, Throwable e);

    void warn(String message, Throwable e);

    void warn(Supplier<String> supplier, Throwable e);

    void warn(Object message, Throwable e, Object... params);

    void warn(String message, Throwable e, Object... params);


    boolean isErrorEnabled();

    void error(Object message);

    void error(String message);

    void error(Supplier<String> supplier);

    void error(Object message, Object... params);

    void error(String message, Object... params);

    void error(Object message, Throwable e);

    void error(String message, Throwable e);

    void error(Supplier<String> supplier, Throwable e);

    void error(Object message, Throwable e, Object... params);

    void error(String message, Throwable e, Object... params);


    boolean isFatalEnabled();

    void fatal(Object message);

    void fatal(String message);

    void fatal(Supplier<String> supplier);

    void fatal(Object message, Object... params);

    void fatal(String message, Object... params);

    void fatal(Object message, Throwable e);

    void fatal(String message, Throwable e);

    void fatal(Supplier<String> supplier, Throwable e);

    void fatal(Object message, Throwable e, Object... params);

    void fatal(String message, Throwable e, Object... params);
}
