/**
 * Copyright (c) 2023 TruthBean(Rogar·Q)
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

import java.time.Duration;
import java.time.Instant;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-12-01 12:07
 */
public interface ConfigurableLogger extends Logger {

    String LOCATION_TIME = "com.truthbean.logger.location-time";

    ConfigurableLogger setClass(Class<?> tracedClass);

    ConfigurableLogger setName(CharSequence name);

    ConfigurableLogger setName(String name);

    String getLoggerName();

    ConfigurableLogger setDefaultLevel(LogLevel level);

    default ConfigurableLogger setUseName(boolean useName) {
        return this;
    }

    static boolean isNoLogger() {
        var no = System.getProperty(LoggerConfig.NO_LOGGER, "false");
        return "true".equalsIgnoreCase(no) || "yes".equalsIgnoreCase(no) || "n".equalsIgnoreCase(no) || "on".equalsIgnoreCase(no)
                || "是".equalsIgnoreCase(no) || "好".equalsIgnoreCase(no) || "嗯".equalsIgnoreCase(no) || "面对疾风吧".equalsIgnoreCase(no);
    }

    LogLevel getDefaultLevel();

    LogLevel getLevel();

    Logger logger();

    static LoggerLocation getLoggerMethod(String loggerName) {
        var start = Instant.now();
        LoggerLocation result = new LoggerLocation();
        result.setLoggerName(loggerName);

        // Hack (?) to get the stack trace.
        var dummyException = new Throwable();
        var locations = dummyException.getStackTrace();
        // Caller will be the third element

        int nextN = 0;
        if (locations != null && locations.length > nextN) {
            var deep = locations.length;
            var caller = locations[nextN];
            String moduleName = caller.getModuleName();
            String moduleVersion = caller.getModuleVersion();
            var className = caller.getClassName();
            var methodName = caller.getMethodName();
            var lineNumber = caller.getLineNumber();

            boolean isLoggerClass = checkLoggerClass(className);
            while (deep > nextN && isLoggerClass) {
                caller = locations[nextN++];
                moduleName = caller.getModuleName();
                moduleVersion = caller.getModuleVersion();
                className = caller.getClassName();
                methodName = caller.getMethodName();
                lineNumber = caller.getLineNumber();
                isLoggerClass = checkLoggerClass(className);
            }

            if (!isLoggerClass) {
                result.setClassName(className);
                result.setModuleName(moduleName);
                result.setMethodName(methodName);
                result.setLineNumber(lineNumber);
                result.setModuleVersion(moduleVersion);
            }
            String locationTime = System.getProperty(LOCATION_TIME, "false");
            boolean bool = Boolean.parseBoolean(locationTime);
            if (bool) {
                var end = Instant.now();
                Duration between = Duration.between(start, end);
                System.err.println("请求日志位置信息花费时间：" + between.toNanos() + "纳秒；约" + between.toMillis() + "毫秒");
            }
        }
        return result;
    }

    static boolean checkLoggerClass(String className) {
        return ("java.util.Optional".equals(className)
                || "com.truthbean.Logger".equals(className)
                || "com.truthbean.logger.BaseLogger".equals(className)
                || "com.truthbean.logger.DefaultBaseLogger".equals(className)
                || "com.truthbean.logger.ConfigurableLogger".equals(className)
                || "com.truthbean.logger.SystemOutLogger".equals(className)
                || "com.truthbean.logger.stdout.Console".equals(className)
                || "com.truthbean.Console".equals(className)
                || "com.truthbean.logger.StdOutImpl".equals(className)
                || "com.truthbean.logger.juli.JuliLogger".equals(className)
                || "com.truthbean.logger.jcl.JclLogger".equals(className)
                || "com.truthbean.logger.jul.JulLoggerImpl".equals(className)
                || "com.truthbean.logger.jdk9.JdkSystemLogger".equals(className)
                || "com.truthbean.logger.slf4j.TruthBeanLogger".equals(className)
                || "com.truthbean.logger.slf4j.Slf4jImpl".equals(className)
                || "com.truthbean.logger.slf4j.Slf4jLocationAwareLoggerImpl".equals(className)
                || "com.truthbean.logger.slf4j.Slf4jLoggerImpl".equals(className)
                || "com.truthbean.logger.log4j2.TruthBeanLogger".equals(className)
                || "com.truthbean.logger.log4j2.Log4j2ExtendedLoggerWrapperImpl".equals(className)
                || "com.truthbean.logger.log4j2.Log4j2Impl".equals(className)
                || "com.truthbean.logger.log4j2.Log4j2LoggerImpl".equals(className)
                || "com.truthbean.logger.jul.bridge.JulBridgeLoggerHandler".equals(className)
                || "java.util.logging.Logger".equals(className)
                || "java.lang.System.Logger".equals(className)
                || "sun.util.logging.internal.LoggingProviderImpl$JULWrapper".equals(className)
                || "sun.rmi.runtime.Log$LoggerLog".equals(className)
                || "com.sun.jmx.remote.util.ClassLogger".equals(className)
                || "jdk.internal.logger.AbstractLoggerWrapper".equals(className)
                || "jdk.internal.net.http.common.Logger".equals(className)
                || "jdk.internal.net.http.common.Log".equals(className)
                || "jdk.internal.net.http.common.DebugLogger".equals(className)
                || "jdk.internal.net.http.hpack.HPACK.Logger".equals(className)
                || "jdk.internal.net.http.hpack.HPACK.RootLogger".equals(className)
                || className.startsWith("org.apache.commons.logging")
                || className.startsWith("org.apache.ibatis.logging")
                || className.startsWith("org.jboss.logging")
                || className.startsWith("com.sun.proxy.$Proxy")
                || className.startsWith("org.springframework.core.log")
                || className.startsWith("com.alibaba.druid.support.logging")
                || "org.mybatis.logging.Logger".equals(className)
                || "org.springframework.boot.logging.DeferredLog".equals(className)
                || "ch.qos.logback.classic.Logger".equals(className)
                || "org.apache.kafka.common.utils.LogContext.LocationAwareKafkaLogger".equals(className)
                || "org.apache.kafka.common.utils.LogContext$LocationAwareKafkaLogger".equals(className)
                || "org.apache.kafka.common.utils.LogContext.LocationIgnorantKafkaLogger".equals(className)
                || "org.apache.kafka.common.utils.LogContext$LocationIgnorantKafkaLogger".equals(className)
                || "org.apache.logging.log4j.spi.AbstractLogger".equals(className)) || className.contains(".logging.");
    }
}
