package com.truthbean.logger.test;

import com.truthbean.Console;
import com.truthbean.Logger;
import com.truthbean.LoggerFactory;
import com.truthbean.logger.LogLevel;
import com.truthbean.logger.LoggerConfig;
import com.truthbean.logger.SystemOutLogger;
import com.truthbean.logger.util.ColorHelper;
import org.junit.jupiter.api.Test;

/**
 * @author TruthBean/Rogar·Q
 * @since Created on 2020-12-02 14:23
 */
class SystemOutLoggerTest {

    static {
        System.setProperty(LoggerConfig.DISABLE_LOGGER, "true");
    }

    @Test
    void log() {
        System.setProperty(LoggerConfig.NO_LOGGER, "false");
        System.setProperty(LoggerConfig.STD_OUT, "true");
        System.setProperty("logging.level.com.truthbean.debbie.core.test", "trace");
        Logger logger = LoggerFactory.getLogger(SystemOutLoggerTest.class);
        logger.error("error");
        logger.info(() -> "Fuck you Java!");

        SystemOutLogger.err("error", null);
        SystemOutLogger.getLogger(SystemOutLoggerTest.class).warn("warn");
        new SystemOutLogger().setClass(SystemOutLoggerTest.class).setDefaultLevel(LogLevel.INFO).info("info");

        Console.e("Test", "error");
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