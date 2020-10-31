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

    static {
        try {
            var serviceLoader = ServiceLoader.load(LoggerInitiation.class);
            var first = serviceLoader.findFirst();
            first.ifPresent(LoggerInitiation::init);
        } catch (Throwable e) {
            LoggerFactory.getLogger().error("", e);
        }
    }

    public LoggerFactory() {
    }

    public static Logger getLogger(Class<?> clazz) {
        return getLogger().setClass(clazz);
    }

    public static Logger getLogger(String loggerName) {
        return getLogger().setName(loggerName);
    }

    private static Logger getLogger() {
        var serviceLoader = ServiceLoader.load(Logger.class);
        var first = serviceLoader.findFirst();
        if (first.isEmpty()) {
            var no = System.getProperty(NO_LOGGER, "false");
            if ("false".equals(no)) {
                throw new NoLoggerProviderException();
            } else {
                return new NoLogger();
            }
        }
        return first.get();
    }
}
