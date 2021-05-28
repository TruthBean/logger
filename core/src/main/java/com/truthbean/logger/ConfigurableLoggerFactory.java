/**
 * Copyright (c) 2021 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger;

import com.truthbean.Logger;
import com.truthbean.LoggerFactory;
import com.truthbean.logger.exception.NoLoggerProviderException;

import java.util.Optional;
import java.util.ServiceLoader;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.5.0-RELEASE
 * Created on 2020-12-26 18:13
 */
public class ConfigurableLoggerFactory implements LoggerFactory {

    private volatile static LoggerConfig config;

    static {
        try {
            var loggerConfigs = ServiceLoader.load(LoggerConfig.class);
            var loggerConfig = loggerConfigs.findFirst();
            synchronized (ConfigurableLoggerFactory.class) {
                config = loggerConfig.orElseGet(DefaultLoggerConfig::getInstance);
            }

            var serviceLoader = ServiceLoader.load(LoggerInitiation.class);
            serviceLoader.forEach(LoggerInitiation::init);
        } catch (Throwable e) {
            synchronized (ConfigurableLoggerFactory.class) {
                config = DefaultLoggerConfig.getInstance();
            }

            var logger = getLogger();
            if (ConfigurableLogger.class.isAssignableFrom(logger.getClass())) {
                ((ConfigurableLogger) logger)
                        .setName("com.truthbean.LoggerFactory")
                        .setDefaultLevel(LogLevel.ERROR)
                        .setUseName(config.useName())
                        .logger()
                        .error("", e);
            } else {
                logger.error("", e);
            }
        }
    }

    public ConfigurableLoggerFactory() {
    }

    public static synchronized LoggerConfig getConfig() {
        return config;
    }

    public static void flushConfig() {
        var serviceLoader = ServiceLoader.load(LoggerInitiation.class);
        serviceLoader.forEach(LoggerInitiation::flush);
    }

    public static void destroy() {
        var serviceLoader = ServiceLoader.load(LoggerInitiation.class);
        serviceLoader.forEach(LoggerInitiation::destroy);
        System.runFinalization();
        System.gc();
    }

    public static Logger getLogger(LogLevel defaultLevel, Class<?> clazz) {
        var logger = getLogger();
        if (logger.getClass() != NoLogger.class) {
            if (ConfigurableLogger.class.isAssignableFrom(logger.getClass())) {
                return ((ConfigurableLogger) logger)
                        .setClass(clazz)
                        .setDefaultLevel(defaultLevel)
                        .setUseName(useName())
                        .logger();
            }
        }
        return logger;
    }

    public static Logger getLogger(Class<?> clazz) {
        var logger = getLogger();
        if (logger.getClass() != NoLogger.class) {
            if (ConfigurableLogger.class.isAssignableFrom(logger.getClass())) {
                return ((ConfigurableLogger) logger)
                        .setClass(clazz)
                        .setDefaultLevel(LogLevel.ERROR)
                        .setUseName(useName())
                        .logger();
            }
        }
        return logger;
    }

    public static Logger getLogger(LogLevel defaultLevel, String loggerName) {
        var logger = getLogger();
        if (logger.getClass() != NoLogger.class) {
            if (ConfigurableLogger.class.isAssignableFrom(logger.getClass())) {
                return ((ConfigurableLogger) logger)
                        .setName(loggerName)
                        .setDefaultLevel(defaultLevel)
                        .setUseName(useName())
                        .logger();
            }
        }
        return logger;
    }

    public static Logger getLogger(String loggerName) {
        var logger = getLogger();
        if (logger.getClass() != NoLogger.class) {
            if (ConfigurableLogger.class.isAssignableFrom(logger.getClass())) {
                return ((ConfigurableLogger) logger)
                        .setName(loggerName)
                        .setDefaultLevel(LogLevel.ERROR)
                        .setUseName(useName())
                        .logger();
            }
        }
        return logger;
    }

    private static boolean useName() {
        final LoggerConfig localConfig = config;
        if (localConfig != null) {
            return localConfig.useName();
        } else {
            return true;
        }
    }

    private static Optional<ConfigurableLogger> getBaseLogger() {
        var logger = getLogger();
        if (ConfigurableLogger.class.isAssignableFrom(logger.getClass())) {
            return Optional.of((ConfigurableLogger) logger);
        } else {
            return Optional.empty();
        }
    }

    private static Logger getLogger() {
        var out = System.getProperty(STD_OUT, "false");
        var doStdOut = "true".equalsIgnoreCase(out) || "yes".equalsIgnoreCase(out) || "y".equalsIgnoreCase(out)
                || "ok".equalsIgnoreCase(out) || "on".equalsIgnoreCase(out)
                || "是".equalsIgnoreCase(out) || "好".equalsIgnoreCase(out) || "确定".equalsIgnoreCase(out) || "陛下英明".equalsIgnoreCase(out);

        var noLog = ConfigurableLogger.isNoLogger();

        Optional<Logger> first = Optional.empty();
        try {
            var serviceLoader = ServiceLoader.load(Logger.class);
            first = serviceLoader.findFirst();
        } catch (Throwable e) {
            if (doStdOut) {
                SystemOutLogger.err("load logger error.", e);
            } else if (!noLog) {
                throw new NoLoggerProviderException("load logger error.", e);
            }
        }
        if (first.isEmpty()) {
            if (!doStdOut) {
                if (!noLog) {
                    throw new NoLoggerProviderException();
                } else {
                    return NON_LOGGER;
                }
            } else {
                return new SystemOutLogger();
            }
        }
        return first.get();
    }

    private static final Logger NON_LOGGER = new NoLogger();
}
