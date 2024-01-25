/**
 * Copyright (c) 2024 TruthBean(Rogar·Q)
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

    public static String format(Object message, Object... params) {
        if (message == null) {
            return "null";
        }
        return format(message.toString(), params);
    }

    public static String format(String message, Object... params) {
        if (params == null || params.length == 0) {
            return message;
        }

        char[] chars = message.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int j = 0, i = 0; j < chars.length; ) {
            var js = chars[j];
            if ('{' == js && j + 1 < chars.length && '}' == chars[j + 1]) {
                if (i < params.length) {
                    sb.append(params[i]);
                    i++;
                } else {
                    sb.append("{}");
                }
                j += 2;
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

    public static StringBuilder buildMessage(boolean color, String level, String threadName, String location) {
        var logger = new StringBuilder();
        if (level == null) {
            return logger;
        }
        if (color) {
            logger.append("\33[98;1m");
        }
        logger.append(DateTimeHelper.nowStr()).append("\033[0m ");
        switch (level) {
            case "OFF", "FATAL" -> {
                if (color) {
                    logger.append("\33[31;1m");
                }
                logger.append("FATAL");
                if (color) {
                    logger.append("\033[0m ").append("[\33[30;1m");
                } else {
                    logger.append(" ");
                }
                logger.append(threadName);
                if (color) {
                    logger.append("\033[0m] ").append("\33[31;4m");
                } else {
                    logger.append(" ");
                }
                logger.append(location);
                if (color) {
                    logger.append("\033[0m \33[97;1m:\033[0m \33[39;1m");
                } else {
                    logger.append(" : ");
                }
            }
            case "SEVERE", "ERROR" -> {
                if (color) {
                    logger.append("\33[91;1m");
                }
                logger.append("ERROR");
                if (color) {
                    logger.append("\033[0m ").append("[\33[30;1m");
                } else {
                    logger.append(" ");
                }
                logger.append(threadName);
                if (color) {
                    logger.append("\033[0m] ").append("\33[91;4m");
                } else {
                    logger.append(" ");
                }
                logger.append(location);
                if (color) {
                    logger.append("\033[0m \33[97;1m:\033[0m \33[39;1m");
                } else {
                    logger.append(" : ");
                }
            }
            case "WARNING", "WARN" -> {
                if (color) {
                    logger.append("\33[93;1m");
                }
                logger.append("WARN");
                if (color) {
                    logger.append(" \033[0m ").append("[\33[30;1m");
                } else {
                    logger.append(" ");
                }
                logger.append(threadName);
                if (color) {
                    logger.append("\033[0m] ").append("\33[93;4m");
                } else {
                    logger.append(" ");
                }
                logger.append(location);
                if (color) {
                    logger.append("\033[0m \33[97;1m:\033[0m \33[39;1m");
                } else {
                    logger.append(" : ");
                }
            }
            case "INFO" -> {
                if (color) {
                    logger.append("\33[92;1m");
                }
                logger.append("INFO");
                if (color) {
                    logger.append(" \033[0m ").append("[\33[30;1m");
                } else {
                    logger.append(" ");
                }
                logger.append(threadName);
                if (color) {
                    logger.append("\033[0m] ").append("\33[92;4m");
                } else {
                    logger.append(" ");
                }
                logger.append(location);
                if (color) {
                    logger.append("\033[0m \33[97;1m:\033[0m \33[39;1m");
                } else {
                    logger.append(" : ");
                }
            }
            case "DEBUG", "CONFIG" -> {
                if (color) {
                    logger.append("\33[94;1m");
                }
                logger.append("DEBUG");
                if (color) {
                    logger.append("\033[0m ").append("[\33[30;1m");
                } else {
                    logger.append(" ");
                }
                logger.append(threadName);
                if (color) {
                    logger.append("\033[0m] ").append("\33[94;4m");
                } else {
                    logger.append(" ");
                }
                logger.append(location);
                if (color) {
                    logger.append("\033[0m \33[97;1m:\033[0m \33[39;1m");
                } else {
                    logger.append(" : ");
                }
            }
            case "FINE", "TRACE", "FINER", "FINEST" -> {
                if (color) {
                    logger.append("\33[95;1m");
                }
                logger.append("TRACE");
                if (color) {
                    logger.append("\033[0m ").append("[\33[30;1m");
                } else {
                    logger.append(" ");
                }
                logger.append(threadName);
                if (color) {
                    logger.append("\033[0m] ").append("\33[95;4m");
                } else {
                    logger.append(" ");
                }
                logger.append(location);
                if (color) {
                    logger.append("\033[0m \33[97;1m:\033[0m \33[39;1m");
                } else {
                    logger.append(" : ");
                }
            }
            case "ALL" -> {
                if (color) {
                    logger.append("\33[98;1m");
                }
                logger.append("ALL  ");
                if (color) {
                    logger.append("\033[0m ").append("[\33[30;1m");
                } else {
                    logger.append(" ");
                }
                logger.append(threadName);
                if (color) {
                    logger.append("\033[0m] ").append("\33[98;4m");
                } else {
                    logger.append(" ");
                }
                logger.append(location);
                if (color) {
                    logger.append("\033[0m \33[97;1m:\033[0m \33[39;1m");
                } else {
                    logger.append(" : ");
                }
            }
            default -> {
            }
        }
        return logger;
    }
}
