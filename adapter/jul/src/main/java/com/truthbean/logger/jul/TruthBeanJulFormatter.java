/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.jul;

import com.truthbean.logger.util.DateTimeHelper;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.3.1
 * Created on 2020-11-17 13:50
 */
public class TruthBeanJulFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        var level = record.getLevel();
        var cname = record.getSourceClassName();
        var method = record.getSourceMethodName();

        var threadName = Thread.currentThread().getName();
        var logger = new StringBuilder();
        logger.append("\33[98;1m").append(DateTimeHelper.nowStr()).append("\033[0m ");
        switch (level.getName()) {
            case "FATAL":
                logger.append("\33[30;1m").append(level).append("\033[0m ")
                        .append("[\33[93;1m").append(threadName).append("\033[0m] ")
                        .append("\33[98;4m").append(cname).append(".").append(method)
                        .append("()\033[0m : \33[39;1m");
                break;
            case "SEVERE":
                logger.append("\33[31;1m").append("ERROR").append("\033[0m ")
                        .append("[\33[93;1m").append(threadName).append("\033[0m] ")
                        .append("\33[91;4m").append(cname).append(".").append(method)
                        .append("()\033[0m : \33[39;1m");
                break;
            case "WARNING":
                logger.append("\33[32;1m").append("WARN").append(" \033[0m ")
                        .append("[\33[93;1m").append(threadName).append("\033[0m] ")
                        .append("\33[92;4m").append(cname).append(".").append(method)
                        .append("()\033[0m : \33[39;1m");
                break;
            case "INFO":
                logger.append("\33[36;1m").append(level).append(" \033[0m ")
                        .append("[\33[93;1m").append(threadName).append("\033[0m] ")
                        .append("\33[96;4m").append(cname).append(".").append(method)
                        .append("()\033[0m : \33[39;1m");
                break;
            case "DEBUG":
                logger.append("\33[34;1m").append(level).append("\033[0m ")
                        .append("[\33[93;1m").append(threadName).append("\033[0m] ")
                        .append("\33[94;4m").append(cname).append(".").append(method)
                        .append("()\033[0m : \33[39;1m");
                break;
            case "TRACE":
                logger.append("\33[35;1m").append(level).append("\033[0m ")
                        .append("[\33[93;1m").append(threadName).append("\033[0m] ")
                        .append("\33[95;4m").append(cname).append(".").append(method)
                        .append("()\033[0m : \33[39;1m");
                break;
        }
        var newMessage = record.getMessage() + "\033[0m";
        logger.append(newMessage).append("\n");
        return logger.toString();
    }
}
