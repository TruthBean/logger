/**
 * Copyright (c) 2023 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-11-17 16:27
 */
public interface LoggerConfig {

    String DISABLE_LOGGER = "truthbean.log.disable";
    String NO_LOGGER = "truthbean.log.no";
    String STD_OUT = "truthbean.log.system-out";
    String COLOR_LOGGER = "truthbean.log.stdout-color";

    String USE_NAME = "truthbean.log.use-name";
    String FALSE = "false";
    String TRUE = "true";
    String LOGGING_LEVEL = "logging.level.";
    String U_ROOT = "ROOT";
    String L_ROOT = "root";

    static void disableLogger() {
        System.setProperty(NO_LOGGER, TRUE);
    }

    static void enableLogger() {
        System.setProperty(NO_LOGGER, FALSE);
    }

    static void noStdout() {
        System.setProperty(STD_OUT, FALSE);
    }

    static void stdout() {
        System.setProperty(STD_OUT, TRUE);
    }

    static void noStdoutColor() {
        System.setProperty(COLOR_LOGGER, FALSE);
    }

    static void useStdoutColor() {
        System.setProperty(COLOR_LOGGER, TRUE);
    }

    default void setLogLevel(String loggerName, LogLevel level) {
    }

    default boolean useName() {
        return false;
    }

    default Map<String, LogLevel> getLoggers() {
        return new HashMap<>(0);
    }

    default Optional<LogLevel> getLevel(String name) {
        return Optional.empty();
    }

    default void clear() {
    }
}
