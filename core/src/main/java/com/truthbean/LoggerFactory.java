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

import com.truthbean.logger.*;
import com.truthbean.logger.exception.NoLoggerProviderException;

import java.util.Optional;
import java.util.ServiceLoader;

/**
 * in 0.5.2 version, move ConfigurableLoggerFactory code to LoggerFactory
 *
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-05-08 22:22
 */
public class LoggerFactory {
    public static String NO_LOGGER = "com.truthbean.no-log";
    public static String STD_OUT = "com.truthbean.system-out";
    public static String COLOR_LOGGER = "com.truthbean.stdout-color";

    private volatile static LoggerConfig config;
    private volatile static LogFactory logFactory;

    static {
        try {
            var loggerConfigs = ServiceLoader.load(LoggerConfig.class);
            var loggerConfig = loggerConfigs.findFirst();
            synchronized (LoggerFactory.class) {
                config = loggerConfig.orElseGet(DefaultLoggerConfig::getInstance);
            }

            var serviceLoader = ServiceLoader.load(LoggerInitiation.class);
            serviceLoader.forEach(LoggerInitiation::init);

            synchronized (LoggerFactory.class) {
                logFactory = getLogFactory();
            }

        } catch (Throwable e) {
            synchronized (LoggerFactory.class) {
                config = DefaultLoggerConfig.getInstance();
                logFactory = getLogFactory();
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

    public static LoggerConfig getConfig() {
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
        var doStdOut = isStdout();
        var noLog = ConfigurableLogger.isNoLogger();

        LogFactory factory = logFactory;

        if (factory == null) {
            if (!doStdOut) {
                if (!noLog) {
                    throw new NoLoggerProviderException();
                } else {
                    return NON_LOGGER;
                }
            } else {
                return new SystemOutLogger();
            }
        } else {
            Logger logger = factory.factory();
            if (logger == null) {
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
            return logger;
        }
    }

    private static LogFactory getLogFactory() {
        var doStdOut = isStdout();
        var noLog = ConfigurableLogger.isNoLogger();

        Optional<LogFactory> logFactoryOptional = Optional.empty();
        try {
            var serviceLoader = ServiceLoader.load(LogFactory.class);
            logFactoryOptional = serviceLoader.findFirst();
        } catch (Throwable e) {
            if (doStdOut) {
                SystemOutLogger.err("load logger error.", e);
            } else if (!noLog) {
                throw new NoLoggerProviderException("load logger error.", e);
            }
        }
        if (logFactoryOptional.isEmpty()) {
            return null;
        }
        return logFactoryOptional.get();
    }

    private static boolean isStdout() {
        var out = System.getProperty(STD_OUT, "false");
        return "true".equalsIgnoreCase(out) || "yes".equalsIgnoreCase(out) || "y".equalsIgnoreCase(out)
                || "ok".equalsIgnoreCase(out) || "on".equalsIgnoreCase(out)
                || "是".equalsIgnoreCase(out) || "好".equalsIgnoreCase(out) || "确定".equalsIgnoreCase(out) || "陛下英明".equalsIgnoreCase(out);
    }

    private static final Logger NON_LOGGER = new NoLogger();
}
