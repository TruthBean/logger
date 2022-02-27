/**
 * Copyright (c) 2022 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.springboot;

import com.truthbean.LoggerFactory;
import org.springframework.boot.logging.*;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import java.util.*;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-12-02 15:45
 */
public class TruthBeanLoggerSystem extends AbstractLoggingSystem {
    private static final LogLevels<com.truthbean.logger.LogLevel> LEVELS = new LogLevels<>();

    private final Set<com.truthbean.logger.LogLevel> configuredLoggers = Collections.synchronizedSet(new HashSet<>());

    static {
        LEVELS.map(LogLevel.TRACE, com.truthbean.logger.LogLevel.TRACE);
        LEVELS.map(LogLevel.DEBUG, com.truthbean.logger.LogLevel.DEBUG);
        LEVELS.map(LogLevel.INFO, com.truthbean.logger.LogLevel.INFO);
        LEVELS.map(LogLevel.WARN, com.truthbean.logger.LogLevel.WARN);
        LEVELS.map(LogLevel.ERROR, com.truthbean.logger.LogLevel.ERROR);
        LEVELS.map(LogLevel.FATAL, com.truthbean.logger.LogLevel.FATAL);
        LEVELS.map(LogLevel.OFF, com.truthbean.logger.LogLevel.OFF);
    }

    public TruthBeanLoggerSystem(ClassLoader classLoader) {
        super(classLoader);
    }

    @Override
    protected String[] getStandardConfigLocations() {
        return new String[0];
    }

    @Override
    public void beforeInitialize() {
        super.beforeInitialize();
    }

    @Override
    protected void loadDefaults(LoggingInitializationContext initializationContext, LogFile logFile) {
        Environment environment = initializationContext.getEnvironment();

        if (environment instanceof ConfigurableEnvironment configurableEnvironment) {
            configurableEnvironment.getPropertySources().forEach(propertySource -> {
                Object source = propertySource.getSource();
                if (source instanceof Map map) {
                    Set set = map.keySet();
                    for (Object o : set) {
                        if (o instanceof String name) {
                            if (name.startsWith("logging.level")) {
                                String loggerName = name.substring(14);
                                String level = map.get(name).toString();
                                var l = com.truthbean.logger.LogLevel.of(level);
                                l.ifPresent(v -> LoggerFactory.getConfig().setLogLevel(loggerName, v));
                            }
                        }
                    }
                }
            });
        }
    }

    @Override
    protected void loadConfiguration(LoggingInitializationContext initializationContext, String location, LogFile logFile) {
    }

    @Override
    public void setLogLevel(String loggerName, LogLevel level) {
    }

    @Override
    public List<LoggerConfiguration> getLoggerConfigurations() {
        List<LoggerConfiguration> list = new ArrayList<>();
        LoggerFactory.getConfig().getLoggers().forEach((name, level) -> {
            LoggerConfiguration configuration = new LoggerConfiguration(name, LogLevel.ERROR, LEVELS.convertNativeToSystem(level));
            list.add(configuration);
        });
        return list;
    }

    @Override
    public LoggerConfiguration getLoggerConfiguration(String loggerName) {
        var level = LoggerFactory.getConfig().getLevel(loggerName).orElse(com.truthbean.logger.LogLevel.ERROR);
        return new LoggerConfiguration(loggerName, LogLevel.ERROR, LEVELS.convertNativeToSystem(level));
    }

    @Override
    public Runnable getShutdownHandler() {
        return new ShutdownHandler();
    }

    @Override
    public void cleanUp() {
        this.configuredLoggers.clear();
        LoggerFactory.getConfig().clear();
    }

    private static final class ShutdownHandler implements Runnable {

        @Override
        public void run() {
            LoggerFactory.destroy();
        }

    }
}
