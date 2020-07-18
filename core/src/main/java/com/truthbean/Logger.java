/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean;

import java.util.function.Supplier;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-05-08 22:14
 */
public interface Logger {
    default Logger setClass(Class<?> tracedClass) {
        // do nothing
        return this;
    }

    default Logger setName(String name) {
        // do noting
        return this;
    }

    boolean isTraceEnabled();

    void trace(String message);

    void trace(Supplier<String> supplier);

    void trace(String message, Object... params);

    void trace(String message, Throwable e);

    void trace(Supplier<String> supplier, Throwable e);

    void trace(String message, Throwable e, Object... params);

    boolean isDebugEnabled();

    void debug(String message);

    void debug(Supplier<String> supplier);

    void debug(String message, Object... params);

    void debug(String message, Throwable e);

    void debug(Supplier<String> supplier, Throwable e);

    void debug(String message, Throwable e, Object... params);

    boolean isInfoEnabled();

    void info(String message);

    void info(Supplier<String> supplier);

    void info(String message, Object... params);

    void info(String message, Throwable e);

    void info(Supplier<String> supplier, Throwable e);

    void info(String message, Throwable e, Object... params);

    boolean isWarnEnabled();

    void warn(String message);

    void warn(Supplier<String> supplier);

    void warn(String message, Object... params);

    void warn(String message, Throwable e);

    void warn(Supplier<String> supplier, Throwable e);

    void warn(String message, Throwable e, Object... params);

    boolean isErrorEnabled();

    void error(String message);

    void error(Supplier<String> supplier);

    void error(String message, Object... params);

    void error(String message, Throwable e);

    void error(Supplier<String> supplier, Throwable e);

    void error(String message, Throwable e, Object... params);

    boolean isFatalEnabled();

    void fatal(String message);

    void fatal(Supplier<String> supplier);

    void fatal(String message, Object... params);

    void fatal(String message, Throwable e);

    void fatal(Supplier<String> supplier, Throwable e);

    void fatal(String message, Throwable e, Object... params);
}
