/**
 * Copyright (c) 2023 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.check.jul;

import com.truthbean.Logger;
import com.truthbean.logger.LogLevel;
import com.truthbean.logger.LoggerConfig;
import com.truthbean.LoggerFactory;
import com.truthbean.Logging;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-05-08 22:32
 */
public class JulLoggerTest extends Logging {

    static {
        System.setProperty("logging.level.com.truthbean", LogLevel.TRACE.name());
        System.setProperty(LoggerConfig.USE_NAME, LoggerConfig.FALSE);
    }

    @Test
    void testJdk9() {
        var logger = java.lang.System.getLogger(JulLoggerTest.class.getName());
        System.out.println(logger);
        Instant begin = Instant.now();
        final int count = 1;
        for (int i = 0; i < count; i++) {
            logger.log(System.Logger.Level.TRACE, "trace");
            logger.log(System.Logger.Level.DEBUG, "debug");
            logger.log(System.Logger.Level.INFO, "info");
            logger.log(System.Logger.Level.WARNING, "warn");
            logger.log(System.Logger.Level.ERROR, "error");
            logger.log(System.Logger.Level.OFF, "FATAL");
        }
        Instant end = Instant.now();
        Duration between = Duration.between(begin, end);
        System.out.println("between day: " + between.toDays() / count);
        System.out.println("between hours: " + between.toHours()/ count);
        System.out.println("between minutes: " + between.toMinutes()/ count);
        System.out.println("between seconds: " + between.toSeconds() / count);
        System.out.println("between millis seconds: " + between.toMillis() / count);
        System.out.println("between nanos seconds: " + between.toNanos() / count);
    }

    @Test
    void testJdk() {
        Instant begin = Instant.now();
        var logger = java.util.logging.Logger.getLogger(JulLoggerTest.class.getName());
        logger.log(Level.FINEST, "FINEST");
        logger.log(Level.FINER, "FINER");
        logger.log(Level.FINE, "fine");
        logger.log(Level.INFO, "info");
        logger.log(Level.WARNING, "warn");
        logger.log(Level.SEVERE, "error");
        Instant end = Instant.now();
        Duration between = Duration.between(begin, end);
        System.out.println("between day: " + between.toDays());
        System.out.println("between hours: " + between.toHours());
        System.out.println("between minutes: " + between.toMinutes());
        System.out.println("between seconds: " + between.toSeconds());
        System.out.println("between millis seconds: " + between.toMillis());
        System.out.println("between nanos seconds: " + between.toNanos());
    }

    @Test
    void trace() {
        long start = System.nanoTime();
        for (int i = 0; i < 1; i++) {
            logger.trace((String) null);
            logger.trace("trace", (Object) null);
            logger.trace("trace {} 1", (Object) null);
            logger.trace("trace {} 1", (Throwable) null);
            logger.trace("trace {} 1", null, null, null);
            logger.trace("trace");
            logger.trace(this);

            var logger = java.lang.System.getLogger(JulLoggerTest.class.getName());
            System.out.println(logger);
            logger.log(System.Logger.Level.TRACE, "trace");
            logger.log(System.Logger.Level.DEBUG, "debug");
            logger.log(System.Logger.Level.INFO, "info");
            logger.log(System.Logger.Level.WARNING, "warn");
            logger.log(System.Logger.Level.ERROR, "error");
        }
        long end = System.nanoTime();
        System.out.println(end - start);
    }

    @Test
    void testLog() {
        logger.log(LogLevel.INFO, "info");
        logger.log(LogLevel.INFO, this);
        logger.log(LogLevel.INFO, () -> "info");
        logger.log(LogLevel.INFO, "{", null, "info");
        logger.log(LogLevel.INFO, this, "info");
        logger.info(this);
    }

    @Test
    void testInfo() {
        logger.info("msg");
        logger.info(() -> "msg");
        logger.info("msg{}", 123);
        logger.info(this, 123);
        logger.info(this);
        logger.info("msg({}),({}),特{}朗普", 1, "444", "吹牛");
    }

    @Test
    void testDebug() {
        logger.debug("debug");
        logger.debug("debug{},{},{}", 55, "7777", this);
        logger.debug("msg");
        logger.debug(() -> "msg");
        logger.debug("msg{}", 123);
        logger.debug(this, 123);
        logger.debug(this);
        logger.debug("msg({}),({}),特{}朗普", 1, "444", "吹牛");
    }

    @Test
    void testError() {
        logger.error("66666666", new RuntimeException("7777"));
        logger.error("error");
        logger.error("error{},{},{}", 55, "7777", this);
        logger.error("msg");
        logger.error(() -> "msg");
        logger.error("msg{}", 123);
        logger.error(this, 123);
        logger.error(this);
        logger.error("msg({}),({}),特{}朗普", 1, "444", "吹牛");
    }

    @Test
    void testTrace() {
        logger.trace("66666666", new RuntimeException("7777"));
        logger.trace("trace");
        logger.trace("trace{},{trace},{}", 55, "7777", this);
        logger.trace("msg");
        logger.trace(() -> "msg");
        logger.trace("msg{}", 123);
        logger.trace(this, 123);
        logger.trace(this);
        logger.trace("msg({}),({}),特{}朗普", 1, "444", "吹牛");
    }

    @Test
    void testFatal() {
        logger.fatal("66666666", new RuntimeException("7777"));
        logger.fatal("fatal");
        logger.fatal("fatal{},{fatal},{}", 55, "7777", this);
        logger.fatal("msg");
        logger.fatal(() -> "msg");
        logger.fatal("msg{}", 123);
        logger.fatal(this, 123);
        logger.fatal(this);
        logger.fatal("msg({}),({}),特{}朗普", 1, "444", "吹牛");
    }

    @Override
    public String toString() {
        return "888888888888888888888888";
    }

    @Test
    void testColor() {
        var start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            LOGGER.trace("color");
            LOGGER.debug("color");
            LOGGER.info("color");
            LOGGER.warn("color");
            LOGGER.error("color");
            LOGGER.fatal("color");
        }
        var end = System.currentTimeMillis();
        System.out.println(end - start);
        // 13_229
    }

    public static final Logger LOGGER = LoggerFactory.getLogger(JulLoggerTest.class);
}
