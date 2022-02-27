/**
 * Copyright (c) 2022 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.jdk.common;

import com.truthbean.logger.LogLevel;
import com.truthbean.LoggerFactory;

import java.util.Optional;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-12-16 11:52
 */
public class LogLevelFilter implements Filter {
    @Override
    public boolean isLoggable(LogRecord record) {
        Level level = record.getLevel();
        String loggerName = record.getLoggerName();
        LogLevel logLevel = JulLevel.toLogLevel(level.intValue());
        Optional<LogLevel> optional = LoggerFactory.getConfig().getLevel(loggerName);
        return optional.filter(value -> isLoggable(logLevel, value)).isPresent();
    }

    public static boolean isLoggable(LogLevel logLevel, LogLevel configLevel) {
        return configLevel.compareTo(logLevel) >= 0;
    }
}
