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

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-05-08 22:22
 */
public interface LoggerFactory {
    String NO_LOGGER = "com.truthbean.no-log";
    String STD_OUT = "com.truthbean.system-out";

    static LoggerConfig getConfig() {
        return ConfigurableLoggerFactory.getConfig();
    }

    static void flushConfig() {
        ConfigurableLoggerFactory.flushConfig();
    }

    static void destroy() {
        ConfigurableLoggerFactory.destroy();
    }

    static Logger getLogger(LogLevel defaultLevel, Class<?> clazz) {
        return ConfigurableLoggerFactory.getLogger(defaultLevel, clazz);
    }

    static Logger getLogger(Class<?> clazz) {
        return ConfigurableLoggerFactory.getLogger(clazz);
    }

    static Logger getLogger(LogLevel defaultLevel, String loggerName) {
        return ConfigurableLoggerFactory.getLogger(defaultLevel, loggerName);
    }

    static Logger getLogger(String loggerName) {
        return ConfigurableLoggerFactory.getLogger(loggerName);
    }
}
