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

import com.truthbean.logger.LogLevel;
import com.truthbean.logger.LoggerFactory;
import com.truthbean.logger.LoggerInitiation;

import java.util.logging.Logger;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-11-18 09:49
 */
public class JulBootInitiation implements LoggerInitiation {
    @Override
    public void init() {
        var config = LoggerFactory.getConfig().getLoggers();
        config.forEach(this::setLogLevel);
    }

    public void setLogLevel(String loggerName, LogLevel logLevel) {
        if (loggerName == null || "ROOT".equals(loggerName)) {
            loggerName = "";
        }
        var logger = Logger.getLogger(loggerName);
        if (logger != null) {
            var level = JulLevel.SEVERE;
            switch (logLevel) {
                case FATAL:
                    level = JulLevel.FATAL;
                    break;
                case ERROR:
                    break;
                case WARN:
                    level = JulLevel.WARNING;
                    break;
                case INFO:
                    level = JulLevel.INFO;
                    break;
                case DEBUG:
                    level = JulLevel.DEBUG;
                    break;
                case TRACE:
                    level = JulLevel.TRACE;
                    break;
                default:
                    level = JulLevel.SEVERE;
                    break;
            }
            logger.setLevel(level);
        }
    }
}
