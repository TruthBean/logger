/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.slf4j.boot;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import com.truthbean.logger.LogLevel;
import com.truthbean.logger.LoggerFactory;
import com.truthbean.logger.LoggerInitiation;
import org.slf4j.Logger;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.slf4j.impl.StaticLoggerBinder;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.3.0
 * Created on 2020-10-30 12:20
 */
public class Slf4jBootInitiation implements LoggerInitiation {
    @Override
    public void init() {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();

        var config = LoggerFactory.getConfig().getLoggers();
        config.forEach(this::setLogLevel);
    }

    public void setLogLevel(String loggerName, LogLevel logLevel) {
        var logger = getLogger(loggerName);
        if (logger != null) {
            var level = Level.ERROR;
            switch (logLevel) {
                case FATAL:
                case ERROR:
                default:
                    break;
                case WARN:
                    level = Level.WARN;
                    break;
                case INFO:
                    level = Level.INFO;
                    break;
                case DEBUG:
                    level = Level.DEBUG;
                    break;
                case TRACE:
                    level = Level.TRACE;
                    break;
            }
            logger.setLevel(level);
        }
    }

    private ch.qos.logback.classic.Logger getLogger(String name) {
        var factory = getLoggerContext();
        return factory.getLogger(getLoggerName(name));
    }

    private String getLoggerName(String name) {
        if (name != null && !name.isBlank() || Logger.ROOT_LOGGER_NAME.equals(name)) {
            return "ROOT";
        }
        return name;
    }

    private LoggerContext getLoggerContext() {
        var factory = StaticLoggerBinder.getSingleton().getLoggerFactory();
        return (LoggerContext) factory;
    }
}