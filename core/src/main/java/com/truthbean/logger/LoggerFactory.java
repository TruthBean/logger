/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger;

import com.truthbean.Logger;
import com.truthbean.logger.exception.NoLoggerProviderException;

import java.util.Map;
import java.util.ServiceLoader;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-05-08 22:22
 */
public class LoggerFactory {
    public static final String NO_LOGGER = "com.truthbean.logger.no";
    private static LoggerConfig config;

    static {
        try {
            var loggerConfigs = ServiceLoader.load(LoggerConfig.class);
            var loggerConfig = loggerConfigs.findFirst();
            config = loggerConfig.orElseGet(DefaultLoggerConfig::new);

            var serviceLoader = ServiceLoader.load(LoggerInitiation.class);
            var first = serviceLoader.findFirst();
            first.ifPresent(LoggerInitiation::init);

        } catch (Throwable e) {
            LoggerFactory.getLogger().error("", e);
            config = new DefaultLoggerConfig();
        }
    }

    public LoggerFactory() {
    }

    public static LoggerConfig getConfig() {
        return config;
    }

    public static Logger getLogger(LogLevel level, Class<?> clazz) {
        var logger = getLogger();
        if (logger.getClass() != NoLogger.class) {
            logger.setClass(clazz).setLevel(level);
        }
        return logger;
    }

    public static Logger getLogger(Class<?> clazz) {
        var logger = getLogger();
        if (logger.getClass() != NoLogger.class) {
            var level = config.getLevel(clazz.getName());
            logger.setClass(clazz).setLevel(level.orElse(LogLevel.ERROR));
        }
        return logger;
    }

    public static Logger getLogger(LogLevel level, String loggerName) {
        return getLogger().setName(loggerName).setLevel(level);
    }

    public static Logger getLogger(String loggerName) {
        var logger = getLogger();
        if (logger.getClass() != NoLogger.class) {
            var level = config.getLevel(loggerName);
            logger.setName(loggerName).setLevel(level.orElse(LogLevel.ERROR));
        }
        return logger;
    }

    private static Logger getLogger() {
        var serviceLoader = ServiceLoader.load(Logger.class);
        var first = serviceLoader.findFirst();
        if (first.isEmpty()) {
            var no = System.getProperty(NO_LOGGER, "false");
            if ("false".equalsIgnoreCase(no) || "no".equalsIgnoreCase(no)) {
                throw new NoLoggerProviderException();
            } else {
                return new NoLogger();
            }
        }
        return first.get();
    }
}
