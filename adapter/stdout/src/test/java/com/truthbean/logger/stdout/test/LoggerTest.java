/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.stdout.test;

import com.truthbean.Logger;
import com.truthbean.logger.LoggerFactory;
import org.junit.jupiter.api.Test;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-05-08 22:32
 */
class LoggerTest {

    private final TestService service = new TestService(LOGGER);
    
    @Test
    void testInfo() {
        LOGGER.info("msg");
        LOGGER.info("msg({}),({}),特{}朗普", 1, "444", "吹牛");
        service.info();
    }

    @Test
    void testDebug() {
        LOGGER.debug("debug");
        LOGGER.debug("debug{},{},{}", 55, "7777", this);
        service.debug();
    }

    @Test
    void testError() {
        LOGGER.error("66666666", new RuntimeException("7777"));
        service.error();
    }

    @Test
    void testTrace() {
        LOGGER.trace("trace");
        LOGGER.trace(() -> {return "hello trace";});
        LOGGER.trace(() -> "hello trace", new RuntimeException());
        service.trace();
    }

    @Override
    public String toString() {
        return "888888888888888888888888";
    }
    
    public static final Logger LOGGER = LoggerFactory.getLogger(LoggerTest.class);
}
