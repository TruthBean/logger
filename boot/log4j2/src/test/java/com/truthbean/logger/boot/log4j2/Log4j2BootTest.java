package com.truthbean.logger.boot.log4j2;

import com.truthbean.logger.LogLevel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class Log4j2BootTest {

    @Test
    void testLog4j2() {
        Logger logger = LogManager.getLogger(Log4j2BootTest.class);
        logger.fatal("log4j2....");
        LogManager.getLogger("com.truthbean.logger.boot.log4j2.Log4j2BootTest.error").error("log4j2....");
        LogManager.getLogger("com.truthbean.logger.boot.log4j2.Log4j2BootTest.warn").warn("log4j2....");
        LogManager.getLogger("com.truthbean.logger.boot.log4j2.Log4j2BootTest.info").info("log4j2....");
        LogManager.getLogger("com.truthbean.logger.boot.log4j2.Log4j2BootTest.debug").debug("log4j2....");
        LogManager.getLogger("com.truthbean.logger.boot.log4j2.Log4j2BootTest.trace").trace("log4j2....");
    }

    @Test
    void testJdk() {
        // -Djava.util.logging.manager=org.apache.logging.log4j.jul.LogManager
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Log4j2BootTest.class.getName());
        logger.info("jul");
        logger.fine("jul");
    }

    @Test
    void testJdk9() {
        System.Logger logger = System.getLogger(Log4j2BootTest.class.getName());
        logger.log(System.Logger.Level.ALL, "jdk9");
        logger.log(System.Logger.Level.INFO, "jdk9");
        logger.log(System.Logger.Level.DEBUG, "jdk9");
    }

    @Test
    void testSlf4j() {
        org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Log4j2BootTest.class);
        logger.info("slf4j");
        logger.debug("slf4j");
    }

    @Test
    void testTruthBean() {
        logger.info("truthbean");
        logger.debug("truthbean");
    }

    @Test
    void testJcl() {
        Log log = LogFactory.getLog(Log4j2BootTest.class);
        log.info("jcl .... ");
        log.debug("jcl .... ");
    }

    private static final com.truthbean.Logger logger = com.truthbean.LoggerFactory.getLogger(LogLevel.TRACE, Log4j2BootTest.class);

}
