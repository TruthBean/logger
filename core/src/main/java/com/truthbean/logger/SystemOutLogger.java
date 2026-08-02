/**
 * Copyright (c) 2026 TruthBean(Rogar·Q)
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
import com.truthbean.logger.util.MessageHelper;

import java.io.PrintStream;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-11-18 14:18
 */
public class SystemOutLogger extends PrintStreamLogger {
    public SystemOutLogger() {
        super(System.out, System.err);
    }

    public static Logger getLogger(Class<?> tracedClass) {
        /**
         * don't use <code>SystemOutLogger.logger()</code> method to void use callback self
         */
        return new SystemOutLogger().setClass(tracedClass).setDefaultLevel(LogLevel.WARN);
    }

    public static Logger getLogger(LoggerConfig loggerConfig, Class<?> tracedClass) {
        SystemOutLogger logger = new SystemOutLogger();
        logger.setClass(tracedClass);
        logger.setDefaultLevel(LogLevel.WARN);
        logger.setLevel(logger.getLevel(loggerConfig));
        return logger;
    }

    public static void err(String message, Throwable e) {
        new SystemOutLogger().logging(LogLevel.ERROR, e, message);
    }

}
