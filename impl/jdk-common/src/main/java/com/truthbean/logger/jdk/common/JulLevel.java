/**
 * Copyright (c) 2023 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.jdk.common;

import com.truthbean.logger.LogLevel;

import java.io.Serial;
import java.util.logging.Level;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-02-13 13:29
 */
public class JulLevel extends Level {
    /**
     * serial version
     */
    @Serial
    private static final long serialVersionUID = -4242942266318231264L;

    protected JulLevel(String name, int value) {
        super(name, value);
    }

    JulLevel(String name, int value, String resourceBundleName) {
        super(name, value, resourceBundleName);
    }

    private static final String DEFAULT_BUNDLE = "sun.util.logging.resources.logging";

    public static final Level FATAL = Level.OFF;
    public static final Level ERROR = Level.SEVERE;
    public static final Level WARN = Level.WARNING;
    public static final Level INFO = Level.INFO;
    public static final Level DEBUG = Level.CONFIG;
    public static final Level TRACE = Level.FINEST;

    public static LogLevel toLogLevel(int julLevelValue) {
        if (julLevelValue == Level.OFF.intValue()) {
            return LogLevel.OFF;
        } else if (julLevelValue < Level.OFF.intValue() && julLevelValue > Level.SEVERE.intValue()) {
            return LogLevel.FATAL;
        } else if (julLevelValue <= Level.SEVERE.intValue() && julLevelValue > Level.WARNING.intValue()) {
            return LogLevel.ERROR;
        } else if (julLevelValue <= Level.WARNING.intValue() && julLevelValue > Level.INFO.intValue()) {
            return LogLevel.WARN;
        } else if (julLevelValue <= Level.INFO.intValue() && julLevelValue > Level.CONFIG.intValue()) {
            return LogLevel.INFO;
        } else if (julLevelValue <= Level.CONFIG.intValue() && julLevelValue > Level.FINE.intValue()) {
            return LogLevel.DEBUG;
        } else if (julLevelValue <= Level.FINE.intValue() && julLevelValue >= Level.FINEST.intValue()) {
            return LogLevel.TRACE;
        } else if (julLevelValue < Level.FINEST.intValue() && julLevelValue >= Level.ALL.intValue()) {
            return LogLevel.ALL;
        } else {
            return LogLevel.OFF;
        }
    }

    public LogLevel toLogLevel() {
        return toLogLevel(intValue());
    }
}
