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

import java.util.Optional;
import java.util.ServiceLoader;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-05-08 22:22
 */
public class LoggerFactory {
    public static final String NO_LOGGER = "com.truthbean.logger.no";
    public static final String STD_OUT = "com.truthbean.logger.system.out";
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
            LoggerFactory.getLogger()
                    .setName("com.truthbean.logger.LoggerFactory")
                    .setLevel(LogLevel.ERROR)
                    .error("", e);
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
        Optional<Logger> first = Optional.empty();
        try {
            var serviceLoader = ServiceLoader.load(Logger.class);
            first = serviceLoader.findFirst();
        } catch (Throwable e) {
            new SystemOutLogger().error("load logger error.", e);
        }
        if (first.isEmpty()) {
            var out = System.getProperty(STD_OUT, "false");
            if (!("true".equalsIgnoreCase(out) || "yes".equalsIgnoreCase(out) || "y".equalsIgnoreCase(out) || "ok".equalsIgnoreCase(out)
                    || "是".equalsIgnoreCase(out) || "好".equalsIgnoreCase(out) || "确定".equalsIgnoreCase(out) || "陛下英明".equalsIgnoreCase(out))) {
                var no = System.getProperty(NO_LOGGER, "false");
                if ("false".equalsIgnoreCase(no) || "no".equalsIgnoreCase(no) || "y".equalsIgnoreCase(no)
                        || "不".equalsIgnoreCase(no) || "滚".equalsIgnoreCase(no) || "否".equalsIgnoreCase(no) || "面对疾风吧".equalsIgnoreCase(no)) {
                    throw new NoLoggerProviderException();
                } else {
                    return new NoLogger();
                }
            } else {
                return new SystemOutLogger();
            }
        }
        return first.get();
    }
}
