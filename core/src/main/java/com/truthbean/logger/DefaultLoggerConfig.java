/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-11-17 16:31
 */
public class DefaultLoggerConfig implements LoggerConfig {

    private final ConcurrentMap<String, LogLevel> levelMap = new ConcurrentHashMap<>();

    public DefaultLoggerConfig() {
        Runtime.getRuntime().addShutdownHook(new Thread(levelMap::clear));
    }

    @Override
    public void setLogLevel(String loggerName, LogLevel level) {
        levelMap.put(loggerName, level);
    }

    @Override
    public Map<String, LogLevel> getLoggers() {
        Map<String, LogLevel> map = new HashMap<>();
        var properties = System.getProperties();
        properties.forEach((key, value) -> {
            var name = (String) key;
            if (name.startsWith("logging.level.")) {
                var level = (String) value;
                var l = LogLevel.of(level);
                l.ifPresent(logLevel -> map.put(name.substring(14), logLevel));
            }
        });
        if (!map.isEmpty()) {
            levelMap.putAll(map);
        }
        return map;
    }

    @Override
    public Optional<LogLevel> getLevel(String name) {
        if (levelMap.isEmpty()) {
            getLoggers();
        }
        if (!levelMap.isEmpty()) {
            for (Map.Entry<String, LogLevel> entry : levelMap.entrySet()) {
                var key = entry.getKey();
                var level = entry.getValue();
                if (key.equals(name)) {
                    return Optional.ofNullable(level);
                }
            }
            LogLevel result = null;
            for (Map.Entry<String, LogLevel> entry : levelMap.entrySet()) {
                var key = entry.getKey();
                var level = entry.getValue();
                if (name.startsWith(key + ".")) {
                    result = level;
                    break;
                }
            }
            if (result != null) {
                levelMap.put(name, result);
                return Optional.of(result);
            }
        }
        if (levelMap.containsKey("ROOT")) {
            LogLevel level = levelMap.get("ROOT");
            return Optional.ofNullable(level);
        } else if (levelMap.containsKey("root")) {
            LogLevel level = levelMap.get("root");
            return Optional.ofNullable(level);
        }
        return Optional.empty();
    }

    @Override
    public void clear() {
        levelMap.clear();
    }
}
