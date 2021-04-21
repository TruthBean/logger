/**
 * Copyright (c) 2021 TruthBean(Rogar·Q)
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
import org.junit.jupiter.api.Test;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-05-08 22:32
 */
public class LoggerTest {

    private final TestService service = new TestService(LOGGER);

    static {
        System.setProperty(LoggerFactory.NO_LOGGER, "false");
        System.setProperty(LoggerFactory.STD_OUT, "true");
        System.setProperty("logging.level.com.truthbean.debbie.core.test", "trace");
    }

    @Test
    void testLog() {
        LOGGER.log(LogLevel.INFO, "info");
        LOGGER.log(LogLevel.INFO, this);
        LOGGER.log(LogLevel.INFO, () -> "info");
        LOGGER.log(LogLevel.INFO, "{", null, "info");
        LOGGER.log(LogLevel.INFO, this, "info");
        LOGGER.info(this);
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

    @Override
    public String toString() {
        return "888888888888888888888888";
    }
    
    public static final Logger LOGGER = LoggerFactory.getLogger(LogLevel.TRACE, LoggerTest.class);
}
