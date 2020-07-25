package com.truthbean.logger.boot.slf4j;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

public class Slf4jTest {

    @Test
    void testLog4j() {
        org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Slf4jTest.class);
        logger.info("log4j.....");
    }

    @Test
    void testJdk() {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Slf4jTest.class.getName());
        logger.info("jul");
    }

    @Test
    void testJcl() {
        Log log = LogFactory.getLog(Slf4jTest.class);
        log.info("jcl");
    }

    @Test
    void testSlf4j() {
        org.slf4j.Logger logger = LoggerFactory.getLogger(Slf4jTest.class);
        logger.info("slf4j");
    }

    @Test
    void testTruthBean() {
        com.truthbean.Logger logger = com.truthbean.logger.LoggerFactory.getLogger(Slf4jTest.class);
        logger.info("truthbean");
        java.util.logging.Logger julLogger = java.util.logging.Logger.getLogger(Slf4jTest.class.getName());
        julLogger.info("jul");
    }

}