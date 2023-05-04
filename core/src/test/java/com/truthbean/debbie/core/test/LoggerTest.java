/**
 * Copyright (c) 2023 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.debbie.core.test;

import com.truthbean.Logger;
import com.truthbean.logger.LogLevel;
import com.truthbean.LoggerFactory;
import com.truthbean.logger.LoggerConfig;
import org.junit.jupiter.api.Test;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-05-08 22:32
 */
public class LoggerTest {

    private final TestService service = new TestService(LOGGER);

    static {
        System.setProperty(LoggerConfig.NO_LOGGER, "false");
        System.setProperty(LoggerConfig.STD_OUT, "true");
        System.setProperty(LoggerConfig.COLOR_LOGGER, "true");
        System.setProperty("logging.level.com.truthbean.debbie.core.test", "trace");
    }

    @Test
    void testLog() {
        String message = "很长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长" +
                "长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长" +
                "长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长的消息";
        LOGGER.log(LogLevel.OFF, message);
        LOGGER.log(LogLevel.OFF, this);
        LOGGER.log(LogLevel.OFF, () -> message);
        LOGGER.log(LogLevel.OFF, "{", null, message);
        LOGGER.log(LogLevel.OFF, this, message);

        LOGGER.log(LogLevel.FATAL, message);
        LOGGER.log(LogLevel.FATAL, this);
        LOGGER.log(LogLevel.FATAL, () -> message);
        LOGGER.log(LogLevel.FATAL, "{", null, message);
        LOGGER.log(LogLevel.FATAL, this, message);

        LOGGER.log(LogLevel.ERROR, message);
        LOGGER.log(LogLevel.ERROR, this);
        LOGGER.log(LogLevel.ERROR, () -> message);
        LOGGER.log(LogLevel.ERROR, "{", null, message);
        LOGGER.log(LogLevel.ERROR, this, message);

        LOGGER.log(LogLevel.WARN, message);
        LOGGER.log(LogLevel.WARN, this);
        LOGGER.log(LogLevel.WARN, () -> message);
        LOGGER.log(LogLevel.WARN, "{", null, message);
        LOGGER.log(LogLevel.WARN, this, message);

        LOGGER.log(LogLevel.INFO, message);
        LOGGER.log(LogLevel.INFO, this);
        LOGGER.log(LogLevel.INFO, () -> message);
        LOGGER.log(LogLevel.INFO, "{", null, message);
        LOGGER.log(LogLevel.INFO, this, message);

        LOGGER.log(LogLevel.DEBUG, message);
        LOGGER.log(LogLevel.DEBUG, this);
        LOGGER.log(LogLevel.DEBUG, () -> message);
        LOGGER.log(LogLevel.DEBUG, "{", null, message);
        LOGGER.log(LogLevel.DEBUG, this, message);

        LOGGER.log(LogLevel.TRACE, message);
        LOGGER.log(LogLevel.TRACE, this);
        LOGGER.log(LogLevel.TRACE, () -> message);
        LOGGER.log(LogLevel.TRACE, "{", null, message);
        LOGGER.log(LogLevel.TRACE, this, message);

    }

    @Test
    void testInfo() {
        LOGGER.info("msg");
        LOGGER.info(() -> "msg");
        LOGGER.info("msg{}", 123);
        LOGGER.info(this, 123);
        LOGGER.info(this);
        LOGGER.info("msg({}),({}),特{}朗普", 1, "444", "吹牛");
        service.info();
    }

    @Test
    void testDebug() {
        LOGGER.debug("debug");
        LOGGER.debug("debug{},{},{}", 55, "7777", this);
        service.debug();
        LOGGER.debug("msg");
        LOGGER.debug(() -> "msg");
        LOGGER.debug("msg{}", 123);
        LOGGER.debug(this, 123);
        LOGGER.debug(this);
        LOGGER.debug("msg({}),({}),特{}朗普", 1, "444", "吹牛");
        service.debug();
    }

    @Test
    void testError() {
        LOGGER.error("66666666", new RuntimeException("7777"));
        LOGGER.error("error");
        LOGGER.error("error{},{},{}", 55, "7777", this);
        LOGGER.error("msg");
        LOGGER.error(() -> "msg");
        LOGGER.error("msg{}", 123);
        LOGGER.error(this, 123);
        LOGGER.error(this);
        LOGGER.error("msg({}),({}),特{}朗普", 1, "444", "吹牛");
        service.error();
    }

    @Test
    void testTrace() {
        LOGGER.trace("66666666", new RuntimeException("7777"));
        LOGGER.trace("trace");
        LOGGER.trace("trace{},{trace},{}", 55, "7777", this);
        LOGGER.trace("msg");
        LOGGER.trace(() -> "msg");
        LOGGER.trace("msg{}", 123);
        LOGGER.trace(this, 123);
        LOGGER.trace(this);
        LOGGER.trace("msg({}),({}),特{}朗普", 1, "444", "吹牛");
        service.trace();
    }

    @Test
    void testFatal() {
        LOGGER.fatal("66666666", new RuntimeException("7777"));
        LOGGER.fatal("fatal");
        LOGGER.fatal("fatal{},{fatal},{}", 55, "7777", this);
        LOGGER.fatal("msg");
        LOGGER.fatal(() -> "msg");
        LOGGER.fatal("msg{}", 123);
        LOGGER.fatal(this, 123);
        LOGGER.fatal(this);
        LOGGER.fatal("msg({}),({}),特{}朗普", 1, "444", "吹牛");
        service.fatal();
    }

    @Test
    void testDigital() {
        LOGGER.info((int)Character.MAX_VALUE);
    }

    @Override
    public String toString() {
        return "888888888888888888888888";
    }
    
    public static final Logger LOGGER = LoggerFactory.getLogger(LogLevel.TRACE, LoggerTest.class);
}
