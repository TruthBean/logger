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

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-12-01 12:07
 */
public interface ConfigurableLogger extends Logger {
    ConfigurableLogger setClass(Class<?> tracedClass);

    ConfigurableLogger setName(CharSequence name);

    ConfigurableLogger setName(String name);

    String getLoggerName();

    ConfigurableLogger setDefaultLevel(LogLevel level);

    default ConfigurableLogger setUseName(boolean useName) {
        return this;
    }

    LogLevel getDefaultLevel();

    LogLevel getLevel();

    Logger logger();

    static LoggerLocation getLoggerMethod(String loggerName, int nextN) {
        LoggerLocation result = new LoggerLocation();
        result.setLoggerName(loggerName);

        // Hack (?) to get the stack trace.
        var dummyException = new Throwable();
        var locations = dummyException.getStackTrace();
        // Caller will be the third element

        if (locations != null && locations.length > nextN) {
            var deep = locations.length;
            var caller = locations[nextN];
            String moduleName = caller.getModuleName();
            String moduleVersion = caller.getModuleVersion();
            var className = caller.getClassName();
            var methodName = caller.getMethodName();
            var lineNumber = caller.getLineNumber();

            while (deep > nextN && ("com.truthbean.Logger".equals(className)
                    || "com.truthbean.logger.BaseLogger".equals(className)
                    || "com.truthbean.logger.juli.JuliLogger".equals(className)
                    || "com.truthbean.logger.jcl.JclLogger".equals(className)
                    || "com.truthbean.logger.jul.JulLoggerImpl".equals(className)
                    || "com.truthbean.logger.jdk9.JdkSystemLogger".equals(className)
                    || "com.truthbean.logger.slf4j.TruthBeanLogger".equals(className)
                    || "com.truthbean.logger.log4j2.TruthBeanLogger".equals(className)
                    || "com.truthbean.logger.jul.bridge.JulBridgeLoggerHandler".equals(className)
                    || "java.util.logging.Logger".equals(className)
                    || "sun.util.logging.internal.LoggingProviderImpl$JULWrapper".equals(className)
                    || "org.apache.logging.log4j.spi.AbstractLogger".equals(className))) {
                caller = locations[nextN++];
                moduleName = caller.getModuleName();
                moduleVersion = caller.getModuleVersion();
                className = caller.getClassName();
                methodName = caller.getMethodName();
                lineNumber = caller.getLineNumber();

            }

            if (!("com.truthbean.Logger".equals(className)
                    || "com.truthbean.logger.BaseLogger".equals(className)
                    || "com.truthbean.logger.juli.JuliLogger".equals(className)
                    || "com.truthbean.logger.jcl.JclLogger".equals(className)
                    || "com.truthbean.logger.jul.JulLoggerImpl".equals(className)
                    || "com.truthbean.logger.jdk9.JdkSystemLogger".equals(className)
                    || "com.truthbean.logger.slf4j.TruthBeanLogger".equals(className)
                    || "com.truthbean.logger.log4j2.TruthBeanLogger".equals(className)
                    || "com.truthbean.logger.jul.bridge.JulBridgeLoggerHandler".equals(className)
                    || "java.util.logging.Logger".equals(className)
                    || "sun.util.logging.internal.LoggingProviderImpl$JULWrapper".equals(className)
                    || "org.apache.logging.log4j.spi.AbstractLogger".equals(className))) {
                result.setClassName(className);
                result.setModuleName(moduleName);
                result.setMethodName(methodName);
                result.setLineNumber(lineNumber);
                result.setModuleVersion(moduleVersion);
            }
        }
        return result;
    }
}
