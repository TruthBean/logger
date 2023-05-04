package com.truthbean.logger.test;

import com.truthbean.Console;
import com.truthbean.Logger;
import com.truthbean.LoggerFactory;
import com.truthbean.logger.LogLevel;
import com.truthbean.logger.LoggerConfig;
import com.truthbean.logger.SystemOutLogger;
import com.truthbean.logger.util.ColorHelper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

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

        List<LogLevel> levels = List.of(LogLevel.OFF, LogLevel.FATAL, LogLevel.ERROR, LogLevel.WARN, LogLevel.INFO, LogLevel.DEBUG, LogLevel.TRACE, LogLevel.ALL);
        Console.info(levels);
    }

    @Test
    void testColor() throws InterruptedException, IOException {
        var colors = ColorHelper.COLORS;
        var styles = ColorHelper.STYLES;
        String str;
        int i = 1;
        for (int style : styles) {
            for (int color : colors) {
                // str = "\rcolor (color: " + color + " style: " + style + ")";
                str = "\r码完代码 他起身关上电脑 用滚烫的开水为自己泡制一碗腾着热气的老坛酸菜牛肉面 " +
                      "\r在黑暗中享受独特的美食 疲倦的身心瞬间放松了下来 " +
                      "\r躺在椅子上休息的中年程序员忽然起身 发现祖传代码上的BUG 直呼自己简直是天才 " +
                      "\r殊不知这正是年轻的菜鸟们给自己挖的深坑 " +
                      "\r可怜的头发似乎早已看穿了一切 即使倔强的反抗 " +
                      "\r在这一文不值的垃圾代码勉强 却显得苍白无力...";
                Console.write(color, style, str.substring(0, ++i));
                if (i == str.length()) {
                    i = 1;
                }
                // Console.writeLine(color, style, "color (color:" + color + " style:" + style + ")");
                Thread.sleep(250);
                Runtime.getRuntime().exec("say " + str.charAt(i - 1));
            }
        }
    }

}