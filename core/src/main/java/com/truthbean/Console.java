/**
 * Copyright (c) 2021 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean;

import com.truthbean.logger.ConfigurableLogger;
import com.truthbean.logger.LogLevel;
import com.truthbean.logger.LoggerConfig;
import com.truthbean.logger.LoggerLocation;
import com.truthbean.logger.util.MessageHelper;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.5.1
 * Created on 2021-06-05 15:07
 */
public class Console {

    public static void write(int color, int style, String message) {
        System.out.print("\33[" + color + ";" + style + "m" + message + "\033[0m");
    }

    public static void writeLine(int color, int style, String message) {
        System.out.println("\33[" + color + ";" + style + "m" + message + "\033[0m");
    }

    public static void fatal(String message, Object... params) {
        log(LogLevel.FATAL, message, params);
    }

    public static void error(String message, Object... params) {
        log(LogLevel.ERROR, message, params);
    }

    public static void warn(String message, Object... params) {
        log(LogLevel.WARN, message, params);
    }

    public static void info(String message, Object... params) {
        log(LogLevel.INFO, message, params);
    }

    public static void debug(String message, Object... params) {
        log(LogLevel.DEBUG, message, params);
    }

    public static void trace(String message, Object... params) {
        log(LogLevel.TRACE, message, params);
    }

    public static void f(String tag, String message, Object... params) {
        LoggerLocation location = new LoggerLocation();
        location.setLoggerName(tag);
        log(location, LogLevel.FATAL, message, params);
    }

    public static void e(String tag, String message, Object... params) {
        LoggerLocation location = new LoggerLocation();
        location.setLoggerName(tag);
        log(location, LogLevel.ERROR, message, params);
    }

    public static void w(String tag, String message, Object... params) {
        LoggerLocation location = new LoggerLocation();
        location.setLoggerName(tag);
        log(location, LogLevel.WARN, message, params);
    }

    public static void i(String tag, String message, Object... params) {
        LoggerLocation location = new LoggerLocation();
        location.setLoggerName(tag);
        log(location, LogLevel.INFO, message, params);
    }

    public static void d(String tag, String message, Object... params) {
        LoggerLocation location = new LoggerLocation();
        location.setLoggerName(tag);
        log(location, LogLevel.DEBUG, message, params);
    }

    public static void t(String tag, String message, Object... params) {
        LoggerLocation location = new LoggerLocation();
        location.setLoggerName(tag);
        log(location, LogLevel.TRACE, message, params);
    }

    private static void log(LogLevel level, String message, Object... params) {
        LoggerLocation location = ConfigurableLogger.getLoggerMethod("");
        log(location, level, message, params);
    }

    private static void log(LoggerLocation location, LogLevel level, String message, Object... params) {
        var threadName = Thread.currentThread().getName();

        var colorStr = System.getProperty(LoggerConfig.COLOR_LOGGER, "true");
        boolean color = Boolean.parseBoolean(colorStr);
        var logger = MessageHelper.buildMessage(color, level.name(), threadName, location.toString());
        var newMessage = MessageHelper.format(message, params);
        if (color) {
            newMessage += "\033[0m";
        }
        logger.append(newMessage);

        System.out.println(logger);
    }
}
