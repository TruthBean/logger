package com.truthbean.logger.boot.log4j2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

public class Log4j2Test {

    @Test
    void testLog4j2() {
        Logger logger = LogManager.getLogger(Log4j2Test.class);
        logger.info("log4j2....");
    }

    @Test
    void testLog4j() {
        org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Log4j2Test.class);
        logger.info("log4j.....");
    }

    @Test
    void testJdk() {
        //  -Djava.util.logging.manager=org.apache.logging.log4j.jul.LogManager
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Log4j2Test.class.getName());
        logger.info("jul");
    }

    @Test
    void testJcl() {
        Log log = LogFactory.getLog(Log4j2Test.class);
        log.info("jcl");
    }

    @Test
    void testSlf4j() {
        org.slf4j.Logger logger = LoggerFactory.getLogger(Log4j2Test.class);
        logger.info("slf4j");
    }

    @Test
    void testTruthBean() {
        com.truthbean.Logger logger = com.truthbean.logger.LoggerFactory.getLogger(Log4j2Test.class);
        logger.info("truthbean");
    }

}
