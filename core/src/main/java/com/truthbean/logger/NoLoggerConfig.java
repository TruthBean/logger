package com.truthbean.logger;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author TruthBean
 * @since 0.5.3
 */
public class NoLoggerConfig implements LoggerConfig {
    private final Map<String, LogLevel> map = Collections.unmodifiableMap(new HashMap<>(0));
    private final Optional<LogLevel> empty = Optional.empty();

    @Override
    public Map<String, LogLevel> getLoggers() {
        return map;
    }

    @Override
    public Optional<LogLevel> getLevel(String name) {
        return empty;
    }
}
