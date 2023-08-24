package com.truthbean.logger.boot.slf4j;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

public class Slf4jBootTest {

    com.truthbean.Logger logger = com.truthbean.LoggerFactory.getLogger(Slf4jBootTest.class);

    @Test
    void testLog4j() {
        org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Slf4jBootTest.class);
        logger.info("log4j.....");
        logger.debug("1234");
        logger.trace("trace....");
    }

    @Test
    void testJdk() {
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Slf4jBootTest.class.getName());
        logger.info("jul");
    }

    @Test
    void testJdk9() {
        System.Logger logger = System.getLogger(Slf4jBootTest.class.getName());
        logger.log(System.Logger.Level.INFO, "jdk9");
    }

    @Test
    void testJcl() {
        Log log = LogFactory.getLog(Slf4jBootTest.class);
        log.info("jcl");
    }

    @Test
    void testSlf4j() {
        org.slf4j.Logger logger = LoggerFactory.getLogger(Slf4jBootTest.class);
        logger.info("slf4j");
        logger.debug("slf4j");
        logger.trace("slf4j");
    }

    @Test
    void testTruthBean() {
        logger.info("truthbean");
        java.util.logging.Logger julLogger = java.util.logging.Logger.getLogger(Slf4jBootTest.class.getName());
        julLogger.info("jul");
    }

}
