package com.truthbean.logger.boot.log4j2;

import com.truthbean.logger.LogLevel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

public class Log4j2BootTest {

    @Test
    void testLog4j2() {
        Logger logger = LogManager.getLogger(Log4j2BootTest.class);
        logger.info("log4j2....");
    }

    @Test
    void testJdk() {
        // -Djava.util.logging.manager=org.apache.logging.log4j.jul.LogManager
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Log4j2BootTest.class.getName());
        logger.info("jul");
    }

    @Test
    void testSlf4j() {
        org.slf4j.Logger logger = LoggerFactory.getLogger(Log4j2BootTest.class);
        logger.info("slf4j");
    }

    @Test
    void testTruthBean() {
        logger.info("truthbean");
    }

    @Test
    void testJcl() {
        Log log = LogFactory.getLog(Log4j2BootTest.class);
        log.info("jcl .... ");
    }

    private static final com.truthbean.Logger logger = com.truthbean.LoggerFactory.getLogger(LogLevel.TRACE, Log4j2BootTest.class);

}
