/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.stdout.boot.test;

import com.truthbean.Logger;
import com.truthbean.logger.LogLevel;
import com.truthbean.logger.LoggerFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-12-09 17:05
 */
public class StdoutBootTest {

    static {
        // com.truthbean.logger.LoggerFactory.getConfig().setLogLevel(StdoutBootTest.class.getName(), LogLevel.TRACE);
        // System.setProperty("logging.level.com.truthbean.logger.stdout.boot.test", "trace");
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
        logger.log(System.Logger.Level.TRACE, "jdk9");
    }

    @Test
    public void testJul() {
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(StdoutBootTest.class.getName());
        logger.log(Level.FINE, "jul");
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
