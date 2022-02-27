/**
 * Copyright (c) 2022 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger;

import com.truthbean.Logger;

import java.util.function.Supplier;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.3.0
 * Created on 2020-10-23 12:14
 */
public class NoLogger implements Logger {

    public NoLogger() {
    }

    @Override
    public boolean isLoggable(LogLevel level) {
        return false;
    }

    @Override
    public void log(LogLevel level, Object message) {

    }

    @Override
    public void log(LogLevel level, String message) {

    }

    @Override
    public void log(LogLevel level, Supplier<String> supplier) {

    }

    @Override
    public void log(LogLevel level, Object message, Object... params) {

    }

    @Override
    public void log(LogLevel level, String message, Object... params) {

    }

    @Override
    public void log(LogLevel level, Object message, Throwable e) {

    }

    @Override
    public void log(LogLevel level, String message, Throwable e) {

    }

    @Override
    public void log(LogLevel level, Supplier<String> supplier, Throwable e) {

    }

    @Override
    public void log(LogLevel level, Object message, Throwable e, Object... params) {

    }

    @Override
    public void log(LogLevel level, String message, Throwable e, Object... params) {

    }

    @Override
    public boolean isTraceEnabled() {
        return false;
    }

    @Override
    public void trace(Object message) {

    }

    @Override
    public void trace(String message) {

    }

    @Override
    public void trace(Supplier<String> supplier) {

    }

    @Override
    public void trace(Object message, Object... params) {

    }

    @Override
    public void trace(String message, Object... params) {

    }

    @Override
    public void trace(Object message, Throwable e) {

    }

    @Override
    public void trace(String message, Throwable e) {

    }

    @Override
    public void trace(Supplier<String> supplier, Throwable e) {

    }

    @Override
    public void trace(Object message, Throwable e, Object... params) {

    }

    @Override
    public void trace(String message, Throwable e, Object... params) {

    }

    @Override
    public boolean isDebugEnabled() {
        return false;
    }

    @Override
    public void debug(Object message) {

    }

    @Override
    public void debug(String message) {

    }

    @Override
    public void debug(Supplier<String> supplier) {

    }

    @Override
    public void debug(Object message, Object... params) {

    }

    @Override
    public void debug(String message, Object... params) {

    }

    @Override
    public void debug(Object message, Throwable e) {

    }

    @Override
    public void debug(String message, Throwable e) {

    }

    @Override
    public void debug(Supplier<String> supplier, Throwable e) {

    }

    @Override
    public void debug(Object message, Throwable e, Object... params) {

    }

    @Override
    public void debug(String message, Throwable e, Object... params) {

    }

    @Override
    public boolean isInfoEnabled() {
        return false;
    }

    @Override
    public void info(Object message) {

    }

    @Override
    public void info(String message) {

    }

    @Override
    public void info(Supplier<String> supplier) {

    }

    @Override
    public void info(Object message, Object... params) {

    }

    @Override
    public void info(String message, Object... params) {

    }

    @Override
    public void info(Object message, Throwable e) {

    }

    @Override
    public void info(String message, Throwable e) {

    }

    @Override
    public void info(Supplier<String> supplier, Throwable e) {

    }

    @Override
    public void info(Object message, Throwable e, Object... params) {

    }

    @Override
    public void info(String message, Throwable e, Object... params) {

    }

    @Override
    public boolean isWarnEnabled() {
        return false;
    }

    @Override
    public void warn(Object message) {

    }

    @Override
    public void warn(String message) {

    }

    @Override
    public void warn(Supplier<String> supplier) {

    }

    @Override
    public void warn(Object message, Object... params) {

    }

    @Override
    public void warn(String message, Object... params) {

    }

    @Override
    public void warn(Object message, Throwable e) {

    }

    @Override
    public void warn(String message, Throwable e) {

    }

    @Override
    public void warn(Supplier<String> supplier, Throwable e) {

    }

    @Override
    public void warn(Object message, Throwable e, Object... params) {

    }

    @Override
    public void warn(String message, Throwable e, Object... params) {

    }

    @Override
    public boolean isErrorEnabled() {
        return false;
    }

    @Override
    public void error(Object message) {

    }

    @Override
    public void error(String message) {

    }

    @Override
    public void error(Supplier<String> supplier) {

    }

    @Override
    public void error(Object message, Object... params) {

    }

    @Override
    public void error(String message, Object... params) {

    }

    @Override
    public void error(Object message, Throwable e) {

    }

    @Override
    public void error(String message, Throwable e) {

    }

    @Override
    public void error(Supplier<String> supplier, Throwable e) {

    }

    @Override
    public void error(Object message, Throwable e, Object... params) {

    }

    @Override
    public void error(String message, Throwable e, Object... params) {

    }

    @Override
    public boolean isFatalEnabled() {
        return false;
    }

    @Override
    public void fatal(Object message) {

    }

    @Override
    public void fatal(String message) {

    }

    @Override
    public void fatal(Supplier<String> supplier) {

    }

    @Override
    public void fatal(Object message, Object... params) {

    }

    @Override
    public void fatal(String message, Object... params) {

    }

    @Override
    public void fatal(Object message, Throwable e) {

    }

    @Override
    public void fatal(String message, Throwable e) {

    }

    @Override
    public void fatal(Supplier<String> supplier, Throwable e) {

    }

    @Override
    public void fatal(Object message, Throwable e, Object... params) {

    }

    @Override
    public void fatal(String message, Throwable e, Object... params) {

    }
}
