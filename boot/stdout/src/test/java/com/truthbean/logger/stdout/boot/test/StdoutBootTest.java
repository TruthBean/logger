/**
 * Copyright (c) 2024 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.stdout.boot.test;

import com.truthbean.Logger;
import com.truthbean.LoggerFactory;
import com.truthbean.logger.ConfigurableLogger;
import com.truthbean.logger.LogLevel;
import com.truthbean.logger.LoggerConfig;
import com.truthbean.logger.jdk.common.JulLevel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;

import java.util.logging.Handler;
import java.util.logging.Level;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-12-09 17:05
 */
public class StdoutBootTest {

    static {
        com.truthbean.LoggerFactory.getConfig().setLogLevel(StdoutBootTest.class.getName(), LogLevel.TRACE);
        LoggerFactory.flushConfig();
        // System.setProperty(ConfigurableLogger.LOCATION_TIME, "false");
        // System.setProperty(LoggerConfig.COLOR_LOGGER, "false");
    }

    @Test
    public void testLogger() {
        Logger logger = LoggerFactory.getLogger(StdoutBootTest.class);
        logger.trace("logger");
    }

    @Test
    public void testJdk9() {
        System.Logger logger = System.getLogger(StdoutBootTest.class.getName());
        System.out.println(logger);
        logger.log(System.Logger.Level.ALL, "jdk9 all ");
        logger.log(System.Logger.Level.TRACE, "jdk9 trace");
        logger.log(System.Logger.Level.DEBUG, "jdk9 debug");
        logger.log(System.Logger.Level.INFO, "jdk9 info");
        logger.log(System.Logger.Level.WARNING, "jdk9 warning");
        logger.log(System.Logger.Level.ERROR, "jdk9 error");
        logger.log(System.Logger.Level.OFF, "jdk9 off");
    }

    @Test
    public void testJul() {
        java.util.logging.Logger rootLogger = java.util.logging.LogManager.getLogManager().getLogger("");
        java.util.logging.Handler[] handlers = rootLogger.getHandlers();
        for (Handler handler : handlers) {
            System.out.println(handler);
            System.out.println(handler.getLevel());
        }
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(StdoutBootTest.class.getName());
        System.out.println(logger.getLevel());
        logger.log(Level.OFF, "jul OFF ");
        logger.log(Level.SEVERE, "jul SEVERE");
        logger.log(Level.WARNING, "jul WARNING");
        logger.log(Level.INFO, "jul INFO");
        logger.log(Level.CONFIG, "jul CONFIG");
        logger.log(Level.FINE, "jul FINE");
        logger.log(Level.FINER, "jul FINER");
        logger.log(Level.FINEST, "jul FINEST");
        logger.log(Level.ALL, "jul ALL");
        logger.log(JulLevel.OFF, "jul OFF");
        logger.log(JulLevel.FATAL, "jul FATAL");
        logger.log(JulLevel.WARN, "jul WARN");
        logger.log(JulLevel.INFO, "jul INFO");
        logger.log(JulLevel.DEBUG, "jul DEBUG");
        logger.log(JulLevel.TRACE, "jul TRACE");
        logger.log(JulLevel.ALL, "jul ALL");
    }

    @Test
    public void testJcl() {
        Log log = LogFactory.getLog(StdoutBootTest.class);
        log.trace("jcl");
    }

    @Test
    public void testJuli() {
        org.apache.juli.logging.Log log = org.apache.juli.logging.LogFactory.getLog(StdoutBootTest.class);
        log.trace("juli");
    }

    @Test
    public void testSlf4j() {
        org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(StdoutBootTest.class);
        logger.trace("slf4j");
    }

    @Test
    public void testLog4j2() {
        org.apache.logging.log4j.Logger logger = LogManager.getLogger(StdoutBootTest.class);
        logger.trace("log4j2");
    }
}
