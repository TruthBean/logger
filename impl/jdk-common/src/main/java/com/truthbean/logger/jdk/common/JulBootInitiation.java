/**
 * Copyright (c) 2023 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.jdk.common;

import com.truthbean.LoggerFactory;
import com.truthbean.logger.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.*;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-11-18 09:49
 */
public class JulBootInitiation implements LoggerInitiation {

    static {
        var handlers = java.util.logging.Logger.getGlobal().getParent().getHandlers();
        var colorStr = System.getProperty(LoggerConfig.COLOR_LOGGER, "true");
        boolean color = Boolean.parseBoolean(colorStr);
        for (var handler : handlers) {
            handler.setLevel(Level.ALL);
            handler.setFilter(new LogLevelFilter());
            if (handler instanceof ConsoleHandler) {
                handler.setFormatter(new TruthBeanJulFormatter(color));
            }
        }
    }

    @Override
    public void init() {
        loadConfiguration();
        var config = LoggerFactory.getConfig().getLoggers();
        config.forEach(this::setLogLevel);
    }

    @Override
    public void flush() {
        loadConfiguration();
        var config = LoggerFactory.getConfig().getLoggers();
        config.forEach(this::setLogLevel);
    }

    public void setLogLevel(String loggerName, LogLevel logLevel) {
        if (loggerName == null || LoggerConfig.U_ROOT.equalsIgnoreCase(loggerName)) {
            loggerName = "";
        }
        var logger = Logger.getLogger(loggerName);
        if (logger != null) {
            var level = JulLevel.ERROR;
            switch (logLevel) {
                case OFF:
                    level = JulLevel.OFF;
                    break;
                case FATAL:
                    level = JulLevel.FATAL;
                    break;
                case WARN:
                    level = JulLevel.WARN;
                    break;
                case INFO:
                    level = JulLevel.INFO;
                    break;
                case DEBUG:
                    level = JulLevel.DEBUG;
                    break;
                case TRACE:
                    level = JulLevel.TRACE;
                    break;
                case ALL:
                    level = JulLevel.ALL;
                    break;
                default:
                case ERROR:
                    break;
            }
            logger.setLevel(level);
        }
    }

    @Override
    public void destroy() {
    }

    private void loadConfiguration() {
        try {
            URL resource = Thread.currentThread().getContextClassLoader().getResource("logging.properties");
            if (resource != null) {
                try (InputStream inputStream = new FileInputStream(resource.getPath())) {
                    LogManager.getLogManager().readConfiguration(inputStream);
                }
            }
        } catch (IOException e) {
            SystemOutLogger.err("", e);
        }
    }
}
