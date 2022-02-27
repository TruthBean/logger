/**
 * Copyright (c) 2022 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.jul.bridge.test;

import com.truthbean.Logger;
import com.truthbean.logger.LogLevel;
import com.truthbean.LoggerFactory;
import com.truthbean.logger.jul.bridge.JulBridgeLoggerHandler;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-12-09 17:05
 */
public class JulBridgeTest {

    static {
        JulBridgeLoggerHandler.install();
        com.truthbean.LoggerFactory.getConfig().setLogLevel(JulBridgeTest.class.getName(), LogLevel.TRACE);
        com.truthbean.LoggerFactory.flushConfig();
    }

    @Test
    public void testLogger() {
        Logger logger = LoggerFactory.getLogger(JulBridgeTest.class);
        logger.trace("logger");
    }

    @Test
    public void testJdk9() {
        System.Logger logger = System.getLogger(JulBridgeTest.class.getName());
        System.out.println(logger);
        logger.log(System.Logger.Level.TRACE, "jdk9");
        logger.log(System.Logger.Level.ERROR, "jdk9", new RuntimeException("2333"));
    }

    @Test
    public void testJul() {
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JulBridgeTest.class.getName());
        logger.log(Level.FINEST, "jul");
    }
}
