/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.check.jul;

import com.truthbean.Logger;
import com.truthbean.logger.LoggerFactory;
import com.truthbean.logger.Logging;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-05-08 22:32
 */
class LoggerTest extends Logging {

    @Test
    void testJdk9() {
        var logger = java.lang.System.getLogger(LoggerTest.class.getName());
        System.out.println(logger);
        logger.log(System.Logger.Level.TRACE, "trace");
        logger.log(System.Logger.Level.DEBUG, "debug");
        logger.log(System.Logger.Level.INFO, "info");
        logger.log(System.Logger.Level.WARNING, "warn");
        logger.log(System.Logger.Level.ERROR, "error");
    }

    @Test
    void testJdk() {
        var logger = java.util.logging.Logger.getLogger(LoggerTest.class.getName());
        logger.log(Level.INFO, "info");
        logger.log(Level.WARNING, "warn");
        logger.log(Level.SEVERE, "error");
    }

    @Test
    void testTrace() {
        LOGGER.trace("trace");
    }

    @Test
    void testInfo() {
        logger.info("msg");
        LOGGER.info("msg{},{}", 1, "444");
        LOGGER.info("error: {}", new RuntimeException(), "test");
    }

    @Test
    void testDebug() {
        LOGGER.debug("debug");
        LOGGER.debug("debug{},{},{}", 55, "7777", this);
    }

    @Test
    void testError() {
        LOGGER.error("66666666", new RuntimeException("7777"));
    }

    @Override
    public String toString() {
        return "888888888888888888888888";
    }

    @Test
    void testColor() {
        var start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            LOGGER.trace("color");
            LOGGER.debug("color");
            LOGGER.info("color");
            LOGGER.warn("color");
            LOGGER.error("color");
            LOGGER.fatal("color");
        }
        var end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    
    public static final Logger LOGGER = LoggerFactory.getLogger(LoggerTest.class);
}
