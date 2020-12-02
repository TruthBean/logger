/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.util;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-05-08 22:03
 */
public class MessageHelper {
    private MessageHelper() {
    }

    public static String format(Object message, Object...params) {
        if (message == null) {
            return "null";
        }
        return format(message.toString(), params);
    }

    public static String format(String message, Object...params) {
        if (params == null || params.length == 0) {
            return message;
        }
        /*if ("{}".equals(message) && params[0] != null) {
            return params[0].toString();
        }
        var splits = message.split("\\{}");
        if (splits.length == 0) {
            return "";
        }
        var result = new StringBuilder(splits[0]);
        if (params[0] != null) {
            result.append(params[0]);
        }
        if (splits.length > 1) {
            var min = Math.min(splits.length, params.length);
            for (int i = 1; i < min; i++) {
                result.append(splits[i]);
                if (params[i] != null) {
                    result.append(params[i]);
                }
            }
            if (splits.length > params.length) {
                for (int i = params.length; i < splits.length; i++) {
                    result.append(splits[i]);
                }
            }
        }
        return result.toString();*/

        var length = message.length();
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = message.charAt(i);
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < chars.length;) {
            var js = chars[j];
            if ('{' == js && j + 1 < chars.length && '}' == chars[j+1]) {
                if (i < params.length) {
                    sb.append(params[i]);
                    i++;
                }
                j+=2;
            } else {
                sb.append(js);
                j++;
            }
        }
        return sb.toString();
    }

    public static String toString(Object message) {
        if (message == null) {
            return "null";
        }
        return message.toString();
    }

    public static StringBuilder buildMessage(String level, String threadName, String location) {
        var logger = new StringBuilder();
        logger.append("\33[98;1m").append(DateTimeHelper.nowStr()).append("\033[0m ");
        switch (level) {
            case "OFF":
            case "FATAL":
                logger.append("\33[31;1m").append("FATAL").append("\033[0m ")
                        .append("[\33[30;1m").append(threadName).append("\033[0m] ")
                        .append("\33[31;4m").append(location)
                        .append("\033[0m \33[97;1m:\033[0m \33[39;1m");
                break;
            case "SEVERE":
            case "ERROR":
                logger.append("\33[91;1m").append("ERROR").append("\033[0m ")
                        .append("[\33[30;1m").append(threadName).append("\033[0m] ")
                        .append("\33[91;4m").append(location)
                        .append("\033[0m \33[97;1m:\033[0m \33[39;1m");
                break;
            case "WARNING":
            case "WARN":
                logger.append("\33[93;1m").append("WARN").append(" \033[0m ")
                        .append("[\33[30;1m").append(threadName).append("\033[0m] ")
                        .append("\33[93;4m").append(location)
                        .append("\033[0m \33[97;1m:\033[0m \33[39;1m");
                break;
            case "INFO":
                logger.append("\33[36;1m").append("INFO").append(" \033[0m ")
                        .append("[\33[30;1m").append(threadName).append("\033[0m] ")
                        .append("\33[36;4m").append(location)
                        .append("\033[0m \33[97;1m:\033[0m \33[39;1m");
                break;
            case "DEBUG":
            case "CONFIG":
            case "FINE":
                logger.append("\33[94;1m").append("DEBUG").append("\033[0m ")
                        .append("[\33[30;1m").append(threadName).append("\033[0m] ")
                        .append("\33[94;4m").append(location)
                        .append("\033[0m \33[97;1m:\033[0m \33[39;1m");
                break;
            case "TRACE":
            case "FINER":
            case "FINEST":
                logger.append("\33[35;1m").append("TRACE").append("\033[0m ")
                        .append("[\33[30;1m").append(threadName).append("\033[0m] ")
                        .append("\33[35;4m").append(location)
                        .append("\033[0m \33[97;1m:\033[0m \33[39;1m");
                break;
            default:
                break;
        }
        return logger;
    }
}
