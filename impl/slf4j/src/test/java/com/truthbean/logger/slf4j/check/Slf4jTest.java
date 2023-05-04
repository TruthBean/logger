/**
 * Copyright (c) 2023 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.slf4j.check;

import com.truthbean.Logger;
import com.truthbean.logger.LogLevel;
import com.truthbean.LoggerFactory;
import org.junit.jupiter.api.Test;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-05-08 22:32
 */
class Slf4jTest {

    private final TestService service = new TestService(LOGGER);

    @Test
    void testLevel() {
        LOGGER.fatal("hello");
        LOGGER.error("hello");
        LOGGER.warn("hello");
        LOGGER.info("hello");
        LOGGER.debug("hello");
        LOGGER.trace("hello");
    }

    @Test
    void testLog() {
        LOGGER.log(LogLevel.INFO, this);
        LOGGER.log(LogLevel.INFO, "log");
        LOGGER.log(LogLevel.INFO, () -> "log");
        LOGGER.log(LogLevel.INFO, "log: {}", 1);
        LOGGER.log(LogLevel.INFO, new StringBuffer("log: {}"), 1);
        LOGGER.log(LogLevel.INFO, new StringBuffer("log: {}"), new RuntimeException(), 1);
    }
    
    @Test
    void testInfo() {
        LOGGER.info("msg");
        LOGGER.info("msg{},{}", 1, "444");
        service.info();

        LOGGER.info("66666666", new RuntimeException("7777"));
        LOGGER.info("info");
        LOGGER.info("info{},{},{}", 55, "7777", this);
        LOGGER.info("msg");
        LOGGER.info(() -> "msg");
        LOGGER.info("msg{}", 123);
        LOGGER.info(this, 123);
        LOGGER.info(this);
        LOGGER.info("msg({}),({}),特{}朗普", 1, "444", "吹牛");
    }

    @Test
    void testDebug() {
        LOGGER.debug("debug");
        LOGGER.debug("debug{},{},{}", 55, "7777", this);
        service.debug();

        LOGGER.debug("66666666", new RuntimeException("7777"));
        LOGGER.debug("debug");
        LOGGER.debug("debug{},{debug},{}", 55, "7777", this);
        LOGGER.debug("msg");
        LOGGER.debug(() -> "msg");
        LOGGER.debug("msg{}", 123);
        LOGGER.debug(this, 123);
        LOGGER.debug(this);
        LOGGER.debug("msg({}),({}),特{}朗普", 1, "444", "吹牛");
    }

    @Test
    void testError() {
        LOGGER.error("66666666", new RuntimeException("7777"));
        service.error();

        LOGGER.error("66666666", new RuntimeException("7777"));
        LOGGER.error("error");
        LOGGER.error("error{},{},{}", 55, "7777", this);
        LOGGER.error("msg");
        LOGGER.error(() -> "msg");
        LOGGER.error("msg{}", 123);
        LOGGER.error(this, 123);
        LOGGER.error(this);
        LOGGER.error("msg({}),({}),特{}朗普", 1, "444", "吹牛");
    }

    @Test
    void testTrace() {
        LOGGER.trace("trace");
        LOGGER.trace(() -> "hello trace");
        LOGGER.trace(() -> "hello trace", new RuntimeException());
        service.trace();
    }

    @Test
    void testFatal() {
        LOGGER.fatal("fatal");
        LOGGER.fatal(() -> "hello fatal");
        LOGGER.fatal(() -> "hello fatal", new RuntimeException());
        service.fatal();

        LOGGER.fatal("66666666", new RuntimeException("7777"));
        LOGGER.fatal("fatal");
        LOGGER.fatal("fatal{},{},{}", 55, "7777", this);
        LOGGER.fatal("msg");
        LOGGER.fatal(() -> "msg fatal");
        LOGGER.fatal("msg{}", 123);
        LOGGER.fatal(this, 123);
        LOGGER.fatal(this);
        LOGGER.fatal("msg({}),({}),特{}朗普", 1, "444", "吹牛");
    }

    @Override
    public String toString() {
        return "888888888888888888888888";
    }
    
    public static final Logger LOGGER = LoggerFactory.getLogger(LogLevel.TRACE, Slf4jTest.class);
}
