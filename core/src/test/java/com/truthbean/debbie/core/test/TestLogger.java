/**
 * Copyright (c) 2024 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.debbie.core.test;

import com.truthbean.logger.LogLevel;
import com.truthbean.logger.NoLogger;
import com.truthbean.logger.util.MessageHelper;

import java.util.function.Supplier;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-12-01 10:57
 */
public class TestLogger extends NoLogger {
    @Override
    public boolean isLoggable(LogLevel level) {
        return false;
    }

    @Override
    public void log(LogLevel level, String message) {
        System.out.println("level: " + level);
        System.out.println("message: " + message);
    }

    @Override
    public void log(LogLevel level, String message, Throwable e) {
        System.out.println("level: " + level);
        System.out.println("message: " + message);
        System.out.println(e.getMessage());
    }

    @Override
    public void log(LogLevel level, String message, Throwable e, Object... params) {
        System.out.println("level: " + level);
        System.out.println("message: " + MessageHelper.format(message, params));
        System.out.println(e.getMessage());
    }

    @Override
    public void trace(String message) {

    }

    @Override
    public void trace(String message, Object... params) {

    }

    @Override
    public void trace(String message, Throwable e) {

    }

    @Override
    public void trace(Supplier<String> supplier, Throwable e) {

    }

    @Override
    public void trace(String message, Throwable e, Object... params) {

    }

    @Override
    public void debug(String message) {

    }

    @Override
    public void debug(Supplier<String> supplier) {

    }

    @Override
    public void debug(String message, Object... params) {

    }

    @Override
    public void debug(String message, Throwable e) {

    }

    @Override
    public void debug(Supplier<String> supplier, Throwable e) {

    }

    @Override
    public void debug(String message, Throwable e, Object... params) {

    }

    @Override
    public void info(String message) {

    }

    @Override
    public void info(Supplier<String> supplier) {

    }

    @Override
    public void info(String message, Object... params) {

    }

    @Override
    public void info(String message, Throwable e) {

    }

    @Override
    public void info(Supplier<String> supplier, Throwable e) {

    }

    @Override
    public void info(String message, Throwable e, Object... params) {

    }

    @Override
    public void warn(String message) {

    }

    @Override
    public void warn(Supplier<String> supplier) {

    }

    @Override
    public void warn(String message, Object... params) {

    }

    @Override
    public void warn(String message, Throwable e) {

    }

    @Override
    public void warn(Supplier<String> supplier, Throwable e) {

    }

    @Override
    public void warn(String message, Throwable e, Object... params) {

    }

    @Override
    public void error(String message) {

    }

    @Override
    public void error(Supplier<String> supplier) {

    }

    @Override
    public void error(String message, Object... params) {

    }

    @Override
    public void error(String message, Throwable e) {

    }

    @Override
    public void error(Supplier<String> supplier, Throwable e) {

    }

    @Override
    public void error(String message, Throwable e, Object... params) {

    }

    @Override
    public void fatal(String message) {

    }

    @Override
    public void fatal(Supplier<String> supplier) {

    }

    @Override
    public void fatal(String message, Object... params) {

    }

    @Override
    public void fatal(String message, Throwable e) {

    }

    @Override
    public void fatal(Supplier<String> supplier, Throwable e) {

    }

    @Override
    public void fatal(String message, Throwable e, Object... params) {

    }
}
