package com.truthbean.logger.test;

import com.truthbean.Console;
import com.truthbean.logger.util.ColorHelper;

import java.time.LocalDateTime;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.6.1
 */
public class ConsoleApplication {
    public static void main(String[] args) {
        while (true) {
            Console.write(ColorHelper.GREEN, ColorHelper.BOLD, "console@truthbean [" + LocalDateTime.now() + "] :> 请输入内容：");
            var line = Console.readLine();
            if ("exit".equals(line)) {
                Console.writeLine(ColorHelper.RED, ColorHelper.BOLD, "console@truthbean [" + LocalDateTime.now() + "] :> 退出程序");
                return;
            } else if ("help".equals(line)) {
                String helpInfo = "exit - 退出程序\n" +
                        " help - 显示帮助信息\n" +
                        " 其他内容 - 打印内容";
                String loggerInfo = " logger | log - 打印日志信息:\n 1. fatal\n" +
                                    "        导致系统崩溃无法运行的错误\n" +
                                    "    2. error\n" +
                                    "        导致数据错误或者丢失，但是系统依然能运行\n" +
                                    "    3. warn\n" +
                                    "        能容忍但是必须被记录下来的错误\n" +
                                    "    4. info\n" +
                                    "        在正常情况下需要被记录的重要信息\n" +
                                    "    5. debug\n" +
                                    "        用于记录方便开发者排查错误及潜在隐患的信息\n" +
                                    "    6. treace\n" +
                                    "        用于跟踪数据的变化";
                Console.writeLine(ColorHelper.BLUE, ColorHelper.BOLD, "console@truthbean [" + LocalDateTime.now() + "] :> 帮助信息:\n " + helpInfo + "\n" + loggerInfo);
            } else if (line.startsWith("logger ") || line.startsWith("log ")) {
                if (line.endsWith(" fatal")) {
                    Console.fatal(":> 打印日志信息");
                } else if (line.endsWith(" error")) {
                    Console.error(":> 打印日志信息");
                } else if (line.endsWith(" warn")) {
                    Console.warn(":> 打印日志信息");
                } else if (line.endsWith(" info")) {
                    Console.info(":> 打印日志信息");
                } else if (line.endsWith(" debug")) {
                    Console.debug(":> 打印日志信息");
                } else if (line.endsWith(" trace")) {
                    Console.trace(":> 打印日志信息");
                } else {
                    Console.trace(":> 打印日志信息");
                }
            } else if ("".equals(line)) {
                Console.writeLine(ColorHelper.YELLOW, ColorHelper.BOLD, "console@truthbean [" + LocalDateTime.now() + "] :> 输入为空");
            } else {
                Console.writeLine(0, ColorHelper.BOLD, "console@truthbean [" + LocalDateTime.now() + "] :> " + line);
            }
        }
    }
}
