package com.truthbean.logger.test;

import com.truthbean.Console;
import com.truthbean.Logger;
import com.truthbean.LoggerFactory;
import com.truthbean.logger.LogLevel;
import com.truthbean.logger.SystemOutLogger;
import com.truthbean.logger.util.ColorHelper;
import org.junit.jupiter.api.Test;

/**
 * @author TruthBean/Rogar·Q
 * @since Created on 2020-12-02 14:23
 */
class SystemOutLoggerTest {

    @Test
    void log() {
        System.setProperty(LoggerFactory.NO_LOGGER, "false");
        System.setProperty(LoggerFactory.STD_OUT, "true");
        System.setProperty("logging.level.com.truthbean.debbie.core.test", "trace");
        Logger logger = LoggerFactory.getLogger(SystemOutLoggerTest.class);
        logger.error("error");
        logger.info(() -> "Fuck you Java!");

        SystemOutLogger.err("error", null);
        SystemOutLogger.getLogger(SystemOutLoggerTest.class).warn("warn");
        new SystemOutLogger().setClass(SystemOutLoggerTest.class).setDefaultLevel(LogLevel.INFO).info("info");
    }

    @Test
    void testColor() {
        var colors = ColorHelper.COLORS;
        var styles = ColorHelper.STYLES;
        for (int color : colors) {
            for (int style : styles) {
                Console.write(color, style, "m color (color:" + color + " style:" + style + ")");
            }
        }
    }

}