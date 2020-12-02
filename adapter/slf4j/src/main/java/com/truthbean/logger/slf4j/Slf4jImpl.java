/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.slf4j;

import com.truthbean.logger.ConfigurableLogger;
import com.truthbean.logger.DefaultBaseLogger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.slf4j.spi.LocationAwareLogger;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-02-14 14:11
 */
public class Slf4jImpl extends DefaultBaseLogger {
    static final Marker MARKER = MarkerFactory.getMarker("truthbean");

    static {
        try {
            Class<?> handlerClass = Class.forName("org.slf4j.bridge.SLF4JBridgeHandler");
            var removeHandlersForRootLogger = handlerClass.getMethod("removeHandlersForRootLogger");
            removeHandlersForRootLogger.invoke(null);
            var install = handlerClass.getMethod("install");
            install.invoke(null);
        } catch (Throwable ignored) {
        }
    }

    public Slf4jImpl() {
    }

    @Override
    public ConfigurableLogger setClass(Class<?> tracedClass) {
        var rawLogger = LoggerFactory.getLogger(tracedClass);
        super.setClass(tracedClass);
        return getLogger(tracedClass.getName(), rawLogger);
    }

    @Override
    public ConfigurableLogger setName(String name) {
        var rawLogger = LoggerFactory.getLogger(name);
        super.setName(name);
        return getLogger(name, rawLogger);
    }

    private ConfigurableLogger getLogger(String name, org.slf4j.Logger rawLogger) {
        if (rawLogger instanceof LocationAwareLogger) {
            return new Slf4jLocationAwareLoggerImpl((LocationAwareLogger) rawLogger, name);
        } else {
            rawLogger.warn("{} is not a suitable logger", rawLogger.getClass());
            return new Slf4jLoggerImpl(rawLogger, name);
        }
    }

}
