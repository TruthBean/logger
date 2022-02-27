/**
 * Copyright (c) 2022 TruthBean(Rogar·Q)
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

    String DISABLE_LOGGER = "com.truthbean.log.disable";
    String NO_LOGGER = "com.truthbean.log.no";
    String STD_OUT = "com.truthbean.system-out";
    String COLOR_LOGGER = "com.truthbean.stdout-color";

    String USE_NAME = "com.truthbean.use-name";
    String FALSE = "false";
    String TRUE = "true";
    String LOGGING_LEVEL = "logging.level.";
    String U_ROOT = "ROOT";
    String L_ROOT = "root";

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
